package com.wan.communtify.dto;

import lombok.Data;

/**P12
 *登录验证信息的包装类
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
