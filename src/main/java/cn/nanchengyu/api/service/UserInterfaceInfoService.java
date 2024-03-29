package cn.nanchengyu.api.service;

import cn.nanchengyu.api.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author nanchengyu
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-01-14 17:30:53
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
