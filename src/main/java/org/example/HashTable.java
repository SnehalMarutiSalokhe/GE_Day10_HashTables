package org.example;

import java.util.LinkedList;

public class HashTable<K, V> {
    private final int size = 10;
    private LinkedList<MyMapNode<K, V>>[] buckets;

    public HashTable() {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % size);
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new MyMapNode<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<MyMapNode<K, V>> bucket : buckets) {
            for (MyMapNode<K, V> node : bucket) {
                result.append(node.key).append(": ").append(node.value).append("\n");
            }
        }
        return result.toString();
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];

        MyMapNode<K, V> toRemove = null;
        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
            System.out.println("Removed: " + key);
        } else {
            System.out.println(key + " not found");
        }
    }

}
