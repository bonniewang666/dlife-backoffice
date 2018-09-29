package com.bootdo.a5.service;

import com.bootdo.a5.domain.CommentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 02:25:07
 */
public interface CommentService {
	
	CommentDO get(Long id);
	
	List<CommentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CommentDO comment);
	
	int update(CommentDO comment);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
