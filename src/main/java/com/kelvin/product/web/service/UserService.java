package com.kelvin.product.web.service;

import com.kelvin.product.core.generic.service.GenericService;
import com.kelvin.product.web.model.system.BaseUser;

public interface UserService extends GenericService{

    void test() throws Exception;

    void login(BaseUser user);

    Boolean validLogin(BaseUser user);
}
