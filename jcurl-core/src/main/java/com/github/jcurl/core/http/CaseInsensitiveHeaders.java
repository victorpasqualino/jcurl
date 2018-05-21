package com.github.jcurl.core.http;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CaseInsensitiveHeaders implements Map<String, String> {
	
	private Map<String, String> headers;
	
	public CaseInsensitiveHeaders() {
		this.headers = new HashMap<>();
	}
	
	public CaseInsensitiveHeaders(Map<String, String> headers) {
		this.headers = new HashMap<>();
		putAll(headers);
	}

	@Override
	public void clear() {
		headers.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return headers.containsKey(((String) key).toLowerCase());
	}

	@Override
	public boolean containsValue(Object value) {
		return headers.containsValue(value);
	}

	@Override
	public Set<Entry<String, String>> entrySet() {
		return Collections.unmodifiableSet(headers.entrySet());
	}

	@Override
	public String get(Object key) {
		return headers.get(key);
	}

	@Override
	public boolean isEmpty() {
		return headers.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return Collections.unmodifiableSet(headers.keySet());
	}

	@Override
	public String put(String key, String value) {
		return headers.put(key.toLowerCase(), value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		m.entrySet().forEach(e -> put(e.getKey(), e.getValue()));
	}

	@Override
	public String remove(Object key) {
		return headers.remove(((String) key).toLowerCase());
	}

	@Override
	public int size() {
		return headers.size();
	}

	@Override
	public Collection<String> values() {
		return Collections.unmodifiableCollection(headers.values());
	}


}
