package practice;

import java.util.Arrays;

/**
 * @ClassName MyHashMap
 * @Description TODO
 * @Author Yi lIN
 * @Date 6/21/22 10:59
 * @Version 1.0
 **/
public class MyHashMap<K, V> {
    // Node is a static class of MyHashMap, since it is
    // very closely bonded to MyHashMap class.
    //  we probably need to access this class outside from MyHashMap class.
    public static class Node< K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }
    }

    //static final variable are global constants
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size; //how many key-value pair are actually stored in the HashMap
    private float loadFactor; //determine when to rehash

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap, float loadFactor) {
        if(cap <= 0) {
            throw new IllegalArgumentException("cap can not be <= 0");
        }
        this.array = (Node<K, V>[]) (new Node[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    //non-negative
    private int hash(K key) {
        // 1. null key
        if(key == null) {
            return 0;
        }

        //2. 3. hashCode()
//        int code = key.hashCode();
//        return code >= 0? code : -code;

        return key.hashCode() & 0X7FFFFFFF;
        // guarantee non-negative 01111111 11111111 11111111 11111111

    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        if(v1 == null && v2 == null) {
            return true;
        }
        if(v1 == null || v2 == null) {
            return false;
        }
        return v1.equals(v2);
    }

    // O(n), traverse the whole array, and traverse each of the linked list in the array.
    public boolean containsValue(V value) {
        //special case
        if(isEmpty()) {
            return false;
        }
        for(Node<K, V> node: array) {
            while(node != null) {
                // check is the valve equals()
                // value, node.getValue() all possible to be null
                if(equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private boolean equalsKey(K k1, K k2) {
        if(k1 == null && k2 == null) {
            return true;
        }
        if(k1 == null || k2 == null) {
            return false;
        }
        return k1.equals(k2);
    }

    public boolean containsKey(K key) {
        // get the index of the key
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while(node != null) {
            // check is the key equals()
            // key, node.getKey() all possible to be null
            if(equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // if key does not exists in the hashmap, return null
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while(node != null) {
            // check is the key equals()
            // key, node.getKey() all possible to be null
            if(equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    // insert/update
    // if the key already exists, return the old corresponding value
    // if the key not exists, return null
    public V put(K key,  V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;

        while(node != null) {
            if(equalsKey(node.key, key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode; //NEW HEAD IS HERE
        size++;
        if(needRehashing()) {

        }
        return null;
    }

    private boolean needRehashing(){
        // float loadFactor;
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private static final int SCALE_FACTOR = 2;

    private void rehashing() {
        // new double sized array.
        // for each node in the old array,
        // put(add the head of linkedlist) to the new larger array;
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
        for(Node<K, V> node: oldArray) {
            while(node != null) {
                Node<K, V> next = node.next;
                int index = getIndex(node.key);
                node.next = array[index];
                array[index] = node;
                node = next;
            }
        }


    }

    public V remove(K key) {
        //get index
        //delete operation on the linked list
        //size--;
        int index = getIndex(key);
        Node<K, V> node = array[index];
        Node<K, V> pre = null;
        while(node != null) {
            if(equalsKey(node.key, key)) {
                if(pre != null) {
                    pre.next = node.next;
                } else {
                    array[index] = node.next;
                }
                size--;
                return node.value;
            }
            pre = node;
            node = node.next;
        }
        return null;
    }
    

}
