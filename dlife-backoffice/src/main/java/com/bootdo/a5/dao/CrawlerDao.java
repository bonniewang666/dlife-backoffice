package com.bootdo.a5.dao;

import com.bootdo.a5.domain.CrawlerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 网页抓取器表
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 18:39:33
 */
@Mapper
public interface CrawlerDao {

	CrawlerDO get(Long id);
	
	List<CrawlerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CrawlerDO crawler);
	
	int update(CrawlerDO crawler);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
