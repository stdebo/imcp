package com.imcp.geteway.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthorizedRequestFilter extends ZuulFilter {    // 进行授权访问处理

    /**
     * 可以进行一些逻辑判断控制程序是否继续执行
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() {    // 表示具体的过滤执行操作
        RequestContext currentContext = RequestContext.getCurrentContext(); // 获取当前请求的上下文
        String auth = "imcp:123456"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }

    /**
     * 返回一个bool值来判断此过滤器的run()方法是否执行：true执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {    // 该Filter是否要执行
        return true;
    }

    /**
     * 通过int值来定义过滤器的执行顺序，数值越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;    // 设置优先级，数字越大优先级越低
    }

    /**
     * 该函数返回一个字符串代表过滤器的类型，这个类型就是在http请求过程中定义的各个阶段
     *
     * @return pre:可以在请求被路由之前调用；routing：路由请求时被调用；post：在routing和error过滤器之后被调用；error：处理请求时发送错误时被调用
     */
    @Override
    public String filterType() {
        // 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
        // 1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
        // 2、route：在进行路由请求的时候被调用；
        // 3、post：在路由之后发送请求信息的时候被调用；
        // 4、error：出现错误之后进行调用
        return "pre";
    }

}
