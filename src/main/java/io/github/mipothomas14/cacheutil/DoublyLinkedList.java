package io.github.mipothomas14.cacheutil;

class DllException extends RuntimeException {
    public DllException(String err){
        super(err);
    }
}

public class DoublyLinkedList <K, V> {
    public int size;
    private Node<K, V> head;
    private Node<K, V> tail;

    public DoublyLinkedList(){
        size = 0;

        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node<K, V> node){
        node.prev = head; // links new node to it's left neighbor
        node.next = head.next; // links new node to it's right neighbor
        head.next.prev = node; // links right neighbor to node
        head.next = node; // links left neighbor to node
        size++;
    }

    public void addFirst(K key, V value){
        addFirst(new Node<>(key, value));
    }

    public void moveToFront(Node<K, V> node){
        if(node == null){throw new DllException("Invalid empty node.");}
        if(node == head || node == tail){throw new DllException("Cannot operate on sentinel nodes.");}
        if(node.prev == null || node.next == null){throw new DllException("Node is not a valid member of DoublyLinkedList.");}

        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;
        
        prev.next = next;
        next.prev = prev;

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node<K, V> node){
        if(node == null){throw new DllException("Invalid empty node.");}
        if(node == head || node == tail){throw new DllException("Cannot operate on sentinel nodes.");}
        if(node.prev == null || node.next == null){throw new DllException("Node is not a valid member of DoublyLinkedList.");}

        Node<K, V> left = node.prev;
        Node<K, V> right = node.next;
        left.next = right;
        right.prev = left;
        node.next = null;
        node.prev = null;

        size--;
    } 

    public Node<K, V> removeLast(){
        if(head.next == tail){
            throw new DllException("Attempting to remove element from empty list.");
        }

        Node<K, V> last = tail.prev;
        Node<K, V> secondLast = last.prev;
        secondLast.next = tail;
        tail.prev = secondLast;
        last.next = null;
        last.prev = null;

        size--;
        return last;
    }

    // traverses till a certain key, then returns corresponding node
    // returns null otherwise
    public Node<K, V> traverseTillKey(K key){
        Node<K, V> node = null;
        Node<K, V> current = this.head.next;

        while(current != this.tail){
            if(current.getKey().equals(key)){
                node = current;
                break;
            }

            current = current.next;
        }

        if(node == null){
            throw new DllException("key " + key + " is not present in DoublyLinkedList.");
        }

        return node;
    }

    @Override
    public String toString(){
        Node<K, V> current = head.next;
        String s = "";

        while(current != tail){
            s += current.getValue().toString();
            if(current.next != tail){
                s += " <-> ";
            }
            current = current.next;
        }

        return s;
    }
}
