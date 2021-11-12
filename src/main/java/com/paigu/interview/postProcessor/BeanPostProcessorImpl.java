package com.paigu.interview.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * spring容器初始bean的增强器
 *
 * @author LiaoXM
 * @date 2021/11/12
 */
@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
//		System.out.println(String.format("初始化了 bean名称:%s,bean全名称:%s", beanName, bean));
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
}
