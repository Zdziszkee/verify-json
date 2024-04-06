package com.github.zdziszkee.verifyjson.verifier;

import com.github.zdziszkee.verifyjson.exception.InvalidIAMRolePolicyException;
import com.github.zdziszkee.verifyjson.exception.JsonDeserializationException;

public interface IAMRolePolicyJsonVerifier {

    boolean verify(String json) throws JsonDeserializationException, InvalidIAMRolePolicyException;
}
