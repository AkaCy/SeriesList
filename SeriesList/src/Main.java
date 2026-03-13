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
        do {
            afficherMenu();
            reponse = scanner.nextLine().trim().toLowerCase();
            if(reponse.equals("1")) {
                afficherSeries(series);
            }
            if(reponse.equals("2")) {
                ajouterserie(series);
            }
            if(reponse.equals("3")) {
                supprimerserie(series);
            }
            for (Series serie : series){
                if(serie.getName().toLowerCase().equals(reponse)) {
                    afficherMenuSeries(serie);
                }
            }
        } while (!reponse.equals("q"));
    }

    public static void afficherMenu(){
        System.out.print("Que voulez-vous faire ?\n" +
                "Quitter : q\n" +
                "Voir Series : 1\n" +
                "Ajouter une série : 2\n" +
                "Supprimer une série : 3\n" +
                "Entrer dans une serie : écrire le nom\n");
    }

    public static void afficherMenuSeries(Series serie){
        serie.displayInformation();
        System.out.print("Que voulez-vous faire ?\n" +
                "Quitter : q\n" +
                "Ajouter une saison : 1\n" +
                "Supprimer une saison : 2\n" +
                "Entrer dans une saison : écrire le nom\n");
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine().trim().toLowerCase();
    }

    public static void afficherSeries(ArrayList<Series> series){
        for (Series serie : series){
            serie.displayInformation();
        }
    }

    public static void supprimerserie(ArrayList<Series> series){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sortie en quelle année ?\n");
        String reponse = scanner.nextLine().trim().toLowerCase();
        for (Series serie : series){
            if (serie.getName().equalsIgnoreCase(reponse)){
                series.remove(serie);
            }
        }
    }

    public static void ajouterserie(ArrayList<Series> series){
        Scanner scanner = new Scanner(System.in);
        //    public Series(String name, int Seasons, LocalDate releaseDate, LocalDate endDate){
        System.out.print("Quel est le nom de votre Série (minuscule sans accents) ?\n");
        String name = scanner.nextLine();
        System.out.print("Sortie en quelle année ?\n");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Sortie quel mois ?\n");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Sortie quel jour ?\n");
        int day = Integer.parseInt(scanner.nextLine());

        System.out.print("La série est-t-elle finie ? (o/n)\n");
        String response = scanner.nextLine();
        do {
            if(response.equals("o")) {
                System.out.print("Quelle date de fin année ?\n");
                int yearEnd = Integer.parseInt(scanner.nextLine());
                System.out.print("Date de fin : mois ?\n");
                int monthEnd = Integer.parseInt(scanner.nextLine());
                System.out.print("date de fin jour ?\n");
                int dayEnd = Integer.parseInt(scanner.nextLine());
                Series series1 = new Series(name, LocalDate.of(year,month,day),LocalDate.of(yearEnd,monthEnd,dayEnd));
                series.add(series1);
            } else if(response.equals("n")) {
                Series series1 = new Series(name, LocalDate.of(year,month,day));
                series.add(series1);
            }
        } while (!response.equals("o") && !response.equals("n"));
    }
}