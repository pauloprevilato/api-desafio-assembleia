package br.com.sicredi.apiassembleia.configuration;

import java.util.Locale;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;

@Slf4j
@Getter
public class Message {

    public static final String BASE_NAME = "br.com.sicredi.apiassembleia";

    private MessageSource source;

    private MessageSourceAccessor accessor;

    public Message(final MessageSource source) {
        this.source = source;
        accessor = new MessageSourceAccessor(source, new Locale("pt", "BR"));
    }

    public String get(final Exception exception) {
        if (exception == null) {
            return null;
        }

        String exceptionMessage = exception.getLocalizedMessage() != null ? exception.getLocalizedMessage() : exception.getMessage();

        if (exception.getMessage() != null && exception.getMessage().contains(BASE_NAME)) {
            try {
                return get(exception.getMessage());

            } catch (NoSuchMessageException e) {
                log.debug(e.getMessage(), e);
                return exceptionMessage;
            }
        }

        return exceptionMessage;
    }

    public String get(final String code) {
        return accessor.getMessage(code);
    }

    public String get(final String code, final Object... args) {
        return accessor.getMessage(code, args);
    }

}
