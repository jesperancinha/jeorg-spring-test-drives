package com.steelzack.b2b2java8.base64;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class Base64StringTest {
    private static final String THIS_IS_MY_TEST_STRING = "This is my test string";
    private static final String VGHPCY_BPCY_BTE_SB0_ZXN0_IHN0CMLU_ZW = "VGhpcyBpcyBteSB0ZXN0IHN0cmluZw==";

    @Test
    public void getEncoded() throws Exception {
        final Base64String string64 = new Base64String(THIS_IS_MY_TEST_STRING);

        final String result = string64.getEncoded();

        assertEquals(VGHPCY_BPCY_BTE_SB0_ZXN0_IHN0CMLU_ZW, result);
    }

    @Test
    public void getDecoded() throws Exception {
        final Base64String string64 = new Base64String(THIS_IS_MY_TEST_STRING);

        final String result = string64.getDecoded(VGHPCY_BPCY_BTE_SB0_ZXN0_IHN0CMLU_ZW);

        assertEquals(THIS_IS_MY_TEST_STRING, result);
    }

}