package campings.items;

import campings.Camper;
import campings.Drinkable;
import campings.actions.Action;
import campings.actions.DrinkAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Bottle is a class that the camper can use to drink.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Bottle extends Item implements Drinkable {

    /**
     * The capacity of the Bottle (liters).
     */
    private double capacity;

    /**
     * Constructing a Bottle with a name, weight, and capacity.
     * @param name the name of the Bottle
     * @param weight the weight of the Bottle
     * @param capacity the capacity (liters) of the Bottle
     */
    public Bottle(String name, double weight, double capacity) {
        super(name, weight);
        this.capacity = capacity;
    }

    /**
     * Returns the allowable actions for the Bottle.
     * @param camper the camper asking for allowable actions
     * @return list of actions the camper can do
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        List<Action> actions = new ArrayList<>();
        actions.add(new DrinkAction(this));
        return actions;
    }

    /**
     * Defines what happens when a camper drinks from the Bottle.
     * @param camper the camper drinking from the Bottle
     * @return String menu description of the action
     */
    @Override
    public String drunkBy(Camper camper) {
        if (this.capacity > 0.15) {
            this.capacity -= 0.15;
            camper.increaseHydrationLevel(2);
            return String.format("%s drinks from the Bottle. Hydration increased by 2. Remaining Bottle Capacity: %.2f liter.", camper.getName(), this.capacity);
        } else if (this.capacity > 0 && this.capacity < 0.15) {
            this.capacity = 0;
            return String.format("%s sips the last droplets from the Bottle. Hydration not increased. Remaining Bottle Capacity: %.2f liter.", camper.getName(), this.capacity);
        }
        return String.format("There is no more water in %s's Bottle (%s)!", camper.getName(), super.name);
    }

    /**
     * Returns a string representation of the Bottle and show capacity left.
     * @return String menu description of the action
     */
    @Override
    public String toString() {
        return super.getSimpleName() + " (" + super.name + ") - to drink, with " + capacity + " liter left.";
    }
}