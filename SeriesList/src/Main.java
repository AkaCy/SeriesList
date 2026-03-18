/**The main file, in charge of merging all the classes together, a full manager in charge of:
 * -Displaying the list of series
 * -Incorporating series along with defining all of their representative parts (Thanks to the class season).
 * Doing it in a loop until the user wants to quit.
 *
 * @author Cyril
 * @version 1.0
 * @since 13/03/2026
 * @see LocalDate, ArrayList, Scanner
 */

import classes.Episode;
import classes.Season;
import classes.Series;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reponse;
        ArrayList<Series> series = new ArrayList<>();
        series.add(new Series("Breaking", LocalDate.of(2008,1,20), LocalDate.of(2013,7,29)));
        do {
            reponse = lireString(scanner,afficherMenu());
            if(reponse.equals("1")) {
                afficherSeries(series);
            }
            if(reponse.equals("2")) {
               //    public Series(String name, int Seasons, LocalDate releaseDate, LocalDate endDate)
                ajouterserie(series);
            }
            if(reponse.equals("3")) {
                supprimerserie(series);
            }
            for (Series serie : series){
                if(serie.getName().toLowerCase().equals(reponse)) {
                    menuSeries(serie);
                }
            }
        } while (!reponse.equals("q"));
    }

    public static String afficherMenu(){
        return "\n\nQue voulez-vous faire ?\n" +
                "Quitter : q\n" +
                "Voir Series : 1\n" +
                "Ajouter une série : 2\n" +
                "Supprimer une série : 3\n" +
                "Entrer dans une serie : écrire le nom\n";
    }

    public static String afficherMenuSeries(Series serie){
       return "\n\nQue voulez-vous faire ?\n" +
                "Quitter : q\n" +
                "Ajouter une saison : 1\n" +
                "Supprimer une saison : 2\n" +
                "Entrer dans une saison : écrire le nom\n";
    }

    public static String afficherMenuSaison(Season season){
        return "\n\nQue voulez-vous faire ?\n" +
                "Quitter : q\n" +
                "Ajouter un épisode : 1\n" +
                "Supprimer un épisode : 2\n" +
                "Marquer un épisode comme lu : 3\n"+
                "Noter un episode : 4\n";
    }

    public static void menuSaison(Season saison){
        Scanner scanner = new Scanner(System.in);
        String reponse;
        do {
            saison.printSeasons();
            saison.printEpisodes();
            reponse = lireString(scanner,afficherMenuSaison(saison));
            if(reponse.equals("1")) {
                ajouterEpisode(saison);
            }
            if(reponse.equals("2")) {
                supprimerEpisode(saison);
            }
            if(reponse.equals("3")) {
                voirEpisode(saison);
            }
            if(reponse.equals("4")) {
                rateEpisode(saison);
            }
        } while (!reponse.equals("q"));
    }

    public static void menuSeries(Series serie){
        Scanner scanner = new Scanner(System.in);
        String reponse;
        do {
            serie.displayInformation();
            reponse = lireString(scanner,afficherMenuSeries(serie));
            if(reponse.equals("1")) {
                ajouterSaison(serie);
            }
            if(reponse.equals("2")) {
                supprimerseason(serie);
            }
            for (Season saison : serie.getSeasons()) {
                if(saison.getName().toLowerCase().equals(reponse)) {
                    menuSaison(saison);
                }
            }
        } while (!reponse.equals("q"));
    }

    public static void ajouterSaison(Series serie){
        Scanner scanner = new Scanner(System.in);
        String reponse = lireString(scanner,"Quel est le nom de la saison à rajouter ?\n");
        serie.addSeason(new Season(reponse));
    }

    public static void voirEpisode(Season saison){
        Scanner scanner = new Scanner(System.in);
        String name = lireString(scanner,"Quel est le nom de l'épisode vu ?\n");
        for (Episode episode : saison.getListEpisodes()) {
            if(episode.getName().toLowerCase().equals(name)) {
                episode.setEpisodeVu(true);
            }
        }
    }

    public static void rateEpisode(Season saison){
        Scanner scanner = new Scanner(System.in);
        String name = lireString(scanner,"Quel est le nom de l'épisode a noter ?\n");
        int rate = lireInt(scanner,"Quel note /5 ?\n");
        for (Episode episode : saison.getListEpisodes()) {
            if(episode.getName().toLowerCase().equals(name)) {
                episode.rateEpisode(rate);
            }
        }
    }

    public static void ajouterEpisode(Season saison){
        Scanner scanner = new Scanner(System.in);
        String name = lireString(scanner,"Quel est le nom de l'épisode à rajouter ?\n");
        int duration = lireInt(scanner,"Quel est la durée de l'épisode à rajouter (minutes)?\n");
        saison.addEpisode(new Episode(name,duration));
    }

    public static void afficherSeries(ArrayList<Series> series){
        for (Series serie : series){
            serie.displayInformation();
        }
    }

    public static void showAllSeries(ArrayList<Series> series){
        for (Series serie : series){
            serie.displayInformation();
        }
    }

    public static void supprimerserie(ArrayList<Series> series){
        Scanner scanner = new Scanner(System.in);
        showAllSeries(series);
        String reponse = lireString(scanner,"Quel est le nom de la série à supprimer ?\n");
        for (Series serie : series){
            if (serie.getName().equalsIgnoreCase(reponse)){
                series.remove(serie);
                System.out.print("Série supprimé !\n");
                showAllSeries(series);
            }
        }
    }

    public static void supprimerEpisode(Season saison){
        Scanner scanner = new Scanner(System.in);
        saison.printEpisodes();
        String reponse = lireString(scanner,"Quel est le nom de l'épisode à supprimer ?\n");
        for (Episode episode : saison.getListEpisodes()){
            if (episode.getName().equalsIgnoreCase(reponse)){
                saison.removeEpisode(episode);
                System.out.print("Episode supprimé !\n");
            }
        }
    }

    public static void supprimerseason(Series serie){
        Scanner scanner = new Scanner(System.in);
        serie.displayInformation();
        String reponse = lireString(scanner,"Quel est le nom de la saison à supprimer ?\n");
        ArrayList<Season> seasons = serie.getSeasons();
        for ( int i=0; i< serie.getNumberSeasons(); i++){
            if (seasons.get(i).getName().equalsIgnoreCase(reponse)){
                serie.removeSeason(seasons.get(i));
                System.out.print("Saison supprimé !\n");
                serie.displayInformation();
            }
        }
    }

    // A ajouter dans la classe Main (par exemple avant ajouterserie)
    public static int lireInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Entree invalide, merci d'entrer un entier.\n");
            }
        }
    }

    public static String lireString(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input.toLowerCase();
            }
            System.out.print("Entree invalide, merci d'entrer un texte non vide.\n");
        }
    }

    public static void ajouterserie(ArrayList<Series> series){
        Scanner scanner = new Scanner(System.in);
        String name = lireString(scanner,"Quel est le nom de votre Série (minuscule sans accents) ?\n");
        int year = lireInt(scanner, "Sortie en quelle année ?\n");
        int month = lireInt(scanner, "Sortie quel mois ?\n");
        int day = lireInt(scanner, "Sortie quel jour ?\n");
        String response;
        do {
            response = lireString(scanner,"La série est-t-elle finie ? (o/n)");
            if(response.equals("o")) {
                int yearEnd = lireInt(scanner, "Fini en quelle année ?\n");
                int monthEnd = lireInt(scanner, "Fini quel mois ?\n");
                int dayEnd = lireInt(scanner, "Fini quel jour ?\n");
                Series series1 = new Series(name, LocalDate.of(year,month,day),LocalDate.of(yearEnd,monthEnd,dayEnd));
                series.add(series1);
            } else if(response.equals("n")) {
                Series series1 = new Series(name, LocalDate.of(year,month,day));
                series.add(series1);
            } else {
                System.out.print("Reponse invalide. Tape 'o' ou 'n'.\n");
            }
        } while (!response.equals("o") && !response.equals("n"));
    }
}