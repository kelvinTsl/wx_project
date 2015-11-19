package com.kelvin.product.web.dao.impl;

import com.kelvin.product.core.generic.dao.impl.GenericDao;
import com.kelvin.product.web.dao.IUserDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangshulei on 2015/11/3.
 */
@Repository
public class UserDao extends GenericDao implements IUserDao  {

}
