package A3Q1;


/**
 * Extends the TreeMap class to allow convenient access to entries
 * within a specified range of key values (findAllInRange).
 * @author jameselder
 */
public class BSTRange<K,V> extends TreeMap<K,V>{

    /* Returns the lowest (deepest) position in the subtree rooted at pos
     * that is a common ancestor to positions with
     * keys k1 and k2, or to the positions they would occupy were they present.
     */
    protected Position<Entry<K, V>> findLowestCommonAncestor(K k1, K k2,
            Position<Entry<K, V>> pos) {
    	

    	if(this.isExternal(pos)) {
    		return pos;
    	}
    	

    	
    	if(this.compare(pos.getElement(), k1) > 0  && this.compare(pos.getElement(), k2) > 0) {
    		if(this.left(pos) != null && this.left(pos).getElement() != null)
    			return findLowestCommonAncestor(k1,k2,this.left(pos));
    	}
    	if(this.compare(pos.getElement(), k1) < 0  && this.compare(pos.getElement(), k2) < 0){
    		if(this.right(pos) != null && this.right(pos).getElement() != null)
    			return findLowestCommonAncestor(k1,k2,this.right(pos));
    	}
    	
    		return pos;
    	
    	
    }

    /* Finds all entries in the subtree rooted at pos  with keys of k or greater
     * and copies them to L, in non-decreasing order.
     */
    protected void findAllAbove(K k, Position<Entry<K, V>> pos,
            PositionalList<Entry<K, V>> L) {
    	
    	if(this.isExternal(pos) || pos == null || pos.getElement() == null) {
    		return;
    	}
    	
    	if(this.left(pos) != null && this.left(pos).getElement() != null) {
	    	if(this.compare(k, this.left(pos).getElement()) <= 0) {
	    		findAllAbove(k,this.left(pos),L);
	    	}
    	}
    	if(pos != null && pos.getElement() != null) {
    		if(this.compare(k, pos.getElement()) <= 0) {
    			L.addLast(pos.getElement());
    		}
    	}
    	
    	
    	if(this.right(pos) != null && this.right(pos).getElement() != null) {
	    	if(this.compare(k, this.right(pos).getElement()) <= 0) {
	    		findAllAbove(k,this.right(pos),L);
	    	}
    	}
    	
    	
    	
    }

    /* Finds all entries in the subtree rooted at pos with keys of k or less
     * and copies them to L, in non-decreasing order.
     */
    protected void findAllBelow(K k, Position<Entry<K, V>> pos,
            PositionalList<Entry<K, V>> L) {
    	
    	if(this.isExternal(pos)|| pos == null || pos.getElement() == null) {
    		return;
    	}
    	
    	if(this.left(pos) != null && this.left(pos).getElement() != null) {
	    	if(this.compare(k, this.left(pos).getElement()) >= 0) {
	    		findAllBelow(k,this.left(pos),L);
	    	}
    	}
    	if(pos != null && pos.getElement() != null) {
    		if(this.compare(k,pos.getElement())>=0)
    		L.addLast(pos.getElement());
    		
    	}
    	
    	if(this.right(pos) != null && this.right(pos).getElement() != null) {
	    	if(this.compare(k, this.right(pos).getElement()) >= 0) {
	    		findAllBelow(k,this.right(pos),L);
	    	}
    	}
    }

    /* Returns all entries with keys no less than k1 and no greater than k2,
     * in non-decreasing order.
     */
    public PositionalList<Entry<K, V>> findAllInRange(K k1, K k2) {
    	
    	if(this.isEmpty()) {
    		return new LinkedPositionalList<Entry<K, V>>();
    	}
    	
    	if(this.compare(k1, k2) > 0) {
    		return new LinkedPositionalList<Entry<K, V>>();
    	}
    	
    	if(this.compare(k1, k2) == 0) {
    		PositionalList<Entry<K, V>> Lr = new LinkedPositionalList<Entry<K, V>>();
    		Entry<K, V> ent = this.ceilingEntry(k1);
    		if(this.compare(ent, k1)==0)
    			Lr.addLast(ent);
    		return Lr;
    	}
    	
    	
    	
    	PositionalList<Entry<K, V>> L = new LinkedPositionalList<Entry<K, V>>();

    	Position<Entry<K, V>> pos = findLowestCommonAncestor(k1,k2,this.root());
    	
    	if(this.left(pos) != null && this.left(pos).getElement() != null) {
	    	findAllAbove(k1,this.left(pos),L); 
    	}
    	if(this.compare(pos.getElement(), this.firstEntry())>=0 && this.compare(pos.getElement(), this.lastEntry())<=0) // && this.compare(k1, this.firstEntry())>=0 && this.compare(k2, this.lastEntry())<=0)
    		L.addLast(pos.getElement());
    	if(this.right(pos) != null && this.right(pos).getElement() != null) {
    		findAllBelow(k2,this.right(pos),L);
    	}
    	
    	
    	return L;
    	
    }
}