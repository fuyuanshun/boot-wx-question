package boot.wx.controller;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.entity.User;
import boot.wx.service.IQuestionAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
     *  退出登录
     */
    @PostMapping("/admin/logout")
    public CommentResult<String> logout(@RequestParam("username") String username, HttpSession session){
        return service.logout(username, session);
    }

    /**
     *  添加某个课程下的题目 测试用
     *
     */
    @PostMapping("/admin/question/add")
    public CommentResult<Integer> add(@RequestBody QuestionEntity questionEntity){
        return service.add(questionEntity);
    }

    /**
     *  获取所有的题目
     *  不分类型. 所有的题目
     */
    @GetMapping("/admin/question/findAllQuestions")
    public CommentResult<List<QuestionEntity>> findAllQuestions(){
        return service.findAllQuestions();
    }

    /**
     *  根据id删除某个题目
     *
     */
    @PostMapping("/admin/question/deleteById/{id}")
    public CommentResult<Integer> deleteById(@PathVariable("id") Integer id){
        return service.deleteById(id);
    }

    /**
     *  根据id更新某个题目
     *  id为必要参数， 其他参数需要又一个不为空
     */
    @PostMapping("/admin/question/updateById")
    public CommentResult<Integer> updateById(@RequestBody QuestionEntity entity){
        return service.updateById(entity);
    }

    /**
     * 查询所有的课程类型
     * @return
     */
    @GetMapping("/admin/question/findAllQuestionTypes")
    public CommentResult<List<QuestionEntity>> findAllQuestionTypes(){
        return null;
    }

    /**
     * 添加一个课程类型
     * @return
     */
    @PostMapping("/admin/question/addQuestionType")
    public CommentResult<QuestionEntity> addQuestionType(){
        return null;
    }

    /**
     * 根据id删除一个课程类型
     * @param id
     * @return
     */
    @PostMapping("/admin/question/deleteQuestionType/{id}")
    public CommentResult<QuestionEntity> deleteQuestionType(@PathVariable("id") Integer id){
        return null;
    }

    /**
     * 根据id删除一个课程类型
     * @return
     */
    @PostMapping("/admin/question/updateQuestionType")
    public CommentResult<QuestionEntity> updateQuestionType(@RequestParam("id") Integer id,
                                                            @RequestParam("name") String name){
        return null;
    }
}
