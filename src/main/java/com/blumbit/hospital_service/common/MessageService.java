package com.blumbit.hospital_service.common;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final MessageSource messageSource;

    
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageCode){
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    public String configMessage(String messageCode, Object[] args){
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }

}
