package boot.wx.service.impl;

import boot.wx.constants.QuestionConstants;
import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.entity.User;
import boot.wx.persistence.QuestionAdminMapper;
import boot.wx.service.IQuestionAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class QuestionAdminService implements IQuestionAdminService {

    @Autowired
    private QuestionAdminMapper mapper;

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "chushimei";

    @Override
    public CommentResult<String> login(String username, String password, HttpSession session) {
        if(ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)){
            session.setAttribute("userName", ADMIN_USERNAME);
            return new CommentResult<>(QuestionConstants.SUCCESS_CODE, QuestionConstants.LOGIN_SUCCESS_MESSAGE, null);
        }
        return new CommentResult<>(1000, QuestionConstants.LOGIN_ERROR_MESSAGE, null);
    }

    @Override
    public CommentResult<Integer> add(QuestionEntity entity) {
        int i = 0;
        try{
            i = mapper.add(entity);
        } catch (Exception e){
            e.printStackTrace();
            return new CommentResult<>(QuestionConstants.ERROR_CODE, QuestionConstants.ERROR_MESSAGE, 0);
        }
        return new CommentResult<>(QuestionConstants.SUCCESS_CODE, QuestionConstants.SUCCESS_MESSAGE, i);
    }
}
