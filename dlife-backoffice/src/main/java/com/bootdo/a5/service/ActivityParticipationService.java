package com.bootdo.a5.service;

import com.bootdo.a5.domain.ActivityParticipationDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-09-29 10:52:37
 */
public interface ActivityParticipationService {
	
	ActivityParticipationDO get(Long id);
	
	List<ActivityParticipationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ActivityParticipationDO activityParticipation);
	
	int update(ActivityParticipationDO activityParticipation);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
