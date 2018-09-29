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

import com.bootdo.a5.domain.ActivityParticipationDO;
import com.bootdo.a5.service.ActivityParticipationService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 小目标参与者
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-09-29 10:52:37
 */
 
@Controller
@RequestMapping("/a5/activityParticipation")
public class ActivityParticipationController {
	@Autowired
	private ActivityParticipationService activityParticipationService;
	
	@GetMapping()
//	@RequiresPermissions("a5:activityParticipation:activityParticipation")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity") //和小目标一样的权限
	String ActivityParticipation(){
	    return "a5/activityParticipation/activityParticipation";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:fitnessActivity:fitnessActivity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ActivityParticipationDO> activityParticipationList = activityParticipationService.list(query);
		int total = activityParticipationService.count(query);
		PageUtils pageUtils = new PageUtils(activityParticipationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:fitnessActivity:add")
	String add(){
	    return "a5/activityParticipation/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:activityParticipation:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ActivityParticipationDO activityParticipation = activityParticipationService.get(id);
		model.addAttribute("activityParticipation", activityParticipation);
	    return "a5/activityParticipation/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:fitnessActivity:add")
	public R save( ActivityParticipationDO activityParticipation){
		if(activityParticipationService.save(activityParticipation)>0){
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
	public R update( ActivityParticipationDO activityParticipation){
		activityParticipationService.update(activityParticipation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:fitnessActivity:remove")
	public R remove( Long id){
		if(activityParticipationService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:fitnessActivity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		activityParticipationService.batchRemove(ids);
		return R.ok();
	}
	
}
