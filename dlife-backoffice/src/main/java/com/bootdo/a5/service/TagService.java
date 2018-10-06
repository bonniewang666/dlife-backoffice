package com.bootdo.a5.service;

import com.bootdo.a5.domain.TagDO;

import java.util.List;
import java.util.Map;

/**
 * 标签表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 14:39:28
 */
public interface TagService {
	
	TagDO get(Long id);
	
	List<TagDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TagDO tag);
	
	int update(TagDO tag);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
