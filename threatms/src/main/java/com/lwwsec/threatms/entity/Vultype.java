package com.lwwsec.threatms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("vultype")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vultype {

    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    @TableField("label")
    private String label;

    @TableField("value")
    private String value;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
