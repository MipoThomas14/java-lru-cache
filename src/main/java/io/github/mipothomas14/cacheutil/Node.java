package io.github.mipothomas14.cacheutil;

final class Node<K, V> {
    private K key;
    private V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public K getKey(){
        return this.key;
    }
    
    public V getValue(){
        return this.value;
    }

    public void updateValue(V value){
        this.value = value;
    }
}