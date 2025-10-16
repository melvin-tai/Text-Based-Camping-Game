package campings.locations;

import campings.Camper;
import campings.Explorable;
import campings.actions.Action;
import campings.actions.ExploreAction;
import campings.items.Ability;

import java.util.ArrayList;
import java.util.List;

public class Trail implements Explorable {

    /**
     * Returns a list of allowable actions at the Trail.
     * @param camper the camper exploring the Trail
     * @return String menu description of the action
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        List<Action> actions = new ArrayList<>();
        actions.add(new ExploreAction(this));
        return actions;
    }

    /**
     * Defines what happens when a camper explores the Trail.
     * @param camper the camper exploring the Trail
     * @return String menu description of the action
     */
    @Override
    public String exploredBy(Camper camper) {
        camper.decreaseHydrationLevel(3);
        camper.increaseColdnessLevel(3);
        if (camper.hasCapability(Ability.RESTING)) {
            camper.increaseHydrationLevel(1);
            camper.decreaseColdnessLevel(4);
        }
        return camper.getName() + " explored the Trail.";
    }

    /**
     * Returns a string representation of the Trail.
     * @return String "Trail"
     */
    @Override
    public String toString() {
        return "Trail";
    }
}