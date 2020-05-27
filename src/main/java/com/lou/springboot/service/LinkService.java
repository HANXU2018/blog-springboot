package com.lou.springboot.service;

import com.lou.springboot.entity.BlogLink;
import com.lou.springboot.utils.PageQueryUtil;
import com.lou.springboot.utils.PageResult;

public interface LinkService {
    /**
     * 查询友链的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogLinkPage(PageQueryUtil pageUtil);

    Boolean saveLink(BlogLink link);

    BlogLink selectById(Integer id);

    Boolean updateLink(BlogLink tempLink);

    Boolean deleteBatch(Integer[] ids);
}
