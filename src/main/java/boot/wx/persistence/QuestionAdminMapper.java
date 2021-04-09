package boot.wx.persistence;

import boot.wx.entity.QuestionEntity;
import boot.wx.entity.QuestionTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionAdminMapper {
    int add(@Param("entity") QuestionEntity entity);

    List<QuestionEntity> findAllQuestions();

    int deleteById(Integer id);

    int updateById(@Param("entity") QuestionEntity entity);

    List<QuestionTypeEntity> findAllQuestionTypes();

    int addQuestionType(String name);

    int deleteQuestionType(Integer id);

    int updateQuestionType(@Param("id") Integer id, @Param("name") String name);

    int updateQuestionFile(@Param("id") Integer id, @Param("name") String name);

    int addQuestionFile(@Param("name") String name, @Param("questionType") String questionType);

    int deleteQuestionFile(Integer id);
}
