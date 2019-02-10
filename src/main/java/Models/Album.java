package Models;

public class Album extends MediaMaterial {

	private String id;
	private String name;
	private Artist[] artists;
	private String primaryImage;
	private String image;
	private String publishYear;
	private String[] images;
    private String status;

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist[] getArtists() {
		return artists;
	}

	public void setArtists(Artist[] artists) {
		this.artists = artists;
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

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getOwnerName() {
		String subtitle = "";
		if(artists != null)
			subtitle = artists[0].artisticName;
		return subtitle;
	}

	@Override
	public String getImageUrl() {
		return primaryImage == null ? image: primaryImage;
	}


	public Album() {

	}

	public Album(String id, String name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}
}
