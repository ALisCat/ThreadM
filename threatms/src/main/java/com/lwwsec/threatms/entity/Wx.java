package com.lwwsec.threatms.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("wx")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wx {

    @ExcelIgnore
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    @TableField("sys_name")
    private String sysName;

    @TableField("module_name")
    private String moduleName;

    @TableField("vul_type")
    private String vulType;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
