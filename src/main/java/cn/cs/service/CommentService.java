package cn.cs.service;

import cn.cs.utils.CSResult;

public interface CommentService {
    CSResult addComment(String comment, Integer pId, Integer id);

    CSResult getCommentList(Integer pId, Integer valueOf);
}
