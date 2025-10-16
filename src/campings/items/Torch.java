package campings.items;

import campings.actions.Action;
import campings.actions.IgniteAction;
import campings.Camper;

import java.util.ArrayList;
import java.util.List;

/**
 * Torch is a class that represents a flammable object that reduces coldness by 1 when ignited.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Torch extends Item implements Flammable {

    /**
     * The REDUCE_COLDNESS_VALUE reduced by the Torch.
     */
    private int REDUCE_COLDNESS_VALUE = 1;

    /**
     * Constructing a Torch with a name and weight.
     * @param name the name of the Torch
     * @param weight the weight of the Torch
     */
    public Torch(String name, double weight) {
        super(name, weight);
    }

    /**
     * Defines what happens when a camper ignites the Torch.
     * @param camper the camper igniting the Torch
     * @return String menu description of the action
     */
    @Override
    public String ignitedBy(Camper camper) {
        camper.decreaseColdnessLevel(REDUCE_COLDNESS_VALUE);
        return this.getSimpleName() + " is ignited by " + camper + " and it reduced the coldness by " + REDUCE_COLDNESS_VALUE + ".";
    }

    /**
     * Returns the allowable actions for the Torch.
     * @param camper the camper asking for allowable actions
     * @return list of actions the camper can do
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
     * Returns a string representation of the Torch.
     * @return String menu description of the action
     */
    @Override
    public String toString() {
        return super.toString() + " - to light the surrounding.";
    }
}
