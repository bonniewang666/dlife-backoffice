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

import com.bootdo.a5.domain.QuestionDO;
import com.bootdo.a5.service.QuestionService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 01:58:34
 */
 
@Controller
@RequestMapping("/a5/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping()
	@RequiresPermissions("a5:question:question")
	String Question(){
	    return "a5/question/question";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:question:question")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<QuestionDO> questionList = questionService.list(query);
		int total = questionService.count(query);
		PageUtils pageUtils = new PageUtils(questionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:question:add")
	String add(){
	    return "a5/question/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:question:edit")
	String edit(@PathVariable("id") Long id,Model model){
		QuestionDO question = questionService.get(id);
		model.addAttribute("question", question);
	    return "a5/question/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:question:add")
	public R save( QuestionDO question){
		if(questionService.save(question)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:question:edit")
	public R update( QuestionDO question){
		questionService.update(question);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:question:remove")
	public R remove( Long id){
		if(questionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:question:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		questionService.batchRemove(ids);
		return R.ok();
	}


	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id,Model model) {
		QuestionDO question = questionService.get(id);
		model.addAttribute("question", question);
		return "a5/question/detail";
	}
	
}
