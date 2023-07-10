package com.capitole.tecnicalTest.ordermanagment.service.api.rest;


import com.capitole.common.handleExceptions.to.ErrorResponse;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Validated
@RequestMapping("/rest/v1/order")
@Tag(name  = "Orders API")
public interface OrdermanagmentRestService {

    @GetMapping
    @Operation(summary = "List of orders", description = "Returns a list of orders filters by optional criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all orders filter by optional criteria", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderTo.class)))}),
            @ApiResponse(responseCode = "500", description = "Something was wrong, please try again", content ={ @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    ResponseEntity<List<OrderTo>> findAll(OrderSearchCriteria criteria);

    @PostMapping
    @Operation(summary = "New order", description = "Create a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Generate new order", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = OrderTo.class))}),
            @ApiResponse(responseCode = "500", description = "Something was wrong, please try again", content ={ @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    ResponseEntity<Boolean> createOrder(@RequestBody OrderTo orderTo);

    @GetMapping("/moreExpensive")
    @Operation(summary = "More expensive order", description = "Returns all data from the more expensive order. " +
            "Filter by optional criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get more expensive order, filter by optional criteria", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = OrderTo.class))}),
            @ApiResponse(responseCode = "500", description = "Something was wrong, please try again",content ={ @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    ResponseEntity<OrderTo> moreExpensiveOrder(OrderSearchCriteria criteria);

    @GetMapping("/lastOrderForUsers")
    @Operation(summary = "Last orders", description = "Returns the last order for each user. Filter by optional criteria. " +
            "Filter by optional criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get more expensive orders. Filter by optional criteria", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = HashMap.class))}),
            @ApiResponse(responseCode = "500", description = "Something was wrong, please try again", content ={ @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    ResponseEntity<List<HashMap>> lastOrderForUsers(OrderSearchCriteria criteria);


    @PatchMapping("/copy/{userFrom}/{userTo}")
    @Operation(summary = "Copy orders between users", description = "Given two users (userFrom, userTo). " +
            "Copy orders of the userFrom to the userTo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Copy orders between users", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = OrderTo.class))}),
            @ApiResponse(responseCode = "500", description = "Something was wrong, please try again", content ={ @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    ResponseEntity<Boolean> copyOrders(@PathVariable("userFrom") Long userIdFrom,@PathVariable("userTo") Long userIdTo);



}
