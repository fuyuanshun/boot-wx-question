package boot.wx.service;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IQuestionAdminService {
    CommentResult<Integer> add(QuestionEntity entity);

    CommentResult<String> login(String username, String password, HttpSession session);

    CommentResult<String> logout(String username, HttpSession session);

    CommentResult<List<QuestionEntity>> findAllQuestions();

    CommentResult<Integer> deleteById(Integer id);

    CommentResult<Integer> updateById(QuestionEntity entity);
}
