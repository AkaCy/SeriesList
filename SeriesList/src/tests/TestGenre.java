package tests;

import classes.GenreList;
import classes.Series;
import enumPack.Genre;

import java.time.LocalDate;

public class TestGenre {
    public static void main(String[] args) {
        // Test avec une liste d'un élément
        GenreList episode1BB = new GenreList();
        System.out.println("================== Breaking bad   ==================");
        episode1BB.addGenre(Genre.Drama);
        episode1BB.addGenre(Genre.Action);
        episode1BB.addGenre(Genre.Thriller);
        episode1BB.printGenre();
        System.out.println();
    }
}
