package boot.wx.service;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface IQuestionService {
    CommentResult<List<QuestionEntity>> findQuestionByType(String questionType, String userId);

    CommentResult<List<QuestionEntity>> findByTypeAndCollect(String questionType, String userId);

    CommentResult<QuestionEntity> findAnswerById(Integer questionId);

    CommentResult<Integer> collect(Integer questionId, String userId);

    CommentResult<Integer> add(QuestionEntity entity);

    CommentResult<JSONObject> commitQuestionCard(String userId, List<QuestionEntity> list);

    CommentResult<List<QuestionEntity>> wrongList(String userId);

    CommentResult<Integer> removeWrongQuestion(String questionIds, String userId);
}
