package com.sample.springboot.microservices.groupservice.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User badge dto
 * 
 * @author Manjunath Asundi
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserBadgeDto {
    private Long id;
    private Set<BadgeDto> badgeSet = new HashSet<BadgeDto>();
}