package com.xencio.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;



    String username;
    String password;

}
