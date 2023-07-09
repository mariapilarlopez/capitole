package com.capitole.tecnicalTest.usermanagment.logic.impl;

import com.capitole.tecnicalTest.ordermanagment.dataaccess.dao.OrderDao;
import com.capitole.tecnicalTest.usermanagment.dataaccess.dao.UserDao;
import com.capitole.tecnicalTest.usermanagment.logic.api.Usermanagment;
import com.capitole.tecnicalTest.usermanagment.logic.api.to.UserTo;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named("UserManagment")
@Transactional
public class UsermanagmentImpl implements Usermanagment {
    private UserDao userDao;

    /**
     * The constructor.
     *
     * @param userDao
     */
    @Inject
    public UsermanagmentImpl(UserDao userDao) {

        this.userDao = userDao;
    }


    @Override
    public UserTo getUserById(Long idUser) {
        return this.userDao.getUserById(idUser);
    }
}
