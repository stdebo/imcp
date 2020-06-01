package com.imcp.api.service.fallback;

import java.util.List;

import com.imcp.api.bean.basic.Dept;
import com.imcp.api.bean.basic.User;
import com.imcp.api.service.IUserClientService;
import org.springframework.stereotype.Component;
import feign.hystrix.FallbackFactory;

@Component
public class IUserClientServiceFallbackFactory implements FallbackFactory<IUserClientService> {

    @Override
    public IUserClientService create(Throwable cause) {
        return new IUserClientService() {
            @Override
            public User getUser2(String id) {
                User vo = new User();
                //vo.setDeptno(888888L);
                //vo.setDname("【ERROR】Feign-Hystrix"); // 错误的提示
                //vo.setLoc("Consumer客户端提供");
                return vo;
            }
        };
    }

}
