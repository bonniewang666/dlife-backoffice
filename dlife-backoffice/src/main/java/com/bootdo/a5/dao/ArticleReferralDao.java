package com.bootdo.a5.dao;

import com.bootdo.a5.domain.ArticleReferralDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 抓取的文章表
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 18:38:44
 */
@Mapper
public interface ArticleReferralDao {

	ArticleReferralDO get(Long id);
	
	List<ArticleReferralDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ArticleReferralDO articleReferral);
	
	int update(ArticleReferralDO articleReferral);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
