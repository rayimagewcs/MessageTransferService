package com.thinvent.message.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.log4j.Log4j;

@Configuration
@Log4j
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new HandlerInterceptor() {

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				String subToken = request.getHeader("subToken");
//				String secritMessage = request.getHeader("secritMessage");
//				PrivateKey privateKey = SecritKeyConfig.getPrivateKey(Constants.PRIVATEKEY);
//				String Message = new String(SecritKeyConfig.decrypt(privateKey, SecritKeyConfig.decode(secritMessage)));
//				String token = subToken + "." + Message;
				//判断是否携带token
	        	/*if(null != subToken && !"".equals(subToken)){
	        		try {
		        		//验证token合法性
	        			//Claims claims = JWTConfig.parseJWT(tokenIn);
	        			
						return true;
					} catch (Exception e) {
		        		//token不合法
						log.info(e.getMessage());
						response.sendError(TvtExceptionEnum.DATA_VER_RELOAD_ERROR.getIndex(), TvtExceptionEnum.DATA_VER_RELOAD_ERROR.getName());
					}
	        	}
	        	return false;*/
				return true;
			}

			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub
			}

			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
				// TODO Auto-generated method stub
			}

		}).addPathPatterns("/**")
		.excludePathPatterns("/error")
		.excludePathPatterns("/v2/**")
		.excludePathPatterns("/swagger*/**");
		super.addInterceptors(registry);
	}

}
