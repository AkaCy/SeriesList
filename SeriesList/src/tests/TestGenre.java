/**In charge of testing the GenreList class
 *
 * @author MrTaquitous
 * @version 1.0
 * @since 13/03/2026
 * @see LocalDate
 */
package tests;

import classes.GenreList;
import enumPack.Genre;

import java.time.LocalDate;

public class TestGenre {
    public static void main(String[] args) {
        GenreList fullClass = new GenreList();
        fullClass.addGenre(Genre.Drama);
        fullClass.addGenre(Genre.Action);
        fullClass.addGenre(Genre.Thriller);
        System.out.println("(full class) " + fullClass.printGenre());

        GenreList emptyClass = new GenreList();
        System.out.println("(Empty class) " + emptyClass.printGenre());

        System.out.println("done.");
    }
}
