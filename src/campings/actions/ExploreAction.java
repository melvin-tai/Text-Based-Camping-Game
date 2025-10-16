package campings.actions;

import campings.Camper;
import campings.Campsite;
import campings.Explorable;

/**
 * ExploreAction is a class used to explore a place.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class ExploreAction extends Action {

    /**
     * Determines if a Location is Explorable.
     */
    private Explorable explorable;

    /**
     * Constructs a ExploreAction for an Explorable Location.
     * @param explorable Location
     */
    public ExploreAction(Explorable explorable) {
        this.explorable = explorable;
    }

    /**
     * Executes ExploreAction.
     * @param camper performing the ExploreAction
     * @param campsite -
     * @return String ExploreAction
     */
    @Override
    public String execute(Camper camper, Campsite campsite) {
        return explorable.exploredBy(camper);
    }

    /**
     * Returns a Menu with ExploreAction.
     * @param camper performing the ExploreAction
     * @return String description of ExploreAction
     */
    @Override
    public String menuDescription(Camper camper) {
        return camper + " will explore " + this.explorable;
    }
}
