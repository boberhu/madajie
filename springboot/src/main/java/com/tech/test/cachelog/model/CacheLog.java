package com.tech.test.cachelog.model;

public class CacheLog {

	private String prefix;
	
	private String key;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "CacheLog [prefix=" + prefix + ", key=" + key + "]";
	}
	
	
}
