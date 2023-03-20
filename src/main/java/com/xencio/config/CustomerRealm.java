package com.xencio.config;

import com.xencio.config.shiro.JwtToken;
import com.xencio.entity.User;
import com.xencio.service.UserService;
import com.xencio.utils.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //shiro中Principal存储的是字符串
        //       String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        // User user = userService.getUserByPrincipal(primaryPrincipal);

        //也可以直接存储user对象，以便在程序中直接获取使用，但是AuthenticationInfo在存储的时候也需要做响应的处理
        String username = JwtUtil.getUsername(principalCollection.toString());
        User user = userService.getUserByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 根据
        // authorizationInfo.addStringPermission(String.valueOf(user.getType()));
        authorizationInfo.addRole(String.valueOf(user.getType()));
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        // 解密获得username，用于和数据库进行对比
        String username = null;
        try {
            //这里工具类没有处理空指针等异常这里处理一下(这里处理科学一些)
            username = JwtUtil.getUsername(token);
        } catch (Exception e) {
            throw new AuthenticationException("heard的token拼写错误或者值为空");
        }
        if (username == null) {
            System.out.println("token无效(空''或者null都不行!)");
            throw new AuthenticationException("token无效");
        }
        User user = userService.getUserByUsername(username);

        if (user == null) {
            System.out.println("用户不存在!)");
            throw new AuthenticationException("用户不存在!");
        }

        if (!JwtUtil.verify(token, username, user.getPassword())) {
            System.out.println("用户名或密码错误(token无效或者与登录者不匹配)!");
            throw new AuthenticationException("用户名或密码错误(token无效或者与登录者不匹配)!");
        }
        return new SimpleAuthenticationInfo(token,token,this.getName());
    }


}

