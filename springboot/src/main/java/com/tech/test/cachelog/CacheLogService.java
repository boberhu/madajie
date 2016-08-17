package com.tech.test.cachelog;

import com.tech.test.cachelog.model.CacheLog;

public interface CacheLogService {

	public void saveLog(CacheLog log) ;
	
	public CacheLog findLog(String key) ;
}
