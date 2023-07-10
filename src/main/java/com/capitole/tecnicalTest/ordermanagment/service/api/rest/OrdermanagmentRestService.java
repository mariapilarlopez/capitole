package com.capitole.tecnicalTest.ordermanagment.service.api.rest;


import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@RequestMapping("/rest/v1/order")
@Tag(name  = "Orders API")
@Api(value = "Service for coverage type management", consumes = "application/json", produces = "application/json")
public interface OrdermanagmentRestService {

    @GetMapping
    @Operation(summary = "List of orders", description = "Returns a list of orders filters by optional criteria")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "System error") })
    List<OrderTo> findAll(OrderSearchCriteria criteria);

    @GetMapping("/moreExpensive")
    @Operation(summary = "More expensive order", description = "Returns all data from the more expensive order. " +
            "Filter by optional criteria")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "System error") })
    OrderTo moreExpensiveOrder(OrderSearchCriteria criteria);

    @PatchMapping("/copy/{userFrom}/{userTo}")
    @Operation(summary = "Copy orders between users", description = "Given two users (userFrom, userTo). " +
            "Copy orders of the userFrom to the userTo")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "System error"),
            @ApiResponse(code = 405,  message = "Incorrect parameters")})
    void copyOrders(@PathVariable("userFrom") Long userIdFrom,@PathVariable("userTo") Long userIdTo);

}
