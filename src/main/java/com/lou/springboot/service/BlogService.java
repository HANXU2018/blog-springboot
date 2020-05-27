package com.lou.springboot.service;

import com.lou.springboot.controller.vo.SimpleBlogListVO;
import com.lou.springboot.entity.Blog;
import com.lou.springboot.utils.PageQueryUtil;
import com.lou.springboot.utils.PageResult;

import java.util.List;

public interface BlogService {
    String saveBlog(Blog blog);
    /**
     * 根据id获取详情
     *
     * @param blogId
     * @return
     */
    Blog getBlogById(Long blogId);

    /**
     * 后台修改
     *
     * @param blog
     * @return
     */
    String updateBlog(Blog blog);

    PageResult getBlogsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);

    public List<SimpleBlogListVO> getBlogListForIndexPage(int type);
}
