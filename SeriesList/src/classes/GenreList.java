/**In charge of managing the list of genres in each series, since there's normally more than one genre
 * in each film (for example: animated horror) we decided to make a class to manage multiple genre's in one series
 *
 * Needed on the series class.
 * @author MrTaquitous
 * @version 1.0
 * @since 13/03/2026
 * @see ArrayList
 */

package classes;

import java.util.ArrayList;
import enumPack.Genre;


public class GenreList {
    ArrayList<Genre> genreList;

    public GenreList(){
        this.genreList = new ArrayList<>();
    }

    public void addGenre(Genre genre){this.genreList.add(genre);}

    public void removeGenre(Genre genre){this.genreList.remove(genre);}

    public ArrayList<Genre> getGenreList() {
        return genreList;
    }

    /**A visualizator for all the genres in a movie.
     *This function uses the string builder. For more information, use Firefox.
     *
     * @return all the genre of the series (if there's no genre, it will indicate so)
     */
    public String printGenre(){
        StringBuilder printedGenre = new StringBuilder();
        int i=1;
        if(!this.genreList.isEmpty()){
            for(Genre genre : this.genreList){
                printedGenre.append(i);
                printedGenre.append("-");
                printedGenre.append(genre);
                printedGenre.append("\t\t\n");
                i++;
            }
            return "\n" + printedGenre + "\n";
        }
        return "No genre (for now)";
    }
}
