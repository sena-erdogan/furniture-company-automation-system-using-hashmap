# furniture-company-automation-system-using-hashmap

A custom iterator class MapIterator was implemented to iterate through the keys in a HashMap data structure.

KWHashMap interface in the book was implemented using the following hashing methods to organize hash
table:
- The chaining technique for hashing by using linked lists to chain items on the same table slot.
- The chaining technique for hashing by using TreeSet to chain items on the same table slot.
- The Coalesced hashing technique. This technique uses the concept of Open Addressing to find first empty place for colliding element by using the quadratic probing and the concept of Separate Chaining to link the colliding elements to each other through pointers (indices in the table). The deletion of a key is performed by linking its next entry to the entry that points the deleted key by replacing deleted entry by the next entry.

Assignment from the Data Structures and Algorithms course (GTU, 2021)
