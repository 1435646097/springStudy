package com.paigu.interview.webservice.config;

import com.paigu.interview.webservice.interceptor.OutPutInterceptor;
import com.paigu.interview.webservice.service.UserWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
@Configuration
public class WebServiceConfig {
    @Autowired
    UserWebService userService;
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public Endpoint  endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), userService);
        endpoint.publish("/twmWebService");
        endpoint.getOutInterceptors().add(new OutPutInterceptor());//加入响应前拦截器
        return endpoint;
    }
}
