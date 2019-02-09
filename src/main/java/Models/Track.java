package Models;


public class Track implements MediaMaterial{
	public Album album;
	public String englishName;
	public int durationMinutes;
	public int durationSeconds;
	public String id;
	public String name;
	public String previewHttpPath;
    public String primaryImage;
	public String image;
	public int trackNumber;
	public String l64HttpPath;
	public String lqHttpPath;
	public String hqHttpPath;
	public int listens;
	public int likes;
	public Artist[] artists;
	
	@Override
	public String getTitle() {
		return name;
	}
	@Override
	public String getImageUrl() {
        if(album != null || image != null){
            primaryImage = primaryImage == null ? image : primaryImage;
            return primaryImage;
        }
        return null;
	}
	
	@Override
	public String getSubTitle(){
		String subT = null;
		if(album != null)
			subT = album.name;
		else subT = artists[0].name;

		return subT;
	}
	

	@Override
	public String toString() {
		return "Track{" +
				"englishName='" + englishName + '\'' +
				", durationMinutes=" + durationMinutes +
				", durationSeconds=" + durationSeconds +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", previewHttpPath='" + previewHttpPath + '\'' +
				", primaryImage='" + primaryImage + '\'' +
				", trackNumber=" + trackNumber +
				", l64HttpPath='" + l64HttpPath + '\'' +
				", lqHttpPath='" + lqHttpPath + '\'' +
				", hqHttpPath='" + hqHttpPath + '\'' +
				", listens=" + listens +
				", likes=" + likes +
				'}';
	}

	public void setQuality(String lq, String hq){
		this.lqHttpPath = lq;
		this.hqHttpPath = hq;
	}
}
