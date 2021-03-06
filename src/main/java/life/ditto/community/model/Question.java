package life.ditto.community.model;

import lombok.Data;

/**
 * @Author Ditto
 * @Date 2021/7/20 14:43
 * @Version 1.0
 */
@Data
public class Question {
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


}
