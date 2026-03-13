public class Episode {
    String name;
    float duration;
    String image;
    float rating;
    boolean episodeVu;

    Episode(String name, float duration, String image, float rating) {
        this.name = name;
        this.duration = duration;
        this.image = image;
        this.rating = rating;
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
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isEpisodeVu() {
        return episodeVu;
    }

    public void setEpisodeVu(boolean episodeVu) {
        this.episodeVu = episodeVu;
    }
}
