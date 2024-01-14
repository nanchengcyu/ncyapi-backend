package cn.nanchengyu.api.model.dto.userinterfaceinfo;

import java.io.Serializable;

/**
 * ClassName: UserInterfaceInfoUpdateRequesst
 * Package: cn.nanchengyu.api.model.dto.userinterfaceinfo
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/14 17:45
 * @Version 1.0
 */
public class UserInterfaceInfoUpdateRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

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

    private static final long serialVersionUID = 1L;

}
