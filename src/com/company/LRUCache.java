package com.company;

import java.util.HashMap;

class Node{
    int key,val;
    Node prev;
    Node next;
    Node(int key ,int val){
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private HashMap<Integer,Node> cache;
    private int capacity;
    private Node left;
    private Node right;

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    private void insertNode(Node node){
        Node prev = right.prev;
        Node next = right;

        prev.next = node;
        node.next = next;

        next.prev = node;
        node.prev = prev;
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if(cache.get(key)!=null){
            removeNode(cache.get(key));
            insertNode(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.get(key)!=null){
            removeNode(cache.get(key));
        }
        cache.put(key,new Node(key,value));
        insertNode(cache.get(key));

        if(cache.size()>capacity){
            Node lru = left.next;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */