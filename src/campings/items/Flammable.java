package campings.items;

import campings.Camper;

/**
 * Flammable is an interface for objects that can be ignited.
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public interface Flammable {

    /**
     * Ignite this flammable object using the given camper (effects the camper).
     * @param camper the camper igniting this object
     * @return string result
     */
    String ignitedBy(Camper camper);
}
