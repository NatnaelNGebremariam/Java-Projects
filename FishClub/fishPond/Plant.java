package fishPond;

/**
 * The state of a plant includes it's position (row and column) and it's     
 * size.                                                                     
 * <p>                                                       
 * A Plant grows over time.  Plants are eaten by fish that pass over them.   
 *                                                                        
 * @author Put Your Name Here                                              
 */

public class Plant {
	
	/** Initial size of plants in beginning of simulation */
	public static final int PLANT_STARTING_SIZE = 150;
	
	/** Maximum size for a plant */
	public static final int MAX_PLANT_SIZE = 1000;
	
	/** Portion of plant that is eaten by a fish passing over it */
	public static final int PLANT_BITE_SIZE = 75;

	/* State of this Plant.  YOU MAY NOT ADD ANY FIELDS! */
	private int row, col, size;
	
	/** Standard constructor that merely initializes the fields from the parameters */
	public Plant(int row, int col, int size) {
		//  Remove this comment and implement this method!!
	}
	
	/** Standard copy constructor that merely copies the fields */
	public Plant(Plant other) {
		//  Remove this comment and implement this method!!
	}
	
	/** returns true if size is bigger than zero, false otherwise. */
	public boolean isAlive() {
		//  Remove this comment and implement this method!!
	}
	
	/** returns row */
	public int getRow() {
		//  Remove this comment and implement this method!!
	}
	
	/** returns column */
	public int getCol() {
		//  Remove this comment and implement this method!!
	}
	
	/** returns size */
	public int getSize() {
		//  Remove this comment and implement this method!!
	}
	
	/** increments size by one unit */
	public void grow() {
		//  Remove this comment and implement this method!!
	}
	
	/** decreases size by biteSize units */
	public void removeBite(int biteSize) {
		//  Remove this comment and implement this method!!
	}
}
