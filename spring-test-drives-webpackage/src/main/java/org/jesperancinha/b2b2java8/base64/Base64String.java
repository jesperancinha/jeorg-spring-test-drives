package org.jesperancinha.b2b2java8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class Base64String {
    private final String stringToEncode;

    Base64String(String stringToDecode) {
        this.stringToEncode = stringToDecode;
    }

    public String getEncoded() {
        return Base64.getEncoder().encodeToString(stringToEncode.getBytes(StandardCharsets.UTF_8));
    }

    public String getDecoded(String stringToDecode) {
        final String localDecodedString = new String(Base64.getDecoder().decode(stringToDecode), StandardCharsets.UTF_8);
        return localDecodedString.equals(this.stringToEncode) ? this.stringToEncode : null;
    }
}

