package boot.wx.controller;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.entity.User;
import boot.wx.service.IQuestionAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class QuestionAdminController {

    @Autowired
    private IQuestionAdminService service;

    /**
     *  管理员登陆
     */
    @PostMapping("/admin/login")
    public CommentResult<String> login(@RequestParam("username") String username, @RequestParam("password") String password,
                                       HttpSession session){
        return service.login(username, password, session);
    }

    /**
     *  添加某个课程下的题目 测试用
     *
     */
    @PostMapping("/admin/question/add")
    public CommentResult<Integer> add(@RequestBody QuestionEntity questionEntity){
        return service.add(questionEntity);
    }
}
