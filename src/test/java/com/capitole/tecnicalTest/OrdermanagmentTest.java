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

        OrderSearchCriteria criteriaUserFrom =getCriteriaUser_idUser1();

        OrderSearchCriteria criteriaUserTo = getCriteriaUser_idUser4();

        List<OrderTo> orderUserFromList = this.ordermanagment.findAll(criteriaUserFrom);
        List<OrderTo> orderUserToList = this.ordermanagment.findAll(criteriaUserTo);

        this.ordermanagment.copyOrdersFromUserToUser(idUserFrom, idUserTo);

        List<OrderTo> orderUserToAfterCopyList = this.ordermanagment.findAll(criteriaUserTo);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() == (orderUserFromList.size() + orderUserToList.size()));


    }

    @Test
    public void copyOrders_FromUserdoesNotExistToUserDoesExist_resultSameNumberOfOrderOfUserTo(){

        OrderSearchCriteria criteriaUserFrom =getCriteriaUser_idUser55();

        OrderSearchCriteria criteriaUserTo = getCriteriaUser_idUser1();

        List<OrderTo> orderUserToList = this.ordermanagment.findAll(criteriaUserTo);

        this.ordermanagment.copyOrdersFromUserToUser(criteriaUserFrom.getIdUser(), criteriaUserTo.getIdUser());

        List<OrderTo> orderUserToAfterCopyList = this.ordermanagment.findAll(criteriaUserTo);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() ==  orderUserToList.size());

    }

    @Test
    public void copyOrders_FromUserdoesExistToUserDoesNotExist_resultSameNumberOfOrderOfUserTo(){

        OrderSearchCriteria criteriaUserFrom =getCriteriaUser_idUser1();

        OrderSearchCriteria criteriaUserTo = getCriteriaUser_idUser55();

        List<OrderTo> orderUserToList = this.ordermanagment.findAll(criteriaUserTo);

        this.ordermanagment.copyOrdersFromUserToUser(criteriaUserFrom.getIdUser(), criteriaUserTo.getIdUser());

        List<OrderTo> orderUserToAfterCopyList = this.ordermanagment.findAll(criteriaUserTo);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() ==  0);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() ==  orderUserToList.size());

    }


    @Test
    public void copyOrdersWhernFromUserIsEqualUserTo_resultSameNumberOfOrder(){

        OrderSearchCriteria criteriaUserFrom =getCriteriaUser_idUser1();

        OrderSearchCriteria criteriaUserTo = getCriteriaUser_idUser1();

        List<OrderTo> orderUserToList = this.ordermanagment.findAll(criteriaUserTo);

        this.ordermanagment.copyOrdersFromUserToUser(criteriaUserFrom.getIdUser(), criteriaUserTo.getIdUser());

        List<OrderTo> orderUserToAfterCopyList = this.ordermanagment.findAll(criteriaUserTo);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() >  0);

        Assert.assertTrue("OK ",
                orderUserToAfterCopyList.size() ==  orderUserToList.size());

    }

    private OrderSearchCriteria getCriteriaUser_idUser1(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        criteria.setIdUser(1L);
        return criteria;

    }

    private OrderSearchCriteria getCriteriaUser_idUser4(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        criteria.setIdUser(4L);
        return criteria;

    }

    private OrderSearchCriteria getCriteriaUser_idUser55(){
        OrderSearchCriteria criteria = new OrderSearchCriteria();
        criteria.setIdUser(55L);
        return criteria;

    }









}
