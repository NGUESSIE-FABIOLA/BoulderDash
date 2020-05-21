/**
 * 
 */
package contract;

import java.io.IOException;

/**
 * @author Heidy Kengne
 *
 */
public interface IOrderPerformer {

    void orderPerform(Order Order) throws IOException;

}
