package cn.nanchengyu.api.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: UserInterfaceInfoQueryRequet
 * Package: cn.nanchengyu.api.model.dto.userinterfaceinfo
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/14 17:44
 * @Version 1.0
 */
@Data
public class UserInterfaceInfoQueryRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;


}
