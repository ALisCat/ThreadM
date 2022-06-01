package com.lwwsec.threatms.test;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwwsec.threatms.entity.Wx;
import com.lwwsec.threatms.entity.WxEasyExcel;
import com.lwwsec.threatms.service.WxService;
import com.lwwsec.threatms.utiles.ExcelFillCellMergeStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testdemo1 {


    @Autowired
    WxService wxService;


    @Test
    public void test5(){
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
    }

    @Test
    public void test6(){
        Map<String, Object> map = new HashMap<>();
        map.put("sys_name","system0526");
        List<Wx> wxList = wxService.listByMap(map);
        System.out.println(wxList);
    }

    @Test
    public void test7(){
        QueryWrapper<Wx> wrapper = new QueryWrapper<>();
        wrapper.eq("sys_name","system0526").select("sys_name","module_Name","vul_type");
        List<Map<String, Object>> list = wxService.listMaps(wrapper);
        System.out.println(list.toString());

        String fileName = "mergevultest02.xlsx";

        //需要合并的列
        int[] mergeColumeIndex = {0, 1};
        //需要从第一行开始，列头第一行
        int mergeRowIndex = 1;

        ExcelWriter excelWriter = EasyExcel.write(fileName, WxEasyExcel.class)
                .registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex)).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("威胁建模").build();


        for (Map<String, Object> map : list) {
            System.out.println(map);
            System.out.println(map.get("sys_name"));
            List<WxEasyExcel> wxList = new ArrayList<>();

            WxEasyExcel excel = new WxEasyExcel(map.get("sys_name").toString(), map.get("module_Name").toString(), map.get("vul_type").toString());
            System.out.println(excel);
            wxList.add(excel);
            System.out.println(wxList);

            excelWriter.write(wxList,writeSheet);

        }
        excelWriter.finish();

    }

    @Test
    public void test8(){
        QueryWrapper<Wx> wrapper = new QueryWrapper<>();
        wrapper.eq("sys_name","system0526").select("sys_name","module_Name","vul_type");
        List<Map<String, Object>> list = wxService.listMaps(wrapper);
        System.out.println(list.toString());

        String fileName = "mergevultest03.xlsx";

        //需要合并的列
        int[] mergeColumeIndex = {0, 1};
        //需要从第一行开始，列头第一行
        int mergeRowIndex = 1;


        List<WxEasyExcel> wxList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            System.out.println(map);
            System.out.println(map.get("sys_name"));


            WxEasyExcel excel = new WxEasyExcel(map.get("sys_name").toString(), map.get("module_Name").toString(), map.get("vul_type").toString());
            System.out.println(excel);
            wxList.add(excel);
            System.out.println(wxList);

        }

        EasyExcel.write(fileName,WxEasyExcel.class)
                .registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex))
                .sheet("威胁建模").doWrite(wxList);
    }
}
