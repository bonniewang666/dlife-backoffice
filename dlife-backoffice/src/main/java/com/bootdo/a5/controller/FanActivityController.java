package com.bootdo.a5.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
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

import com.bootdo.a5.domain.FanActivityDO;
import com.bootdo.a5.service.FanActivityService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 拼饭活动
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-27 20:23:32
 */
 
@Controller
@RequestMapping("/a5/fanActivity")
public class FanActivityController {
	@Autowired
	private FanActivityService fanActivityService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("a5:fanActivity:fanActivity")
	String FanActivity(Model model){
		List<DictDO> dictDOs = dictService.listByType("company");
		model.addAttribute("companies", dictDOs);
		return "a5/fanActivity/fanActivity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:fanActivity:fanActivity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FanActivityDO> fanActivityList = fanActivityService.list(query);
		int total = fanActivityService.count(query);
		PageUtils pageUtils = new PageUtils(fanActivityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:fanActivity:add")
	String add(){
	    return "a5/fanActivity/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:fanActivity:edit")
	String edit(@PathVariable("id") Long id,Model model){
		FanActivityDO fanActivity = fanActivityService.get(id);
		model.addAttribute("fanActivity", fanActivity);
	    return "a5/fanActivity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:fanActivity:add")
	public R save( FanActivityDO fanActivity){
		if(fanActivityService.save(fanActivity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:fanActivity:edit")
	public R update( FanActivityDO fanActivity){
		fanActivityService.update(fanActivity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:fanActivity:remove")
	public R remove( Long id){
		if(fanActivityService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:fanActivity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fanActivityService.batchRemove(ids);
		return R.ok();
	}


	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id,Model model) {
		FanActivityDO fanActivity = fanActivityService.get(id);
		model.addAttribute("fanActivity", fanActivity);
		return "a5/fanActivity/detail";
	}

	/**
	 * 批量移动
	 */
	@PostMapping("/batchMove")
	@ResponseBody
	@RequiresPermissions("a5:fanActivity:edit")
	public R batchMove(@RequestParam("targetCompany") String targetCompany, @RequestParam("targetBizCategory") String
			targetBizCategory, @RequestParam("ids[]") Long[] ids) {
		fanActivityService.batchMove(targetCompany, targetBizCategory, ids);
		return R.ok();
	}


}
