package campings;

import campings.actions.Action;
import campings.items.Bedroll;
import campings.items.Item;
import campings.items.Torch;
import campings.locations.Trail;
import campings.locations.River;
import campings.locations.MountainSpring;

import java.util.List;
import java.util.ArrayList;

/**
 * Campsite is a class that represents where a camper goes.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Campsite implements ActionCapable {

    /**
     * A Camper.
     */
    private Camper camper;

    /**
     * List of Items scattered on a Campsite.
     */
    private List<Item> scatteredItems;

    /**
     * List of Locations a Camper can explore.
     */
    private List<Explorable> explorablePlaces = new ArrayList<>();

    /**
     * Constructs a Campsite for a Camper, with scatteredItems Bedroll and Torch, and explorablePlaces Trail, River, and MountainSpring.
     * @param camper accommodated by this Campsite
     */
    public Campsite(Camper camper) {
        this.camper = camper;
        this.scatteredItems = new ArrayList<>();

        this.scatteredItems.add(new Bedroll("KAMUI V2", 7));
        this.scatteredItems.add(new Torch("Pine wood", 1));

        explorablePlaces.add(new Trail());
        explorablePlaces.add(new River());
        explorablePlaces.add(new MountainSpring());
    }

    /**
     * Adds an Item to Campsite’s scatteredItems.
     * @param item added
     */
    public void addItem(Item item) {
        this.scatteredItems.add(item);
    }

    /**
     * Removes an Item from Campsite’s scatteredItems.
     * @param item removed
     */
    public void removeItem(Item item) {
        this.scatteredItems.remove(item);
    }

    /**
     * Retrieves all allowableActions for a Camper.
     * @param camper performing the Actions
     * @return list of allowableActions
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        List<Action> actions = new ArrayList<>();
        for (Item item : this.scatteredItems) {
            actions.add(item.getPackAction());
        }
        for (Explorable place : this.explorablePlaces) {
            actions.addAll(place.allowableActions(camper));
        }
        return actions;
    }

    /**
     * Prints out all Items scattered on Campsite.
     */
    public void listOutItems() {
        System.out.println("Here are the items that we have on campsite:");
        for (Item item : this.scatteredItems) {
            System.out.println(item);
        }
    }

    /**
     * Simulates Campsite interaction.
     * @return String descriptions of Campsite allowableActions.
     */
    public void simulate() {
        List<Action> actions = new ArrayList<>();
        actions.addAll(this.allowableActions(this.camper));
        actions.addAll(camper.allowableActions());
        System.out.println("#########################################");
        this.camper.checkAllItems();
        System.out.println();
        this.listOutItems();
        System.out.println("\n#########################################");
        Action action = Menu.showMenu(actions, camper);
        System.out.println(action.execute(camper, this) + "\n\n");
    }
}
