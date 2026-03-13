package tests;

import classes.Episode;

public class TestEpisode {
    public static void main(String[] args) {
        // Test avec une liste d'un élément
        Episode episode1BB = new Episode("Chute libre", 58);
        System.out.println("================== Episode Chute libre de Breaking Bad de 58 min non vu non raté    ==================");
        episode1BB.printEpisode();

        episode1BB.rateEpisode(4.5);

        System.out.println();

    }
}
