package life.ditto.community.dto;

import lombok.Data;

/**
 * @Author Ditto
 * @Date 2021/7/16 16:22
 * @Version 1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarurl;
}
