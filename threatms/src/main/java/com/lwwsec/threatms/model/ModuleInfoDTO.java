package com.lwwsec.threatms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleInfoDTO {

    private String moduleName;

    private List<String> vulTypeList;
}
