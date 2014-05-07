import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class ParsingUser {
	static AtomicBoolean more = new AtomicBoolean(true);
	static AtomicInteger nThreads = new AtomicInteger(0);
	static ArrayList<Track> outliers = new ArrayList<Track>();
	static ArrayList<Thread> threads = new ArrayList<Thread>();
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

	private static void getUsers(int userid,ArrayList<UserInfo> users) throws IOException {
		if(userid % 1000 == 0)
			System.out.println("STARTING ID: "+userid);
		String json;
		try {
		json = getJson("http://api.soundcloud.com/users/"+userid+".json?client_id=f14fee2217f12c3314d1f3cccef8c07b");
		} catch (Exception e) {
			return;
		}
		JsonParser parser = new JsonParser();
		
		
		User user;
		Track track;
		
		JsonArray array2;
        Gson gson = new Gson();
		user = gson.fromJson(json, User.class);
		try {
		if(user.getTrack_count() > 0){
				//System.out.println("Had tracks");
				UserInfo userInfo = new UserInfo(user.getTrack_count() < 200 ? user.getTrack_count() : 200);
				json = getJson("http://api.soundcloud.com/users/"+ user.getId() + "/tracks.json?client_id=f14fee2217f12c3314d1f3cccef8c07b&limit=500");
				array2 = parser.parse(json).getAsJsonArray();
				for(int j=0; j<user.getTrack_count() && j < 200; j++){
					track = gson.fromJson(array2.get(j), Track.class);
					//System.out.println("THIS IS A TRACK"+track.getId());
					userInfo.addTrack(track, j);
				}
				FindOutliers.checkTracks(userInfo,outliers);
				//System.out.println(user.getTrack_count());
			}
		} catch (Exception e) {
			return;
		}
	}
	
	public static void main(String[] args) {
		try {
		final ArrayList<UserInfo> users = new ArrayList<UserInfo>();
		final int start = 92972290;
		for(int i=start;i>0;i--) {
			if(nThreads.get() < 32) {
			final int userid = i;
				Thread t = new Thread() { 
					 public void run() {
						nThreads.incrementAndGet();
						 try {
							getUsers(userid,users);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						nThreads.decrementAndGet();
					 }
				 };
				 threads.add(t);
				 t.start();
			 } else {
				try {
					getUsers(i,users);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Done!");
		
	//	System.out.println("Users: "+users.size());
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
