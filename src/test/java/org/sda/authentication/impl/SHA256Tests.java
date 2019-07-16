package org.sda.authentication.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.sda.authentication.HashFunction;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SHA256Tests {
    private String expectedResult;
    private String password;
    private HashFunction hashFunction;

    @Before
    public void initialize() {
        hashFunction = new SHA256();
    }

    public SHA256Tests(String expectedResult, String password) {
        this.expectedResult = expectedResult;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection passwordsAndHashes() {
        return Arrays.asList(new Object[][] {
                {"795C39095A8246649702A26BF05E9F0EFAD914A72A4B37FBDD2A832F3CEB0455".toLowerCase(), "tomasz"},
                {"78BB556ED17425F6091384D51615BFA69B8902228DC2693FD5DA801EA175236F".toLowerCase(), "tomasz20"},
                {"EBD222531C6ADE7721212766CAB4857F5C48B4F89B833734C9326BA7588D395F".toLowerCase(), "--00(^"},
                {"81EE8CF90A80DD1D98CBAC3C4BABFB1B7BDADCFF6DE569CCDCF7D855B2A85036".toLowerCase(), "KAduCEusz"}
        });
    }

    @Test
    public void testHashPassword() {
        String hashPass = hashFunction.hashPassword(password);
        assertEquals(expectedResult, hashPass);
    }
}
