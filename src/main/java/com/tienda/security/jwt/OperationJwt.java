package com.tienda.security.jwt;


import com.tienda.model.dto.TokenDto;
import com.tienda.model.user.User;

public interface OperationJwt {
    TokenDto generateTokenDto(User user);
}
