package campings.items;

import campings.Camper;
import campings.actions.Action;

import java.util.List;

/**
 * FlintAndSteel is a class that the camper can use to ignite fires.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class FlintAndSteel extends Item {

    /**
     * Constructing a FlintAndSteel with a name and weight.
     * @param name the name of the FlintAndSteel
     * @param weight the weight of the FlintAndSteel
     */
    public FlintAndSteel(String name, double weight) {
        super(name, weight);
        this.addCapability(Ability.IGNITE_FIRE);
    }

    /**
     * Returns a string representation of the FlintAndSteel.
     * @return String menu description of the action
     */
    @Override
    public String toString() {
        return super.toString() + " - to start a fire.";
    }

    /**
     * Defines what happens when a camper rests with the FlintAndSteel.
     * Note: Starting a fire happens as long as the camper has the FlintAndSteel; no further actions needed.
     * @param camper the camper resting from the Bedroll
     * @return String menu description of the action
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        return List.of();
    }
}
