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

    void orderPerform(UserOrder userOrder) throws IOException;

}
