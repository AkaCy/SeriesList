package tests;

import classes.Series;
import enumPack.Genre;
import java.time.LocalDate;

public class TestSeries {
    public static void main(String[] args) {
        // Test avec une liste d'un élément
        Series episode1BB = new Series("Breaking bad", LocalDate.of(2008,1,20), LocalDate.of(2013,7,29));
        System.out.println("================== Breaking bad   ==================");
        episode1BB.setGenre(Genre.Drama);
        episode1BB.displayInformation();
        System.out.println();
    }
}
