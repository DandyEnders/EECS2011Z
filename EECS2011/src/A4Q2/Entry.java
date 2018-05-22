package A4Q2;

//begin#fragment Entry

//begin#fragment Entry
/** Interface for a key-value pair entry **/
public interface Entry<K,V> {
  /** Returns the key stored in this entry. */
  public K getKey();
  /** Returns the value stored in this entry. */
  public V getValue();
}
//end#fragment Entry
