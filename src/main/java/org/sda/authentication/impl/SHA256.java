package org.sda.authentication.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.sda.authentication.HashFunction;

public class SHA256 implements HashFunction {

    @Override
    public String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
