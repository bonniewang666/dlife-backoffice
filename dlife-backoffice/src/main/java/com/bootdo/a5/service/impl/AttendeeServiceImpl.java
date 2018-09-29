package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.AttendeeDao;
import com.bootdo.a5.domain.AttendeeDO;
import com.bootdo.a5.service.AttendeeService;



@Service
public class AttendeeServiceImpl implements AttendeeService {
	@Autowired
	private AttendeeDao attendeeDao;
	
	@Override
	public AttendeeDO get(Long id){
		return attendeeDao.get(id);
	}
	
	@Override
	public List<AttendeeDO> list(Map<String, Object> map){
		return attendeeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return attendeeDao.count(map);
	}
	
	@Override
	public int save(AttendeeDO attendee){
		return attendeeDao.save(attendee);
	}
	
	@Override
	public int update(AttendeeDO attendee){
		return attendeeDao.update(attendee);
	}
	
	@Override
	public int remove(Long id){
		return attendeeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return attendeeDao.batchRemove(ids);
	}
	
}
