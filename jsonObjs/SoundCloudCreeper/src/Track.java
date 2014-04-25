import java.util.Date;


public class Track {
	private int id;
	private String created_at;
	private int user_id;
	private User user;
	private String title;
	private String permalink;
	private String permalink_url;
	private String uri;
	private String sharing;
	private String embeddable_by;
	private String purchase_url;
	private String artwork_url;
	private String description;
	private String label;
	private long duration;
	private String genre;
	private int shared_to_count;
	private String tag_list;
	private int label_id;
	private String label_name;
	private long release;
	private int release_day;
	private int release_month;
	private int release_year;
	private boolean streamable;
	private boolean downloadable;
	private String state;
	private String license;
	private String track_type;
	private String waveform_url;
	private String download_url;
	private String stream_url;
	private String video_url;
	private int bpm;
	private boolean commentable;
	private String isrc;
	private String key_signature;
	private int comment_count;
	private int download_count;
	private int playback_count;
	private int favoritings_count;
	private String original_format;
	private double original_content_size;
	//created_with???
	private String assest_data;
	//private boolean user_favorite?
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public String getPermalink_url() {
		return permalink_url;
	}
	public void setPermalink_url(String permalink_url) {
		this.permalink_url = permalink_url;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getSharing() {
		return sharing;
	}
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
	public String getEmbeddable_by() {
		return embeddable_by;
	}
	public void setEmbeddable_by(String embeddable_by) {
		this.embeddable_by = embeddable_by;
	}
	public String getPurchase_url() {
		return purchase_url;
	}
	public void setPurchase_url(String purchase_url) {
		this.purchase_url = purchase_url;
	}
	public String getArtwork_url() {
		return artwork_url;
	}
	public void setArtwork_url(String artwork_url) {
		this.artwork_url = artwork_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getShared_to_count() {
		return shared_to_count;
	}
	public void setShared_to_count(int shared_to_count) {
		this.shared_to_count = shared_to_count;
	}
	public String getTag_list() {
		return tag_list;
	}
	public void setTag_list(String tag_list) {
		this.tag_list = tag_list;
	}
	public int getLabel_id() {
		return label_id;
	}
	public void setLabel_id(int label_id) {
		this.label_id = label_id;
	}
	public String getLabel_name() {
		return label_name;
	}
	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}
	public long getRelease() {
		return release;
	}
	public void setRelease(long release) {
		this.release = release;
	}
	public int getRelease_day() {
		return release_day;
	}
	public void setRelease_day(int release_day) {
		this.release_day = release_day;
	}
	public int getRelease_month() {
		return release_month;
	}
	public void setRelease_month(int release_month) {
		this.release_month = release_month;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public boolean isStreamable() {
		return streamable;
	}
	public void setStreamable(boolean streamable) {
		this.streamable = streamable;
	}
	public boolean isDownloadable() {
		return downloadable;
	}
	public void setDownloadable(boolean downloadable) {
		this.downloadable = downloadable;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getTrack_type() {
		return track_type;
	}
	public void setTrack_type(String track_type) {
		this.track_type = track_type;
	}
	public String getWaveform_url() {
		return waveform_url;
	}
	public void setWaveform_url(String waveform_url) {
		this.waveform_url = waveform_url;
	}
	public String getDownload_url() {
		return download_url;
	}
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	public String getStream_url() {
		return stream_url;
	}
	public void setStream_url(String stream_url) {
		this.stream_url = stream_url;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public int getBpm() {
		return bpm;
	}
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
	public boolean isCommentable() {
		return commentable;
	}
	public void setCommentable(boolean commentable) {
		this.commentable = commentable;
	}
	public String getIsrc() {
		return isrc;
	}
	public void setIsrc(String isrc) {
		this.isrc = isrc;
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
	public int getFavoritings_count() {
		return favoritings_count;
	}
	public void setFavoritings_count(int favoritings_count) {
		this.favoritings_count = favoritings_count;
	}
	public String getOriginal_format() {
		return original_format;
	}
	public void setOriginal_format(String original_format) {
		this.original_format = original_format;
	}
	public double getOriginal_content_size() {
		return original_content_size;
	}
	public void setOriginal_content_size(double original_content_size) {
		this.original_content_size = original_content_size;
	}
	public String getAssest_data() {
		return assest_data;
	}
	public void setAssest_data(String assest_data) {
		this.assest_data = assest_data;
	}
}
