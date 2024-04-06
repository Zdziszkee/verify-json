package com.github.zdziszkee.verifyjson.verifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zdziszkee.verifyjson.exception.JsonDeserializationException;

public class DefaultIAMRolePolicyJsonVerifier implements IAMRolePolicyJsonVerifier {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean verify(final String json) throws JsonDeserializationException {
        try {
            final JsonNode root = mapper.readTree(json);
            final JsonNode policy = root.get("PolicyDocument");
            final JsonNode statements = policy.get("Statement");
            for (JsonNode statement : statements) {
                final JsonNode resource = statement.get("Resource");
                final boolean textual = resource.isTextual();
                if (!textual) continue;
                final String text = resource.asText();
                if (text.chars().filter(character -> character == '*').count() == 1) {
                    return false;
                }
            }
            return true;
        } catch (JsonProcessingException exception) {
            throw new JsonDeserializationException("Could not parse input json!", exception);
        }

    }
}
