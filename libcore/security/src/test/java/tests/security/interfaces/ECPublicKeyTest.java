/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tests.security.interfaces;
import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;
import dalvik.annotation.TestTargetClass;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

@TestTargetClass(ECPublicKey.class)
public class ECPublicKeyTest extends TestCase {
    
    /**
     * @tests java.security.interfaces.ECPublicKey 
     * #getW()
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "getW",
          methodArgs = {}
        )
    })
    @SuppressWarnings("serial")
    public void test_getW() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("EC", Util.prov);
        gen.initialize(Util.ecParam, new SecureRandom(new MySecureRandomSpi(),
                null) {
        });
        ECPublicKey key = (ECPublicKey) gen.generateKeyPair().getPublic();
        assertECPointEquals(new ECPoint(BigInteger.valueOf(4),
                BigInteger.valueOf(15)), key.getW());
    }

    private void assertECPointEquals(ECPoint expected, ECPoint actual) {
        assertEquals("X coordiates are different", expected.getAffineX(),
                actual.getAffineX());
        assertEquals("Y coordiates are different", expected.getAffineY(),
                actual.getAffineY());
    }
}