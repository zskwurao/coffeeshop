package cn.cs.mapper;

import cn.cs.pojo.Comment;
import cn.cs.utils.CSResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int addComment(@Param("comment") String comment, @Param("pId") Integer pId,@Param("uId")Integer id);

    List<Comment> getCommentList(@Param("pId") Integer pId, @Param("uId") Integer valueOf);
}
