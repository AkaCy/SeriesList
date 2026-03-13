/**In charge of testing the class season and its compatibility with the episodes class
 *
 * @author Cyril
 * @version 1.0
 * @since 13/03/2026
 */
package tests;

import classes.Series;
import enumPack.Genre;
import java.time.LocalDate;

public class TestSeries {
    public static void main(String[] args) {
        // Test avec une liste d'un élément
        Series serie1 = new Series("Breaking bad", LocalDate.of(2008,1,20), LocalDate.of(2013,7,29));
        serie1.addGenre(Genre.Drama);
        serie1.addGenre(Genre.Action);
        serie1.addGenre(Genre.Thriller);
        serie1.displayInformation();

        Series serie2 = new Series("Breaking badder", LocalDate.of(2008,1,20));
        serie2.displayInformation();
    }
}
