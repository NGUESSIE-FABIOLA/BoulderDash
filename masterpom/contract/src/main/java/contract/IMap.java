/**
 * 
 */
package contract;

import java.util.Observable;

import model.element.IElement;

/**
 * @author nodji
 *
 */
public interface IMap {
		/*
		 * 
		 */
		public int getHeight();
		
		
		public int getWidht();
		
		public IElement getAllElements();
		
		
		public IElement getElementByID();
		
		public IElement getElementByName();
		
		public void setMapHasChanged();
		
		Observable getObservable();
	}

