package com.ampta.ecom.dto.request;

import com.ampta.ecom.dto.AddressDTO;
import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressDTO address;
}
