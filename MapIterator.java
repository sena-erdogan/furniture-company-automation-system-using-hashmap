import java.util.*;

public class MapIterator<K, V> extends HashMap<K,V> implements Iterator{
    private K key;
    private V val;
    private Set<K> keys = keySet(); 
    private Iterator<K> iter = keys.iterator();
    private ArrayList<K> iterated = new ArrayList<>();

    public MapIterator(){
        //this(iter.next());
    }
    public MapIterator(K key){
        if(size() == 0 || containsKey(key) == false) throw new IndexOutOfBoundsException();
        else{
            this.key = key;
            val = get(key);
            while(iter.next() != key)   iter.next();
            iter.next();
            iterated.add(key);
        }
    }
    public K next(){
        K next = iter.next();
        iterated.add(next);
        return next;
    }
    public K prev(){
        K prev = null;
        //prev = iter.prev();
        iterated.add(prev);
        return prev;
    }
    public boolean hasNext(){
        for(K key: keys){
            if(iterated.contains(key) == false) return true;
        }
        return false;
    }
    public void remove(){
        remove(key);
    }
}

