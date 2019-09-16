package com.wan.communtify.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String accountId;
    private String name;
    private String token;
    private long gmt_create;
    private long gmt_modified;
    private String avatarUrl;
}
