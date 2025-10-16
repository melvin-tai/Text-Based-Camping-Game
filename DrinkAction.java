package campings.actions;

import campings.Camper;
import campings.Campsite;
import campings.Drinkable;

/**
 * DrinkAction is a class used to drink from an object or a place.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class DrinkAction extends Action {

    /**
     * Determines if an Item is Drinkable.
     */
    private Drinkable drinkable;

    /**
     * Constructs a DrinkAction for a Drinkable Item.
     * @param drinkable Item
     */
    public DrinkAction(Drinkable drinkable) {
        this.drinkable = drinkable;
    }

    /**
     * Executes DrinkAction.
     * @param camper performing the DrinkAction
     * @param campsite -
     * @return String DrinkAction
     */
    @Override
    public String execute(Camper camper, Campsite campsite) {
        return this.drinkable.drunkBy(camper);
    }

    /**
     * Returns a Menu with DrinkAction.
     * @param camper performing the DrinkAction
     * @return String description of DrinkAction
     */
    @Override
    public String menuDescription(Camper camper) {
        return camper + " will drink from " + this.drinkable;
    }
}