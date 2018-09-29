package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.FitnessActivityDao;
import com.bootdo.a5.domain.FitnessActivityDO;
import com.bootdo.a5.service.FitnessActivityService;



@Service
public class FitnessActivityServiceImpl implements FitnessActivityService {
	@Autowired
	private FitnessActivityDao fitnessActivityDao;
	
	@Override
	public FitnessActivityDO get(Long id){
		return fitnessActivityDao.get(id);
	}
	
	@Override
	public List<FitnessActivityDO> list(Map<String, Object> map){
		return fitnessActivityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fitnessActivityDao.count(map);
	}
	
	@Override
	public int save(FitnessActivityDO fitnessActivity){
		return fitnessActivityDao.save(fitnessActivity);
	}
	
	@Override
	public int update(FitnessActivityDO fitnessActivity){
		return fitnessActivityDao.update(fitnessActivity);
	}
	
	@Override
	public int remove(Long id){
		return fitnessActivityDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fitnessActivityDao.batchRemove(ids);
	}
	
}
