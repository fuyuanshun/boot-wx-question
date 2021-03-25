package boot.wx.controller;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class QuestionController {

    @Autowired
    private IQuestionService service;

    /**
     *  获取某个课程下的所有的题目
     * {questionType}表示课程的类型
     *
     */
    @GetMapping("/question/findQuestionByType/{questionType}/{user_id}")
    public CommentResult<List<QuestionEntity>> findQuestionByType(@PathVariable("questionType") String questionType,
                                                                  @PathVariable(value = "user_id") String userId){
        return service.findQuestionByType(questionType, userId);
    }

    /**
     *  获取某个课程下所有收藏的题目
     */
    @GetMapping("/question/findByTypeAndCollect/{questionType}/{user_id}")
    public CommentResult<List<QuestionEntity>> findByTypeAndCollect(@PathVariable("questionType") String questionType,
                                                       @PathVariable("user_id") String userId){
        return service.findByTypeAndCollect(questionType, userId);
    }

    /**
     *  收藏某个题目
     *
     * @param userId 用户id
     * @param questionId 题目id
     */
    @GetMapping("/question/collect/{question_id}/{user_id}")
    public CommentResult<Integer> collect(@PathVariable("question_id") Integer questionId,
                                          @PathVariable("user_id") String userId){
        return service.collect(questionId, userId);
    }
}
