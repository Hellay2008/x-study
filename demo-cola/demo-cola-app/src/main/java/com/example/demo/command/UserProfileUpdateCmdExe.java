package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.convertor.UserProfileConvertor;
import com.example.demo.domain.user.UserProfile;
import com.example.demo.dto.UserProfileUpdateCmd;
import com.example.demo.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}