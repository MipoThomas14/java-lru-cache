package test.java.manual;

import cacheutil.*;

public class CLITest{
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(4);

        cache.put(10, "Apple");
        cache.put(5, "Pineapple");
        cache.put(8, "Orange");

        System.out.println(cache);
    }
}