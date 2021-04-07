package boot.wx.persistence;

import boot.wx.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface QuestionAdminMapper {
    int add(@Param("entity") QuestionEntity entity);
}
