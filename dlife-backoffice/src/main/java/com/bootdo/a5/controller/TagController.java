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

import com.bootdo.a5.domain.TagDO;
import com.bootdo.a5.service.TagService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 标签表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 14:39:28
 */
 
@Controller
@RequestMapping("/a5/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	
	@GetMapping()
	@RequiresPermissions("a5:tag:tag")
	String Tag(){
	    return "a5/tag/tag";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:tag:tag")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TagDO> tagList = tagService.list(query);
		int total = tagService.count(query);
		PageUtils pageUtils = new PageUtils(tagList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:tag:add")
	String add(){
	    return "a5/tag/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:tag:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TagDO tag = tagService.get(id);
		model.addAttribute("tag", tag);
	    return "a5/tag/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:tag:add")
	public R save( TagDO tag){
		if(tagService.save(tag)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:tag:edit")
	public R update( TagDO tag){
		tagService.update(tag);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:tag:remove")
	public R remove( Long id){
		if(tagService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:tag:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tagService.batchRemove(ids);
		return R.ok();
	}
	
}
