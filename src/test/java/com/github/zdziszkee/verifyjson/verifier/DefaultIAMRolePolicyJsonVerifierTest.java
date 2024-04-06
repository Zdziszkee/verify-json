package com.github.zdziszkee.verifyjson.verifier;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultIAMRolePolicyJsonVerifierTest {
    private final IAMRolePolicyJsonVerifier verifier = new DefaultIAMRolePolicyJsonVerifier();

    @Test
    void verifyCorrectInputWithAsterisk() throws URISyntaxException, IOException {
        assertFalse(verifier.verify(loadJsonFromFile("./correct-input-with-asterisk.json")));
    }

    @Test
    void verifyCorrectInputWithoutAsterisk() throws URISyntaxException, IOException {
        assertTrue(verifier.verify(loadJsonFromFile("./correct-input-without-asterisk.json")));
    }
    @Test
    void verifyEmptyInput() throws URISyntaxException, IOException  {
        assertTrue(verifier.verify(loadJsonFromFile("empty-input.json")));
    }

    @Test
    void verifyMultipleStatementsWithAsteriskInput() throws URISyntaxException, IOException  {
        assertFalse(verifier.verify(loadJsonFromFile("multiple-statements-with-asteriks-input.json")));
    }
    @Test
    void verifyMultipleStatementsWithoutAsteriskInput() throws URISyntaxException, IOException  {
        assertTrue(verifier.verify(loadJsonFromFile("multiple-statements-without-asteriks-input.json")));
    }
    @Test
    void verifyStatementWithoutAsteriskInput() throws URISyntaxException, IOException  {
        assertTrue(verifier.verify(loadJsonFromFile("statement-without-resource-field-input.json")));
    }
    private String loadJsonFromFile(String path) throws IOException, URISyntaxException {

        final URI resource = getClass().getClassLoader().getResource(path).toURI();
        return Files.readString(Paths.get(resource));
    }
}