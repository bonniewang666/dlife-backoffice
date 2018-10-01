package com.bootdo.a5.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.a5.domain.ClockInDO;
import com.bootdo.a5.service.ClockInService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 打卡信息
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 10:31:17
 */
 
@Controller
@RequestMapping("/a5/clockIn")
public class ClockInController {
	@Autowired
	private ClockInService clockInService;
	
	@GetMapping()
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	String ClockIn(){
	    return "a5/clockIn/clockIn";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ClockInDO> clockInList = clockInService.list(query);
		int total = clockInService.count(query);
		PageUtils pageUtils = new PageUtils(clockInList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	String add(){
	    return "a5/clockIn/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	String edit(@PathVariable("id") Long id,Model model){
		ClockInDO clockIn = clockInService.get(id);
		model.addAttribute("clockIn", clockIn);
	    return "a5/clockIn/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivityadd")
	public R save( ClockInDO clockIn){
		if(clockInService.save(clockIn)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	public R update( ClockInDO clockIn){
		clockInService.update(clockIn);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	public R remove( Long id){
		if(clockInService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	public R remove(@RequestParam("ids[]") Long[] ids){
		clockInService.batchRemove(ids);
		return R.ok();
	}
	
}
