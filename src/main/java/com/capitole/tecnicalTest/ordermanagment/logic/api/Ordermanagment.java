package com.capitole.tecnicalTest.ordermanagment.logic.api;

import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;

import java.util.HashMap;
import java.util.List;

public interface Ordermanagment {

    /**
     * Get the identifier of the last order for each user.
     * Filtering orders by optional criterias such as store, date, city ...
     * @param criteria
     * @return
     */
    List<HashMap> getMaxOrderForEachUser(OrderSearchCriteria criteria);

    /**
     * Get the order
     * @param idOrder
     * @return
     */
    OrderTo getOrderById(Long idOrder);

    Boolean copyOrdersFromUserToUser(Long idUserFrom, Long IdUserTo);

    /**
     * Get all orders filter by criteria
     * Filtering orders by optional criterias such as store, date, city ..
     * @param criteria
     * @return
     */
    List<OrderTo> findAll(OrderSearchCriteria criteria);

    /**
     * Get the more expensive order.
     * Filtering orders by optional criterias such as store, city ...
     * @param criteria
     * @return
     */
    OrderTo getMoreExpensiveOrder(OrderSearchCriteria criteria);

    Boolean insertOrder(OrderTo order);
}
