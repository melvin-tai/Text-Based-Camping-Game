package campings;

import java.util.List;
import campings.actions.Action;

/**
 * ActionCapable is an interface representing if an object provides allowable actions for the camper.
 *
 * @author Melvin (FIT2099)
 * @version 1.0
 */
public interface ActionCapable {
    /**
     * Return list of actions that this object allows for the camper.
     * @param camper the camper asking for allowable actions
     * @return list of allowable actions
     */
    public List<Action> allowableActions(Camper camper);
}