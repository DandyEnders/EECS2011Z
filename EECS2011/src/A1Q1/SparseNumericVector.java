package A1Q1;
import java.util.*;

/**
 * Represents a sparse numeric vector. Elements are comprised of a (long)
 * location index an a (double) value.  The vector is maintained in increasing
 * order of location index, which facilitates numeric operations like
 * inner products (projections).  Note that location indices can be any integer
 * from 1 to Long.MAX_VALUE.  The representation is based upon a
 * singly-linked list.
 * The following methods are supported:  iterator, getSize, getFirst,
 * add, remove, and dot, which takes the dot product of the with a second vector
 * passed as a parameter.
 * @author jameselder
 */
public class SparseNumericVector implements Iterable {

    protected SparseNumericNode head = null;
    protected SparseNumericNode tail = null;
    protected long size;

  /**
     * Iterator
     */
    @Override
    public Iterator<SparseNumericElement> iterator() { //iterator
        return new SparseNumericIterator(this);
    }

    /**
     * @return number of non-zero elements in vector
     */
   public long getSize() {
        return size;
    }

     /**
     * @return the first node in the list.
     */
    public SparseNumericNode getFirst() {
        return head;
    }
    
    /**
     * Add the element to the vector.  It is inserted to maintain the
     * vector in increasing order of index.  If the element has zero value, or if 
     * an element with the same index already exists, an UnsupportedOperationException is thrown. 
     * @param e element to add
     */
  public void add(SparseNumericElement e) throws UnsupportedOperationException {
       //implement this method
	  
	  
	  //case 0 element is empty
	  if(e.getValue() == 0){
		  throw new UnsupportedOperationException();
	  }
	  
	  //case 1 list is empty
	  
	  if(this.head == null && this.tail == null){
		  SparseNumericNode node = new SparseNumericNode(e, null);
		  this.head = node;
		  this.tail = node;
		  this.size++;
		  return;
	  }
	  
	  //case 2 element with same index exist 
	  
	  //added iterator
	  SparseNumericIterator itr = new SparseNumericIterator(this);
	  
	  
	  while(itr.hasNext()){
		  if(itr.next().getIndex() == e.getIndex()){
			  throw new UnsupportedOperationException();
		  }
	  }
	  
	  //case 3 	list and element are non-empty, and no element with same index exist
	  // 		add nodal element in the list
	  
	  this.size++;
	  
	  //case 3.1 inserted in head
	  if(e.getIndex() < this.head.getElement().getIndex()){
		 SparseNumericNode node = new SparseNumericNode(e, this.head);
		 this.head = node;
	  }else 
		  
		  
	  //case 3.2 inserted in tail
	  if(e.getIndex() > this.tail.getElement().getIndex()){
		 SparseNumericNode node = new SparseNumericNode(e, null);
		 this.tail.setNext(node);
	  }
	  
	  //case 3.3 inserted in middle
	  else{
		  //refresh iterator
		  itr = new SparseNumericIterator(this);
		  while(itr.hasNext()){
			  SparseNumericNode position = itr.position;
			  SparseNumericElement elemFirst = itr.next();
			  SparseNumericElement elemSecond = itr.position.getElement();
			  
			  if(elemFirst.getIndex() < e.getIndex() && elemSecond.getIndex() > e.getIndex()){
				  SparseNumericNode node = new SparseNumericNode(e, position.getNext());
				  position.setNext(node);
				  break;
			  }
			  
		  }
		  
	  }
	  
	  
	  
    }

    /**
     * If an element with the specified index exists, it is removed and the
     * method returns true.  If not, it returns false.
     *
     * @param index of element to remove
     * @return true if removed, false if does not exist
     */
    public boolean remove(Long index) {
        //implement this method
    	
        //this return statement is here to satisfy the compiler - replace it with your code.
    	SparseNumericIterator itr = new SparseNumericIterator(this);
    	
    	//case 0 index out of bound
    	if(index < this.head.getElement().getIndex() || index > this.tail.getElement().getIndex()){
    		return false;
    	}
    	
    	this.size--;
    	
    	//case 1.1 remove head
    	if(this.head.getElement().getIndex() == index){
    		SparseNumericNode newHead = this.head.getNext();
    		this.head.setNext(null);
    		this.head = newHead;
    		return true;
    	}else
    	
    	//case 1.2 remove tail
    	if(this.tail.getElement().getIndex() == index){
    		
    		return true;
    		
    	//case 1.3 remove middle
    	}else {
	    	while(itr.hasNext()){
	    		SparseNumericNode nodeFirst = itr.position;
	    		SparseNumericNode nodeSecond = nodeFirst.getNext();
	    		SparseNumericNode nodeThird = nodeSecond.getNext();
	    		itr.next();
				
	    		if(nodeSecond.getElement().getIndex() == index){
	    			nodeFirst.setNext(nodeThird);
	    			nodeSecond.setNext(null);
	    			return true;
	    		}
	    		
	    		if(nodeThird.equals(this.tail)){
	    			break;
	    		}
	    	}
    	}
        return false; 
    }

    /**
     * Returns the inner product of the vector with a second vector passed as a
     * parameter.  The vectors are assumed to reside in the same space.
     * Runs in O(m+n) time, where m and n are the number of non-zero elements in
     * each vector.
     * @param Y Second vector with which to take inner product
     * @return result of inner product
     */

    public double dot (SparseNumericVector Y) {
        //implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
    	
    	//added iterator
  	  	SparseNumericIterator thisItr = new SparseNumericIterator(this);
  	    SparseNumericIterator YItr = new SparseNumericIterator(Y);
  	  	//sum
    	double sum = 0;
    	
    	while(thisItr.hasNext()){
    		SparseNumericElement thisElem = thisItr.position.getElement();
    		SparseNumericElement YElem = YItr.position.getElement();
    		
    		if(thisElem.getIndex() == YElem.getIndex()){
    			sum += thisElem.getValue() * YElem.getValue();
    			thisItr.next();
    		}else{
    			if(thisElem.getIndex() > YElem.getIndex()){
    				YItr.next();
    			}else{
    				thisItr.next();
    			}
    		}
    	}
    	
    	
        return sum;
   }

       /**
     * returns string representation of sparse vector
     */

    @Override
    public String toString() {
        String sparseVectorString = "";
        Iterator<SparseNumericElement> it = iterator();
        SparseNumericElement x;
        while (it.hasNext()) {
            x = it.next();
            sparseVectorString += "(index " + x.getIndex() + ", value " + x.getValue() + ")\n";
        }
        return sparseVectorString;
    }
}

