package life.ditto.community.controller;

import life.ditto.community.GithubProvider.GithubPorvider;
import life.ditto.community.dto.AccessTokenDTO;
import life.ditto.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("2b3d20b60352de04f79a");
        accessTokenDTO.setClient_secret("b099f73c6bd92d6290dd0fdf29b0e3d7cc1e6110");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8081/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubPorvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubPorvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
