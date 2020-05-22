/**
 * 
 */
package contract;

import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

/**
 * @author nodji
 *
 */
public interface IMap {
		/*
		 * 
		 */
	int getHeight();
	
	int getWidth();
	
	List<IElement> getAllElements() throws SQLException;
	 
	IElement getElementByPosition(int x,int y);

    IElement getElementByID(int ID);
    
    IElement getElementByName(String name) throws SQLException;
    
    void setMapHasChanged();
    
    Observable getObservable();
    
    void applyPhysics();
	}

