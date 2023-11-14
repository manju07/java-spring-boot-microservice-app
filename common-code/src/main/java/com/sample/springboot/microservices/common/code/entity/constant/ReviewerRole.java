package com.sample.springboot.microservices.common.code.entity.constant;

public enum ReviewerRole {
    Employee("Employee"), Manager("Manager"), Business_Head("Business_Head");

    private String reviewerRole;

    ReviewerRole(String reviewerRole) {
        this.reviewerRole = reviewerRole;
    }

    public String getReviewRole() {
        return this.reviewerRole;
    }

}