package com.oa01.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo implements Serializable {
    private String loginAccount;
    private String loginPwd;
    private String code;
    private String role;//角色
}
