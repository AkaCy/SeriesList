package classes;

import enumPack.Genre;
import java.time.LocalDate;

public class Series {
    String name;
    String[] Seasons;
    float rating;
    LocalDate releaseDate;
    LocalDate endDate;
    Genre genre;

    Series(String name, String[] Seasons, float rating, LocalDate releaseDate, LocalDate endDate){
        this.setName(name);
        this.setSeasons(Seasons);
        this.setRating(rating);
        this.setReleasedate(releaseDate);
        this.setEndDate(endDate);
        this.setGenre(Genre.NaN);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeasons(String[] Seasons){

    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public void setReleasedate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public void setGenre(Genre genre){
        this.genre = genre;
    }


    public String getName(){
        return name;
    }

    public float getRating(){
        return rating;
    }
}
