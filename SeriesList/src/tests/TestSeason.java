package tests;

import classes.Episode;
import classes.Season;

public class TestSeason
{
    public static void main(String[] args)
    {
        Season testSeason = new Season("Breaking Bad");
        Episode episode = new Episode("Chute libre", 58);
        testSeason.addEpisode(episode);
        testSeason.printSeasons();
    }
}
