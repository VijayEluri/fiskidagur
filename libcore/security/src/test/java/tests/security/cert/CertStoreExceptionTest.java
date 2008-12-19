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

package tests.security.cert;

import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;
import dalvik.annotation.TestTargetClass;

import junit.framework.TestCase;

import java.security.cert.CertStoreException;

/**
 * Tests for <code>CertStoreException</code> class constructors and methods.
 * 
 */
@TestTargetClass(CertStoreException.class)
public class CertStoreExceptionTest extends TestCase {

    public static void main(String[] args) {
    }

    /**
     * Constructor for CertStoreExceptionTests.
     * 
     * @param arg0
     */
    public CertStoreExceptionTest(String arg0) {
        super(arg0);
    }

    private static String[] msgs = {
            "",
            "Check new message",
            "Check new message Check new message Check new message Check new message Check new message" };

    private static Throwable tCause = new Throwable("Throwable for exception");

    /**
     * Test for <code>CertStoreException()</code> constructor Assertion:
     * constructs CertStoreException with no detail message
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {}
        )
    })
    public void testCertStoreException01() {
        CertStoreException tE = new CertStoreException();
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>CertStoreException(String)</code> constructor Assertion:
     * constructs CertStoreException with detail message msg. Parameter
     * <code>msg</code> is not null.
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.String.class}
        )
    })
    public void testCertStoreException02() {
        CertStoreException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new CertStoreException(msgs[i]);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>CertStoreException(String)</code> constructor Assertion:
     * constructs CertStoreException when <code>msg</code> is null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies null asa parameter.",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.String.class}
        )
    })
    public void testCertStoreException03() {
        String msg = null;
        CertStoreException tE = new CertStoreException(msg);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>CertStoreException(Throwable)</code> constructor
     * Assertion: constructs CertStoreException when <code>cause</code> is
     * null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies null as a parameter.",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.Throwable.class}
        )
    })
    public void testCertStoreException04() {
        Throwable cause = null;
        CertStoreException tE = new CertStoreException(cause);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>CertStoreException(Throwable)</code> constructor
     * Assertion: constructs CertStoreException when <code>cause</code> is not
     * null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.Throwable.class}
        )
    })
    public void testCertStoreException05() {
        CertStoreException tE = new CertStoreException(tCause);
        if (tE.getMessage() != null) {
            String toS = tCause.toString();
            String getM = tE.getMessage();
            assertTrue("getMessage() should contain ".concat(toS), (getM
                    .indexOf(toS) != -1));
        }
        assertNotNull("getCause() must not return null", tE.getCause());
        assertEquals("getCause() must return ".concat(tCause.toString()), tE
                .getCause(), tCause);
    }

    /**
     * Test for <code>CertStoreException(String, Throwable)</code> constructor
     * Assertion: constructs CertStoreException when <code>cause</code> is
     * null <code>msg</code> is null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies null as parameters.",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.String.class, java.lang.Throwable.class}
        )
    })
    public void testCertStoreException06() {
        CertStoreException tE = new CertStoreException(null, null);
        assertNull("getMessage() must return null", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>CertStoreException(String, Throwable)</code> constructor
     * Assertion: constructs CertStoreException when <code>cause</code> is
     * null <code>msg</code> is not null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies null as the second parameter.",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.String.class, java.lang.Throwable.class}
        )
    })
    public void testCertStoreException07() {
        CertStoreException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new CertStoreException(msgs[i], null);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>CertStoreException(String, Throwable)</code> constructor
     * Assertion: constructs CertStoreException when <code>cause</code> is not
     * null <code>msg</code> is null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies null as the first parameter.",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.String.class, java.lang.Throwable.class}
        )
    })
    public void testCertStoreException08() {
        CertStoreException tE = new CertStoreException(null, tCause);
        if (tE.getMessage() != null) {
            String toS = tCause.toString();
            String getM = tE.getMessage();
            assertTrue("getMessage() must should ".concat(toS), (getM
                    .indexOf(toS) != -1));
        }
        assertNotNull("getCause() must not return null", tE.getCause());
        assertEquals("getCause() must return ".concat(tCause.toString()), tE
                .getCause(), tCause);
    }

    /**
     * Test for <code>CertStoreException(String, Throwable)</code> constructor
     * Assertion: constructs CertStoreException when <code>cause</code> is not
     * null <code>msg</code> is not null
     */
    @TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Verifies positive case.",
      targets = {
        @TestTarget(
          methodName = "CertStoreException",
          methodArgs = {java.lang.String.class, java.lang.Throwable.class}
        )
    })
    public void testCertStoreException09() {
        CertStoreException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new CertStoreException(msgs[i], tCause);
            String getM = tE.getMessage();
            String toS = tCause.toString();
            if (msgs[i].length() > 0) {
                assertTrue("getMessage() must contain ".concat(msgs[i]), getM
                        .indexOf(msgs[i]) != -1);
                if (!getM.equals(msgs[i])) {
                    assertTrue("getMessage() should contain ".concat(toS), getM
                            .indexOf(toS) != -1);
                }
            }
            assertNotNull("getCause() must not return null", tE.getCause());
            assertEquals("getCause() must return ".concat(tCause.toString()),
                    tE.getCause(), tCause);
        }
    }
}