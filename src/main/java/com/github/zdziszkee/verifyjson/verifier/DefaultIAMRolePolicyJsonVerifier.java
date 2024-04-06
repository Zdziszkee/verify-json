package com.github.zdziszkee.verifyjson.verifier;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DefaultIAMRolePolicyJsonVerifier implements IAMRolePolicyJsonVerifier {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean verify(final String json) {
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
        } catch (Exception exception) {
            //Yes this is a bad practice but also it's the easiest way to satisfy: Method should return logical false if an input JSON Resource field contains a single asterisk and true in any other case.
            //The task description does not specify anything...
            //The correct solution to all of this would be to create model classes for every IAMRolePolicy component, and based on documentation verify if policy structure is correct
            //It is surprising aws sdk does not have unmarshaller for that...
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception occurred while parsing IAMRolePolicy from json: " + exception.getMessage());            // we do not want to lose information about our exception.

        }
        return true;
    }

}
