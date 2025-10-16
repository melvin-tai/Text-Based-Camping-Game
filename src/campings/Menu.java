package campings;

import campings.actions.Action;

import java.util.*;

/**
 * Displays a Menu of Actions that a Camper can do.
 * @author Minh Hoang Bui
 * @version 1.0
 */
public class Menu {
    /**
     * Credit to Minh Hoang Bui to optimize the old code for this
     */
    public static Action showMenu(List<Action> actions, Camper camper) {
        Scanner scanner = new Scanner(System.in);
        Character startChar = 'a';

        Map<Character, Action> keyToActionMap = new HashMap<>();

        for (Action action: actions) {
            keyToActionMap.put(startChar, action);
            System.out.println(startChar + ": " + action.menuDescription(camper));
            startChar++;
        }

        char key;
        do {
            key = scanner.next().charAt(0);
        } while (!keyToActionMap.containsKey(key));

        return keyToActionMap.get(key);
    }
}
