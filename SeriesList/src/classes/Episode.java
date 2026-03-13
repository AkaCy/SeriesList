package classes;

public class Episode {
    String name;
    double duration;
    Rating rating;
    boolean episodeVu;


    public Episode(String name, double duration) {
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
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration)
    {
        this.duration = duration;
    }

    public boolean isEpisodeVu() {
        return episodeVu;
    }

    public void setEpisodeVu(boolean episodeVu) {
        this.episodeVu = episodeVu;
    }

    public void printEpisode(boolean indentation) {
        String prefix = indentation ? "\t" : "";
        System.out.println(prefix + "Nom épisode : " + name);
        System.out.println(prefix + "Durée épisode : " + duration);
        this.rating.printRatingTotal(indentation);
        if (!episodeVu) {
            System.out.println(prefix +"Episode Vu : Non");
        } else {
            System.out.println(prefix +"Episode Vu : Oui");
        }
    }

    public void rateEpisode(double newRating) {
        this.rating.addRating(newRating);
    }


}
