package main;

import java.util.HashMap;

public class MultivalueHashMap<K1, K2, V> {
	private HashMap<K1, HashMap<K2,V>> map;
	 public MultivalueHashMap() {
		 this.map = new HashMap<K1,HashMap<K2,V>>();
	 }
	 public boolean contains(K1 key1) {
		 return this.map.containsKey(key1);
	 }
	 public boolean contains(K1 key1, K2 key2) {
		 return this.map.containsKey(key1) ? this.map.get(key1).containsKey(key2) : false;
	 }
	 public void put(K1 key1, K2 key2, V value) {
		 this.map.putIfAbsent(key1, new HashMap<K2,V>());
		 this.map.get(key1).put(key2, value);
	 }
	 public void putIfAbsent(K1 key1, K2 key2, V value) {
		 this.map.putIfAbsent(key1, new HashMap<K2,V>());
		 this.map.get(key1).putIfAbsent(key2, value);
	 }
	 public V get(K1 key1, K2 key2) {
		 return this.map.containsKey(key1) ? this.map.get(key1).get(key2) : null;
	 }
}
