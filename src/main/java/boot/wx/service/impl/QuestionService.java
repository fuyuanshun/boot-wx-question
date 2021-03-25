package boot.wx.service.impl;

import boot.wx.constants.QuestionConstants;
import boot.wx.entity.CommentResult;
import boot.wx.entity.QuestionEntity;
import boot.wx.persistence.QuestionMapper;
import boot.wx.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionMapper mapper;

    @Override
    public CommentResult<List<QuestionEntity>> findQuestionByType(String questionType, String userId) {
        log.info("查询接口：  /question/findQuestionByType/{questionType} 被 " + userId + "调用");
        List<QuestionEntity> result = null;
        try{
            result =  mapper.findQuestionByType(questionType, userId);
        } catch (Exception e){
            e.printStackTrace();
            return new CommentResult<>(QuestionConstants.ERROR_CODE, QuestionConstants.ERROR_MESSAGE, null);
        }
        return new CommentResult<>(QuestionConstants.SUCCESS_CODE, QuestionConstants.SUCCESS_MESSAGE, result);
    }

    @Override
    public CommentResult<List<QuestionEntity>> findByTypeAndCollect(String questionType, String userId) {
        log.info("查询收藏接口：  /question/collect/{questionType}/{user_id} 被 " + userId + "调用");
        List<QuestionEntity> result = null;
        try{
            result =  mapper.findByTypeAndCollect(questionType, userId);
        } catch (Exception e){
            e.printStackTrace();
            return new CommentResult<>(QuestionConstants.ERROR_CODE, QuestionConstants.ERROR_MESSAGE, null);
        }
        return new CommentResult<>(QuestionConstants.SUCCESS_CODE, QuestionConstants.SUCCESS_MESSAGE, result);
    }

    @Override
    public CommentResult<Integer> collect(Integer questionId, String userId) {
        log.info("收藏接口：  /question/collect/{user_id}/{question_id} 被 " + userId + "调用");
        try{
            int count = mapper.findCollectStatus(userId, questionId); //查询是否已经收藏过了
            if(count > 0){ //有数据了，删除收藏
                mapper.collect(userId, questionId, "delete");
            } else { //没有数据，添加收藏
                mapper.collect(userId, questionId, "collect");
            }
        } catch (Exception e){
            e.printStackTrace();
            return new CommentResult<>(QuestionConstants.ERROR_CODE, QuestionConstants.ERROR_MESSAGE, null);
        }
        return new CommentResult<>(QuestionConstants.SUCCESS_CODE, QuestionConstants.SUCCESS_MESSAGE, 1);
    }
}
