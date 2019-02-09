package Models;


import okhttp3.MediaType;
import okio.BufferedSource;

public class Album implements MediaMaterial{
	public String id;
	public String name;
	public Artist[] artists;
	public String primaryImage;
	public String image;
	public String publishYear;
	public String[] images;
    public String status;

	@Override
	public String getTitle() {
		return name;
	}

	@Override
	public String getImageUrl() {
		return primaryImage == null ? image: primaryImage;
	}


	@Override
	public String getSubTitle(){
		String subtitle = "";
		if(artists != null)
			subtitle = artists[0].artisticName;
		return subtitle;
	}


}
