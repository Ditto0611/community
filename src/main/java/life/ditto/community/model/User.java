package life.ditto.community.model;

import lombok.Data;

/**
 * @Author Ditto
 * @Date 2021/7/19 10:18
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarurl;


}
