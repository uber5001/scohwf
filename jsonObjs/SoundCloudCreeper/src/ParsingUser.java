import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class ParsingUser {
	private static String getJson(String url) throws IOException{
		//System.out.println(url);
		URL url1 = null;
		try {
			url1 = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection con = (HttpURLConnection) url1.openConnection();
		con.setRequestProperty("Accept-Charset", "UTF-8");
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			sb.append(line + '\n');
		}
		
		return sb.toString();
	}
	private static boolean getUsers(int offset, int limit,ArrayList<UserInfo> users) throws IOException {

		String json = getJson("http://api.soundcloud.com/users.json?client_id=f14fee2217f12c3314d1f3cccef8c07b&offset="+offset+"&limit="+limit);
		
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(json).getAsJsonArray();
		
		User user;
		Track track;
		
		JsonArray array2;
        Gson gson = new Gson();
		
		for(int i=0; i<array.size(); i++){
			user = gson.fromJson(array.get(i), User.class);
			System.out.println(user.getUsername());
			if(user.getTrack_count() > 0){
				
				UserInfo userInfo = new UserInfo(user.getTrack_count()+1);
				json = getJson("http://api.soundcloud.com/users/"+ user.getId() + "/tracks.json?client_id=f14fee2217f12c3314d1f3cccef8c07b&limit=500");
				array2 = parser.parse(json).getAsJsonArray();
				for(int j=0; j<user.getTrack_count(); j++){
					track = gson.fromJson(array2.get(j), Track.class);
					System.out.println("THIS IS A TRACK"+track.getId());
					userInfo.addTrack(track, j);
				}
				users.add(userInfo);
				//System.out.println(user.getTrack_count());
			}
			if(users.size() > 200)
				return false;
		}
		return array.size() > 0;
	}
	
	public static void main(String[] args) throws JsonSyntaxException, MalformedURLException, IOException {
		ArrayList<UserInfo> users = new ArrayList<UserInfo>();
		int limit = 50;
		for(int i=0;i<100;i++) {
			int offset = i * limit;
			boolean more = getUsers(offset,limit,users);
			if(!more)
				break;
		}
		System.out.println("Users: "+users.size());
		
		ArrayList<Track> outliers = FindOutliers.findOutliers(users);
		System.out.println("Outliers: "+outliers.size());
		for(Track t : outliers ) {
			System.out.println("id: "+t.getId());
		}
	}
	
	
}
