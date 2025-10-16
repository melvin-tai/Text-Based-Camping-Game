package campings;

/**
 * The entry point to run the campings application.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Application {

    /**
     * The method to run the camping simulation.
     */
    public static void main(String[] args) {
        Camper camper = new Camper("Cloudy");
        Campsite campsite = new Campsite(camper);
        while (camper.isConscious()) {
            campsite.simulate();
        }
        System.out.println("You lived a good one. Start again.");
    }
}
