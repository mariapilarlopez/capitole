package com.capitole.tecnicalTest;

import com.capitole.tecnicalTest.ordermanagment.logic.api.Ordermanagment;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class OrdermanagmentTest extends AbstractTest {

    @Inject
    Ordermanagment ordermanagment;


    @Test
    public void getMaxOrderIdByUser_t001(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        List<HashMap> result = this.ordermanagment.getMaxOrderIdByUser(criteria);
        Assert.assertTrue("OK ", result.size()>1);
    }

    @Test
    public void getMaxOrderIdByUser_t002(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        criteria.setIdStore(55L);
        List<HashMap> result = this.ordermanagment.getMaxOrderIdByUser(criteria);
        Assert.assertTrue("OK ", result.size()==0);
    }

    @Test
    public void getOrderById_t001(){
        Long idOrder = 1L;
        OrderTo result = this.ordermanagment.getOrderById(idOrder);
        Assert.assertTrue("OK ", result != null && idOrder.equals(result.getIdOrder()));
    }

    @Test
    public void getOrderById_t002(){
        Long idOrder = 55L;
        OrderTo result = this.ordermanagment.getOrderById(idOrder);
        Assert.assertTrue("OK ", result == null);
    }

    @Test
    public void copyOrdersFromUserToUser_t001(){

        Long idUserFrom = 1L;
        Long idUserTo = 4L;

        OrderSearchCriteria criteriaUserFrom = new OrderSearchCriteria();
        criteriaUserFrom.setIdUser(idUserFrom);

        OrderSearchCriteria criteriaUserTo = new OrderSearchCriteria();
        criteriaUserTo.setIdUser(idUserTo);

        List<OrderTo> orderUserFromList = this.ordermanagment.findAll(criteriaUserFrom);
        List<OrderTo> orderUserToList = this.ordermanagment.findAll(criteriaUserTo);

        this.ordermanagment.copyOrdersFromUserToUser(idUserFrom, idUserTo);

        List<OrderTo> orderUserToAfterCopyList = this.ordermanagment.findAll(criteriaUserTo);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() == (orderUserFromList.size() + orderUserToList.size()));


    }







}
