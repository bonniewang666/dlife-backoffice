package com.bootdo.a5.service;

import com.bootdo.a5.domain.QuestionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 01:58:34
 */
public interface QuestionService {
	
	QuestionDO get(Long id);
	
	List<QuestionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QuestionDO question);
	
	int update(QuestionDO question);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int batchMove(String targetCompany, String targetBizCategory, Long[] ids);
}
