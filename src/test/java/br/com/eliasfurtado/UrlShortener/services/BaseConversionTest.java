package br.com.eliasfurtado.UrlShortener.services;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


public class BaseConversionTest {

    private BaseConversion baseConversion = new BaseConversion();

    @Test
    public void encode_0() {
        assertEquals("a", baseConversion.encode(0));
    }

    @Test
    public void encode_lessThan62() {
        assertEquals("k", baseConversion.encode(10));
    }

    @Test
    public void encode_moreThan62() {
        assertEquals("bq", baseConversion.encode(78));
    }

    @Test
    public void decode_singleCharacter() {
        assertEquals(11, baseConversion.decode("l"));
    }
}