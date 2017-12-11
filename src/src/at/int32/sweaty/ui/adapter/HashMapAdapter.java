package at.int32.sweaty.ui.adapter;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public abstract class HashMapAdapter<K, V, T> {

	private LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();

	public abstract V create(K Key, T item);

	public abstract void onAdd(V item);

	public abstract void onRemove(V item);
	
	public abstract void onUpdate(V item);

	public void put(K key, T item) {
		V create = create(key, item);
		map.put(key, create);
		onUpdate(create);
		onAdd(create);
	}

	public V remove(K key) {
		V remove = map.remove(key);
		onRemove(remove);
		onUpdate(remove);
		return remove;
	}

	public boolean containsKey(K key) {
		return map.containsKey(key);
	}
	
	public int size() {
		return map.size();
	}
	
	public V get(K key) {
		return map.get(key);
	}
	
	public Set<K> keySet() {
		return map.keySet();
	}
	
	public Set<Entry<K, V>> entrySet() {
		return map.entrySet();
	}
	
}
