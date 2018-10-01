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

import com.bootdo.a5.domain.TagsDO;
import com.bootdo.a5.service.TagsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 标签表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 10:22:45
 */
 
@Controller
@RequestMapping("/a5/tags")
public class TagsController {
	@Autowired
	private TagsService tagsService;
	
	@GetMapping()
	@RequiresPermissions("a5:tags:tags")
	String Tags(){
	    return "a5/tags/tags";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:tags:tags")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TagsDO> tagsList = tagsService.list(query);
		int total = tagsService.count(query);
		PageUtils pageUtils = new PageUtils(tagsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:tags:add")
	String add(){
	    return "a5/tags/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:tags:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TagsDO tags = tagsService.get(id);
		model.addAttribute("tags", tags);
	    return "a5/tags/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:tags:add")
	public R save( TagsDO tags){
		if(tagsService.save(tags)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:tags:edit")
	public R update( TagsDO tags){
		tagsService.update(tags);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:tags:remove")
	public R remove( Long id){
		if(tagsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:tags:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tagsService.batchRemove(ids);
		return R.ok();
	}
	
}
