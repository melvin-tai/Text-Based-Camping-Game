package campings.items;

import campings.actions.Action;
import campings.actions.IgniteAction;
import campings.Camper;

import java.util.ArrayList;
import java.util.List;

/**
 * OilLantern is a class that represents a flammable object that reduces coldness by 2 when ignited.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class OilLantern extends Item implements Flammable {

    /**
     * The REDUCE_COLDNESS_VALUE reduced by the OilLantern.
     */
    private int REDUCE_COLDNESS_VALUE = 2;

    /**
     * Constructing a OilLantern with a name and weight.
     * @param name the name of the OilLantern
     * @param weight the weight of the OilLantern
     */
    public OilLantern(String name, double weight) {
        super(name, weight);
    }

    /**
     * Defines what happens when a camper ignites the OilLantern.
     * @param camper the camper igniting the OilLantern
     * @return String menu description of the action
     */
    @Override
    public String ignitedBy(Camper camper) {
        camper.decreaseColdnessLevel(REDUCE_COLDNESS_VALUE);
        return this.getSimpleName() + " is ignited by " + camper + " and it reduces the coldness by " + REDUCE_COLDNESS_VALUE;
    }

    /**
     * Defines what happens when a camper has the OilLantern, which can be lit by a FlintAndSteel.
     * @param camper the camper resting from the OilLantern
     * @return String menu description of the action
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        List<Action> actions = new ArrayList<>();
        if (camper.hasCapability(Ability.IGNITE_FIRE)) {
            actions.add(new IgniteAction(this));
        }
        return actions;
    }

    /**
     * Returns a string representation of the OilLantern.
     * @return String menu description of the action
     */
    @Override
    public String toString() {
        return super.toString() + " - to reduce the cold.";
    }
}
