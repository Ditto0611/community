package life.ditto.community.dto;

import life.ditto.community.model.User;
import lombok.Data;

/**
 * @Author Ditto
 * @Date 2021/7/22 10:37
 * @Version 1.0
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creatorId;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
