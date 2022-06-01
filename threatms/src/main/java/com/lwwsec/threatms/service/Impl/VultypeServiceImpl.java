package com.lwwsec.threatms.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwwsec.threatms.entity.Vultype;
import com.lwwsec.threatms.mapper.VultypeMapper;
import com.lwwsec.threatms.service.VultypeService;
import org.springframework.stereotype.Service;

@Service
public class VultypeServiceImpl extends ServiceImpl<VultypeMapper, Vultype> implements VultypeService {
}
