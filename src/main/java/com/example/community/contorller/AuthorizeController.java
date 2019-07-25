package com.example.community.contorller;

import com.example.community.dto.AccessDTO;
import com.example.community.dto.GitHubUserInfo;
import com.example.community.service.UserService;
import com.example.community.util.GitHubUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author ChenSK
 * @date 2019-07-23 - 16:08
 */
@Controller
public class AuthorizeController {

    @Autowired
    UserService userService;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.client.uri}")
    private String clientUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam String code, @RequestParam String state, HttpSession session){
        AccessDTO accessDTO = new AccessDTO(clientId,clientSecret,code,clientUri,state);
        String accessToken = GitHubUtil.getAccessToken(accessDTO);
        String token = accessToken.split("=")[1].split("&")[0];
        GitHubUserInfo userInfo = GitHubUtil.getUserInfo(token);
        session.setAttribute("user",userInfo);
        userService.addUserInfo(token);
        return "redirect:/";
    }
}
