package com.implementations.dsa;

import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> { //generic

        //node class starts
        private class Node {

            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        } //node class ends

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }

        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; //storing the LinkedList on the arrayIndex or bucketIndex
            int di = 0;
            for (int i = 0; i < ll.size(); i++) { //we traverse through every node of the LL stored at every bucket index.
                Node node = ll.get(i); //then we store that node in separate node variable.
                if (node.key.equals(key)) { //if the key exists, we return the index of that key.
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets; //
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }


        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }
        public V get (K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keySet = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keySet.add(node.key);
                }
            }
            return keySet;
        }

        public boolean isEmpty() {
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Bhuvan", 90);
        hm.put("Bhanu", 100);
        hm.put("Parth", 10);
        hm.put("Effortful" , 100);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
        System.out.println(hm.get("Effortful"));
        System.out.println(hm.remove("Effortful"));
        System.out.println(hm.get("Effortful"));

    }
}
