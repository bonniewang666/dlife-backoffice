package com.bootdo.a5.dao;

import com.bootdo.a5.domain.ClockInDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 打卡信息
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 10:31:17
 */
@Mapper
public interface ClockInDao {

	ClockInDO get(Long id);
	
	List<ClockInDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ClockInDO clockIn);
	
	int update(ClockInDO clockIn);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
