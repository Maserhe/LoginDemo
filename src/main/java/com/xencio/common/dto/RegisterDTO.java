package com.xencio.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    String username;

    String password;


    String  tel;

    Integer type;


}
