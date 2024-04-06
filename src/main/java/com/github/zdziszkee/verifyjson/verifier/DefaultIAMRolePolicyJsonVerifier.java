package com.github.zdziszkee.verifyjson.verifier;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zdziszkee.verifyjson.exception.IAMRolePolicyJsonParsingException;

public class DefaultIAMRolePolicyJsonVerifier implements IAMRolePolicyJsonVerifier {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean verify(final String json) throws IAMRolePolicyJsonParsingException {
        try {
            final JsonNode root = mapper.readTree(json);
            final JsonNode document = root.get("PolicyDocument");
            final JsonNode statements = document.get("Statement");
            for (JsonNode statement : statements) {
                final String resource = statement.get("Resource").asText();
                final long asterisks = resource.chars().filter(character -> character == '*').count();
                if (asterisks == 1) {
                    return false;
                }
            }
            return true;
        } catch (JsonProcessingException exception) {
            throw new IAMRolePolicyJsonParsingException("Could not parse json into IAMRolePolicy!", exception);
        }
    }
}
