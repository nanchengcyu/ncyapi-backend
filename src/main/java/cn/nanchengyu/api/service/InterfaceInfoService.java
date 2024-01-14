package cn.nanchengyu.api.service;

import cn.nanchengyu.api.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* @author nanchengyu
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-01-14 17:28:53
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
