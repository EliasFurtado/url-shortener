package br.com.eliasfurtado.UrlShortener.services;

import org.springframework.stereotype.Service;

@Service
public class BaseConversion {
    private final String allowedString = "0123456789ABCDEFGHIKJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final char[] allowedCharacters = allowedString.toCharArray();
    private final int base = allowedCharacters.length;

    public String encode(long input) {
        var encodedString = new StringBuilder();

        if(input == 0) {
            return String.valueOf(allowedCharacters[0]);
        }

        while(input > 0) {
            encodedString.append(String.valueOf((int) input % base));
            input = input / base;
        }

        return encodedString.reverse().toString();
    }

    public long decode (String input) {
        char[] characters = input.toCharArray();
        int length = characters.length;

        int decoded = 0;

        int counter = 1;

        for (int i = 0; i < length; i++) {
            decoded += allowedString.indexOf(characters[i]) * Math.pow(base, length - counter);
            counter++;
        }
        return decoded;
    }

}
