package cn.nanchengyu.api.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;




/**
 * ClassName: UserInterfaceInfoServiceImplTest
 * Package: cn.nanchengyu.api.service.impl
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/14 18:11
 * @Version 1.0
 */
@SpringBootTest
public class UserInterfaceInfoServiceImplTest {

    @Resource
    private UserInterfaceInfoServiceImpl userInterfaceInfoService;
    @Test
    public void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1L, 1L);
        Assertions.assertTrue(b);

    }
}