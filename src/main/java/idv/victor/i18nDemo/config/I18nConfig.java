package idv.victor.i18nDemo.config;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 設定 i18n 設定
 */
@Configuration
public class I18nConfig {

    /**
     * Application 支持的語系
     */
    @Value(value = "${locale.supported}")
    private List<String> supportLocales;

    /**
     * Application default 的語系
     */
    @Value(value = "${locale.default}")
    private String defaultLocale;

    /**
     * 解析當前 application 的語系
     * @return
     */
    @Bean
    public LocaleResolver getLocaleResolver(){
        CustomLocaleResolver localeResolver = new CustomLocaleResolver();
        localeResolver.setDefaultLocale(LocaleUtils.toLocale(defaultLocale));
        localeResolver.setSupportedLocales(supportLocales.stream().map(l-> LocaleUtils.toLocale(l)).collect(Collectors.toList()));
        return localeResolver;
    }

    /**
     * 讀取語系檔
     * @return
     */
    @Bean(name="messageSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18n/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
