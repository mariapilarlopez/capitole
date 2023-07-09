package com.capitole.tecnicalTest.usermanagment.logic.api;

import com.capitole.tecnicalTest.usermanagment.logic.api.to.UserTo;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;


public interface Usermanagment {

    /**
     * Get the user
     * @param idUser
     * @return
     */
    UserTo getUserById(Long idUser);
}
