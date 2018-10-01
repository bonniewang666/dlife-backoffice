package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.ClockInDao;
import com.bootdo.a5.domain.ClockInDO;
import com.bootdo.a5.service.ClockInService;



@Service
public class ClockInServiceImpl implements ClockInService {
	@Autowired
	private ClockInDao clockInDao;
	
	@Override
	public ClockInDO get(Long id){
		return clockInDao.get(id);
	}
	
	@Override
	public List<ClockInDO> list(Map<String, Object> map){
		return clockInDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return clockInDao.count(map);
	}
	
	@Override
	public int save(ClockInDO clockIn){
		return clockInDao.save(clockIn);
	}
	
	@Override
	public int update(ClockInDO clockIn){
		return clockInDao.update(clockIn);
	}
	
	@Override
	public int remove(Long id){
		return clockInDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return clockInDao.batchRemove(ids);
	}
	
}
