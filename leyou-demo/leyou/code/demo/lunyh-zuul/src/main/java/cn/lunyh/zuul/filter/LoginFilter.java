package cn.lunyh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器的类型：
     * pre: 请求在被路由之前执行
     * route: 在路由请求时调用
     * post: 在route和errror过滤器之后调用
     * error: 处理请求时发生错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序
     * 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行该过滤器
     * true: 执行
     * false: 不执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取zuul提供的上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 从上下文对象中获取请求对象
        HttpServletRequest request = requestContext.getRequest();

        // 获取token信息
        String token = request.getParameter("token");

        //判断
        if (StringUtils.isBlank(token)){
            //拦截
            requestContext.setSendZuulResponse(false);

            // 设置响应状态码，401 身份未验证
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);

            // 设置响应信息
            requestContext.setResponseBody("{\"status\":\"401\", \"text\":\"request error!\"}");
        }

        // 校验通过，把登陆信息放入上下文信息，继续向后执行
        requestContext.set("token", token);
        return null;
    }
}
