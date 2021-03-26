package boot.wx.controller;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.service.IQuestionService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class QuestionController {

    @Autowired
    private IQuestionService service;


    /**
     *  添加某个课程下的题目 测试用
     *
     */
    @PostMapping("/question/add")
    public CommentResult<Integer> add(@RequestBody QuestionEntity questionEntity){
        return service.add(questionEntity);
    }

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
     *  获取某个题目的正确答案和解析
     *
     */
    @GetMapping("/question/findAnswerById/{question_id}")
    public CommentResult<QuestionEntity> findAnswerById(@PathVariable("question_id") Integer questionId){
        return service.findAnswerById(questionId);
    }

    /**
     *  收藏某个题目
     *
     * @param userId 用户id
     * @param questionId 题目id
     */
    @PostMapping("/question/collect/{question_id}/{user_id}")
    public CommentResult<Integer> collect(@PathVariable("question_id") Integer questionId,
                                          @PathVariable("user_id") String userId){
        return service.collect(questionId, userId);
    }

    /**
     * 提交答题卡
     *
     * @return
     */
    @PostMapping("/question/commit/{user_id}")
    public CommentResult<JSONObject> commitQuestionCard(@PathVariable("user_id") String userId,
                                                        @RequestBody List<QuestionEntity> list){
        return service.commitQuestionCard(userId, list);
    }

    /**
     * 查询错题记录
     *
     * @return
     */
    @GetMapping("/question/wrong/{user_id}")
    public CommentResult<List<QuestionEntity>> wrongList(@PathVariable("user_id") String userId){
        return service.wrongList(userId);
    }

    /**
     * 删除某个错题记录, 支持删除多个，多个id之间使用半角','分割
     *
     * @return
     */
    @PostMapping("/question/removeWrong/{question_ids}/{user_id}")
    public CommentResult<Integer> removeWrongQuestion(@PathVariable("question_ids") String questionIds,
                                                      @PathVariable("user_id") String userId){
        return service.removeWrongQuestion(questionIds, userId);
    }
}
