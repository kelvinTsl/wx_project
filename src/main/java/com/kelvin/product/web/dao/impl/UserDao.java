package com.kelvin.product.web.dao.impl;

import com.kelvin.product.core.generic.dao.impl.GenericDao;
import com.kelvin.product.web.common.Constant;
import com.kelvin.product.web.dao.IUserDao;
import com.kelvin.product.web.model.system.BaseUser;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangshulei on 2015/11/3.
 */
@Repository
public class UserDao extends GenericDao implements IUserDao  {

    public int countUserByTeleAndPasswor(BaseUser user){
        String hql = "select count(a) from BaseUser as a where telephone = ? and password = ? and status = ?";
        Query queryObject = getSession().createQuery(hql);
        Long count = (Long)queryObject.setParameter(0,user.getTelephone()).setParameter(1,user.getPassword()).setParameter(2, Constant.BASEUSER_STATUS_1).uniqueResult();
        return count.intValue();

//        Criteria criteria = createCriteria(BaseUser.class);
//        criteria.add(Restrictions.eq("userName",user.getUserName()));
//        criteria.add(Restrictions.eq("password",user.getPassword()));
//        List<BaseUser> list = criteria.list();
//        if(list != null){
//            return list.size();
//        }
//        return 0;
    }
}
