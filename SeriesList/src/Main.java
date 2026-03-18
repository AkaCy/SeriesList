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
            System.out.print("What do you want to do?\nQuit: q\nList series: 1\nAdd a series: 2\n");
            reponse = scanner.nextLine().trim().toLowerCase();
            if(reponse.equals("1")) {
                for (Series serie : series){
                    serie.displayInformation();
                }
            }
            if(reponse.equals("2")) {
                //    public Series(String name, int Seasons, LocalDate releaseDate, LocalDate endDate){
                System.out.print("What's the name of the series\n");
                String name = scanner.nextLine();
                System.out.print("What year did it go out?\n");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("What month did it go out?\n");
                int month = Integer.parseInt(scanner.nextLine());
                System.out.print("What day did it go out?\n");
                int day = Integer.parseInt(scanner.nextLine());

                System.out.print("La série est-t-elle finie ? (o/n)\n");
                String response = scanner.nextLine();
                do {
                    if(response.equals("y")) {
                        System.out.print("What year did it end?\n");
                        int yearEnd = Integer.parseInt(scanner.nextLine());
                        System.out.print("What month did it end?\n");
                        int monthEnd = Integer.parseInt(scanner.nextLine());
                        System.out.print("What day did it end?\n");
                        int dayEnd = Integer.parseInt(scanner.nextLine());
                        Series series1 = new Series(name, LocalDate.of(year,month,day),LocalDate.of(yearEnd,monthEnd,dayEnd));
                        series.add(series1);
                    } else if(response.equals("n")) {
                        Series series1 = new Series(name, LocalDate.of(year,month,day));
                        series.add(series1);
                    }
                } while (!response.equals("y") && !response.equals("n"));
            }
        } while (!reponse.equals("q"));
    }
}