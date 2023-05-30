package idv.victor.i18nDemo.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@Component
public class HeaderInterceptor extends LocaleChangeInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException {
        String acceptLanguage = request.getHeader("Accept-Language");

        Locale locale = null;
        if(StringUtils.isBlank(acceptLanguage)){
            locale = Locale.forLanguageTag("zh-TW");
        }else {
            locale = Locale.forLanguageTag(acceptLanguage);
        }
        LocaleContextHolder.setLocale(locale);
        return true;
    }
}
