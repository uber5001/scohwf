var currentTrack = 0;
var hasTracks = true;
function addTrack(offset) {
	var BASE_API_URL = "http://moneypicsapp.com/soundcloud/getTracks.php";
	var params = "offset="+offset+"&duration=1";
	var xhr = new XMLHttpRequest();
	xhr.open("post", BASE_API_URL+"?"+params, true);
	xhr.onload = function(e) {
		var r = JSON.parse(this.response);
		if (r.tracks.length >= 1) {
			widget.load("http://api.soundcloud.com/tracks/" + r.tracks[0], {
				auto_play: false,
				auto_advance: false,
				buying: false,
				liking: false,
				download: false,
				sharing: false,
				show_artwork: true,
				show_comments: false,
				show_playcount: false,
				hide_related: true,
				show_user: true,
				visual: true,
				start_track: 0
			});
		} else {
			//failed!
			hasTracks = false;
			document.body.removeChild(iframe);
		}
	};
	xhr.send();
	
	var iframe = document.createElement('iframe');
	iframe.src = "http://w.soundcloud.com/player/?";
	container.appendChild(iframe);
	var widget = SC.Widget(iframe);
}
function loadIfNeeded() {
	if (hasTracks) {
		var scrollWidth = Math.max(document.body.scrollWidth, document.body.scrollHeight);
		var scrollOffset = Math.max(document.body.scrollLeft, document.body.scrollTop);
		var viewportWidth = Math.max(document.body.offsetWidth, document.body.offsetHeight);
		var distanceFromEnd = scrollWidth - viewportWidth - scrollOffset;
		if (distanceFromEnd < 500) {
			addTrack(currentTrack++);
		}
	}
}
document.body.onscroll = loadIfNeeded;
loadIfNeeded();
loadIfNeeded();
loadIfNeeded();
loadIfNeeded();
loadIfNeeded();