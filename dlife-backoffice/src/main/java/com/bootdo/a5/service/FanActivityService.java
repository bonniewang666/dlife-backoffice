package com.bootdo.a5.service;

import com.bootdo.a5.domain.FanActivityDO;

import java.util.List;
import java.util.Map;

/**
 * 拼饭活动
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-27 20:23:32
 */
public interface FanActivityService {
	
	FanActivityDO get(Long id);
	
	List<FanActivityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FanActivityDO fanActivity);
	
	int update(FanActivityDO fanActivity);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
