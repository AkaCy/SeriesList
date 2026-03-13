import classes.Series;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reponse;
        ArrayList<Series> series = new ArrayList<>();
        do {
            System.out.print("Que voulez-vous faire ?\nQuitter : q\nVoir Series : 1\nAjouter une série : 2\n");
            reponse = scanner.nextLine().trim().toLowerCase();
            if(reponse.equals("1")) {
                for (Series serie : series){
                    serie.displayInformation();
                }
            }
            if(reponse.equals("2")) {
                //    public Series(String name, int Seasons, LocalDate releaseDate, LocalDate endDate){
                System.out.print("Quel est le nom de votre Série ?\n");
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
        } while (!reponse.equals("q"));
    }
}