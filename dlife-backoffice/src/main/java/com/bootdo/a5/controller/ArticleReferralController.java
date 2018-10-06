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

import com.bootdo.a5.domain.ArticleReferralDO;
import com.bootdo.a5.service.ArticleReferralService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 抓取的文章表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 18:38:44
 */
 
@Controller
@RequestMapping("/a5/articleReferral")
public class ArticleReferralController {
	@Autowired
	private ArticleReferralService articleReferralService;
	
	@GetMapping()
	@RequiresPermissions("a5:articleReferral:articleReferral")
	String ArticleReferral(){
	    return "a5/articleReferral/articleReferral";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:articleReferral:articleReferral")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ArticleReferralDO> articleReferralList = articleReferralService.list(query);
		int total = articleReferralService.count(query);
		PageUtils pageUtils = new PageUtils(articleReferralList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:articleReferral:add")
	String add(){
	    return "a5/articleReferral/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:articleReferral:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ArticleReferralDO articleReferral = articleReferralService.get(id);
		model.addAttribute("articleReferral", articleReferral);
	    return "a5/articleReferral/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:articleReferral:add")
	public R save( ArticleReferralDO articleReferral){
		if(articleReferralService.save(articleReferral)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:articleReferral:edit")
	public R update( ArticleReferralDO articleReferral){
		articleReferralService.update(articleReferral);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:articleReferral:remove")
	public R remove( Long id){
		if(articleReferralService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:articleReferral:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		articleReferralService.batchRemove(ids);
		return R.ok();
	}


	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id,Model model) {
		ArticleReferralDO articleReferralDO = articleReferralService.get(id);
		model.addAttribute("articleReferral", articleReferralDO);
		return "a5/articleReferral/detail";
	}
	
}
