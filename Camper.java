package campings;

import campings.actions.Action;
import campings.items.Item;
import campings.items.Ability;

import java.util.List;

/**
 * Camper is a class that initializes a camper.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public class Camper implements ActionCapable {

    /**
     * Camper's name.
     */
    private String name;

    /**
     * Camper's Backpack.
     */
    private Backpack backpack;

    /**
     * Camper's Hydration Level.
     */
    private int hydrationLevel;

    /**
     * Camper's Coldness.
     */
    private int coldnessLevel;

    /**
     * Constructs a Camper with a name, backpack (10 kg weightLimit), 20 hydrationLevel, and 20 coldnessLevel.
     * @param name of Camper
     */
    public Camper(String name) {
        this.name = name;
        this.backpack = new Backpack(10);
        this.hydrationLevel = 20;
        this.coldnessLevel = 20;
    }

    /**
     * Retrieves Camper's Backpack.
     * @return Backpack of Camper
     */
    public Backpack getBackpack() {
        return this.backpack;
    }

    /**
     * Retrieves Camper's name.
     * @return name of Camper
     */
    public String getName() {
        return this.name;
    }

    /**
     * Displays all Items in Camper's Backpack with total and maximum weight.
     */
    public void checkAllItems() {
        System.out.printf("Here are the items that %s has in the Backpack (%.2f / %.2fkg):\n",
                this.name, this.backpack.getTotalWeight(), this.backpack.getWeightLimit());
        for (Item item : this.backpack.getItems()) {
            System.out.println(item);
        }
    }

    /**
     * Retrieves all allowableActions that a Camper can perform according to Items in Backpack.
     * @param camper performing the allowableActions
     * @return list of allowableActions
     */
    @Override
    public List<Action> allowableActions(Camper camper) {
        return this.backpack.allowableActions(camper);
    }

    /**
     * Checks if Camper have capabilities from Items in Backpack.
     * @param capability for Camper to use Abilities
     * @return TRUE if Camper has the capability, otherwise FALSE
     */
    public boolean hasCapability(Ability capability) {
        for (Item item : this.backpack.getAllItems()) {
            if (item.hasCapability(capability)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Increases Camper's coldness level by an amount.
     * @param amount to increase coldnessLevel
     */
    public void increaseColdnessLevel(int amount) {
        this.coldnessLevel += amount;
    }

    /**
     * Decreases Camper's coldness level by an amount.
     * @param amount to decrease coldnessLevel
     */
    public void decreaseColdnessLevel(int amount) {
        this.coldnessLevel -= amount;
        if (this.coldnessLevel < 0) {
            this.coldnessLevel = 0;
        }
    }

    /**
     * Increases Camper's hydration level by an amount.
     * @param amount to increase hydrationLevel
     */
    public void increaseHydrationLevel(int amount) {
        this.hydrationLevel += amount;
    }

    /**
     * Decreases Camper's hydration level by an amount.
     * @param amount to decrease hydrationLevel
     */
    public void decreaseHydrationLevel(int amount) {
        this.hydrationLevel -= amount;
        if (this.hydrationLevel < 0) {
            this.hydrationLevel = 0;
        }
    }

    /**
     * Retrieves all allowableActions that Camper can perform.
     * @return list of allowableActions
     */
    public List<Action> allowableActions() {
        return this.backpack.allowableActions(this);
    }

    /**
     * Checks if Camper is conscious (coldnessLevel < 30 and hydrationLevel > 0).
     * @return TRUE if Camper is conscious, otherwise FALSE
     */
    public boolean isConscious() {
        return (this.coldnessLevel < 30) && (this.hydrationLevel > 0);
    }

    /**
     * Returns a string representation of Camper's name, hydrationLevel, and coldnessLevel.
     * @return String representation of Camper
     */
    @Override
    public String toString() {
        return this.name + " (hydration level: " + this.hydrationLevel + ", coldness level: " + this.coldnessLevel + ")";
    }
}
