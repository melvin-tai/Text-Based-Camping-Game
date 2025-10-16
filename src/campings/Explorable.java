package campings;

/**
 * Campsite is an interface that represents if a Location is Explorable by a Camper.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public interface Explorable extends ActionCapable {

    /**
     * Defines what happens when a Camper explores a Location.
     * @param camper performing ExploreAction
     * @return String description of ExploreAction
     */
    public String exploredBy(Camper camper);
}
