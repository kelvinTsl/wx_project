package com.kelvin.product.web.dao;

import com.kelvin.product.core.generic.dao.IGenericDao;
import com.kelvin.product.web.model.system.BaseUser;
import org.hibernate.Session;

/**
 * Created by tangshulei on 2015/11/3.
 */
public interface IUserDao extends IGenericDao {

    int countUserByTeleAndPasswor(BaseUser user);
}
