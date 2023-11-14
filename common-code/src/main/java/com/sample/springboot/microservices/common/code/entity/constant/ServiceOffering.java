package com.sample.springboot.microservices.common.code.entity.constant;
/**
 * @author Manjunath Asundi
 */
public enum ServiceOffering {
    ABC("abc"), XYZ("xyz"),
    MNO("mno"), PQR("pqr");

    private String serviceOffering;

    ServiceOffering(String serviceOffering) {
        this.serviceOffering = serviceOffering;
    }

    public String getServiceOffering() {
        return this.serviceOffering;
    }
}