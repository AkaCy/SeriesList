/**In charge of testing the episode class
 *
 * @author Cyril
 * @version 1.0
 * @since 13/03/2026
 */
package tests;

import classes.Episode;

public class TestEpisode {
    public static void main(String[] args) {
        // Test avec une liste d'un élément
        Episode episode1BB = new Episode("Chute libre", 58);
        System.out.println("================== Episode Chute libre de Breaking Bad de 58 min non vu non raté    ==================");
        episode1BB.printEpisode(false);

        episode1BB.rateEpisode(4.5);

        System.out.println();

    }
}
