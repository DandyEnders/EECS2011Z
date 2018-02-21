package A2Q2;

import java.util.*;

/**
 * Adaptible priority queue using location-aware entries in a min-heap, based on
 * an extendable array.  The order in which equal entries were added is preserved.
 *
 * @author jameselder
 * @param <E> The entry type.
 */
public class APQ<E> {

    private final ArrayList<E> apq; //will store the min heap
    private final Comparator<E> comparator; //to compare the entries
    private final Locator<E> locator;  //to locate the entries within the queue

    /**
     * Constructor
     * @param comparator used to compare the entries
     * @param locator used to locate the entries in the queue
     * @throws NullPointerException if comparator or locator parameters are null
     */
    public APQ(Comparator<E> comparator, Locator<E> locator) throws NullPointerException {
        if (comparator == null || locator == null) {
            throw new NullPointerException();
        }
        apq = new ArrayList<>();
        apq.add(null); //dummy value at index = 0
        this.comparator = comparator;
        this.locator = locator;
    }
    
    private boolean hasLeftChild(int pos) {
    	return getLeftChildIndex(pos) <= size() && getLeftChildIndex(pos) > 1;
    }
    
    private boolean hasRightChild(int pos) {
    	return getRightChildIndex(pos) <= size() && getRightChildIndex(pos) > 2;
    }

	private boolean hasParent(int pos) {
		return getParentIndex(pos) >  0 ;
	}
    
    private E getParent(int pos) {
    	if(hasParent(pos)){
    		return apq.get(this.getParentIndex(pos));
    	}else {
    		return null;
    	}
    }
    
    private E getLeftChild(int pos) {
    	if(hasLeftChild(pos)){
    		return apq.get(this.getLeftChildIndex(pos));
    	}else {
    		return null;
    	}
    }
    
   private E getRightChild(int pos) {
    	if(hasRightChild(pos)){
    		return apq.get(this.getRightChildIndex(pos));
    	}else {
    		return null;
    	}
    }
    
    private int getParentIndex(int pos) {
    	return (int)(pos/2);
    }
    
    private int getLeftChildIndex(int pos) {
    	return (2*pos);
    }
    
    private int getRightChildIndex(int pos) {
    	return (2*pos + 1);
    }
    
    
    /**
     * Inserts the specified entry into this priority queue.
     *
     * @param e the entry to insert
     * @throws NullPointerException if parameter e is null
     */
    public void offer(E e) throws NullPointerException {
    //implement this method    
    	
    	if (e == null) {
    		throw new NullPointerException("offer null e");
    	}
    	
    	locator.set(e, size());
    	apq.add(e);
    	upheap(size());
    	
    	
    }

   /**
     * Removes the entry at the specified location.
     *
     * @param pos the location of the entry to remove
     * @throws BoundaryViolationException if pos is out of range
     */
    public void remove(int pos) throws BoundaryViolationException {
    //implement this method
	    if(pos > size() || pos < 1) {
	    	throw new BoundaryViolationException("pos : " + pos);
	    }
	    
	    if(pos == size()) {
	    	apq.remove(size());
	    }else {
	    	E lastElement = apq.remove(size());
	    	apq.set(pos, lastElement);
	 	    locator.set(lastElement, pos);
	 	    downheap(pos);
	    }
	    
    }

   /**
     * Removes the first entry in the priority queue.
     */
    public E poll() {
        //implement this method
    	E returnElement = peek();
    	E lastElement = apq.remove(size());
    	if(size() > 0) {
	    	apq.set(1, lastElement);
	    	locator.set(lastElement, 1);
	    	downheap(1);
    	}
    	return returnElement;
    }

  /**
     * Returns but does not remove the first entry in the priority queue.
     */
     public E peek() {
        if (isEmpty()) {
            return null;
        }
        return apq.get(1);
    }

   public boolean isEmpty() {
        return (size() == 0); 
    }

    public int size() {
        return apq.size() - 1; //dummy node at location 0
    }


    /**
     * Shift the entry at pos upward in the heap to restore the minheap property
     * @param pos the location of the entry to move
     */
    private void upheap(int pos) {
        //implement this method
    	while(hasParent(pos) && comparator.compare(getParent(pos), apq.get(pos)) > 0 ) {
    		swap(getParentIndex(pos),pos);
    		pos = getParentIndex(pos);
    	}
    }

    /**
     * Shift the entry at pos downward in the heap to restore the minheap property
     * @param pos the location of the entry to move
     */
    private void downheap(int pos) {
        //implement this method
    	
    	while(hasLeftChild(pos)){
    		int smallerChildIndex = getLeftChildIndex(pos);
    		
    		if(hasRightChild(pos) && comparator.compare(getRightChild(pos), getLeftChild(pos)) < 0) {
    			smallerChildIndex = getRightChildIndex(pos);
    		}
    		
    		if(comparator.compare(apq.get(smallerChildIndex), apq.get(pos)) > 0) {
    			swap(smallerChildIndex,pos);
    		}else {
    			break;
    		}
    		pos = smallerChildIndex;
    	}
    }


    /**
     * Swaps the entries at the specified locations.
     *
     * @param pos1 the location of the first entry 
     * @param pos2 the location of the second entry 
     */
    private void swap(int pos1, int pos2) {
        //implement this method
    	E temp = apq.get(pos1);
    	apq.set(pos1, apq.get(pos2));
    	apq.set(pos2, temp);
    	
		locator.set(apq.get(pos1), pos1);
		locator.set(apq.get(pos2), pos2);
		
    }
}