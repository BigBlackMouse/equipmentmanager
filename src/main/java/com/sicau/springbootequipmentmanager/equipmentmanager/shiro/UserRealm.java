package com.sicau.springbootequipmentmanager.equipmentmanager.shiro;

import com.sicau.springbootequipmentmanager.equipmentmanager.common.component.JwtComponent;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserPerms;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;


public class UserRealm extends AuthorizingRealm {
    @Autowired
    private JwtComponent jwtComponent;
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.getPrimaryPrincipal();
        if (Objects.isNull(user)) {
            throw new AuthorizationException();
        }
        Integer userId = user.getUserId();

        if (Objects.isNull(userId)) {
            throw new AuthorizationException();
        }
        List<UserPerms> permsList = userService.getUserPerms(userId);
        if (CollectionUtils.isEmpty(permsList)){
            throw new AuthorizationException();
        }

        HashSet<String > perms = new HashSet<>();
        HashSet<String > roles = new HashSet<>();

        for(UserPerms userPerms:permsList){
            roles.add(userPerms.getRoleCode());
            perms.add(userPerms.getRoleCode());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(perms);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getPrincipal().toString();
        String userName = jwtComponent.getUserName(token);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        User user = userService.getUserInfo(userInfo);

        if (Objects.isNull(user)) {
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token, this.getName());

        return info;


    }

    /**
     * 支持Token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
}
