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

    @Test
    void get(){
        LRUCache<Integer, String> cache = new LRUCache<>(5);
        cache.put(50, "Apple");
        cache.put(40, "Pineapple");
        cache.put(30, "Orange");
        cache.put(20, "Mango");
        cache.put(10, "Berries");

        System.out.println("list before getting: ");
        cache.printList();

        System.out.println("\nNode pulled: " + cache.get(30));
        System.out.print("List after getting: ");
        cache.printList();
    }
}
