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

import com.bootdo.a5.domain.AttendeeDO;
import com.bootdo.a5.service.AttendeeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-09-29 12:36:56
 */
 
@Controller
@RequestMapping("/a5/attendee")
public class AttendeeController {
	@Autowired
	private AttendeeService attendeeService;
	
	@GetMapping()
	@RequiresPermissions("a5:fanActivity:fanActivity")
	String Attendee(){
	    return "a5/attendee/attendee";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:fanActivity:fanActivity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AttendeeDO> attendeeList = attendeeService.list(query);
		int total = attendeeService.count(query);
		PageUtils pageUtils = new PageUtils(attendeeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:fanActivity:edit")
	String add(){
	    return "a5:fanActivity:edit";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:fanActivity:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AttendeeDO attendee = attendeeService.get(id);
		model.addAttribute("attendee", attendee);
	    return "a5/attendee/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:fanActivity:edit")
	public R save( AttendeeDO attendee){
		if(attendeeService.save(attendee)>0){
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
	public R update( AttendeeDO attendee){
		attendeeService.update(attendee);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:fanActivity:edit")
	public R remove( Long id){
		if(attendeeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:fanActivity:edit")
	public R remove(@RequestParam("ids[]") Long[] ids){
		attendeeService.batchRemove(ids);
		return R.ok();
	}
	
}
