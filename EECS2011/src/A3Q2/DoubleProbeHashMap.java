/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A3Q2;

/**
 *
 * @author elder
 */
public class DoubleProbeHashMap<K, V> extends ProbeHashMap<K, V> {

    int q; //Prime number of secondary hash
    
    // provide same constructors as base class
    /**
     * Creates a hash table with capacity 17,  prime factor 109345121 and 
     * secondary prime factor q = 13.
     */
    public DoubleProbeHashMap() {
        super();
        q = 13; //largest prime less than 17
    }

    /**
     * Creates a hash table with the given capacity cap, prime factor 109345121 
     * and secondary prime factor q equal to the largest prime less than cap.
     * Cap must be at least 3 otherwise an Exception is thrown.
     */
    public DoubleProbeHashMap(int cap) throws Exception {
        super(cap);
        if (cap < 3) {
            throw new Exception();
        }
        q = selectSecondaryHashPrime(cap);
    }

    /**
     * Creates a hash table with the given capacity and prime factor, and
     * secondary prime factor q equal to the largest prime less than capacity.
     * Cap must be at least 3 otherwise an Exception is thrown.
     */
    public DoubleProbeHashMap(int cap, int p) throws Exception {
        super(cap, p);
        if (cap < 3) {
            throw new Exception();
        }
        q = selectSecondaryHashPrime(cap);
    }
    
  /**
     * Updates the size of the hash table to be at least newCap and rehashes all 
     * entries.  Must also update secondary prime factor q.
     */
    protected void resize(int newCap) {
        Iterable<Entry<K,V>> entries = entrySet();
        capacity = selectNewCapacity(newCap);
        createTable();
        n = 0;
        q = selectSecondaryHashPrime(newCap);
        for (Entry<K, V> e : entries) {
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Searches for an entry with key equal to k (which is known to have primary
     * hash value h1), returning the index at which it was found, or returning
     * -(a+1) where a is the index of the first empty or available slot that can
     * be used to store a new such entry.  Uses secondary hashing function 
     * h’(k) = q - k mod q, where the secondary prime factor q is the smallest 
     * prime less than the current capacity.
     *
     * @param h1 the precalculated hash value of the given key
     * @param k the key
     * @return index of found entry or if not found
     */
    protected int findSlot(int h1, K k) {
    	int avail = -1;                               // no slot available (thus far)
        int j = h1;                  // index while scanning table
        int h2 = secondaryHashValue(k);
        
        do {
            totalProbes++;
            if (isAvailable(j)) {                       // may be either empty or defunct
                if (avail == -1) {
                    avail = j;               // this is the first available slot!
                }
                if (table[j] == null) {
                    break;              // if empty, search fails immediately
                }
            } else if (table[j].getKey().equals(k)) {
                return j;                                 // successful match
            }
            j = (j + h2) % capacity;                       // keep looking (cyclically)
        } while (j != h1);                             // stop if we return to the start
        return -(avail + 1);                          // search has failed
    }

    /**
     * Returns value of secondary hash function h’(k) = q - k mod q, 
     * where k is the hash code for key (i.e. key.hashCode()).*
     */
    private int secondaryHashValue(K key) {
    	int firsthash = hashValue(key);
        return Math.abs(q - firsthash % q);
    }

  //Selects secondary hash prime to be the largest prime less than cap
    int selectSecondaryHashPrime(int cap) {
        //
        for (int i = cap - 1; i > 0; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return 1;
    }
}
