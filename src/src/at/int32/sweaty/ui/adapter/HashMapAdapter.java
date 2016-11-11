package at.int32.sweaty.ui.adapter;

import java.util.LinkedHashMap;

public abstract class HashMapAdapter<K, V, T> {

	private LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();

	public abstract V create(K Key, T item);

	public abstract void onAdd(V item);

	public abstract void onRemove(V item);

	public void put(K key, T item) {
		V create = create(key, item);
		map.put(key, create);
		onAdd(create);
	}

	public V remove(K key) {
		V remove = map.remove(key);
		onRemove(remove);
		return remove;
	}

	public boolean containsKey(K key) {
		return map.containsKey(key);
	}

	public void update() {

	}
}
