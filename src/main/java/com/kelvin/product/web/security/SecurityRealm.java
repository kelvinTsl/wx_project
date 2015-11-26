package com.kelvin.product.web.security;

import com.kelvin.product.web.model.system.BaseUser;
import com.kelvin.product.web.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户身份验证,授权 Realm 组件
 *
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //        String username = String.valueOf(principals.getPrimaryPrincipal());

        //        final BaseUser user = userService.selectByUsername(username);
        //        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        //        for (Role role : roleInfos) {
        //            // 添加角色
        //            System.err.println(role);
        //            authorizationInfo.addRole(role.getRoleSign());
        //
        //            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
        //            for (Permission permission : permissions) {
        //                // 添加权限
        //                System.err.println(permission);
        //                authorizationInfo.addStringPermission(permission.getPermissionSign());
        //            }
        //        }
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        BaseUser user = new BaseUser();
        user.setTelephone(username);
        user.setPassword(password);

        final Boolean authentication =userService.validLogin(user);
        if (!authentication) {
            throw new AuthenticationException("用户名或密码错误.");
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }

}
