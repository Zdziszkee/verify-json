package com.github.zdziszkee.verifyjson.verifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IAMRolePolicyJsonVerifier implements JsonVerifier {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean verify(String json) {

        try {
            JsonNode root = mapper.readTree(json);

        } catch (JsonProcessingException exception) {
            return true;
        }
        return false;
    }
}
