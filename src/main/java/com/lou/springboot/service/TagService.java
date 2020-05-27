package com.lou.springboot.service;

import com.lou.springboot.entity.BlogTagCount;
import com.lou.springboot.utils.PageQueryUtil;
import com.lou.springboot.utils.PageResult;

import java.util.List;

public interface TagService {
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    public List<BlogTagCount> getBlogTagCountForIndex();
}
