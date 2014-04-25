package findOutlier;
import java.util.ArrayList;
public class findOutlier {

	
	public static void main(String[] args) {
		// creates Lists of Users and User with Outliers
		ArrayList <User> users = u.getList();
		ArrayList <User> usersWithOutliers = new ArrayList<User>();
		
		// cycles through list to find tracks
		for(int i=0;i<users.size;i++){
				checkTracks(users.get(i));			
		}

	}
	
	// adds Users that have outliers to UserswithTracks
	public void checkTracks(User u){
		// checks if the current user has tracks
		// if the user has more than one track
		if(u.track_count>1){
			// finds outlier threshold 
			calcOutlier(u);
			return
			
		}	
		// if the user only has one track
		else if(u.track_count==1){
			if(u.track.get(0).playback_count>10000){
				userWithOutliers.add(u);
			}
			return
		}
		// if the user has no tracks
		else
			return;
	}
	
	public void calcOutlier(User u){
		int avg=0;
		for(int i=0;i<user.track.size;i++){
			
		}
	}

}
