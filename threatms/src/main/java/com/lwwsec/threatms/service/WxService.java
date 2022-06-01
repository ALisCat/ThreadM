package com.lwwsec.threatms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwwsec.threatms.entity.Wx;
import com.lwwsec.threatms.model.WxVo;


public interface WxService extends IService<Wx> {

    /**
     * 保存威胁模型数据
     */
    void saveWxInfo(WxVo wxVo);

}
