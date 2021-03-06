package org.jesperancinha.std.flash22.interceptors.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.CYAN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

public class FeelingLoveInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        CYAN.printGenericTitleLn("preHandle called!");
        GREEN.printGenericLn("Drinkin' fine wine");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        CYAN.printGenericTitleLn("postHandle called!");
        GREEN.printGenericLn("If you like the finer things in life");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception) {
        CYAN.printGenericTitleLn("afterCompletion called!");
        GREEN.printGenericLn("Tastes like fine wine");
    }
}