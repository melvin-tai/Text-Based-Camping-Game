package campings.actions;

import campings.Camper;
import campings.Campsite;
import campings.items.Flammable;

/**
 * IgniteAction is a class used to ignite a flammable object.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class IgniteAction extends Action {

    /**
     * Determines if an Item is Flammable.
     */
    private Flammable flammable;

    /**
     * Constructs a IgniteAction for a Flammable Item.
     * @param flammable Item
     */
    public IgniteAction(Flammable flammable) {
        this.flammable = flammable;
    }

    /**
     * Executes IgniteAction.
     * @param camper performing the IgniteAction
     * @param campsite -
     * @return String IgniteAction
     */
    @Override
    public String execute(Camper camper, Campsite campsite) {
        return flammable.ignitedBy(camper);
    }

    /**
     * Returns a Menu with IgniteAction.
     * @param camper performing the IgniteAction
     * @return String description of IgniteAction
     */
    @Override
    public String menuDescription(Camper camper) {
        return camper + " will ignite " + flammable.getClass().getSimpleName();
    }
}
