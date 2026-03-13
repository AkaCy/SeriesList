package classes;

import java.util.ArrayList;

public class Episode {
    String name;
    float duration;
    Rating rating;
    boolean episodeVu;


    public Episode(String name, float duration) {
        this.name = name;
        this.duration = duration;
        this.rating =  new Rating();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration)
    {
        this.duration = duration;
    }

    public boolean isEpisodeVu() {
        return episodeVu;
    }

    public void setEpisodeVu(boolean episodeVu) {
        this.episodeVu = episodeVu;
    }

    public void printEpisode() {
        System.out.println("Nom épisode : " + name);
        System.out.println("Durée épisode : " + duration);
        this.rating.printRatingTotal();
        if (!episodeVu) {
            System.out.println("Episode Vu : Non");
        } else {
            System.out.println("Episode Vu : Oui");
        }
    }

    public void rateEpisode(double newRating) {
        this.rating.addRating(newRating);
        this.rating.printRatingTotal();
    }


}
