package cn.nanchengyu.api.service.impl;

import cn.nanchengyu.api.common.ErrorCode;
import cn.nanchengyu.api.exception.BusinessException;
import cn.nanchengyu.api.mapper.InterfaceInfoMapper;
import cn.nanchengyu.api.model.entity.InterfaceInfo;
import cn.nanchengyu.api.service.InterfaceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author nanchengyu
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-01-14 17:28:53
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {


    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }



}




