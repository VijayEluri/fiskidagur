/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.harmony.luni.tests.java.util;

import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;
import dalvik.annotation.TestTargetClass;

import junit.framework.TestCase;

import java.io.Serializable;
import java.util.IllegalFormatPrecisionException;

import org.apache.harmony.testframework.serialization.SerializationTest;
import org.apache.harmony.testframework.serialization.SerializationTest.SerializableAssert;

@TestTargetClass(IllegalFormatPrecisionException.class) 
public class IllegalFormatPrecisionExceptionTest extends TestCase {

    /**
     * @tests java.util.IllegalFormatPrecisionException#IllegalFormatPrecisionException(int)
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "IllegalFormatPrecisionException",
          methodArgs = {int.class}
        )
    })
    public void test_illegalFormatPrecisionException() {
        IllegalFormatPrecisionException illegalFormatPrecisionException = new IllegalFormatPrecisionException(
                Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, illegalFormatPrecisionException
                .getPrecision());
    }

    /**
     * @tests java.util.IllegalFormatPrecisionException#getPrecision()
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "getPrecision",
          methodArgs = {}
        )
    })
    public void test_getPrecision() {
        int precision = 12345;
        IllegalFormatPrecisionException illegalFormatPrecisionException = new IllegalFormatPrecisionException(
                precision);
        assertEquals(precision, illegalFormatPrecisionException.getPrecision());
    }

    /**
     * @tests method for 'java.util.IllegalFormatPrecisionException#getMessage()
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "getMessage",
          methodArgs = {}
        )
    })
    public void test_getMessage() {
        int precision = 12345;
        IllegalFormatPrecisionException illegalFormatPrecisionException = new IllegalFormatPrecisionException(
                precision);
        assertTrue(null != illegalFormatPrecisionException.getMessage());

    }

    // comparator for IllegalFormatPrecisionException objects
    private static final SerializableAssert exComparator = new SerializableAssert() {
        public void assertDeserialized(Serializable initial,
                Serializable deserialized) {

            SerializationTest.THROWABLE_COMPARATOR.assertDeserialized(initial,
                    deserialized);

            IllegalFormatPrecisionException initEx = (IllegalFormatPrecisionException) initial;
            IllegalFormatPrecisionException desrEx = (IllegalFormatPrecisionException) deserialized;

            assertEquals("Precision", initEx.getPrecision(), desrEx
                    .getPrecision());
        }
    };

    /**
     * @tests serialization/deserialization.
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "!SerializationSelf",
          methodArgs = {}
        )
    })
    public void testSerializationSelf() throws Exception {

        SerializationTest.verifySelf(
                new IllegalFormatPrecisionException(12345), exComparator);
    }

    /**
     * @tests serialization/deserialization compatibility with RI.
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "!SerializationGolden",
          methodArgs = {}
        )
    })
    public void testSerializationCompatibility() throws Exception {

        SerializationTest.verifyGolden(this,
                new IllegalFormatPrecisionException(12345), exComparator);
    }
}