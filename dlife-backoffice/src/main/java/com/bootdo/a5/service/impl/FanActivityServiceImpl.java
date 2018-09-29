package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.FanActivityDao;
import com.bootdo.a5.domain.FanActivityDO;
import com.bootdo.a5.service.FanActivityService;



@Service
public class FanActivityServiceImpl implements FanActivityService {
	@Autowired
	private FanActivityDao fanActivityDao;
	
	@Override
	public FanActivityDO get(Long id){
		return fanActivityDao.get(id);
	}
	
	@Override
	public List<FanActivityDO> list(Map<String, Object> map){
		return fanActivityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fanActivityDao.count(map);
	}
	
	@Override
	public int save(FanActivityDO fanActivity){
		return fanActivityDao.save(fanActivity);
	}
	
	@Override
	public int update(FanActivityDO fanActivity){
		return fanActivityDao.update(fanActivity);
	}
	
	@Override
	public int remove(Long id){
		return fanActivityDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fanActivityDao.batchRemove(ids);
	}
	
}
