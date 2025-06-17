package com.DeliveryMatch.DeliveryMatch.dto;

import com.DeliveryMatch.DeliveryMatch.enums.UserRole;
import lombok.Data;

@Data
public class SignupRequest {
    private String name ,email,password;
    private UserRole userRole;
}
