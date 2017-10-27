package com.ai.test.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2<K, V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5096982055155668972L;

	private final int MAX_CACHE_SIZE;

	public LRUCache2(int cacheSize) {
		// 根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
		super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
		this.MAX_CACHE_SIZE = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_CACHE_SIZE;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<K, V> entry : entrySet()) {
			sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}

}
