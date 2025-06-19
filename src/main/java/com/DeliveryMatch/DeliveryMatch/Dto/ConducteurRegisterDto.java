package com.DeliveryMatch.DeliveryMatch.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConducteurRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}