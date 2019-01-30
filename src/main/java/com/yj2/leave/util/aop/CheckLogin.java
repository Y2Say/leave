package com.yj2.leave.util.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 验证登录状态
 */
@Log4j2
@Aspect
@Order(1)
@Component("com.yj2.demo.util.aop.CheckLogin")
public class CheckLogin {


   /* @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserMapper userMapper;

    @Pointcut("execution(public * com.yj2.demo.controller.*.*(..))")
    public void check() {

    }

    @Around("check()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        //log.debug("检查session");
        boolean isCheck;
        boolean require;

        Signature signature = pjp.getSignature();
        // 获取类上的注解
        RequireLogin classAnnotation = (RequireLogin) signature.getDeclaringType().getAnnotation(RequireLogin.class);

        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        // 获取方法上的注解
        RequireLogin methodAnnotation = targetMethod.getAnnotation(RequireLogin.class);
        if (methodAnnotation == null && classAnnotation == null) {
            return pjp.proceed();
        }
        // 如果方法上没有注解，以类上注解为准
        if (methodAnnotation == null) {
            isCheck = classAnnotation.check();
            require = classAnnotation.require();
        } else {
            // 如果方法上有注解，以方法注解为准
            isCheck = methodAnnotation.check();
            require = methodAnnotation.require();
        }
        // 如果不需要检查，就放过
        if (!isCheck) {
            return pjp.proceed();
        }
        String token1 = request.getHeader("x-auth-token");
        if (StringUtils.isEmpty(token1)) {
            if (require) {
                throw new ServiceException(ExceptionEnum.ERROR_TOKEN);
            } else {
                session.removeAttribute("user_id");
                return pjp.proceed();
            }
        }
        User account = userMapper.selectByPrimaryKey(token1);
        if (account != null) {
            if (require) {
                throw new ServiceException(ExceptionEnum.ERROR_TOKEN);
            } else {
                session.removeAttribute("user_id");
                return pjp.proceed();
            }
        }

        String claims = TokenUtil.getaccountIdByToken(token1);
        if (StringUtils.isEmpty(claims)) {//验证失败
            if (require) {
                throw new ServiceException(ExceptionEnum.ERROR_TOKEN);
            } else {
                session.removeAttribute("user_id");
                return pjp.proceed();
            }
        }
        session.setAttribute("user_id", claims);
        return pjp.proceed();
    }*/

}
