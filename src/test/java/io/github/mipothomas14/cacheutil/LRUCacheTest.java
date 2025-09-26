package io.github.mipothomas14.cacheutil;

import org.junit.jupiter.api.*;
// import static org.junit.jupiter.api.Assertions.*;


public class LRUCacheTest {
    @Test
    void printCacheComponents(){
        LRUCache<Integer, String> cache = new LRUCache<>(3);
       
        cache.put(10, "Apple");
        cache.put(5, "Pineapple");
        cache.put(8, "Orange");

        System.out.println("Cache list:");
        cache.printList();
        System.out.println();

        System.out.println("Cache map:");
        cache.printMap();
        System.out.println();
    }

    @Test
    void printMap(){
        LRUCache<Integer, String> cache = new LRUCache<>(3);
       
        cache.put(10, "Apple");
        cache.put(5, "Pineapple");
        cache.put(8, "Orange");

        System.out.println("Cache list:");
        cache.printList();
    }

    @Test
    void cacheEviction(){
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(10, "Apple");
        cache.put(20, "Pineapple");
        cache.put(30, "Orange");
        cache.put(40, "Berries"); // cache should be maxed out at this point, we should be evicting here;
        System.out.println("\nFinal list: ");
        cache.printList();
    }
}
