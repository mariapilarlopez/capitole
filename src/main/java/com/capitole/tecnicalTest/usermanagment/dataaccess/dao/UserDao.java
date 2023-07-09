package com.capitole.tecnicalTest.usermanagment.dataaccess.dao;

import com.capitole.tecnicalTest.usermanagment.logic.api.to.UserTo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao<User, Long>{

    UserTo getUserById(@Param("idUser") Long idUser);
}
