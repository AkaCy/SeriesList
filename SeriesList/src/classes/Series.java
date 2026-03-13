package classes;

import enumPack.Genre;
import java.time.LocalDate;

public class Series {
    String name;
    int seasons;
    Rating rating;
    LocalDate releaseDate;
    LocalDate endDate;
    Genre genre;

    public Series(String name, int Seasons, LocalDate releaseDate, LocalDate endDate){
        this.setName(name);
        this.setSeasons(Seasons);
        this.setReleasedate(releaseDate);
        this.setEndDate(endDate);
        this.setGenre(Genre.NaN);
        this.rating = new Rating();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSeasons(int seasons){
        this.seasons = seasons;
    }
    public void setReleasedate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }
    public void setGenre(Genre genre){this.genre = genre;}


    public String getName(){
        return name;
    }
    public int getSeasons(){return seasons;}
    public LocalDate getReleaseDate(){return releaseDate;}
    public LocalDate getEndDate(){return endDate;}
    public Genre getGenre(){return genre;}


    public void displayInformation(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append(" | # of seasons: ");
        sb.append(this.getSeasons());
        sb.append(" | Rating: ");
        sb.append(this.rating.printRatingTotalToString());
        sb.append("\n\t");
        sb.append("Release date: ");
        sb.append(this.getReleaseDate());
        sb.append("\n\t");
        sb.append("End date: ");
        sb.append(this.getEndDate());
        sb.append("\n\t");
        sb.append("Genre: ");
        sb.append(this.getGenre());
        System.out.println(sb);
    }
}
