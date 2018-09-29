package com.bootdo.a5.controller;

import java.util.HashMap;
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

import com.bootdo.a5.domain.CommentDO;
import com.bootdo.a5.service.CommentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 02:25:07
 */

@Controller
@RequestMapping("/a5/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping()
    @RequiresPermissions("a5:comment:comment")
    String Comment() {
        return "a5/comment/comment";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("a5:comment:comment")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<CommentDO> commentList = commentService.list(query);
        int total = commentService.count(query);
        PageUtils pageUtils = new PageUtils(commentList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("a5:comment:add")
    String add() {
        return "a5/comment/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("a5:comment:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        CommentDO comment = commentService.get(id);
        model.addAttribute("comment", comment);
        return "a5/comment/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("a5:comment:add")
    public R save(CommentDO comment) {
        if (commentService.save(comment) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("a5:comment:edit")
    public R update(CommentDO comment) {
        commentService.update(comment);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("a5:comment:remove")
    public R remove(Long id) {
        if (commentService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("a5:comment:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        commentService.batchRemove(ids);
        return R.ok();
    }

    /**
     * Retrieve all sub comments of particular comment given by parent id.
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("a5:comment:comment")
    public String detail( @PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "a5/comment/detail";
    }


    /**
     * Retrieve all sub comments of particular comment given by parent id.
     */
    @GetMapping("/parent/{pid}")
    @RequiresPermissions("a5:comment:comment")
    public String parent( @PathVariable("pid") Long pid, Model model) {
        CommentDO commentDO = commentService.get( pid );
        model.addAttribute("parentId", pid);
        model.addAttribute("comment", commentDO);
        return "a5/comment/detail";
    }

    /**
     * Retrieve all sub comments of particular comment given by parent id.
     */
    @GetMapping("/createdBy/{uid}")
    @RequiresPermissions("a5:comment:comment")
    public String createdBy( @PathVariable("uid") Long uid, Model model) {
        model.addAttribute("userId", uid);
        return "a5/comment/detail";
    }

}
