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

import com.bootdo.a5.domain.WechatUserDO;
import com.bootdo.a5.service.WechatUserService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 00:44:28
 */
 
@Controller
@RequestMapping("/a5/wechatUser")
public class WechatUserController {
	@Autowired
	private WechatUserService wechatUserService;
	
	@GetMapping()
	@RequiresPermissions("a5:wechatUser:wechatUser")
	String WechatUser(){
	    return "a5/wechatUser/wechatUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:wechatUser:wechatUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WechatUserDO> wechatUserList = wechatUserService.list(query);
		int total = wechatUserService.count(query);
		PageUtils pageUtils = new PageUtils(wechatUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:wechatUser:add")
	String add(){
	    return "a5/wechatUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:wechatUser:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WechatUserDO wechatUser = wechatUserService.get(id);
		model.addAttribute("wechatUser", wechatUser);
	    return "a5/wechatUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:wechatUser:add")
	public R save( WechatUserDO wechatUser){
		if(wechatUserService.save(wechatUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:wechatUser:edit")
	public R update( WechatUserDO wechatUser){
		wechatUserService.update(wechatUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:wechatUser:remove")
	public R remove( Long id){
		if(wechatUserService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:wechatUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		wechatUserService.batchRemove(ids);
		return R.ok();
	}


	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id,Model model) {
		WechatUserDO wechatUser = wechatUserService.get(id);
		model.addAttribute("wechatUser", wechatUser);
		return "a5/wechatUser/wechatUserDetail";
	}
	
}
