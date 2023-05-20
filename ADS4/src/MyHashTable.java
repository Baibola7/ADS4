import java.util.LinkedList;

public class MyHashTable<K, V> {
    private int M = 11;// default number of chains
    private int size;
    private LinkedList<HashNode<K, V>>[] chain;

    private int capacity;
    private float loadFactor;

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashTable() {
        chain = new LinkedList[M];
        size = 0;
        this.capacity = 16;
        this.loadFactor = loadFactor;
    }
    public class HashNode<K, V> {
        private K key;
        private V value;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key.toString() + " " + value.toString();
        }
    }
    /**
     * Method hash - This is a function that takes a key and returns an index
     * into the array that represents the hashtable. The goal of a good hash function
     * is to evenly distribute the keys across the array to minimize collisions.
     * @return int.
     */
    private int hash (K key) {
        return key.hashCode() % M;
    }
    /**
     * Method getSize -  This function returns the number of key-value
     * pairs currently stored in the hashtable..
     * @return int.
     */
    public int getSize() {
        return size;
    }
    /**
     * Method put - This function takes a key-value pair and inserts it into
     * the hashtable. It uses the hash function to compute the index where the
     * pair should be stored. If there is already a pair with the same key in the
     * hashtable, the value for that key is updated.
     */
    public void put (K key, V value) {
        resize();
        if (chain[hash(key)] == null){
            chain[hash(key)] = new LinkedList<HashNode<K, V>>();
        }
        for (HashNode<K, V> node: chain[hash(key)]){
            if(node.getKey().equals(key)){
                node.setValue(value);
                return;
            }
        }
        chain[hash(key)].add(new HashNode<K, V>(key, value));
        size++;
    }
    /**
     * Method get This function takes a key and returns the corresponding value from the
     * hashtable. It uses the hash function to compute the index where the value should be stored,
     * and then looks for the key at that index. If the key is not found, get returns null
     * (or some other sentinel value).
     * @return Value.
     */
    public V get (K key) {
        if (chain[hash(key)] == null) return null;

        for (HashNode<K, V> node: chain[hash(key)]){
            if(node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }
    /**
     * Method remove - This function takes a key and removes the corresponding key-value pair
     * from the hashtable. It uses the hash function to compute the index where the pair should be stored,
     * and then looks for the key at that index. If the key is found, the pair is removed and the function
     * returns true. Otherwise, it returns false.
     * @return Value.
     */
    public V remove(K key) {
        if (chain[hash(key)] == null) return null;

        for (HashNode<K, V> node: chain[hash(key)]){
            if(node.getKey().equals(key)) {
                chain[hash(key)].remove(node);
                size--;
                return node.getValue();
            }
        }
        size--;
        return null;
    }
    /**
     * Method contains -  This function takes a key and returns true if the key is present in the hashtable, false otherwise.
     * It uses the hash function to compute the index where the key should be stored, and then looks for the key at that index.
     * @return boolean;
     */
    public boolean contains(V value) {
        for(LinkedList<HashNode<K,V>> list: chain) {
            for(HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return true;
            }
        }
        return false;
    }
    /**
     * Method  This function takes a value and returns the key that maps to that value in the hashtable. This function is not typically
     * provided by standard hashtable implementations, as it requires iterating over all key-value pairs in the hashtable until the correct
     * value is found.
     * @return Object.
     */
    public K getKey(V value) {
        for(LinkedList<HashNode<K,V>> list: chain) {
            for(HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return node.getKey();
            }
        }
        return null;
    }


//  Resizing a hash table consists of choosing a new hash function to map
//  to the new size, creating a hash table of the new size, iterating through
//  the elements of the old table, and inserting them into the new table.
//  Create a new array with a larger size: Determine the new size for the hashtable, typically by doubling the current size. Create a new array with this new size to accommodate more elements.
//Rehash the existing elements: Iterate through the existing elements in the original hashtable and rehash them into the new array. This involves recalculating their hash codes based on the new array size and placing them in the appropriate positions in the new array.
//Update the reference to the new array: Replace the reference to the original array with the reference to the new array, so that future operations on the hashtable use the resized array.
//Adjust the load factor threshold: The load factor is the ratio of the number of elements in the hashtable to its capacity. It helps determine when a resize is necessary. Typically, a hashtable is resized when the load factor exceeds a certain threshold (e.g., 0.75). After resizing, the load factor threshold may need to be adjusted to reflect the new array size.
    public void resize() {
        double loadFactory = (size / chain.length);
        if (loadFactory > 0.75) {
            LinkedList<HashNode<K, V>>[] newList = new LinkedList[M];
            for (int i =0; i< chain.length; i++) {
                newList[i] = chain[i];
            }
            chain = newList;
        }
    }
}