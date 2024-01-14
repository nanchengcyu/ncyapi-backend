package cn.nanchengyu.api.controller;

import cn.hutool.json.JSONUtil;
import cn.nanchengyu.api.annotation.AuthCheck;
import cn.nanchengyu.api.common.*;
import cn.nanchengyu.api.constant.UserConstant;
import cn.nanchengyu.api.exception.BusinessException;
import cn.nanchengyu.api.exception.ThrowUtils;

import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInfoAddRequest;
import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInfoUpdateRequest;
import cn.nanchengyu.api.model.dto.interfaceinfo.InterfaceInvokeRequest;
import cn.nanchengyu.api.model.entity.InterfaceInfo;
import cn.nanchengyu.api.model.entity.User;
import cn.nanchengyu.api.model.enums.InterfaceInfoStatusEnum;
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
 */
@RestController
@RequestMapping("/interfaceInfo")
@Slf4j
public class InterfaceInfoController {

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private UserService userService;

    /**
     * 上线接口
     *
     * @param
     * @param request
     * @return
     */
    @PostMapping("/online")
    @AuthCheck(mustRole = "admin") //控制权限 必须管理员才可以这样操作
    public BaseResponse<Boolean> onlineInterfaceInfo(@RequestBody IdRequest idRequest, HttpServletRequest request) {
        //判断传回来的id参数是否不正常null和<=0都不正常
        if (idRequest == null || idRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = idRequest.getId(); //此处getId是mybatis-plus自动生成
        //查看接口是否存在
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        if (oldInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        //判断该接口是否可以调用

        //仅本人或者管理员可修改
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        interfaceInfo.setStatus(InterfaceInfoStatusEnum.ONLINE.getValue());
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        return ResultUtils.success(result);


    }

    /**
     * 下线接口
     *
     * @param
     * @param request
     * @return
     */

    @PostMapping("/offline")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<Boolean> offlineInterfaceInfo(@RequestBody IdRequest idRequest, HttpServletRequest request) {
        //判断传回来的id参数是否不正常null和<=0都不正常
        if (idRequest == null || idRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = idRequest.getId();//此处getId是Data插件自动生成
        //查看接口是否存在
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        if (oldInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        //判断该接口是否可以调用

        //仅本人或者管理员可修改
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        interfaceInfo.setStatus(InterfaceInfoStatusEnum.OFFLINE.getValue());
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        return ResultUtils.success(result);

    }

    @PostMapping("/invoke")
    public BaseResponse<Object> invokeInterfaceInfo(@RequestBody InterfaceInvokeRequest interfaceInvokeRequest, HttpServletRequest request) {
        //判断传回来的id参数是否不正常null和<=0都不正常
        if (interfaceInvokeRequest == null || interfaceInvokeRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = interfaceInvokeRequest.getId(); //此处getId是Data插件自动生成
        String userRequestParams = interfaceInvokeRequest.getUserRequestParams();
        //查看接口是否存在
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        if (oldInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        if (oldInterfaceInfo.getStatus() == InterfaceInfoStatusEnum.OFFLINE.getValue()){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"该接口已下线");
        }

        //判断该接口是否可以调用
        //String accessKey = userService.getAccessKey();
        // String secretKey = userService.getSecretKey();
        //仅本人或者管理员可修改
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        interfaceInfo.setStatus(InterfaceInfoStatusEnum.OFFLINE.getValue());
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        return ResultUtils.success(result);

    }


}
