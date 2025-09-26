package io.github.mipothomas14.cacheutil;

import org.junit.jupiter.api.*;
public class DoublyLinkedListTest {
    @Test
    void prints(){
        DoublyLinkedList<Integer, String> dll = new DoublyLinkedList<>();
        dll.addFirst(10, "Apple");
        dll.addFirst(20, "Cherry");
        dll.addFirst(5, "Banana");

        System.out.println("Full list: ");
        System.out.println(dll);
    }
}
