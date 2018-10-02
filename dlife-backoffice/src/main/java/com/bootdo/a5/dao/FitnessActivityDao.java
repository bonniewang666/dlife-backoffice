package com.bootdo.a5.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.domain.FitnessActivityDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 健身活动信息
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 01:32:25
 */
@Mapper
public interface FitnessActivityDao {

	FitnessActivityDO get(Long id);
	
	List<FitnessActivityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FitnessActivityDO fitnessActivity);
	
	int update(FitnessActivityDO fitnessActivity);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);


	/**
	 * 批量修改
	 * */
	int batchMove(Long[] ids);

}
