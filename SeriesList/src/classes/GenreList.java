package classes;

import java.util.ArrayList;
import enumPack.Genre;


public class GenreList {
    ArrayList<Genre> genreList;

    public GenreList(){
        this.genreList = new ArrayList<>();
    }

    public void addGenre(Genre genre){this.genreList.add(genre);}

    public void removeGenre(Genre genre){this.genreList.remove(genre);}

    public String printGenre(){
        StringBuilder printedGenre = new StringBuilder();
        if(!this.genreList.isEmpty()){
            for(Genre genre : this.genreList){
                printedGenre.append(genre);
                printedGenre.append(" ");
            }
            return printedGenre.toString();
        }
        return "No genre (for now)";
    }
}
