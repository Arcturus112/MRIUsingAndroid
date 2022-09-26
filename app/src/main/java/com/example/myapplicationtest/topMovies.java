package com.example.myapplicationtest;

public class topMovies {
    private String Id;
    private String Rank;
    private String Title;
    private String FullTitle;
    public String Year;
    private String Image;
    private String Crew;
    private String IMDbRating;
    private String IMDbRatingCount;

    public topMovies(){
    }

    public topMovies(String id,String rank,String title,String fullTitle,String year,String image,String crew,String iMDbRating,String iMDbRatingCount){
        Id = id;
        Rank = rank;
        Title = title;
        FullTitle = fullTitle;
        Year = year;
        Image = image;
        Crew = crew;
        IMDbRating = iMDbRating;
        IMDbRatingCount = iMDbRatingCount;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFullTitle() {
        return FullTitle;
    }

    public void setFullTitle(String fullTitle) {
        FullTitle = fullTitle;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getCrew() {
        return Crew;
    }

    public void setCrew(String crew) {
        Crew = crew;
    }

    public String getIMDbRating() {
        return IMDbRating;
    }

    public void setIMDbRating(String IMDbRating) {
        this.IMDbRating = IMDbRating;
    }

    public String getIMDbRatingCount() {
        return IMDbRatingCount;
    }

    public void setIMDbRatingCount(String IMDbRatingCount) {
        this.IMDbRatingCount = IMDbRatingCount;
    }
}
