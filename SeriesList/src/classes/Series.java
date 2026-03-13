package classes;

import enumPack.Genre;
import java.time.LocalDate;
import java.util.ArrayList;

public class Series {
    String name;
    ArrayList<Season> seasons;
    Rating rating;
    LocalDate releaseDate;
    LocalDate endDate;
    GenreList genreList;

    public Series(String name, LocalDate releaseDate, LocalDate endDate){
        this.setName(name);
        this.seasons = new ArrayList<Season>();
        this.setReleasedate(releaseDate);
        this.setEndDate(endDate);
        this.genreList = new GenreList();
        this.rating = new Rating();
    }

    public Series(String name, LocalDate releaseDate){
        this.setName(name);
        this.seasons = new ArrayList<Season>();
        this.setReleasedate(releaseDate);
        this.genreList = new GenreList();
        this.rating = new Rating();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSeasons(ArrayList<Season> seasons){this.seasons = seasons;}
    public void setReleasedate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }
    public void addGenre(Genre genre){
        this.genreList.addGenre(genre);
    }


    public String getName(){
        return name;
    }

    public int getNumberSeasons(){
        int nb = 0;
        for (Season season : this.seasons) {
            nb+=1;
        }
        return nb;
    }
    public ArrayList<Season> getSeasons(){return seasons;}
    public LocalDate getReleaseDate(){return releaseDate;}
    public LocalDate getEndDate(){return endDate;}


    public void displayInformation(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append(" | # of seasons: ");
        sb.append(this.getNumberSeasons());
        sb.append(" | Rating: ");
        sb.append(this.rating.printRatingTotalToString());
        sb.append("\n\t");
        sb.append("Release date: ");
        sb.append(this.getReleaseDate());
        sb.append("\n\t");
        sb.append("End date: ");
        sb.append(this.getEndDate());
        sb.append("\n\t");
        sb.append("Genre list: ");
        sb.append(this.genreList.printGenre());
        System.out.println(sb);
    }
}
