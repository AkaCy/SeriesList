/**The main file, in charge of merging all the classes together, a full manager in charge of:
 * -Displaying the list of series
 * -Incorporating series along with defining all of their representative parts (Thanks to the class season).
 * Doing it in a loop until the user wants to quit.
 *
 * @author Cyril
 * @version 1.2
 * @since 18/03/2026
 * @see LocalDate, ArrayList, Scanner
 */

import classes.Episode;
import classes.Season;
import classes.Series;
import classes.GenreList;
import enumPack.Genre;

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

               "Ajouter un genre : 4 \n" +
               "Soustraire un genre : 5 \n" +
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
            if(reponse.equals("4")){
                addGenre(serie);
            }
            if(reponse.equals("5")){
                subsGenre(serie);
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

    public static void addGenre(Series serie){
        int i = 1;
        for(Genre genre : Genre.values()){
            System.out.println(i + "-" + genre);
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int genreValue = lireInt(scanner, "Choose what genre to add (number) : \n");
        genreValue--;
        i = 0;
        for(Genre genre : Genre.values()){
            if(i == genreValue){
                serie.addGenre(genre);
            }
            i++;
        }
    }

    public static void subsGenre(Series serie){
        serie.printGenreList();
        Scanner scanner = new Scanner(System.in);
        int genreValue = lireInt(scanner, "Choose what genre to remove (number) : \n");
        genreValue--;
        Genre genreToRemove = Genre.NaN;
        int i = 0;
        for(Genre genre : serie.getGenreList()){
            if(i == genreValue){
                genreToRemove = genre;
            }
            i++;
        }
        if(genreToRemove != Genre.NaN){
            serie.removeGenre(genreToRemove);
        }

    }

    public static void ajouterserie(ArrayList<Series> series){
        Scanner scanner = new Scanner(System.in);
        String name = lireString(scanner,"Quel est le nom de votre Série (minuscule sans accents) ?\n");
        int year = lireInt(scanner, "Sortie en quelle année ?\n");
        System.out.println(year);
        System.out.println(year<2026);
        while(year>2026 || year<0){
            System.out.println("Wrong input (either future or negative number) \n");
            year = lireInt(scanner, "Sortie en quelle année ?\n");
        }
        int month = lireInt(scanner, "Sortie quel mois ?\n");
        while((month>12) || (month<0)){
            System.out.println("Wrong input, we have 12 months bro, what are you doing? (either future or negative number) \n");
            month = lireInt(scanner, "Sortie quel mois ?\n");
        }
        int day = lireInt(scanner, "Sortie quel jour ?\n");
        if(month == 1 || month== 3 || month== 5 || month== 7 || month== 8 || month== 10 || month== 12){
            while((day>31) || (day<0)){
                System.out.println("Omg bro are you inventing days now? \n");
                day = lireInt(scanner, "Sortie quel jour ?\n");
            }
        } else if (month == 4 || month== 6 || month== 9 || month == 11) {
            while((day>30) || (day<0)){
                System.out.println("Omg bro are you inventing days now? \n");
                day = lireInt(scanner, "Sortie quel jour ?\n");
            }
        } else if ((month == 2) && ((year%400 ==0) && (!(year%100 == 0)))){
            while((day>29) || (day<0)){
                System.out.println("Clue : it's february and we're in a leap year \n");
                day = lireInt(scanner, "Sortie quel jour ?\n");
            }
        }else{
            while((day>28) || (day<0)){
                System.out.println("Clue : it's february and we're not in a leap year \n");
                day = lireInt(scanner, "Sortie quel jour ?\n");
            }
        }

        String response;
        do {
            response = lireString(scanner,"La série est-t-elle finie ? (o/n)");
            if(response.equals("o")) {
                int yearEnd = lireInt(scanner, "Fini en quelle année ?\n");
                while(yearEnd>2026 || yearEnd<0 || yearEnd<year){
                    System.out.println("Either our of range, negative or earlier than the date it came out \n");
                    yearEnd = lireInt(scanner, "Fini en quelle année ?\n");
                }
                int monthEnd = lireInt(scanner, "Fini quel mois ?\n");
                while((monthEnd>12) || (monthEnd<0) || (yearEnd == year && monthEnd<month)){
                    System.out.println("Either our of range, negative or earlier than the date it came out \n");
                    monthEnd = lireInt(scanner, "Fini quel mois ?\n");
                }
                int dayEnd = lireInt(scanner, "Fini quel jour ?\n");
                if(monthEnd == 1 || monthEnd== 3 || monthEnd== 5 || monthEnd== 7 || monthEnd== 8 || monthEnd== 10 || monthEnd== 12){
                    while((dayEnd>31) || (dayEnd<0) || (yearEnd == year && monthEnd==month && dayEnd<day)){
                        System.out.println("Either our of range, negative or earlier than the date it came out \n");
                        dayEnd = lireInt(scanner, "Sortie quel jour ?\n");
                    }
                } else if (monthEnd == 4 || monthEnd== 6 || monthEnd== 9 || monthEnd == 11) {
                    while((dayEnd>30) || (dayEnd<0) || (yearEnd == year && monthEnd==month && dayEnd<day)){
                        System.out.println("Either our of range, negative or earlier than the date it came out \n");
                        dayEnd = lireInt(scanner, "Fini quel jour ?\n");
                    }
                } else if ((monthEnd == 2) && ((yearEnd%400 ==0) && (!(yearEnd%100 == 0)))){
                    while((dayEnd>29) || (dayEnd<0) || (yearEnd == year && monthEnd==month && dayEnd<day)){
                        System.out.println("Either our of range, negative or earlier than the date it came out \n");
                        dayEnd = lireInt(scanner, "Fini quel jour ?\n");
                    }
                }else{
                    while((dayEnd>28) || (dayEnd<0) || (yearEnd == year && monthEnd==month && dayEnd<day)){
                        System.out.println("Either our of range, negative or earlier than the date it came out \n");
                        dayEnd = lireInt(scanner, "Fini quel jour ?\n");
                    }
                }
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