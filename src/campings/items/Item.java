package campings.items;

import java.util.HashSet;
import java.util.Set;

import campings.ActionCapable;
import campings.actions.PackAction;
import campings.actions.UnpackAction;

/**
 * Item is an abstract class for camping items.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public abstract class Item implements ActionCapable {

    /**
     * Name of an Item.
     */
    String name;

    /**
     * Weight of an Item (kg).
     */
    double weight;

    /**
     * Capabilities of an(y) Item.
     */
    private Set<Enum<Ability>> statuses;

    /**
     * Constructs a new Item with a specified name and weight.
     * @param name of the Item
     * @param weight of the Item (kg)
     */
    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.statuses = new HashSet<>();
    }

    /**
     * Returns the simple class name of an Item.
     * @return getSimpleName of the Item
     */
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Returns the weight of an Item.
     * @return Weight of the item
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Packs an Item from a Camper's storage.
     * @return PackAction of the Item
     */
    public PackAction getPackAction() {
        return new PackAction(this);
    }

    /**
     * Unpacks an Item from a Camper's storage.
     * @return UnpackAction of the Item
     */
    public UnpackAction getUnpackAction() {
        return new UnpackAction(this);
    }

    /**
     * Add a Capability from an Item.
     * @param capability the capability to be added
     */
    protected void addCapability(Enum<Ability> capability) {
        this.statuses.add(capability);
    }

    /**
     * Removes a Capability from an Item.
     * @param capability the capability to be removed
     */
    protected void removeCapability(Enum<Ability> capability) {
        this.statuses.remove(capability);
    }

    /**
     * Checks whether an Item has a Capability.
     * @param capability the Capability to check
     * @return TRUE if the Item has the Capability, otherwise FALSE
     */
    public boolean hasCapability(Enum<Ability> capability) {
        return this.statuses.contains(capability);
    }

    /**
     * Returns a string representation of the item's name and weight.
     * @return String of the item
     */
    @Override
    public String toString() {
        return String.format("%s (%s) has weight of %.2f kg", getSimpleName(), name, weight);
    }
}
