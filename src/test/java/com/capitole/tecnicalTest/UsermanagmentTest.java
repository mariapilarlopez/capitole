package com.capitole.tecnicalTest;

import com.capitole.tecnicalTest.usermanagment.logic.api.Usermanagment;
import com.capitole.tecnicalTest.usermanagment.logic.api.to.UserTo;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class UsermanagmentTest extends AbstractTest {

    @Inject
    Usermanagment usermanagment;


    @Test
    public void getUserById_t001(){
        Long userId = 1L;
        UserTo result = this.usermanagment.getUserById(userId);
        Assert.assertTrue("OK ", result != null && userId.equals(result.getIdUser()));
    }



}



