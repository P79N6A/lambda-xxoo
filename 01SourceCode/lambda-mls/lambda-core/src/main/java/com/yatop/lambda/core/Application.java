 package com.yatop.lambda.core;

 import org.springframework.beans.factory.BeanCreationException;
 import org.springframework.boot.Banner.Mode;
 import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
 import org.springframework.boot.builder.SpringApplicationBuilder;
 import org.springframework.context.annotation.ComponentScan;

 @EnableAutoConfiguration
 @ComponentScan
 public class Application {
     public static void main(String[] args) {
         try {
            new SpringApplicationBuilder().bannerMode(Mode.OFF).sources(Application.class).run(args);
         } catch (BeanCreationException e) {
             System.err.println("请检查是否已正确配置应用");
             e.printStackTrace();
        }
     }
 }
