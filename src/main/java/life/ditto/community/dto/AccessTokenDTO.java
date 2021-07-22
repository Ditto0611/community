package life.ditto.community.dto;

import lombok.Data;

/**
 * @Author Ditto
 * @Date 2021/7/16 15:38
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
