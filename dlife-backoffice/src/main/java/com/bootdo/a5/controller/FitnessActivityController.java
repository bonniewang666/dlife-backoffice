package com.bootdo.a5.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.a5.domain.FitnessActivityDO;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.a5.service.FitnessActivityService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 健身活动信息
 *
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 01:32:25
 */

@Controller
@RequestMapping("/a5/fitnessActivity")
public class FitnessActivityController {
    @Autowired
    private FitnessActivityService fitnessActivityService;
    @Autowired
    private DictService dictService;

    @GetMapping()
    @RequiresPermissions("a5:fitnessActivity:fitnessActivity")
    String FitnessActivity(Model model) {
        List<DictDO> dictDOs = dictService.listByType("company");
        model.addAttribute("companies", dictDOs);
        return "a5/fitnessActivity/fitnessActivity";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("a5:fitnessActivity:fitnessActivity")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<FitnessActivityDO> fitnessActivityList = fitnessActivityService.list(query);
        int total = fitnessActivityService.count(query);
        PageUtils pageUtils = new PageUtils(fitnessActivityList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("a5:fitnessActivity:add")
    String add() {
        return "a5/fitnessActivity/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("a5:fitnessActivity:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        FitnessActivityDO fitnessActivity = fitnessActivityService.get(id);
        model.addAttribute("fitnessActivity", fitnessActivity);
        return "a5/fitnessActivity/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("a5:fitnessActivity:add")
    public R save(FitnessActivityDO fitnessActivity) {
        if (fitnessActivityService.save(fitnessActivity) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("a5:fitnessActivity:edit")
    public R update(FitnessActivityDO fitnessActivity) {
        fitnessActivityService.update(fitnessActivity);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("a5:fitnessActivity:remove")
    public R remove(Long id) {
        if (fitnessActivityService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("a5:fitnessActivity:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        fitnessActivityService.batchRemove(ids);
        return R.ok();
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        FitnessActivityDO fitnessActivity = fitnessActivityService.get(id);
        model.addAttribute("fitnessActivity", fitnessActivity);
        return "a5/fitnessActivity/detail";
    }


    /**
     * 批量移动
     */
    @PostMapping("/batchMove")
    @ResponseBody
    @RequiresPermissions("a5:fitnessActivity:edit")
    public R batchMove(@RequestParam("targetCompany") String targetCompany, @RequestParam("targetBizCategory") String
            targetBizCategory, @RequestParam("ids[]") Long[] ids) {
        fitnessActivityService.batchMove(targetCompany, targetBizCategory, ids);
        return R.ok();
    }


}
