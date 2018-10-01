package com.bootdo.a5.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.a5.domain.BizModuleDO;
import com.bootdo.a5.service.BizModuleService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 业务板块表
 *
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 15:24:35
 */

@Controller
@RequestMapping("/a5/bizModule")
public class BizModuleController {
    @Autowired
    private BizModuleService bizModuleService;
    @Autowired
    private DictService dictService;

    @GetMapping()
    @RequiresPermissions("a5:bizModule:bizModule")
    String BizModule(Model model) {

        List<DictDO> dictDOs = dictService.listByType("company");
        model.addAttribute("companies", dictDOs);

        return "a5/bizModule/bizModule";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("a5:bizModule:bizModule")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<BizModuleDO> bizModuleList = bizModuleService.list(query);
        int total = bizModuleService.count(query);
        PageUtils pageUtils = new PageUtils(bizModuleList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("a5:bizModule:add")
    String add() {
        return "a5/bizModule/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("a5:bizModule:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        BizModuleDO bizModule = bizModuleService.get(id);
        model.addAttribute("bizModule", bizModule);
        return "a5/bizModule/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("a5:bizModule:add")
    public R save(BizModuleDO bizModule) {

        bizModule.setUpdateDate(new Date());
        bizModule.setCreateDate(new Date());
//        bizModule.setCreateUserId(ShiroUtils.getUser().getUserId());
//        bizModule.setUpdateUserId(ShiroUtils.getUser().getUserId());
        if (bizModuleService.save(bizModule) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("a5:bizModule:edit")
    public R update(BizModuleDO bizModule) {
        bizModule.setUpdateDate(new Date());
//        bizModule.setUpdateUserId(ShiroUtils.getUser().getUserId());
        bizModuleService.update(bizModule);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("a5:bizModule:remove")
    public R remove(Long id) {
        if (bizModuleService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("a5:bizModule:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        bizModuleService.batchRemove(ids);
        return R.ok();
    }


    @ResponseBody
    @GetMapping("/bizModule/{type}")
    public List<DictDO> bizModule(@PathVariable("type") String type) {
        // 查询列表数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("type", type);
        List<DictDO> dictList = dictService.list(map);
        return dictList;
    }

}
