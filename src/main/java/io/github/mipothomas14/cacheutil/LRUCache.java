package io.github.mipothomas14.cacheutil;

import java.util.*;

public class LRUCache<K, V> {
    // fields
    public int size; // todo: handle sizing manually; abstract information also

    public final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;

    
    // public constructor
    public LRUCache(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Cache capacity cannot be equal to or less than zero");
        }

        this.capacity = capacity;
        this.list = new DoublyLinkedList<>();
        this.size = list.size;
        this.map = new HashMap<>();
    }


    // public API
    // public V get(K key){
        
    // }

    private Node<K, V> evictLast(){ // removes least used entry from HashMap and DLL
        Node<K, V> last = list.removeLast();
        map.remove(last.getKey());
        return last;
    }


    // todo: update capacity + evict last used!
    public void put(K key, V value){
        Node<K, V> node;
        if(map.containsKey(key)){ // checks if same key is in map, and updates instead of creating an entirely new entry
            node = map.get(key);
            node.updateValue(value);
            list.moveToFront(node);
            System.out.println("updating, not instantiating");
        } else{ // proceed as normal with creating a new node
            node = new Node<K,V>(key, value);
            System.out.println("Creating new node: " + node);
            list.addFirst(node);
        }

        map.put(key, node);
        size = list.size;
        if(size > capacity){
            Node<K, V> last = evictLast();
            System.out.println("Evicting: " + last);
        }
        size = list.size;
    }

    public boolean containsKey(K key){
        return map.containsKey(key);
    }

    @Override
    public String toString(){
        return "don't call this";
    }

    public void printList(){
        System.out.println(list.toString());
    }

    public void printMap(){
        System.out.println(map.toString());
    }
}