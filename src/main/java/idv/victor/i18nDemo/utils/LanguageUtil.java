package idv.victor.i18nDemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 用於操作 i18n 相關函數
 */
@Component
public class LanguageUtil {

    /**
     * 轉換 i18n 的訊息
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * 依照現在語系取得字幕檔
     * @param messageKey 鍵值
     * @return 字幕
     */
    public String getMessage(String messageKey){
        return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
    }

    /**
     * 依照現在語系取得字幕檔
     * @param messageKey 鍵值
     * @param params 參數
     * @return 字幕
     */
    public String getMessage(String messageKey, String... params){
        return messageSource.getMessage(messageKey, params, LocaleContextHolder.getLocale());
    }
}
