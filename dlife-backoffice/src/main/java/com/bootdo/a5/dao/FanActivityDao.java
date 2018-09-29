package com.bootdo.a5.dao;

import com.bootdo.a5.domain.FanActivityDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 拼饭活动
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-27 20:23:32
 */
@Mapper
public interface FanActivityDao {

	FanActivityDO get(Long id);
	
	List<FanActivityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FanActivityDO fanActivity);
	
	int update(FanActivityDO fanActivity);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
