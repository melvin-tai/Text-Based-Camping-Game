package campings.actions;

import campings.items.Item;
import campings.Camper;
import campings.Campsite;

/**
 * PackAction is a class for camper to pack items.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class PackAction extends Action {

    /**
     * Determines if an Item is in a Camper's Backpack.
     */
    private Item item;

    /**
     * Constructs a PackAction for an Item.
     * @param item packed
     */
    public PackAction(Item item) {
        this.item = item;
    }

    /**
     * Executes PackAction.
     * @param camper performing the PackAction
     * @param campsite -
     * @return String PackAction
     */
    @Override
    public String execute(Camper camper, Campsite campsite) {
        if (camper.getBackpack().add(this.item)) {
            campsite.removeItem(this.item);
            return camper + " packed " + this.item.getSimpleName() + " to the backpack";
        }
        return this.item.getSimpleName() + " can not be packed as it will exceed the backpack limit";
    }

    /**
     * Returns a Menu with PackAction.
     * @param camper performing the PackAction
     * @return String description of PackAction
     */
    @Override
    public String menuDescription(Camper camper) {
        return camper + " will pack " + this.item.getSimpleName() + " to the backpack";
    }
}
