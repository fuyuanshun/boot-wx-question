package boot.wx.service;

import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;

import java.util.List;

public interface IQuestionService {
    CommentResult<List<QuestionEntity>> findQuestionByType(String questionType, String userId);

    CommentResult<List<QuestionEntity>> findByTypeAndCollect(String questionType, String userId);

    CommentResult<Integer> collect(Integer questionId, String userId);
}