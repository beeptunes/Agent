package Models;


public class Track extends MediaMaterial {

	private Album album;
	private String englishName;
	private int durationMinutes;
	private int durationSeconds;
	private String id;
	private String name;
	private String previewHttpPath;
    private String primaryImage;
	private String image;
	private int trackNumber;
	private String l64HttpPath;
	private String lqHttpPath;
	private String hqHttpPath;
	private int listens;
	private int likes;
	private Artist[] artists;
	

	@Override
	public String getImageUrl() {
        if(album != null || image != null){
            primaryImage = primaryImage == null ? image : primaryImage;
            return primaryImage;
        }
        return null;
	}
	
	@Override
	public String getOwnerName(){
		String subT;
		if(album != null)
			subT = album.getName();
		else subT = artists[0].name;

		return subT;
	}


	@Override
	public String toString() {
		return "Track{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public int getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(int durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreviewHttpPath() {
		return previewHttpPath;
	}

	public void setPreviewHttpPath(String previewHttpPath) {
		this.previewHttpPath = previewHttpPath;
	}

	public String getPrimaryImage() {
		return primaryImage;
	}

	public void setPrimaryImage(String primaryImage) {
		this.primaryImage = primaryImage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getL64HttpPath() {
		return l64HttpPath;
	}

	public void setL64HttpPath(String l64HttpPath) {
		this.l64HttpPath = l64HttpPath;
	}

	public String getLqHttpPath() {
		return lqHttpPath;
	}

	public void setLqHttpPath(String lqHttpPath) {
		this.lqHttpPath = lqHttpPath;
	}

	public String getHqHttpPath() {
		return hqHttpPath;
	}

	public void setHqHttpPath(String hqHttpPath) {
		this.hqHttpPath = hqHttpPath;
	}

	public int getListens() {
		return listens;
	}

	public void setListens(int listens) {
		this.listens = listens;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Artist[] getArtists() {
		return artists;
	}

	public void setArtists(Artist[] artists) {
		this.artists = artists;
	}
}
