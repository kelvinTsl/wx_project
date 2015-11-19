package com.kelvin.product.web.service.impl;

import com.kelvin.product.core.generic.service.impl.GenericServiceImpl;
import com.kelvin.product.web.dao.IUserDao;
import com.kelvin.product.web.service.UserService;
import com.kelvin.product.web.system.model.User;
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

    public void test(){
        User user = new User();
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
//        User user1 = null;
//        user1.getPassword();

        User user1 = new User();
        user1.setPassword("password");
            user1.setUserName("username");
        sessionFactory.getCurrentSession().save(user1);
//        sessionFactory.getCurrentSession().flush();
        //userDao.excute(sql,paramMap);
        code = userDao.getSession().getTransaction().hashCode();
        //tx.rollback();
        try {
            User user2 = null;
            user2.getPassword();
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}
