package com.bootdo.a5.service;

import com.bootdo.a5.domain.TagsDO;

import java.util.List;
import java.util.Map;

/**
 * 标签表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 14:22:13
 */
public interface TagsService {
	
	TagsDO get(Long id);
	
	List<TagsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TagsDO tags);
	
	int update(TagsDO tags);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
