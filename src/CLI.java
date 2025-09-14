import java.util.*;
import cacheutil.*;

public class CLI{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedList<Integer, String> dll = new DoublyLinkedList<>();

        dll.addFirst(4, "Mango");
        dll.addFirst(3, "Peach");
        dll.addFirst(2, "Orange");
        dll.addFirst(1, "Banana");
        dll.addFirst(0, "Apple");

        System.out.print("Add one more fruit: ");
        dll.addFirst(5, input.nextLine());

        System.out.println("Full list: ");
        System.out.println(dll.toString());
        input.close();
    }
}