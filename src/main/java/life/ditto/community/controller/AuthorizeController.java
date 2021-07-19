package life.ditto.community.controller;

import life.ditto.community.GithubProvider.GithubPorvider;
import life.ditto.community.dto.AccessTokenDTO;
import life.ditto.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Ditto
 * @Date 2021/7/16 15:22
 * @Version 1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubPorvider githubPorvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("{github.client.secret}")
    private String clientSecret;
    @Value("{github.redirect.uri}")
    private String redirectUri;



    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubPorvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubPorvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
