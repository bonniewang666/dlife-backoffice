package com.bootdo.a5.dao;

import com.bootdo.a5.domain.TagDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 标签表
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 14:39:28
 */
@Mapper
public interface TagDao {

	TagDO get(Long id);
	
	List<TagDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TagDO tag);
	
	int update(TagDO tag);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
