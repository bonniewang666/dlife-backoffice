package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.ActivityParticipationDao;
import com.bootdo.a5.domain.ActivityParticipationDO;
import com.bootdo.a5.service.ActivityParticipationService;



@Service
public class ActivityParticipationServiceImpl implements ActivityParticipationService {
	@Autowired
	private ActivityParticipationDao activityParticipationDao;
	
	@Override
	public ActivityParticipationDO get(Long id){
		return activityParticipationDao.get(id);
	}
	
	@Override
	public List<ActivityParticipationDO> list(Map<String, Object> map){
		return activityParticipationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return activityParticipationDao.count(map);
	}
	
	@Override
	public int save(ActivityParticipationDO activityParticipation){
		return activityParticipationDao.save(activityParticipation);
	}
	
	@Override
	public int update(ActivityParticipationDO activityParticipation){
		return activityParticipationDao.update(activityParticipation);
	}
	
	@Override
	public int remove(Long id){
		return activityParticipationDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return activityParticipationDao.batchRemove(ids);
	}
	
}
