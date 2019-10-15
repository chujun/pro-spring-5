package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
        //MessageDigestFactoryBean messageDigestFactoryBean1 = (MessageDigestFactoryBean) ctx.getBean("messageDigestFactoryBean");
        //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'messageDigestFactoryBean' available

        //访问产生bean的factory bean: &beanName
        MessageDigestFactoryBean messageDigestFactoryBean2 = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        ctx.close();
    }
}
