/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Vera Y. Petrashkova
* @version $Revision$
*/

package tests.api.javax.security.cert;

import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;
import dalvik.annotation.TestTargetClass;

import junit.framework.TestCase;

import javax.security.cert.CertificateNotYetValidException;


/**
 * Tests for <code>DigestException</code> class constructors and methods.
 * 
 */
@TestTargetClass(CertificateNotYetValidException.class)
public class CertificateNotYetValidExceptionTest extends TestCase {

    public static void main(String[] args) {
    }

    /**
     * Constructor for CertificateNotYetValidExceptionTests.
     * 
     * @param arg0
     */
    public CertificateNotYetValidExceptionTest(String arg0) {
        super(arg0);
    }

    static String[] msgs = {
            "",
            "Check new message",
            "Check new message Check new message Check new message Check new message Check new message" };

    static Throwable tCause = new Throwable("Throwable for exception");

    /**
     * Test for <code>CertificateNotYetValidException()</code> constructor
     * Assertion: constructs CertificateNotYetValidException with no detail
     * message
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "CertificateNotYetValidException",
          methodArgs = {}
        )
    })
    public void testCertificateNotYetValidException01() {
        CertificateNotYetValidException tE = new CertificateNotYetValidException();
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>CertificateNotYetValidException(String)</code>
     * constructor Assertion: constructs CertificateNotYetValidException with
     * detail message msg. Parameter <code>msg</code> is not null.
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies CertificateNotYetValidException constructor with " +
            "valid parameters.",
      targets = {
        @TestTarget(
          methodName = "CertificateNotYetValidException",
          methodArgs = {java.lang.String.class}
        )
    })
    public void testCertificateNotYetValidException02() {
        CertificateNotYetValidException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new CertificateNotYetValidException(msgs[i]);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>CertificateNotYetValidException(String)</code>
     * constructor Assertion: constructs CertificateNotYetValidException when
     * <code>msg</code> is null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies  CertificateNotYetValidException constructor with " +
            "null as a parameter.",
      targets = {
        @TestTarget(
          methodName = "CertificateNotYetValidException",
          methodArgs = {java.lang.String.class}
        )
    })
    public void testCertificateNotYetValidException03() {
        String msg = null;
        CertificateNotYetValidException tE = new CertificateNotYetValidException(
                msg);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }
}