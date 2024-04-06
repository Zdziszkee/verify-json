package com.github.zdziszkee.verifyjson.exception;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonLocation;

public class JsonDeserializationException extends JacksonException {
    public JsonDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public JsonLocation getLocation() {
        return null;
    }

    @Override
    public String getOriginalMessage() {
        return null;
    }

    @Override
    public Object getProcessor() {
        return null;
    }
}
