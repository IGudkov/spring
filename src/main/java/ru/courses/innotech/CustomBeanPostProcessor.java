package ru.courses.innotech;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean.getClass().isAnnotationPresent(LogTransformation.class)) {
      String logFileName = bean.getClass().getAnnotation(LogTransformation.class).logFileName();
      ProxyFactory proxyFactory = new ProxyFactory(bean);
      proxyFactory.addAdvice(new LoggingInterceptor(logFileName));
      return proxyFactory.getProxy();
    }
    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
  }

  private record LoggingInterceptor(String logFileName) implements MethodInterceptor {

    @Override
      public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Date dateBegin = new Date();
        String inputArguments = Arrays.toString(methodInvocation.getArguments());

        Object returnValue = methodInvocation.proceed();

        FileOutputStream fileOutputStream = new FileOutputStream(logFileName, true);
        fileOutputStream.write(("\n"
            + dateBegin
            + "; component class name: " + Objects.requireNonNull(methodInvocation.getThis()).getClass()
            + "; method name: " + methodInvocation.getMethod().getName()
            + "; method input data: " + inputArguments
            + "; method returned data: " + (returnValue == null ? "null" : returnValue.toString()))
            .getBytes(StandardCharsets.UTF_8)
        );
        fileOutputStream.close();

        return returnValue;
      }
    }

}
