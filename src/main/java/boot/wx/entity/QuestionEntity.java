package boot.wx.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionEntity {
    private Integer id;
    private String questionType;
    private String questionContent;
    private String selects;
    private String correctSelect;
    private String selectType;
    private Integer sorted;
    private String createTime;
    private String questionComment;
    private Integer collectStatus;
}
