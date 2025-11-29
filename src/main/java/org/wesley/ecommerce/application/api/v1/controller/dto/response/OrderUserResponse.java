package org.wesley.ecommerce.application.api.v1.controller.dto.response;

import org.wesley.ecommerce.application.domain.model.Users;

import java.util.UUID;

public record OrderUserResponse(
        UUID id,
        String name,
        String email,
        String street,
        String city,
        String state,
        String zip
) {
    public static OrderUserResponse fromEntity(Users user) {
        if (user == null) return null;
        
        var address = user.getAddress();
        
        return new OrderUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                address != null ? address.getStreet() : null,
                address != null ? address.getCity() : null,
                address != null ? address.getState() : null,
                address != null ? address.getZip() : null
        );
    }
}