package com.example.springbootwithjpa.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "activity_lottery_ckey_model")
public class ActivityLotteryCKeyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ssoid", columnDefinition = "bigint(11)  COMMENT '账号ssoid'")
    private Long ssoid;

    @Column(name = "ninelattices_id", columnDefinition = "bigint(20)  COMMENT '活动外键'")
    private Long nineLatticesID;

    @Column(name = "code", columnDefinition = "varchar(50) NOT NULL COMMENT '兑换码编号'")
    private String code;

    @Column(name = "status", columnDefinition = "tinyint(1) NOT NULL COMMENT '状态 0-已使用 1-未使用'")
    private Integer status = 1;

    @Column(name = "is_delete", columnDefinition = "tinyint(1) COMMENT '是否删除 0-是 1-否'")
    private Integer isDelete = 1;

    @Column(name = "tx_time", columnDefinition = "varchar(20) NULL COMMENT '业务日期'")
    private String txTime;

    @Column(name = "cre_time", columnDefinition = "bigint(20) NULL COMMENT '创建时间'")
    private Long creTime;

    @Column(name = "mod_time", columnDefinition = "bigint(20) NULL COMMENT '修改时间'")
    private Long modTime;



    }