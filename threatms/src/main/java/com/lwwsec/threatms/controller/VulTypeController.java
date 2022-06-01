package com.lwwsec.threatms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwwsec.threatms.common.Result;
import com.lwwsec.threatms.entity.Vultype;
import com.lwwsec.threatms.service.VultypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用于接收级联选择器的数据
 */

@RestController
@RequestMapping("/vultype")
public class VulTypeController {

    @Autowired
    VultypeService vultypeService;

    @GetMapping
    public Result<?> getVulType(){

        QueryWrapper<Vultype> wrapper = new QueryWrapper<>();
        wrapper.select("label","value");
        List<Map<String, Object>> list = vultypeService.listMaps(wrapper);

        return Result.success(list);
    }

}
