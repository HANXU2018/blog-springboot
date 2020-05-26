package com.lou.springboot.service;

import com.lou.springboot.utils.PageQueryUtil;
import com.lou.springboot.utils.PageResult;

public interface TagService {
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);
}
