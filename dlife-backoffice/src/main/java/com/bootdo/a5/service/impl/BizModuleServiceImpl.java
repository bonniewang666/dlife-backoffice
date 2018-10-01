package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.BizModuleDao;
import com.bootdo.a5.domain.BizModuleDO;
import com.bootdo.a5.service.BizModuleService;



@Service
public class BizModuleServiceImpl implements BizModuleService {
	@Autowired
	private BizModuleDao bizModuleDao;
	
	@Override
	public BizModuleDO get(Long id){
		return bizModuleDao.get(id);
	}
	
	@Override
	public List<BizModuleDO> list(Map<String, Object> map){
		return bizModuleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bizModuleDao.count(map);
	}
	
	@Override
	public int save(BizModuleDO bizModule){
		return bizModuleDao.save(bizModule);
	}
	
	@Override
	public int update(BizModuleDO bizModule){
		return bizModuleDao.update(bizModule);
	}
	
	@Override
	public int remove(Long id){
		return bizModuleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return bizModuleDao.batchRemove(ids);
	}
	
}
