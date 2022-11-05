package foodManagement;

/**
 * A SortedListOfImmutables represents a sorted collection of immutable objects 
 * that implement the Listable interface.  
 * 
 * An array of references to Listable objects is used internally to represent 
 * the list.  
 * 
 * The items in the list are always kept in alphabetical order based on the 
 * names of the items.  When a new item is added into the list, it is inserted 
 * into the correct position so that the list stays ordered alphabetically
 * by name.
 */
public class SortedListOfImmutables {

	/*
	 * STUDENTS:  You may NOT add any other instance variables or
	 * static variables to this class!
	*/
	private Listable[] items;

	/**
	 * This constructor creates an empty list by creating an internal array
	 * of size 0.  (Note that this is NOT the same thing as setting the internal
	 * instance variable to null.) 
	 */
	public SortedListOfImmutables() {
		items= new Listable[0];
		
	}

	/**
	 *  Copy constructor.  The current object will become a copy of the
	 *  list that the parameter refers to.  
	 *  
	 *  The copy must be made in such a way that future changes to
	 *  either of these two lists will not affect the other. In other words, 
	 *  after this constructor runs, adding or removing things from one of 
	 *  the lists must not have any effect on the other list.
	 *  
	 *  @param other the list that is to be copied
	 */
	public SortedListOfImmutables(SortedListOfImmutables other) {
		items= new Listable[other.getSize()];
		for (int i=0; i<other.getSize();i++) {
			items[i]=other.items[i];
		}
	
	}

	/**
	 * Returns the number of items in the list.
	 * @return number of items in the list
	 */
	public int getSize() {
		int size= items.length;
		return size;
	}
	
	/**
	 * Returns a reference to the item in the ith position in the list.  (Indexing
	 * is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		return items[i];
	}
	
	/**
	 * Adds an item to the list.  This method assumes that the list is already
	 * sorted in alphabetical order based on the names of the items in the list.
	 * 
	 * The new item will be inserted into the list in the appropriate place so
	 * that the list will remain alphabetized by names.
	 * 
	 * In order to accomodate the new item, the internal array must be re-sized 
	 * so that it is one unit larger than it was before the call to this method.
	 *  
	 * @param itemToAdd refers to a Listable item to be added to this list
	 */
	public void add(Listable itemToAdd) {
		boolean outcome=true;
		//Creates a new list for the new size
		Listable[] Newitems= new Listable[items.length+1];
		//Variable for new array created
		int Newsize= Newitems.length;
		//Duplicates the same value of old array to the new array
		for(int x=0; x<items.length;x++) {
			Newitems[x]=items[x];
		}
		//If the array is empty then.
		if(items.length==0) {
			Newitems[0]=itemToAdd;
		}else {
			for(int y=0;y<items.length;y++) {
				if(itemToAdd.getName().compareTo(items[y].getName())<0
						&&outcome ==true) {
					//New array equals to itemToAdd
					Newitems[y]=itemToAdd;
					for(int z=y+1; z<Newsize; z++) {
						Newitems[z]=items[z-1];
					}
					outcome= false;
				}
			}
			if(outcome==true) {
				Newitems[Newsize-1]=itemToAdd;
			}
			
		}
		//duplicates the new array to the old array
		items= new Listable[Newsize];
		for(int i=0;i<Newsize;i++) {
			items[i]=Newitems[i];
		}
		
		
	}

	/**
	 * Adds an entire list of items to the current list, maintaining the 
	 * alphabetical ordering of the list by the names of the items.
	 * 
	 * @param listToAdd a list of items that are to be added to the current object
	 */
	public void add(SortedListOfImmutables listToAdd) {
		//Adds every value to the correct position
		for(int i=0;i<listToAdd.items.length;i++) {
			this.add(listToAdd.items[i]);
		}
		
	}
	
