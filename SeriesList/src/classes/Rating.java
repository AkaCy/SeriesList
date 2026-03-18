/**
 * In charge of calculating the ratings of everything, be the episodes, season or the whole series, made to
 * be as flexible as possible.
 *
 * Needed on the Season class, episode class and series class.
 *
 * @author Cyril
 * @version 1.0
 * @since 13/03/2026
 * @see ArrayList
 */
package classes;

import java.util.ArrayList;

public class Rating{
    ArrayList<Double> rating;

    public Rating(){
        rating = new ArrayList<>();
    }

    public ArrayList<Double> getRating() {
        return rating;
    }

    public void setRating(ArrayList<Double> rating) {
        this.rating = rating;
    }

    public void addRating(double newRating) {
        if (newRating > 5) {
            System.out.println("Rating can't be greater than 5");
        } else {
            this.rating.add(newRating);
        }
    }

    public void printRatingTotal(boolean indentation){
        String prefix = indentation ? "\t" : "";
        float totalRating = 0;
        for (double rating : this.rating) {
            totalRating += rating;
        }
        if (totalRating > 0) {
            System.out.println(prefix +"Total Rating : " + totalRating/this.rating.size());
        } else {
            System.out.println(prefix + "Total Rating : No ratings (or your series really sucks)");
        }

    }

    /**In charge of telling the rating of the episode/season/series
     * It uses the rating class... no wait, we are the rating class...
     *
     * @return either the average rating or no rating if there are no ratings
     */
    public String printRatingTotalToString(){
        float totalRating = 0;
        for (double rating : this.rating) {
            totalRating += rating;
        }
        if (totalRating > 0) {
            return "" + totalRating/this.rating.size();
        } else {
            return "No ratings (or your series just really sucks)";
        }

    }
}
