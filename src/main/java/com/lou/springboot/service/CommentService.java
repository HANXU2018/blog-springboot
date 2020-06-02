package com.lou.springboot.service;

import com.lou.springboot.entity.BlogComment;
import com.lou.springboot.utils.PageQueryUtil;
import com.lou.springboot.utils.PageResult;

public interface CommentService {
    /**
     * 后台管理系统中评论分页功能
     *
     * @param pageUtil
     * @return
     */
    PageResult getCommentsPage(PageQueryUtil pageUtil);

    /**
     * 批量审核
     *
     * @param ids
     * @return
     */
    Boolean checkDone(Integer[] ids);

    /**
     * 添加回复
     *
     * @param commentId
     * @param replyBody
     * @return
     */
    Boolean reply(Long commentId, String replyBody);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 添加评论
     *
     * @param blogComment
     * @return
     */
    Boolean addComment(BlogComment blogComment);

    public PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page);
}
