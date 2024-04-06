package com.github.zdziszkee.verifyjson.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zdziszkee.verifyjson.exception.JsonDeserializationException;
import com.github.zdziszkee.verifyjson.model.iamrolepolicy.IAMRolePolicy;
import com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement.PolicyDocument;

import java.io.IOException;

public class IAMRolePolicyDeserializer extends JsonDeserializer<IAMRolePolicy> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public IAMRolePolicy deserialize(JsonParser parser, DeserializationContext context) throws JsonDeserializationException {
        try {
            JsonNode root = parser.getCodec().readTree(parser);
            return null;
        } catch (IOException e) {
            throw new JsonDeserializationException("Could not deserialize json!",e);
        }
    }
}
