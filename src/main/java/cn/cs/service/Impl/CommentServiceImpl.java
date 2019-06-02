package cn.cs.service.Impl;

import cn.cs.mapper.CommentMapper;
import cn.cs.pojo.Comment;
import cn.cs.service.CommentService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public CSResult addComment(String comment, Integer pId, Integer id) {

        int count = commentMapper.addComment(comment,pId,id);
        if(count==1){
            return CSResult.ok();
        }else {
            return CSResult.build(0,"添加失败");
        }
    }

    @Override
    public CSResult getCommentList(Integer pId, Integer valueOf) {
        System.out.println(pId +"  "+valueOf);
        List<Comment> list = commentMapper.getCommentList(pId,valueOf);
        return CSResult.ok(list);
    }
}
