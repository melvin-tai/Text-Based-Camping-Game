package campings.locations;

import campings.Drinkable;
import campings.actions.Action;
import campings.actions.DrinkAction;
import campings.actions.ExploreAction;
import campings.Explorable;
import campings.Camper;
import campings.items.Ability;

import java.util.ArrayList;
import java.util.List;

/**
 * River is a class that represents a place the camper can explore and drink from.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class River implements Explorable, Drinkable {

    /**
     * Returns a list of allowable actions at the River.
     * @param camper the camper exploring the River
     * @return String menu description of the actions
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        List<Action> actions = new ArrayList<>();
        actions.add(new ExploreAction(this));
        actions.add(new DrinkAction(this));
        return actions;
    }

    /**
     * Defines what happens when a camper explores the River.
     * @param camper the camper exploring the River
     * @return String menu description of the action
     */
    @Override
    public String exploredBy(Camper camper) {
        camper.decreaseHydrationLevel(4);
        camper.increaseColdnessLevel(2);
        if (camper.hasCapability(Ability.IGNITE_FIRE)) {
            camper.increaseHydrationLevel(5);
            camper.decreaseColdnessLevel(3);
            return camper.getName() + " explored the River and started a fire. Hydration increased by 1. Coldness increased by 1.";
        }
        return camper.getName() + " explored the River. Hydration decreased by 4. Coldness increased by 2.";
    }

    /**
     * Defines what happens when a camper drinks from the River.
     * @param camper the camper drinking from the River
     * @return String menu description of the action
     */
    @Override
    public String drunkBy(Camper camper) {
        camper.increaseHydrationLevel(2);
        return camper.getName() + " drinks from the River. Hydration increased by 2.";
    }

    /**
     * Returns a string representation of the River.
     * @return String "River"
     */
    @Override
    public String toString() {
        return "River";
    }
}
