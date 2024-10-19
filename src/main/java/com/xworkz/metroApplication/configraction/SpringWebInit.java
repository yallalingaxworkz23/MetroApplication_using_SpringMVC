package com.xworkz.metroApplication.configraction;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("invoking in the getRootConfigClasses....");
		System.out.println("invoking in the rootConfigraction...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
         log.info("invoking in the getServletConfigClasses...");
		return new Class [] {BeanConfigraction.class};
	}

	@Override
	protected String[] getServletMappings() {
      log.info("invoking in the getServletMapping..");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		log.info("invoking in the configureDefaultServletHandiling...");
	configurer.enable();
	}
	
	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB

        // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

        registration.setMultipartConfig(multipartConfigElement);

    }


}
