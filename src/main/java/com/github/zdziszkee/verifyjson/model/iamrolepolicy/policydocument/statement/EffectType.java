package com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement;

public enum EffectType {
    ALLOW("Allow"),
    DENY("Deny");

    final String value;

    EffectType(String value) {
        this.value = value;
    }
}
