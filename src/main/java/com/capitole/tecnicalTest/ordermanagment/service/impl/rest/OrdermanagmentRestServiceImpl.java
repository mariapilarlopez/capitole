package com.capitole.tecnicalTest.ordermanagment.service.impl.rest;

import com.capitole.tecnicalTest.ordermanagment.logic.api.Ordermanagment;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import com.capitole.tecnicalTest.ordermanagment.service.api.rest.OrdermanagmentRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
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
    public ResponseEntity<List<OrderTo>> findAll(OrderSearchCriteria criteria) {
        try {
            return new ResponseEntity<>( this.ordermanagment.findAll(criteria), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> createOrder(OrderTo orderTo) {
        try {
            return new ResponseEntity( this.ordermanagment.insertOrder(orderTo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<OrderTo> moreExpensiveOrder(OrderSearchCriteria criteria) {
        try {
            return new ResponseEntity<>(  this.ordermanagment.getMoreExpensiveOrder(criteria), HttpStatus.OK);
        } catch (Exception e) {
            OrderTo _orderTo = new OrderTo();
            return new ResponseEntity<OrderTo>(_orderTo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<HashMap>> lastOrderForUsers(OrderSearchCriteria criteria) {
        try {
            return new ResponseEntity<>( this.ordermanagment.getMaxOrderForEachUser(criteria), HttpStatus.OK);
        } catch (Exception e) {
            List<HashMap> _idS = new ArrayList<HashMap>();
            return new ResponseEntity<List<HashMap>>(_idS, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> copyOrders(Long userIdFrom, Long userIdTo) {
        try {
            return new ResponseEntity( this.ordermanagment.copyOrdersFromUserToUser(userIdFrom, userIdTo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
