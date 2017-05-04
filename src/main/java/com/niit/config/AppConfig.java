package com.niit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.niit")
public class AppConfig extends WebMvcConfigurerAdapter {
	/*public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/WEB-INF/resources/");
		
		}
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getMultipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(20971520);
		commonsMultipartResolver.setMaxInMemorySize(1058576);
		return getMultipartResolver();
		
	}*/
	@Bean
    public ViewResolver viewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".html");
        
        return viewResolver;
    }
 
 //MultiPart Resolver
 @Bean(name="multipartResolver") 
 public MultipartResolver getMultiResolver(){
	 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
	 return multipartResolver;
 }
 @Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	}
