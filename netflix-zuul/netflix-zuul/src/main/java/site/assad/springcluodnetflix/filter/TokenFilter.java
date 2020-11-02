package site.assad.springcluodnetflix.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul Filter 自定义过滤器
 *
 * @author yulinying
 * @since 2020/11/2
 */
public class TokenFilter extends ZuulFilter {
    
    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    
    /**
     * 过滤器类型
     */
    @Override
    public String filterType() {
        return "pre";
    }
    
    /**
     * filter 执行顺序，通过数字指定，数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 1;
    }
    
    /**
     * 是否执行该过滤器，此处为true，说明需要过滤
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        return request.getRequestURI().contains("/info");
    }
    
    /**
     * 过滤器逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(">>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());
        // 获取请求的参数
        String token = request.getParameter("token");
        // token 为空，阻止路由
        if (!StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
        return null;
    }
}
