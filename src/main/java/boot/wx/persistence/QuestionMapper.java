package boot.wx.persistence;

import boot.wx.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuestionMapper {
    List<QuestionEntity> findQuestionByType(@Param("questionType") String questionType, @Param("userId") String userId);

    List<QuestionEntity> findByTypeAndCollect(@Param("questionType") String questionType, @Param("userId") String userId);

    void collect(@Param("userId") String userId, @Param("questionId") Integer questionId, @Param("option") String option);

    int findCollectStatus(@Param("userId") String userId, @Param("questionId") Integer questionId);

}
