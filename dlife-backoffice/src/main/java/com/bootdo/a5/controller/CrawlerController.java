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

import com.bootdo.a5.domain.CrawlerDO;
import com.bootdo.a5.service.CrawlerService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 网页抓取器表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 18:39:33
 */
 
@Controller
@RequestMapping("/a5/crawler")
public class CrawlerController {
	@Autowired
	private CrawlerService crawlerService;
	
	@GetMapping()
	@RequiresPermissions("a5:crawler:crawler")
	String Crawler(){
	    return "a5/crawler/crawler";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("a5:crawler:crawler")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CrawlerDO> crawlerList = crawlerService.list(query);
		int total = crawlerService.count(query);
		PageUtils pageUtils = new PageUtils(crawlerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("a5:crawler:add")
	String add(){
	    return "a5/crawler/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("a5:crawler:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CrawlerDO crawler = crawlerService.get(id);
		model.addAttribute("crawler", crawler);
	    return "a5/crawler/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("a5:crawler:add")
	public R save( CrawlerDO crawler){
		if(crawlerService.save(crawler)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("a5:crawler:edit")
	public R update( CrawlerDO crawler){
		crawlerService.update(crawler);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("a5:crawler:remove")
	public R remove( Long id){
		if(crawlerService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("a5:crawler:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		crawlerService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * trigger crawling
	 */
	@PostMapping( "/crawling")
	@ResponseBody
	@RequiresPermissions("a5:articleReferral:add")
	public R crawling( Long id){
		if(crawlerService.crawling(id)>0){
			return R.ok();
		}
		return R.error();
	}

}
