package cn.nanchengyu.api.controller;

import cn.hutool.json.JSONUtil;
import cn.nanchengyu.api.annotation.AuthCheck;
import cn.nanchengyu.api.common.BaseResponse;
import cn.nanchengyu.api.common.DeleteRequest;
import cn.nanchengyu.api.common.ErrorCode;
import cn.nanchengyu.api.common.ResultUtils;
import cn.nanchengyu.api.constant.UserConstant;
import cn.nanchengyu.api.exception.BusinessException;
import cn.nanchengyu.api.exception.ThrowUtils;

import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInfoAddRequest;
import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInfoUpdateRequest;
import cn.nanchengyu.api.model.entity.InterfaceInfo;
import cn.nanchengyu.api.model.entity.User;
import cn.nanchengyu.api.service.InterfaceInfoService;
import cn.nanchengyu.api.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * api接口
 *
 */
@RestController
@RequestMapping("/interfaceInfo")
@Slf4j
public class InterfaceInfoController {

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private UserService userService;




}
