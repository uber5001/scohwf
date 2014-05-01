
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
public class FindOutliers {
	static ArrayList <Track> outliers = new ArrayList<Track>();
	
	
	public static ArrayList<Track> findOutliers(ArrayList<UserInfo> users) {
		
		// creates Lists of Users and User with Outliers
		
		// cycles through list to find tracks
		for(int i=0;i<users.size();i++){
				checkTracks(users.get(i));			
		}
		return outliers;
	}
	
	// adds Users that have outliers to UserswithTracks
	public static void checkTracks(UserInfo user){
		// checks if the current user has tracks
		// if the user has more than one track
		User u = user.getSelf();
		Track[] tracks = user.getTracks();
		if(u.getTrack_count()>1){
			System.out.println("YAY HAD TRACKS");
			// finds outlier threshold 
			calcOutlier(user);
			return;
			
		}
		else if(u.getTrack_count()==1){
			if(tracks[0].getPlayback_count()>10000){
				outliers.add(tracks[0]);
			}
			return;
		}
		// if the user has no tracks
		else {
			//System.out.println("No tracks");
			return;
		}
	}
	
	public static void calcOutlier(UserInfo user){
		ArrayList <Track> lowHalf=new ArrayList<Track>();
		ArrayList <Track> upHalf=new ArrayList<Track>();
		int max=0;	
		// sorts playbacks
		User u = user.getSelf();
		ArrayList<Track> tracks = new ArrayList<Track>(Arrays.asList(user.getTracks()));
		Track max_track = null;
		Collections.sort(tracks);
		double median= median(tracks);
		// gets the upper and lower halves of the playback counts
		for(int i=0;i<tracks.size();i++){
			double playbacks=tracks.get(i).getPlayback_count();	
			if(playbacks<=median){
				lowHalf.add(tracks.get(i));
			}
			else{
				upHalf.add(tracks.get(i));
			}
			// get the biggest number of playbacks to compare
			if(max<tracks.get(i).getPlayback_count()){
				max=tracks.get(i).getPlayback_count();
				max_track = tracks.get(i);
			}
		}
		double q1=median(lowHalf);
		double q3=median(upHalf);
		double iqr=q3-q1;
		iqr=iqr*1.5;
		System.out.println("Iqr: "+iqr);
		if(max>=iqr){
			outliers.add(max_track);
		}
		return;
	}

	private static double median(ArrayList<Track> tracks) {
		return tracks.get(tracks.size() / 2).getPlayback_count();
	}

}
