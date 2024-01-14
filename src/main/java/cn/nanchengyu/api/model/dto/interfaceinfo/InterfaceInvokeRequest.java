package cn.nanchengyu.api.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: InterfaceInvokeRequest
 * Package: cn.nanchengyu.api.model.dto.interfaceinfo
 * Description:接口调用请求
 *
 * @Author 南城余
 * @Create 2024/1/14 16:22
 * @Version 1.0
 */
@Data
public class InterfaceInvokeRequest implements Serializable {
    //DTO 数据传输对象是前端传后端的请求参数 主要给Controller使用的
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;

}
