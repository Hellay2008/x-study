package com.example.demo.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.dto.UserProfileGetQry;
import com.example.demo.dto.clientobject.UserProfileCO;
import com.example.demo.gatewayimpl.database.UserProfileMapper;
import com.example.demo.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileGetQryExe {

    @Resource
    private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }

}
