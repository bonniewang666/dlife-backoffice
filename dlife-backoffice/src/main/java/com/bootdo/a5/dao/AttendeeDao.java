package com.bootdo.a5.dao;

import com.bootdo.a5.domain.AttendeeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-09-29 12:36:56
 */
@Mapper
public interface AttendeeDao {

	AttendeeDO get(Long id);
	
	List<AttendeeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AttendeeDO attendee);
	
	int update(AttendeeDO attendee);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
