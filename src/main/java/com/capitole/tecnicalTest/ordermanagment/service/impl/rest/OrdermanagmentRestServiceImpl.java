package com.capitole.tecnicalTest.ordermanagment.service.impl.rest;

import com.capitole.tecnicalTest.ordermanagment.logic.api.Ordermanagment;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import com.capitole.tecnicalTest.ordermanagment.service.api.rest.OrdermanagmentRestService;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController("OrderRestService")
public class OrdermanagmentRestServiceImpl  implements OrdermanagmentRestService {

    private Ordermanagment ordermanagment;

    /**
     * The constructor.
     *
     * @param ordermanagment
     */
    @Inject
    public OrdermanagmentRestServiceImpl( Ordermanagment ordermanagment) {

        this.ordermanagment = ordermanagment;
    }

    @Override
    public List<OrderTo> findAll(OrderSearchCriteria criteria) {
        return this.ordermanagment.findAll(criteria);
    }

    @Override
    public OrderTo moreExpensiveOrder(OrderSearchCriteria criteria) {
        return this.ordermanagment.getMoreExpensiveOrder(criteria);
    }
}
