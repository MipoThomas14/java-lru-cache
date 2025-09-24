package cacheutil;
import java.util.*;

public class LRUCache<K, V> {
    // fields
    public int size; // todo: handle sizing manually; abstract information also

    public final int capacity;
    private final Map<K, Node<K, V>> index;
    private final DoublyLinkedList<K, V> list;

    
    // public constructor
    public LRUCache(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Cache capacity cannot be equal to or less than zero");
        }

        this.capacity = capacity;
        this.list = new DoublyLinkedList<>();
        this.size = list.size;
        this.index = new HashMap<>();
    }


    // public API
    // public V get(K key){
        
    // }


    // todo: update capacity + evict last used!
    public void put(K key, V value){
        Node<K, V> node;
        if(index.containsKey(key)){ // checks if same key is in map, and updates instead of creating an entirely new entry
            node = index.get(key);
            node.updateValue(value);
            list.moveToFront(node);
            System.out.println("updating, not instantiating");
        } else{ // proceed as normal with creating a new node
            System.out.println("Instantiating, not updating");
            node = new Node<K,V>(key, value);
            list.addFirst(node);
        }

        index.put(key, node);
    }

    public boolean containsKey(K key){
        return index.containsKey(key);
    }

}