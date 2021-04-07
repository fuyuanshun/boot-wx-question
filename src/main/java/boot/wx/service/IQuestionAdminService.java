package boot.wx.service;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.entity.User;

import javax.servlet.http.HttpSession;

public interface IQuestionAdminService {
    CommentResult<Integer> add(QuestionEntity entity);

    CommentResult<String> login(String username, String password, HttpSession session);
}
