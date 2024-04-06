package com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement;

import java.util.Optional;

public record Statement(Optional<String> sid, EffectType effectType, Principal principal) {
}
