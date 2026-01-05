package com.ampta.ecom.dto.response;

import com.ampta.ecom.dto.AddressDTO;
import com.ampta.ecom.model.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private AddressDTO address;
}
