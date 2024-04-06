package com.github.zdziszkee.verifyjson.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.zdziszkee.verifyjson.model.iamrolepolicy.IAMRolePolicy;
import com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement.PolicyDocument;

import java.io.IOException;

public class PolicyDocumentDeserializer extends JsonDeserializer<PolicyDocument> {

    @Override
    public PolicyDocument deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return null;
    }
}
