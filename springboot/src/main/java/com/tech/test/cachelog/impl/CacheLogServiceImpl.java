/**
 * 
 */
package com.tech.test.cachelog.impl;

import com.tech.test.cachelog.CacheLogService;
import com.tech.test.cachelog.anno.Cache;
import com.tech.test.cachelog.anno.Flush;
import com.tech.test.cachelog.model.CacheLog;

/**
 * @author Administrator
 *
 */
public class CacheLogServiceImpl implements CacheLogService {

	@Override
	@Cache(prefix="test",expiration=1000*60*60*10)  
	public void saveLog(CacheLog log) {
		System.out.println("save success!");
	}

	@Override
	@Flush(prefix="test")  
	public CacheLog findLog(String key) {
		System.out.println("find success!");
		return null;
	}

}
