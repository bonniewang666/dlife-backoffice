package com.bootdo.a5.service;

import com.bootdo.a5.domain.WechatUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 00:44:28
 */
public interface WechatUserService {
	
	WechatUserDO get(Long id);
	
	List<WechatUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WechatUserDO wechatUser);
	
	int update(WechatUserDO wechatUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
