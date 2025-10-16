package campings.locations;

import campings.actions.Action;
import campings.actions.ExploreAction;
import campings.actions.DrinkAction;
import campings.Explorable;
import campings.Camper;
import campings.Drinkable;

import java.util.ArrayList;
import java.util.List;

/**
 * MountainSpring is a class that represents a place the camper can explore and drink from.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class MountainSpring implements Explorable, Drinkable {

    /**
     * Returns a list of allowable actions at the MountainSpring.
     * @param camper the camper exploring the MountainSpring
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
        camper.decreaseHydrationLevel(3);
        camper.increaseColdnessLevel(2);
        return camper.getName() + " explored the Mountain Spring. Hydration decreased by 3. Coldness increased by 2.";
    }

    /**
     * Defines what happens when a camper drinks from the River.
     * @param camper the camper drinking from the River
     * @return String menu description of the action
     */
    @Override
    public String drunkBy(Camper camper) {
        camper.increaseHydrationLevel(3);
        return camper.getName() + " drinks from the Mountain Spring. Hydration increased by 3.";
    }

    /**
     * Returns a string representation of the MountainSpring.
     * @return String "MountainSpring"
     */
    @Override
    public String toString() {
        return "MountainSpring";
    }
}
