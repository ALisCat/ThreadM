package com.lwwsec.threatms.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwwsec.threatms.common.Result;
import com.lwwsec.threatms.entity.Wx;
import com.lwwsec.threatms.entity.WxEasyExcel;
import com.lwwsec.threatms.model.WxVo;
import com.lwwsec.threatms.service.WxService;
import com.lwwsec.threatms.utiles.ExcelFillCellMergeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class WxController {

    @Autowired
    WxService wxService;

    @RequestMapping("/wx")
    public void save(@RequestBody WxVo wxVo, HttpServletResponse response) throws IOException {

        wxService.saveWxInfo(wxVo);

        QueryWrapper<Wx> wrapper = new QueryWrapper<>();
        wrapper.eq("sys_name",wxVo.getSysName()).select("sys_name","module_Name","vul_type");
        List<Map<String, Object>> list = wxService.listMaps(wrapper);

        String fileName =wxVo.getSysName() + ".xlsx";
        fileName = URLEncoder.encode(fileName,"utf-8");

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.addHeader("realfilename",fileName);
        response.setHeader("Access-Control-Expose-Headers","realfilename");
        //文件下载方式
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));

        //需要合并的列
        int[] mergeColumeIndex = {0, 1};
        //需要从第一行开始，列头第一行
        int mergeRowIndex = 1;

        List<WxEasyExcel> wxList = new ArrayList<>();
        for (Map<String, Object> map : list) {

            WxEasyExcel excel = new WxEasyExcel(map.get("sys_name").toString(), map.get("module_Name").toString(), map.get("vul_type").toString());
            wxList.add(excel);

        }

        EasyExcel.write(response.getOutputStream(),WxEasyExcel.class)
                .registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex))
//                .autoCloseStream(Boolean.FALSE)
                .sheet("威胁建模").doWrite(wxList);

    }


    @GetMapping("/AllCount")
    public Result<?> selectAll(){
        int count = wxService.count();
        System.out.println(count);
        return Result.success();
    }


}
