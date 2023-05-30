package idv.victor.i18nDemo.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

/**
 * 客製化 i18n LocalResolver 切換語系
 */
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String AcceptLang = request.getHeader("Accept-Language");
        if (StringUtils.isEmpty(AcceptLang)) {
            LocaleContextHolder.setLocale(getDefaultLocale());
            return getDefaultLocale();
        }
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(AcceptLang);
        Locale locale = Locale.lookup(list,getSupportedLocales());
        if (locale == null) {
            LocaleContextHolder.setLocale(getDefaultLocale());
            return getDefaultLocale();
        }
        LocaleContextHolder.setLocale(locale);
        return locale;
    }

}
