package com.capitole.tecnicalTest.ordermanagment.logic.impl;

import com.capitole.tecnicalTest.ordermanagment.dataaccess.dao.OrderDao;
import com.capitole.tecnicalTest.ordermanagment.logic.api.Ordermanagment;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import com.capitole.tecnicalTest.usermanagment.logic.api.Usermanagment;
import com.capitole.tecnicalTest.usermanagment.logic.api.to.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
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
    public List<HashMap> getMaxOrderIdByUser(OrderSearchCriteria criteria) {

        return this.orderDao.getMaxOrderIdByUser(criteria);
    }

    @Override
    public OrderTo getOrderById(Long idOrder) {
        return this.orderDao.getOrderById(idOrder);
    }

    @Override
    public void copyOrdersFromUserToUser(Long idUserFrom, Long idUserTo) {

        if (idUserFrom == idUserTo){
            LOG.warn(String.format("Action not done, users are equal. From user %s to user %s  ", idUserFrom, idUserTo));
            return;
        }

        UserTo userTo = this.usermanagment.getUserById(idUserTo);
        if (userTo == null){
            LOG.warn(String.format("Action not done, user does not exist. From user %s to user %s ", idUserFrom, idUserTo));
            return;
        }

        if (idUserFrom == idUserTo){
            LOG.warn(String.format("Action not done, users are equal. From user %s to user %s  ", idUserFrom, idUserTo));
            return;
        }

        OrderSearchCriteria criteriaUserFrom = new OrderSearchCriteria();
        criteriaUserFrom.setIdUser(idUserFrom);
        List<OrderTo> ordersToCopyList = this.orderDao.findAll(criteriaUserFrom);
        for(OrderTo order: ordersToCopyList){
            order.setIdUser(idUserTo);
            this.orderDao.insertOrder(order);
        }
    }

    @Override
    public List<OrderTo> findAll(OrderSearchCriteria criteria) {
        return this.orderDao.findAll(criteria);
    }


}
