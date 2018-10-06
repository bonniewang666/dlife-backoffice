package com.bootdo.a5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.ArticleReferralDao;
import com.bootdo.a5.domain.ArticleReferralDO;
import com.bootdo.a5.service.ArticleReferralService;



@Service
public class ArticleReferralServiceImpl implements ArticleReferralService {
	@Autowired
	private ArticleReferralDao articleReferralDao;
	
	@Override
	public ArticleReferralDO get(Long id){
		return articleReferralDao.get(id);
	}
	
	@Override
	public List<ArticleReferralDO> list(Map<String, Object> map){
		return articleReferralDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return articleReferralDao.count(map);
	}
	
	@Override
	public int save(ArticleReferralDO articleReferral){
		return articleReferralDao.save(articleReferral);
	}
	
	@Override
	public int update(ArticleReferralDO articleReferral){
		return articleReferralDao.update(articleReferral);
	}
	
	@Override
	public int remove(Long id){
		return articleReferralDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return articleReferralDao.batchRemove(ids);
	}
	
}
