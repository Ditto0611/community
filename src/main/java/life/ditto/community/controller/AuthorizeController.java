package life.ditto.community.controller;

import life.ditto.community.GithubProvider.GithubPorvider;
import life.ditto.community.Mapper.UserMapper;
import life.ditto.community.dto.AccessTokenDTO;
import life.ditto.community.dto.GithubUser;
import life.ditto.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;


    @Autowired(required = false)
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubPorvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubPorvider.getUser(accessToken);
        if(githubUser != null && githubUser.getId() != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarurl(githubUser.getAvatarurl());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            //登录成功，写cookie和session


            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";


        }else{
            //登录失败重新登录
            return "redirect:/";
        }
    }
}
