
public class User {
	private int id;
	private String permalink;
	private String username;
	private String uri;
	private String permalink_url;
	private String avatar_url;
	private String country;
	private String full_name;
	private String city;
	private String description;
	private String discogs_name;
	private String myspace_name;
	private String website;
	private String website_title;
	private int track_count;
	private int playlist_count;
	private int followers_count;
	private int followings_count;
	private int public_favorites_count;
	private String avatar_data;

	public User(){
		setId(0);
		setUsername("");
		setFull_name("");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPermalink_url() {
		return permalink_url;
	}

	public void setPermalink_url(String permalink_url) {
		this.permalink_url = permalink_url;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscogs_name() {
		return discogs_name;
	}

	public void setDiscogs_name(String discogs_name) {
		this.discogs_name = discogs_name;
	}

	public String getMyspace_name() {
		return myspace_name;
	}

	public void setMyspace_name(String myspace_name) {
		this.myspace_name = myspace_name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite_title() {
		return website_title;
	}

	public void setWebsite_title(String website_title) {
		this.website_title = website_title;
	}

	/*public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}*/

	public int getTrack_count() {
		return track_count;
	}

	public void setTrack_count(int track_count) {
		this.track_count = track_count;
	}

	public int getPlaylist_count() {
		return playlist_count;
	}

	public void setPlaylist_count(int playlist_count) {
		this.playlist_count = playlist_count;
	}

	public int getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}

	public int getFollowings_count() {
		return followings_count;
	}

	public void setFollowings_count(int followings_count) {
		this.followings_count = followings_count;
	}

	public int getPublic_favorites_count() {
		return public_favorites_count;
	}

	public void setPublic_favorites_count(int public_favorites_count) {
		this.public_favorites_count = public_favorites_count;
	}

	public String getAvatar_data() {
		return avatar_data;
	}

	public void setAvatar_data(String avatar_data) {
		this.avatar_data = avatar_data;
	}
}
