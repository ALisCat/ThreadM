package com.lwwsec.threatms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个没有用到
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VulType {

    private String label;
    private String value;
}
