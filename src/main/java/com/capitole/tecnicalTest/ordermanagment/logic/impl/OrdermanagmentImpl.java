package com.capitole.tecnicalTest.ordermanagment.logic.impl;

import com.capitole.tecnicalTest.ordermanagment.dataaccess.dao.OrderDao;
import com.capitole.tecnicalTest.ordermanagment.logic.api.Ordermanagment;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import com.capitole.tecnicalTest.usermanagment.logic.api.Usermanagment;
import com.capitole.tecnicalTest.usermanagment.logic.api.to.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;

@Named("OrderManagment")
@Transactional
public class OrdermanagmentImpl implements Ordermanagment {

    private OrderDao orderDao;

    private Usermanagment usermanagment;

    private static final Logger LOG = LoggerFactory.getLogger(OrdermanagmentImpl.class);

    /**
     * The constructor.
     *
     * @param orderDao
     */
    @Inject
    public OrdermanagmentImpl(OrderDao orderDao, Usermanagment usermanagment) {

        this.orderDao = orderDao;
        this.usermanagment = usermanagment;
    }

    @Override
    public List<HashMap> getMaxOrderForEachUser(OrderSearchCriteria criteria) {

        return this.orderDao.getMaxOrderForEachUser(criteria);
    }

    @Override
    public OrderTo getOrderById(Long idOrder) {
        return this.orderDao.getOrderById(idOrder);
    }

    @Override
    public Boolean copyOrdersFromUserToUser(Long idUserFrom, Long idUserTo) {

        if (idUserFrom == idUserTo){
            LOG.warn(String.format("Action not done, users are equal. From user %s to user %s  ", idUserFrom, idUserTo));
            return false;
        }

        UserTo userTo = this.usermanagment.getUserById(idUserTo);
        if (userTo == null){
            LOG.warn(String.format("Action not done, user does not exist. From user %s to user %s ", idUserFrom, idUserTo));
            return false;
        }

        if (idUserFrom == idUserTo){
            LOG.warn(String.format("Action not done, users are equal. From user %s to user %s  ", idUserFrom, idUserTo));
            return false;
        }

        OrderSearchCriteria criteriaUserFrom = new OrderSearchCriteria();
        criteriaUserFrom.setIdUser(idUserFrom);
        List<OrderTo> ordersToCopyList = this.orderDao.findAll(criteriaUserFrom);
        for(OrderTo order: ordersToCopyList){
            order.setIdUser(idUserTo);
            this.orderDao.insertOrder(order);
        }
        return true;
    }

    @Override
    public List<OrderTo> findAll(OrderSearchCriteria criteria) {
        return this.orderDao.findAll(criteria);
    }

    @Override
    public OrderTo getMoreExpensiveOrder(OrderSearchCriteria criteria) {
        return this.orderDao.getMoreExpensiveOrder(criteria);
    }

    @Override
    public Boolean insertOrder(OrderTo order){
        return this.orderDao.insertOrder(order);
    }


}
