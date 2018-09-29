package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.WechatUserDao;
import com.bootdo.a5.domain.WechatUserDO;
import com.bootdo.a5.service.WechatUserService;



@Service
public class WechatUserServiceImpl implements WechatUserService {
	@Autowired
	private WechatUserDao wechatUserDao;
	
	@Override
	public WechatUserDO get(Long id){
		return wechatUserDao.get(id);
	}
	
	@Override
	public List<WechatUserDO> list(Map<String, Object> map){
		return wechatUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wechatUserDao.count(map);
	}
	
	@Override
	public int save(WechatUserDO wechatUser){
		return wechatUserDao.save(wechatUser);
	}
	
	@Override
	public int update(WechatUserDO wechatUser){
		return wechatUserDao.update(wechatUser);
	}
	
	@Override
	public int remove(Long id){
		return wechatUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return wechatUserDao.batchRemove(ids);
	}
	
}
