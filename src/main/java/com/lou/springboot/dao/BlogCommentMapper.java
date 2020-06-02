package com.lou.springboot.dao;

import com.lou.springboot.entity.BlogComment;
import com.lou.springboot.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BlogCommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    BlogComment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);

    List<BlogComment> findBlogCommentList(PageQueryUtil pageUtil);

    int getTotalBlogComments(PageQueryUtil pageUtil);

    int checkDone(Integer[] ids);

    int deleteBatch(Integer[] ids);
}
