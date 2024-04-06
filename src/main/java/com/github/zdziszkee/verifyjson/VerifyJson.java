package com.github.zdziszkee.verifyjson;


import com.github.zdziszkee.verifyjson.verifier.DefaultIAMRolePolicyJsonVerifier;
import com.github.zdziszkee.verifyjson.verifier.IAMRolePolicyJsonVerifier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VerifyJson {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You need to provide path to json file you want to verify!");
            System.exit(1);
        }

        final String file = args[0];
        try {
            final String json = Files.readString(Paths.get(file));
            IAMRolePolicyJsonVerifier verifier = new DefaultIAMRolePolicyJsonVerifier();
            final boolean result = verifier.verify(json);
            System.out.println("Verify result: " + result);
        } catch (IOException exception) {
            System.out.println("Could not load file with path: " + file);
            System.exit(1);
        }
    }
}