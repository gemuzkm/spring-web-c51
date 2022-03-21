package by.tms.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        if (request.getSession().getAttribute("user") != null) {
////            return true;
////        }
//// //       response.sendRedirect("/");
////        return false;
//        return true;
//    }
}
