package com.capitole.tecnicalTest.ordermanagment.dataaccess.dao;

import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao<Order, Long>{

    List<HashMap> getMaxOrderIdByUser(OrderSearchCriteria criteria);

    List<OrderTo> findAll(OrderSearchCriteria criteria);

    OrderTo getOrderById(@Param("idOrder") Long idOrder);

    List<OrderTo> getMoreExpensiveOrder(OrderSearchCriteria criteria);

    void insertOrder(OrderTo order);



}
