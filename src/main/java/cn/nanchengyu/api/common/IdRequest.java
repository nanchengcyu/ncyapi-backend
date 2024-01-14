package cn.nanchengyu.api.common;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: IdReques
 * Package: cn.nanchengyu.api.common
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/13 23:42
 * @Version 1.0
 */
@Data
public class IdRequest  implements Serializable {
    private Long id;

    private  static final long serialVersionUID = 1L;
}
