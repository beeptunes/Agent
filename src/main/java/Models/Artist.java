package Models;

public class Artist extends MediaMaterial{
    private String artistImage;
    private String image;
    String artisticName;
    String name;
    private String created;
    private String biography;
    private String id;
    private int likeCount;

    public String getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        artisticName = artisticName == null ? name : artisticName;
        return artisticName;
    }

    @Override
    public String getOwnerName() {
        return "";
    }

    @Override
    public String getImageUrl() {
        artistImage = artistImage == null ? image : artistImage;
        return artistImage;
    }

}