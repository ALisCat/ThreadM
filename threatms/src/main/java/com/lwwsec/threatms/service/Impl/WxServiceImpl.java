package com.lwwsec.threatms.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwwsec.threatms.entity.Wx;
import com.lwwsec.threatms.mapper.WxMapper;
import com.lwwsec.threatms.model.ModuleInfoDTO;
import com.lwwsec.threatms.model.WxVo;
import com.lwwsec.threatms.service.WxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 直接在实现类里面写方法,在controller里面调用方法
 * 个人理解:model和entity层差不多,entity中的属性值,和数据库中的表保持一致.但是有些数据较为特殊,如数组/列表等,不方便直接存入表中,因此需要一个处理数据的过程.
 * model就是写来处理数据用的,通过设计数据结构,从而设计model层
 *
 * 注意,在实现类中,还是对entity类进行数据库操作,然后在其中写一个方法,对前端传过来的数据进行处理
 */
@Service
public class WxServiceImpl extends ServiceImpl<WxMapper, Wx> implements WxService {

    //controller中使用(@RequestBody WxVo wxVo),使得前端传输过来的json数据变成一个类对象 以下方法接收一个对象
    @Override
    public void saveWxInfo(WxVo wxVo) {
        //mybatis plus 批量添加,是传入一个list,因此先创建一个entity类的list列表,后面将前端传过来的数据经过model类处理后,添加到list列表中,再插入数据库
        List<Wx> wxList = new ArrayList<>();

        //前端数据处理
        //WxVo类中的get方法,直接获取其中的sysName
        String sysName = wxVo.getSysName();
        //通过get方法,获取一个ModuleInfoDTO类型的list列表,而且WxVo类本身就是将这个定义成ModuleInfoDTO类型
        // 此时,该list列表中,存放着前端传输过来的所有moduleInfoDTOList数据,其中的数据是0个或多个ModuleInfoDTO
        // 而每个ModuleInfoDTO中存放着一个moduleName和一个vulTypeList,其中vulTypeList中可能存在多个数据
        List<ModuleInfoDTO> moduleInfoDTOList = wxVo.getModuleInfoDTOList();

        //使用循环进行数据存入前面定义的wxList
        //对moduleInfoDTOList进行循环
        for (ModuleInfoDTO moduleInfoDTO : moduleInfoDTOList) {
            //获取moduleInfoDTO中的moduleName
            String moduleName = moduleInfoDTO.getModuleName();
            //获取当前moduleInfoDTO中的vulTypeList,并将其内的值循环出来,赋值给变量vulType
            for (String vulType : moduleInfoDTO.getVulTypeList()) {
                //当每循环一次,得到一个vulType,就将前面得到的数据一起存入wxList
                // 即: 系统名 模块名 漏洞类型
                // 当当前模块名的的漏洞类型list中的vulType都循环出来后,该循环结束,跳到上一个循环,继续下一个模块名的漏洞类型list中的vulType的循环
                wxList.add(Wx.builder().sysName(sysName).moduleName(moduleName).vulType(vulType).build());
            }
        }

        //将最终获得的wxList存入数据库
        this.saveBatch(wxList);
    }
}
