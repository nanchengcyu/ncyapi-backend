package cn.nanchengyu.api.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: userinterfaceinfo
 * Package: cn.nanchengyu.api.model.dto
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/14 17:41
 * @Version 1.0
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

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

}

