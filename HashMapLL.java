import java.util.*;

public class HashMapLL<K,V> implements IHashMapLL<K,V>{
    /** Class KWLinkedList implements a linked list and
     a ListIterator. */
    public class KWLinkedList<E> { 

        /** A Node is the building block for a linked list. */
        private class Node<E> {
            /** The data value. */
            private E data;
            /** The link to the next node. */
            private Node<E> next = null;
            /** The link to the previous node. */
            private Node<E> prev = null;
            /** Sole constructor */
            private Node(){

                //Intentionally empty

            }
            /** Construct a node with the given data value.
             @param dataItem The data value
             */
            private Node(E dataItem) {
                data = dataItem;
            }
            /** Creates a new node that references another node.
             @param dataItem The data stored
             @param nodeRef The node referenced by new node
             */
            private Node(E dataItem, Node<E> nodeRef) {
                data = dataItem;
                next = nodeRef;
            }
        }

        // Data Fields
        /** A reference to the head of the list. */
        private Node<E> head = null;
        /** A reference to the end of the list. */
        private Node<E> tail = null;
        /** The size of the list. */
        private int size = 0;

        /** Default constructor */
        public KWLinkedList(){

            //Intentionally empty

        }

        /** Inner class to implement the ListIterator interface. */
        private class KWListIter implements ListIterator<E> {
            /** A reference to the next item. */
            private Node<E> nextItem;
            /** A reference to the last item returned. */
            private Node<E> lastItemReturned;
            /** The index of the current item. */
            private int index = 0;

            /** Construct a KWListIter that will reference the ith item.
             @param i The index of the item to be referenced
             */
            public KWListIter(int i) {
                // Validate i parameter.
                if (i < 0 || i > size) {
                    throw new IndexOutOfBoundsException("Invalid index " + i);
                }
                lastItemReturned = null; // No item returned yet.
                // Special case of last item.
                if (i == size) {
                    index = size;
                    nextItem = null;
                } else { // Start at the beginning
                    nextItem = head;
                    for (index = 0; index < i; index++) {
                        nextItem = nextItem.next;
                    }
                }
            }

            /** Indicate whether movement forward is defined.
             @return true if call to next will not throw an exception
             */
            public boolean hasNext() {
                return nextItem != null;
            }

            /** Move the iterator forward and return the next item.
             @return The next item in the list
             @throws NoSuchElementException if there is no such object
             */
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastItemReturned = nextItem;
                nextItem = nextItem.next;
                index++;
                return lastItemReturned.data;
            }

            /** Indicate whether movement backward is defined.
             @return true if call to previous will not throw an exception
             */
            public boolean hasPrevious() {
                return (nextItem == null && size != 0)
                        || nextItem.prev != null;
            }

            /** Move the iterator backward and return the previous item.
             @return The previous item in the list
             @throws NoSuchElementException if there is no such object
             */
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                if (nextItem == null) { // Iterator is past the last element
                    nextItem = tail;
                } else {
                    nextItem = nextItem.prev;
                }
                lastItemReturned = nextItem;
                index--;
                return lastItemReturned.data;
            }

            /** Add a new item between the item that will be returned
             by next and the item that will be returned by previous.
             If previous is called after add, the element added is
             returned.
             @param obj The item to be inserted
             */
            public void add(E obj) {
                if (head == null) { // Add to an empty list.
                    head = new Node<>(obj);
                    tail = head;
                } else if (nextItem == head) { // Insert at head.
                    // Create a new node.
                    Node<E> newNode = new Node<>(obj);
                    // Link it to the nextItem.
                    newNode.next = nextItem;  // Step 1
                    // Link nextItem to the new node.
                    nextItem.prev = newNode;  // Step 2
                    // The new node is now the head.
                    head = newNode; // Step 3
                } else if (nextItem == null) { // Insert at tail.
                    // Create a new node.
                    Node<E> newNode = new Node<>(obj);
                    // Link the tail to the new node.
                    tail.next = newNode; // Step 1
                    // Link the new node to the tail.
                    newNode.prev = tail; // Step 2
                    // The new node is the new tail.
                    tail = newNode; // Step 3
                } else { // Insert into the middle.
                    // Create a new node.
                    Node<E> newNode = new Node<>(obj);
                    // Link it to nextItem.prev.
                    newNode.prev = nextItem.prev; // Step 1
                    nextItem.prev.next = newNode; // Step 2
                    // Link it to the nextItem.
                    newNode.next = nextItem; // Step 3
                    nextItem.prev = newNode; // Step 4
                }
                // Increase size and index and set lastItemReturned.
                size++;
                index++;
                lastItemReturned = null;
            } // End of method add.

