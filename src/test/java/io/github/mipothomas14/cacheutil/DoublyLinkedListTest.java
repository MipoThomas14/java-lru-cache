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

    @Test 
    void removeLast(){
        DoublyLinkedList<Integer, String> dll = new DoublyLinkedList<>();
        dll.addFirst(10, "Apple");
        dll.addFirst(20, "Cherry");
        dll.addFirst(5, "Banana");

        System.out.println("list before removal:");
        System.out.println(dll);

        dll.removeLast();
        dll.removeLast();

        System.out.println("list before removal:");
        System.out.println(dll);    
    }

    @Test
    void traverseTillKeyTest(){
        DoublyLinkedList<Integer, String> dll = new DoublyLinkedList<>();
        dll.addFirst(30, "Apple");
        dll.addFirst(20, "Cherry");
        dll.addFirst(10, "Banana");
        dll.addFirst(5, "Orange");
        dll.addFirst(1, "Mango");

        System.out.println(dll.traverseTillKey(1));
    }

    @Test
    void moveToFrontTest(){
        DoublyLinkedList<Integer, String> dll = new DoublyLinkedList<>();
        dll.addFirst(30, "Apple");
        dll.addFirst(20, "Cherry");
        dll.addFirst(10, "Banana");
        dll.addFirst(5, "Orange");
        dll.addFirst(1, "Mango");
        
        System.out.println("List before moving: ");
        System.out.println(dll);

        // move to front
        // dll.moveToFront(30);

    }
}
