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

        System.out.println("Cache list: \n");
        cache.printList();

        System.out.println("Cache map: \n");
        cache.printMap();
    }
}