            /**	Sets the last item returned to be the given object

             @param obj the given object

             */
            public void set(E obj){

                if(lastItemReturned == null)	throw new IllegalStateException();
                else	lastItemReturned.data = obj;

            }

            /**	Removes the last item returned

             */
            public void remove(){

                if(lastItemReturned == null)	throw new IllegalStateException();
                else	lastItemReturned.prev.next = null;

            }

            /**	Returns the previous index

             @return int index

             */
            public int previousIndex(){

                if(index == 0)	return -1;

                lastItemReturned = lastItemReturned.prev;

                nextItem = lastItemReturned.next;

                index--;

                return index;

            }

            /**	Returns the next index

             @return int the next index

             */
            public int nextIndex(){

                if(size == index+1)	return size;

                lastItemReturned = lastItemReturned.next;

                nextItem = lastItemReturned.next;

                index++;

                return index;

            }

        }

        /**	Returns a list iterator at the beginning of the list

         @return ListIterator<E>

         */
        public ListIterator<E> listIterator(){

            return listIterator(0);

        }

        /**	Returns a list ierator at the given index position of the list

         @param index the index

         @return ListIterator<E>

         */
        public ListIterator<E> listIterator(int index){

            KWListIter listIterator = new KWListIter(index);

            return listIterator;

        }

        /** Add an item to the front of the list.
         @param item The item to be added
         */
        public void addFirst(E item) {
            head = new Node<>(item, head);
            size++;
        }

        /**	Adds a new entry at the end of the list

         @param item the new entry

         */
        public void addLast(E item) {
            tail = new Node<>(item, tail);
            size++;
        }

        /**	Returns the first entry of the list

         @return E first entry

         */
        public E getFirst() {
            if(size == 0)	throw new NoSuchElementException("No such element exception");
            else	return head.data;
        }

        /**	Returns the last entry of the list

         @return E last entry

         */
        public E getLast() {
            if(size == 0)	throw new NoSuchElementException("No such element exception");
            else	return tail.data;
        }

        /**	Adds a new entry at the end of the list

         @param obj the new entry

         */
        public void add(E obj) {
            addLast(obj);
        }

        /** Add an item at position index.
         @param index The position at which the object is to be
         inserted
         @param obj The object to be inserted
         @throws IndexOutOfBoundsException if the index is out
         of range (i < 0 || i > size())
         */
        public void add(int index, E obj) {
            listIterator(index).add(obj);
        }

        /** Get the element at position index.
         @param index Position of item to be retrieved
         @return The item at index
         */
        public E get(int index) {

            return listIterator(index).next();

        }

        /**	Returns the size of the list

         @return int size

         */
        public int size(){

            return size;

        }

        /**	Removes the entry at the given index

         @param index the index

         @return E the removed entry

         */
        public E remove(int index){

            Node<E> t = new Node<E>();

            if(index == size-1){

                t = tail;

                tail = tail.prev;


            }else if(size == 0)	throw new IllegalStateException();
            else if(size == 1){

                head = null;
                tail = null;

            }else{

                Node<E> temp = new Node<E>();

                temp = head;

                for(int i=0; i<index; i++){

                    if(i == index){

                        t=temp;

                        temp.prev.next = temp.next;

                    }

                    temp = temp.next;

                }

            }

            return t.data;

        }

    }
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
    private KWLinkedList<KWLinkedList<Entry<K,V>>> theData;

    public HashMapLL(){
        theData = new KWLinkedList<>();
    }
    public V get(Object key){
        if(size() == 0)   return null;
        KWLinkedList<Entry<K,V>> ll = new KWLinkedList<>();
        for(int i=0; i< theData.size();i++){
            ll = theData.get(i);
            for(int j=0; j<ll.size(); j++){
                if(ll.get(j).getKey() == key)   return ll.get(j).getValue();
            }
        }
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
        KWLinkedList<Entry<K,V>> ll = new KWLinkedList<>();
        for(int i=0; i< theData.size();i++){
            ll = theData.get(i);
            for(int j=0; j<ll.size(); j++){
                if(ll.get(j).getKey() == key){
                    result = ll.get(j).getValue();
                    ll.remove(j);
                }
            }
        }
        return result;
    }
    public int size(){
        return theData.size();
    }
}
