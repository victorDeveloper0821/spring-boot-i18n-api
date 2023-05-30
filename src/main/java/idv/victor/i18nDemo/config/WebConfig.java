package idv.victor.i18nDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC 設定
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 讀取 Accept-Languange 並 assign 語系至 LocaleContextHolder
     */
    @Autowired
    private HeaderInterceptor localeInterceptor;

    /**
     * 註冊 interceptor
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor).addPathPatterns("/**");
    }
}
