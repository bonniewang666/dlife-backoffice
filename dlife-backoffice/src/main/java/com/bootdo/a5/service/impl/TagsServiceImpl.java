package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.TagsDao;
import com.bootdo.a5.domain.TagsDO;
import com.bootdo.a5.service.TagsService;



@Service
public class TagsServiceImpl implements TagsService {
	@Autowired
	private TagsDao tagsDao;
	
	@Override
	public TagsDO get(Long id){
		return tagsDao.get(id);
	}
	
	@Override
	public List<TagsDO> list(Map<String, Object> map){
		return tagsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tagsDao.count(map);
	}
	
	@Override
	public int save(TagsDO tags){
		return tagsDao.save(tags);
	}
	
	@Override
	public int update(TagsDO tags){
		return tagsDao.update(tags);
	}
	
	@Override
	public int remove(Long id){
		return tagsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tagsDao.batchRemove(ids);
	}
	
}
