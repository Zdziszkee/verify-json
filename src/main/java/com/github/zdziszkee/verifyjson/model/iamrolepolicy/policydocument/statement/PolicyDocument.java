package com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.zdziszkee.verifyjson.deserializer.PolicyDocumentDeserializer;
import com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.Version;
import com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement.action.Action;

import java.util.List;
import java.util.Optional;

@JsonDeserialize(using = PolicyDocumentDeserializer.class)
public record PolicyDocument(Version version, Statement statement, Optional<Principal> principal, List<Action> actions, Optional<Resource> resource, Optional<Condition> condition) {

}
