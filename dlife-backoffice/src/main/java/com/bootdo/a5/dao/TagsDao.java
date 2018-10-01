package com.bootdo.a5.dao;

import com.bootdo.a5.domain.TagsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 标签表
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 10:22:45
 */
@Mapper
public interface TagsDao {

	TagsDO get(Long id);
	
	List<TagsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TagsDO tags);
	
	int update(TagsDO tags);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
