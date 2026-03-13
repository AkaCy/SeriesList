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
        this.rating.add(newRating);
    }

    public void printRatingTotal(){
        float totalRating = 0;
        for (double rating : this.rating) {
            totalRating += rating;
        }
        if (totalRating > 0) {
            System.out.println("Total Rating : " + totalRating/this.rating.size());
        } else {
            System.out.println("Total Rating : No ratings");
        }

    }
    public String printRatingTotalToString(){
        float totalRating = 0;
        for (double rating : this.rating) {
            totalRating += rating;
        }
        if (totalRating > 0) {
            return "" + totalRating/this.rating.size();
        } else {
            return "No ratings";
        }

    }
}
