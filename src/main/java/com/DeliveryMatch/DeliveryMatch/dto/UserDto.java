package com.DeliveryMatch.DeliveryMatch.dto;

import com.DeliveryMatch.DeliveryMatch.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
     private String email;
    private UserRole userRole;
}
