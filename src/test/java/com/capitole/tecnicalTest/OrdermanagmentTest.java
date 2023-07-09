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
    public void getLastOrderForEachUserWithoutCondictions_resultEmptyList(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        List<HashMap> result = this.ordermanagment.getMaxOrderIdByUser(criteria);
        Assert.assertTrue("OK ", result.size()>1);
    }

    @Test
    public void getLastOrderForEachUserWithStoreCondiction_StoreDoesExist_resultListWithElements(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        criteria.setIdStore(1L);
        List<HashMap> result = this.ordermanagment.getMaxOrderIdByUser(criteria);
        Assert.assertTrue("OK ", result.size()>0);
    }

    @Test
    public void getLastOrderForEachUserWithStoreCondiction_StoreDoesNotExist_resultListWithElements(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        criteria.setIdStore(55L);
        List<HashMap> result = this.ordermanagment.getMaxOrderIdByUser(criteria);
        Assert.assertTrue("OK ", result.size()==0);
    }

    @Test
    public void getOrderWhenidOrderExist_resultOrderWithSameIdThatsearchedOrder(){
        Long idOrder = 1L;
        OrderTo result = this.ordermanagment.getOrderById(idOrder);
        Assert.assertTrue("OK ", result != null && idOrder.equals(result.getIdOrder()));
    }

    @Test
    public void getOrderDoesNotExist_resultNullObject(){
        Long idOrder = 55L;
        OrderTo result = this.ordermanagment.getOrderById(idOrder);
        Assert.assertTrue("OK ", result == null);
    }

    @Test
    public void copyOrdersFromUserDoesExistToUserDoesExist_resultSameNumberOfOrderOfUserTo(){

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

    @Test
    public void copyOrders_FromUserdoesNotExistToUserDoesExist_resultSameNumberOfOrderOfUserTo(){

        Long idUserFrom = 55L;
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
                orderUserToAfterCopyList.size() ==  orderUserToList.size());

    }







}
