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

import com.bootdo.a5.dao.FanActivityDao;
import com.bootdo.a5.domain.FanActivityDO;
import com.bootdo.a5.service.FanActivityService;



@Service
public class FanActivityServiceImpl implements FanActivityService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FanActivityDao fanActivityDao;
	@Autowired
	private BizModuleDao bizModuleDao;
	
	@Override
	public FanActivityDO get(Long id){
		return fanActivityDao.get(id);
	}
	
	@Override
	public List<FanActivityDO> list(Map<String, Object> map){
		return fanActivityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fanActivityDao.count(map);
	}
	
	@Override
	public int save(FanActivityDO fanActivity){
		return fanActivityDao.save(fanActivity);
	}
	
	@Override
	public int update(FanActivityDO fanActivity){
		return fanActivityDao.update(fanActivity);
	}
	
	@Override
	public int remove(Long id){
		return fanActivityDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fanActivityDao.batchRemove(ids);
	}


	public int batchMove(String targetCompany, String targetBizCategory, Long[] ids){
		{
			if(ids == null || ids.length == 0 ){
				logger.info("ids is not allowed to be null.");
				return 0;
			}

			bizModuleDao.batchRemovePin( ids );

			int ret = 0;

			for ( Long id : ids ) {
				BizModuleDO bizModuleDO = new BizModuleDO();

				bizModuleDO.setCompany( targetCompany );
				bizModuleDO.setBizCategory(targetBizCategory);

				bizModuleDO.setObjectId( id );
				bizModuleDO.setObjectType("PIN");

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
