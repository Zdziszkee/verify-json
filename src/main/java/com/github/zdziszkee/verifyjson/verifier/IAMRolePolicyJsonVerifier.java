package com.github.zdziszkee.verifyjson.verifier;

import com.github.zdziszkee.verifyjson.exception.IAMRolePolicyJsonParsingException;

public interface IAMRolePolicyJsonVerifier {

    boolean verify(String json) throws IAMRolePolicyJsonParsingException;
}
