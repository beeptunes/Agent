package com.beeptunes.agent.Models;



public class Artist implements MediaMaterial{
    public String artistImage;
    public String image;
    public String artisticName;
    public String name;
    public String created;
    public String biography;
    public String id;
    public int likeCount;


    @Override
    public String getTitle() {
        artisticName = artisticName == null ? name : artisticName;
        return artisticName;
    }
    @Override
    public String getImageUrl() {
        artistImage = artistImage == null ? image : artistImage;
        return artistImage;
    }

    @Override
    public String getSubTitle(){
        return "";
    }

}