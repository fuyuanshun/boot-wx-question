package boot.wx.persistence;

import boot.wx.entity.QuestionEntity;
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
}
