package com.bootdo.a5.service.impl;

import com.bootdo.a5.dao.BizModuleDao;
import com.bootdo.a5.domain.BizModuleDO;
import com.bootdo.a5.domain.FitnessActivityDO;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.FitnessActivityDao;
import com.bootdo.a5.service.FitnessActivityService;


@Service
public class FitnessActivityServiceImpl implements FitnessActivityService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FitnessActivityDao fitnessActivityDao;

    @Autowired
    private BizModuleDao bizModuleDao;

    @Override
    public FitnessActivityDO get(Long id) {
        return fitnessActivityDao.get(id);
    }

    @Override
    public List<FitnessActivityDO> list(Map<String, Object> map) {
        return fitnessActivityDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return fitnessActivityDao.count(map);
    }

    @Override
    public int save(FitnessActivityDO fitnessActivity) {
        return fitnessActivityDao.save(fitnessActivity);
    }

    @Override
    public int update(FitnessActivityDO fitnessActivity) {
        return fitnessActivityDao.update(fitnessActivity);
    }

    @Override
    public int remove(Long id) {
        return fitnessActivityDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return fitnessActivityDao.batchRemove(ids);
    }


    @Override
    public int batchMove(String targetCompany , String targetBizCategory,  Long[] ids) {

        if(ids == null || ids.length == 0 ){
            logger.info("ids is not allowed to be null.");
            return 0;
        }

        bizModuleDao.batchRemoveFit( ids );

        int ret = 0;

        for ( Long id : ids ) {
            BizModuleDO bizModuleDO = new BizModuleDO();

            bizModuleDO.setCompany( targetCompany );
            bizModuleDO.setBizCategory(targetBizCategory);

            bizModuleDO.setObjectId( id );
            bizModuleDO.setObjectType("FIT");

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
