
public class Track implements Comparable<Track> {
	private int id;
	private String created_at;
	private int user_id;
	private String key_signature;
	private int comment_count;
	private int download_count;
	private int playback_count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getKey_signature() {
		return key_signature;
	}

	public void setKey_signature(String key_signature) {
		this.key_signature = key_signature;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getDownload_count() {
		return download_count;
	}

	public void setDownload_count(int download_count) {
		this.download_count = download_count;
	}

	public int getPlayback_count() {
		return playback_count;
	}

	public void setPlayback_count(int playback_count) {
		this.playback_count = playback_count;
	}

	@Override
	public int compareTo(Track that) {
		if(this.getPlayback_count() == that.getPlayback_count())
			return 0;
		if(this.getPlayback_count() > that.getPlayback_count())
			return 1;
		else
			return -1;
	}

}
