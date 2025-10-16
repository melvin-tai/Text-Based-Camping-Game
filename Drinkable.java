package campings;

/**
 * Campsite is an interface that represents if an Item/Location is Drinkable by a Camper.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public interface Drinkable {

    /**
     * Defines what happens when a Camper drinks from an Item/Location.
     * @param camper performing DrinkAction
     * @return String description of DrinkAction
     */
    public String drunkBy(Camper camper);
}