	/**
	 * Removes an item from the list.
	 * 
	 * If the list contains the same item that the parameter refers to, it will be 
	 * removed from the list.  
	 * 
	 * If the item appears in the list more than once, just one instance will be
	 * removed.
	 * 
	 * If the item does not appear on the list, then this method does nothing.
	 * 
	 * @param itemToRemove refers to the item that is to be removed from the list
	 */
	public void remove(Listable itemToRemove) {
		boolean outcome=false;
		for(int x=0;x<items.length;x++) {
			//If items equals itemToRemove then,
			if(items[x].getName().equals(itemToRemove.getName())) {
				outcome=true;
				break;
			}
		}
		//If a new array that has one less space in the array is needed then,
		if(outcome==true) {
			Listable[] Newitems= new Listable[items.length-1];
			int value=0;
			boolean Removeditem=false;
			for(int i=0; i<items.length;i++) {
				//If item is not removed then,
				if(items[i].getName().equals(itemToRemove.getName())
				   &&Removeditem==false) {
					Removeditem=true;
					continue;
				}else {
					Newitems[value]=items[i];
					value++;
				}	
			}
			//Duplicates all items from new array to old array
			items= new Listable[Newitems.length];
			for (int y=0; y<items.length;y++) {
				items[y]=Newitems[y];
			}	
		}

	}

	/**
	 * Removes an entire list of items from the current list.  Any items in the
	 * parameter that appear in the current list are removed; any items in the
	 * parameter that do not appear in the current list are ignored.
	 * 
	 * @param listToRemove list of items that are to be removed from this list
	 */
	public void remove(SortedListOfImmutables listToRemove) {
		//Checks listToRemove and removes every value inside
		for(int i=0;i<listToRemove.items.length;i++) {
			this.remove(listToRemove.items[i]);
		}
	}

	/**
	 * Returns the sum of the wholesale costs of all items in the list.
	 * 
	 * @return sum of the wholesale costs of all items in the list
	 */
	public int getWholesaleCost() {
		int size= items.length;
		int wholesale=0;
		//adds every vale in the array to get wholesale cost
		for(int i=0;i<size;i++) {
			wholesale+=items[i].getWholesaleCost();
		}
		return wholesale;
	}

	/**
	 * Returns the sum of the retail values of all items in the list.
	 * 
	 * @return sum of the retail values of all items in the list
	 */
	public int getRetailValue() {
		int size= items.length;
		int retailvalue=0;
		//adds every vale in the array to get retail value
		for(int i=0;i<size;i++) {
			retailvalue+=items[i].getRetailValue();
		}
		return retailvalue;
	}

	/**
	 * Checks to see if a particular item is in the list.
	 * 
	 * @param itemToFind item to look for
	 * @return true if the item is found in the list, false otherwise
	 */
	public boolean checkAvailability(Listable itemToFind) {
		int size=items.length;
		for (int i=0;i<size; i++) {
			//If items equals itemToFind then,
			if(items[i].equals(itemToFind)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a list of items is contained in the current list.
	 * If more than one copy of a particular element appear in the 
	 * parameter, then the current list must contain at least that many as well.
	 * 
	 * @param listToCheck list of items that may or may not appear in the
	 * current list
	 * @return true if all items in the parameter are contained in the current 
	 * list. (If more than one copy of a particular element appear in the
	 * parameter, then the current list must contain at least that many as well.)
	 */
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		//creates a duplicates of the current object in place
		SortedListOfImmutables NewItems= new SortedListOfImmutables(this);
		boolean Availabilitychecker= false;
		
		for (int i=0;i<listToCheck.items.length; i++) {
			//Checks if items is in the array listToCheck
			if(NewItems.checkAvailability(listToCheck.items[i])==false) {
				Availabilitychecker= false;
				break;
			}else { 
				Availabilitychecker= true;
				for (int x=0;x<NewItems.items.length; x++) {
					if(NewItems.items[x].equals(listToCheck.items[i])) {
						NewItems.remove(NewItems.items[x]);
						break;
					}
				}
			}
		}
		return Availabilitychecker;
	}
	
	/*
	 * We'll give you this one for free.  Do not modify this method or you
	 * will fail our tests!
	 */
	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}
