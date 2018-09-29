package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.QuestionDao;
import com.bootdo.a5.domain.QuestionDO;
import com.bootdo.a5.service.QuestionService;



@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public QuestionDO get(Long id){
		return questionDao.get(id);
	}
	
	@Override
	public List<QuestionDO> list(Map<String, Object> map){
		return questionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return questionDao.count(map);
	}
	
	@Override
	public int save(QuestionDO question){
		return questionDao.save(question);
	}
	
	@Override
	public int update(QuestionDO question){
		return questionDao.update(question);
	}
	
	@Override
	public int remove(Long id){
		return questionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return questionDao.batchRemove(ids);
	}
	
}
