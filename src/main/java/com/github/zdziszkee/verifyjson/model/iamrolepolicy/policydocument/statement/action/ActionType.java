package com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement.action;

public enum ActionType {
    ACTION("Action"),
    NOT_ACTION("NotAction");
    final String value;

    ActionType(String value) {
        this.value = value;
    }
}
