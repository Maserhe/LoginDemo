package com.xencio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    Integer id;

    String username;

    String password;

    String salt;

    String  tel;
}
