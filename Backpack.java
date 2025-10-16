package campings;

import campings.actions.Action;
import campings.items.Bedroll;
import campings.items.Bottle;
import campings.items.FlintAndSteel;
import campings.items.Item;
import campings.items.OilLantern;

import java.util.ArrayList;
import java.util.List;

/**
 * Backpack is a class that represents if a Location is Explorable by a Camper.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Backpack implements ActionCapable {

    /**
     * List of Items stored in a Camper's Backpack.
     */
    private List<Item> items;

    /**
     * Maximum weight of a Camper's Backpack.
     */
    private double weightLimit;

    /**
     * Constructs a Backpack with a weightLimit, holding a Bedroll, Bottle, FlintAndSteel, and OilLantern.
     * @param weightLimit of the Backpack
     */
    public Backpack(double weightLimit) {
        this.weightLimit = weightLimit;
        this.items = new ArrayList<>();

        Bedroll bedroll = new Bedroll("KAMUI", 7);
        Bottle bottle = new Bottle("Mountain Franklin", 1, 1);
        FlintAndSteel flintandsteel = new FlintAndSteel("Aurora", 0.5);
        OilLantern oillantern = new OilLantern("Feuerhand", 1.5);

        this.items.add(bedroll);
        this.items.add(bottle);
        this.items.add(flintandsteel);
        this.items.add(oillantern);
    }

    /**
     * Returns the list of Items in Backpack.
     * @return list of Items in the Backpack.
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * Returns a copy of the list of Items in Backpack.
     * @return new list of Items in the Backpack
     */
    public List<Item> getAllItems() {
        return new ArrayList<>(this.items);
    }

    /**
     * Calculates the total weight of Items in Backpack.
     * @return total weight of all Items
     */
    public double getTotalWeight() {
        double total = 0;
        for (Item item : this.items) {
            total += item.getWeight();
        }
        return total;
    }

    /**
     * Returns the maximum weight capacity of Backpack.
     * @return weight limit of Backpack
     */
    public double getWeightLimit() {
        return weightLimit;
    }

    /**
     * Adds an Item to Backpack if total weight does not exceed weight limit.
     * @param item added
     * @return TRUE if Item is added, otherwise FALSE
     */
    public boolean add(Item item) {
        if (getTotalWeight() + item.getWeight() <= weightLimit) {
            this.items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Removes an Item from Backpack.
     * @param item removed
     * @return TRUE if Item is removed, otherwise FALSE
     */
    public boolean remove(Item item) {
        return this.items.remove(item);
    }

    /**
     * Returns list of allowed Actions by Items in Backpack.
     * @param camper interacting with the Backpack
     * @return list of allowableActions for the Camper
     */
    public List<Action> allowableActions(Camper camper) {
        List<Action> actions = new ArrayList<>();
        for (Item item : this.items) {
            actions.add(item.getUnpackAction());
            actions.addAll(item.allowableActions(camper));
        }
        return actions;
    }
}