/**In charge of testing the rating class
 * @author Cyril
 * @version 1.0
 * @since 13/03/2026
 */
package tests;
import classes.Episode;
import classes.Rating;

public class TestRating {
    public static void main(String[] args) {
        // Test d'un Rating
        Rating ratingList = new Rating();
        ratingList.printRatingTotal(false);

        ratingList.addRating(4.5);
        System.out.println("================== should print an error showing a rating can't be greater than 5  ==================");
        ratingList.addRating(5.5);
        ratingList.addRating(2.5);
        ratingList.addRating(2);
        ratingList.addRating(1);
        System.out.println("================== should display 2.5    ==================");
        ratingList.printRatingTotal(false);
        System.out.println();

    }
}
