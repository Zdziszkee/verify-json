package com.github.zdziszkee.verifyjson.verifier;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IAMRolePolicyJsonVerifierTest {
    private final JsonVerifier verifier = new IAMRolePolicyJsonVerifier();

    @Test
    void verifyCorrectInputWithAsterisk() throws URISyntaxException, IOException {
        final URI resource = getClass().getClassLoader().getResource("correct-input-with-asterisk.json").toURI();
        String json = Files.readString(Paths.get(resource));

        assertFalse(verifier.verify(json));
    }

    @Test
    void verifyCorrectInputWithoutAsterisk() throws URISyntaxException, IOException {
        final URI resource = getClass().getClassLoader().getResource("./correct-input-without-asterisk.json").toURI();
        String json = Files.readString(Paths.get(resource));

        assertTrue(verifier.verify(json));
    }
}