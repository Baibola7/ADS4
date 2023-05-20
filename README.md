# ADS4
# Assignment 4 Defence
### Resize Method [(source)](https://github.com/Baibola7/ADS4/blob/master/ADS4/src/MyHashTable.java)
# Assignment 4 Documentation
Welcome to my respository, which I created due to ADS lessons. Here you can easily find some tasks with their explanations. Hope you like it
### Hash
 This is a function that takes a key and returns an index into the array that represents the hashtable. The goal of a good hash function is to evenly distribute the keys across the array to minimize collisions.
```java
  private int hash (K key) {
    return key.hashCode() % M;
  }
``` 
### getSize
 This function returns the number of key-value pairs currently stored in the hashtable.
```java
  public int getSize() {
    return size;
  }
``` 
### put
 This function takes a key-value pair and inserts it into the hashtable. It uses the hash function to compute the index where the pair should be stored. If there is already a pair with the same key in the hashtable, the value for that key is updated.
```java
  public void put (K key, V value) {
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
``` 
### get
 This function takes a key and returns the corresponding value from the hashtable. It uses the hash function to compute the index where the value should be stored, and then looks for the key at that index. If the key is not found, get returns null (or some other sentinel value).
```java
  public V get (K key) {
    if (chain[hash(key)] == null) return null;

    for (HashNode<K, V> node: chain[hash(key)]){
      if(node.getKey().equals(key)) return node.getValue();
    }
    return null;
  }
``` 
### remove
This function takes a key and removes the corresponding key-value pair from the hashtable. It uses the hash function to compute the index where the pair should be stored, and then looks for the key at that index. If the key is found, the pair is removed and the function returns true. Otherwise, it returns false.
```java
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
``` 
### contains
 This function takes a key and returns true if the key is present in the hashtable, false otherwise. It uses the hash function to compute the index where the key should be stored, and then looks for the key at that index.
```java
  public boolean contains(V value) {
    for(LinkedList<HashNode<K,V>> list: chain) {
      for(HashNode<K,V> node: list){
        if (node.getValue().equals(value)) return true;
      }
    }
    return false;
  }
``` 
### getKey
 This function takes a value and returns the key that maps to that value in the hashtable. This function is not typically provided by standard hashtable implementations, as it requires iterating over all key-value pairs in the hashtable until the correct value is found.
```java
    public K getKey(V value) {
    for(LinkedList<HashNode<K,V>> list: chain) {
      for(HashNode<K,V> node: list){
        if (node.getValue().equals(value)) return node.getKey();
      }
    }
    return null;
  }
``` 
