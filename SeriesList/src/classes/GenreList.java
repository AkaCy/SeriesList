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

    public void printGenre(){
        if(this.genreList.isEmpty()){
            System.out.println("No listed genre (for now)");
        }else{
            System.out.println("Genre list: ");
            for(Genre genre : this.genreList){
                System.out.println(genre);
            }
        }

    }
}
