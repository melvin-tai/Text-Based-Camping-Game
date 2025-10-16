package campings.items;

import campings.Camper;
import campings.actions.Action;

import java.util.List;

/**
 * Bedroll is a class that the camper can use to rest.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Bedroll extends Item {

    /**
     * Constructing a Bedroll with a name and weight.
     * @param name the name of the Bedroll
     * @param weight the weight of the Bedroll
     */
    public Bedroll (String name, double weight) {
        super(name, weight);
        this.addCapability(Ability.RESTING);
    }

    /**
     * Returns a string representation of the Bedroll.
     * @return String menu description of the action
     */
    @Override
    public String toString() {
        return super.toString() + " - to rest.";
    }

    /**
     * Defines what happens when a camper rests with the Bedroll.
     * Note: Resting happens as long as the camper has the Bedroll; no further actions needed.
     * @param camper the camper resting from the Bedroll
     * @return String menu description of the action
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        return List.of();
    }
}
