import java.util.*;
import cacheutil.*;

public class CLI{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LRUCache<Integer, String> cache = new LRUCache<>(4);

        cache.put(10, "Apple");
        cache.put(5, "Pineapple");
        cache.put(8, "Orange");

        System.out.println(cache);
        input.close();
    }
}