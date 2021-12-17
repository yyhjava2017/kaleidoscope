package com.kd.feign.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import user.icontroller.IUserController;


@FeignClient("kdcommon")
public interface UserService extends IUserController {
}
