/**In charge of managing each individual season, and displaying the episodes inside of it, with the information
 * contained in each episode along with it.
 *
 * Needed on the series class
 *
 * @author Cyril
 * @version 1.0
 * @since 13/03/2026
 * @see ArrayList, Scanner
 */

package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Season {
    String name;
    ArrayList<Episode> listEpisodes;

    public Season(String name) {
        this.name = name;
        this.listEpisodes = new ArrayList<Episode>();
    }

    public void addEpisode(Episode episode) {
        this.listEpisodes.add(episode);
    }

    public void removeEpisode(Episode episode){
        this.listEpisodes.remove(episode);
    }

    public void printEpisodes(){
        System.out.println("---- List Episode ----");
        for(Episode episode : this.listEpisodes){
            episode.printEpisode(true);
        }
    }

    public void printSeasons(){
        System.out.println("Name : " + this.name);
        System.out.println("Total Duration : " + this.getTotalDuration());
        System.out.println("Nombre d'Episodes : " + this.getNumberEpisodes());
    }

    /**Counts the number of episodes in each season
     *
     * @return An integer demonstrating the number of episodes
     */
    public int getNumberEpisodes(){
        int nb = 0;
        for (Episode episode : this.listEpisodes) {
            nb+=1;
        }
        return nb;
    }


    /**Counts the total duration of the season
     *
     * @return An integer demonstrating the length of the whole season
     */
    public double getTotalDuration(){
        double totalDuration = 0;
        for (Episode episode : this.listEpisodes){
            totalDuration += episode.getDuration();
        }
        return totalDuration;
    }

    public ArrayList<Episode> getListEpisodes() {
        return listEpisodes;
    }

    public void setListEpisodes(ArrayList<Episode> listEpisodes) {
        this.listEpisodes = listEpisodes;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
