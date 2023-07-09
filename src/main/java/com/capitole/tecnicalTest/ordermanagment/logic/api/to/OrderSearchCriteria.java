package com.capitole.tecnicalTest.ordermanagment.logic.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class OrderSearchCriteria implements Serializable {

    @Schema(name = "idStore", description= "Store identifier", example = "1")
    private Long idStore;

    @Schema(name = "idOrder", description= "Order identifier", example = "1")
    private Long idOrder;

    @Schema(name = "idUser", description= "User identifier", example = "1")
    private Long idUser;

    private Date date;

    @Schema(name = "address", description= "Order address ", example = "LOREM")
    private String address;

    @Schema(name = "zipCode", description= "Order zip code ", example = "50")
    private String zipCode;

    @Schema(name = "city", description= "Order city ", example = "ZUE")
    private String city;

    @Schema(name = "country", description= "Order country ", example = "ES")
    private String country;

    public Long getIdStore() {
        return idStore;
    }

    public void setIdStore(Long idStore) {
        this.idStore = idStore;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
