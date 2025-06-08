import java.util.*;

public class HashMapTS<K,V> implements IHashMapTS<K,V>{

    /** Contains key‐value pairs for a hash table. */
    private static class Entry<K, V> {
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** Creates a new key‐value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }
    private ArrayList<TreeSet<Entry<K,V>>> theData;

    public HashMapTS(){
        theData = new ArrayList<>();
    }
    public V get(Object key){
        if(size() == 0)   return null;
        TreeSet<Entry<K,V>> ts = new TreeSet<>();
        for(int i=0; i< theData.size();i++){
            ts = theData.get(i);
            for(int j=0; j<ts.size(); j++){
                //if(ts.get(j).getKey() == key)   return ts.get(j).getValue();
            } 
        }
        return null;
    }
    private V get(Object key, Entry<K,V> localroot){
        return null;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public V put(K key, V value){
        //theData.add(hashCode(key),value);
        return value;
    }
    public V remove(Object key){
        V result = null;
        TreeSet<Entry<K,V>> ts = new TreeSet<>();
        for(int i=0; i< theData.size();i++){
            ts = theData.get(i);
            for(int j=0; j<ts.size(); j++){
                /*
                if(ts.get(j).getKey() == key){
                    result = ts.get(j).getValue();
                    ts.remove(j);
                }*/
            }
        }
        return result;
    }
    private V remove(Object key, Entry<K,V> localroot){
        return null;
    }
    public int size(){
        return theData.size();
    }
}

