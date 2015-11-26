package com.kelvin.product.web.service.impl;

import com.kelvin.product.core.generic.service.impl.GenericServiceImpl;
import com.kelvin.product.web.common.Constant;
import com.kelvin.product.web.dao.IUserDao;
import com.kelvin.product.web.model.system.BaseUser;
import com.kelvin.product.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl extends GenericServiceImpl implements UserService {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private IUserDao userDao;

    @Resource
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void login(BaseUser user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getTelephone(), user.getPassword());
//        token.setRememberMe(true);
        // 身份验证
        subject.login(token);
        // 验证成功在Session中保存用户信息
//        Map<String,Object> map = new HashMap<>();
//        map.put("userName", user.getUserName());
//        map.put("password", user.getPassword());
//        map.put("status", Constant.BASEUSER_STATUS_1);
//        final BaseUser authUserInfo = userDao.findUniqueByPropertys(BaseUser.class,map);
//        subject.getSession().setAttribute("user", authUserInfo);
    }

    public Boolean validLogin(BaseUser user){
        int count = userDao.countUserByTeleAndPasswor(user);
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }

    public void test(){
        BaseUser user = new BaseUser();
        user.setPassword("password");
        user.setUserName("username");
        sessionFactory.getCurrentSession().save(user);

        Transaction tx = userDao.getSession().getTransaction();

        String sql = "insert into User values ('111',:password,:username)";
        Map<String, Object> paramMap = new HashMap<String,Object>();
        paramMap.put("password","pass");
        paramMap.put("username", "username");
        namedParameterJdbcTemplate.update(sql, paramMap);
        sql = "insert into User values ('2222','ddddd','aaaaa')";
        jdbcTemplate.update(sql);

        int code = userDao.getSession().getTransaction().hashCode();
//        BaseUser user1 = null;
//        user1.getPassword();

        BaseUser user1 = new BaseUser();
        user1.setPassword("password");
            user1.setUserName("username");
        sessionFactory.getCurrentSession().save(user1);
//        sessionFactory.getCurrentSession().flush();
        //userDao.excute(sql,paramMap);
        code = userDao.getSession().getTransaction().hashCode();
        //tx.rollback();
        try {
            BaseUser user2 = null;
            user2.getPassword();
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}
