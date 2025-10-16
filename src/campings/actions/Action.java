package campings.actions;

import campings.Camper;
import campings.Campsite;

/**
 * Action is an abstract class that represents the camper's allowed actions.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public abstract class Action {

    /**
     * Executes an Action for a Camper in a Campsite.
     * @param camper performing the Action
     * @param campsite where Action happens
     * @return String description of the Action
     */
    public abstract String execute(Camper camper, Campsite campsite);

    /**
     * Returns a Menu with Action.
     * @param camper performing the Action
     * @return String description of the Action
     */
    public abstract String menuDescription(Camper camper);
}
