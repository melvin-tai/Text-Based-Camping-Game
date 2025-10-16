package campings.actions;

import campings.items.Item;
import campings.Camper;
import campings.Campsite;

/**
 * UnpackAction is a class for camper to unpack items.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class UnpackAction extends Action {
    /**
     * Determines if an Item is in a Camper's Backpack.
     */
    private Item item;

    /**
     * Constructs a UnpackAction for an Item.
     * @param item packed
     */
    public UnpackAction(Item item) {
        this.item = item;
    }

    /**
     * Executes UnpackAction.
     * @param camper performing the UnpackAction
     * @param campsite -
     * @return String UnpackAction
     */
    @Override
    public String execute(Camper camper, Campsite campsite) {
        if (camper.getBackpack().remove(this.item)) {
            campsite.addItem(this.item);
            return camper + " removed " + this.item.getSimpleName() + " from the backpack";
        }
        return this.item.getSimpleName() + " can not be unpacked";
    }

    /**
     * Returns a Menu with UnpackAction.
     * @param camper performing the UnpackAction
     * @return String description of UnpackAction
     */
    @Override
    public String menuDescription(Camper camper) {
        return camper + " will unpack " + this.item.getSimpleName() + " from the backpack";
    }
}
