package com.liberty.poker.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 6488496395945903915L;
    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("messages");

    protected String message;
    
    protected Object[] params;
    
    public BusinessException(String aMessage, Object... aParams) {
        if(aMessage == null) {
            throw new IllegalArgumentException();
        }
        if(aParams == null) {
            throw new IllegalArgumentException();
        }
        this.message = aMessage;
        this.params = aParams;
    }
    
    public BusinessException(String aMessage) {
        if(aMessage == null) {
            throw new IllegalArgumentException();
        }
        this.message = aMessage;
    }

    @Override
    public String getMessage() {
        if(this.params == null) {
            return MessageFormat.format(MESSAGES.getString(this.message), new Object[] {}); 
        }
        return MessageFormat.format(MESSAGES.getString(this.message), this.params); 
    }

}
