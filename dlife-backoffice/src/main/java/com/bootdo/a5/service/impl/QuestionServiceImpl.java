package com.bootdo.a5.service.impl;

import com.bootdo.a5.dao.BizModuleDao;
import com.bootdo.a5.domain.BizModuleDO;
import com.bootdo.common.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.QuestionDao;
import com.bootdo.a5.domain.QuestionDO;
import com.bootdo.a5.service.QuestionService;



@Service
public class QuestionServiceImpl implements QuestionService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private BizModuleDao bizModuleDao;
	
	@Override
	public QuestionDO get(Long id){
		return questionDao.get(id);
	}
	
	@Override
	public List<QuestionDO> list(Map<String, Object> map){
		return questionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return questionDao.count(map);
	}
	
	@Override
	public int save(QuestionDO question){
		return questionDao.save(question);
	}
	
	@Override
	public int update(QuestionDO question){
		return questionDao.update(question);
	}
	
	@Override
	public int remove(Long id){
		return questionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return questionDao.batchRemove(ids);
	}

	public int batchMove(String targetCompany, String targetBizCategory, Long[] ids){
		{
			if(ids == null || ids.length == 0 ){
				logger.info("ids is not allowed to be null.");
				return 0;
			}

			bizModuleDao.batchRemoveFaqs( ids );

			int ret = 0;

			for ( Long id : ids ) {
				BizModuleDO bizModuleDO = new BizModuleDO();

				bizModuleDO.setCompany( targetCompany );
				bizModuleDO.setBizCategory(targetBizCategory);

				bizModuleDO.setObjectId( id );
				bizModuleDO.setObjectType("FAQS");

				bizModuleDO.setCreateUserId(ShiroUtils.getUser().getUserId());
				bizModuleDO.setCreateDate(new Date());
				bizModuleDO.setUpdateUserId(ShiroUtils.getUser().getUserId());
				bizModuleDO.setUpdateDate(new Date());
				bizModuleDao.save(bizModuleDO);
				ret++;
			}

			return ret;
		}
	}
	
}
