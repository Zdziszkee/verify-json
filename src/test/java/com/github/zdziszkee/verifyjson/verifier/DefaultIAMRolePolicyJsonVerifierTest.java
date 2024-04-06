package com.github.zdziszkee.verifyjson.verifier;

import com.github.zdziszkee.verifyjson.exception.IAMRolePolicyJsonParsingException;
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
    void verifyCorrectInputWithAsterisk() throws URISyntaxException, IOException, IAMRolePolicyJsonParsingException {
        assertFalse(verifier.verify(loadJsonFromFile("./correct-input-with-asterisk.json")));
    }

    @Test
    void verifyCorrectInputWithoutAsterisk() throws URISyntaxException, IOException, IAMRolePolicyJsonParsingException {
        assertTrue(verifier.verify(loadJsonFromFile("./correct-input-without-asterisk.json")));
    }

    private String loadJsonFromFile(String path) throws IOException, URISyntaxException {

        final URI resource = getClass().getClassLoader().getResource(path).toURI();
        return Files.readString(Paths.get(resource));
    }
}