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
* @author Alexey V. Varlamov
* @version $Revision$
*/

package org.apache.harmony.security.tests.java.security;

import dalvik.annotation.TestTargetClass;
import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;

import java.security.Guard;
import java.security.GuardedObject;

import junit.framework.TestCase;
@TestTargetClass(GuardedObject.class)
/**
 * Tests for <code>GuardedObject</code>
 * 
 */

public class GuardedObjectTest extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(GuardedObjectTest.class);
    }

    /** Null guard imposes no restriction. */
    @TestInfo(
      level = TestLevel.PARTIAL,
      purpose = "Haven't separate case for getObject() method",
      targets = {
        @TestTarget(
          methodName = "GuardedObject",
          methodArgs = {Object.class, Guard.class}
        )
    })
    public void testNoGuard() {
        Object obj = null;
        GuardedObject go = new GuardedObject(obj, null);
        assertNull(go.getObject());

        obj = "ewte rtw3456";
        go = new GuardedObject(obj, null);
        assertEquals(obj, go.getObject());
    }

    /** Test real guard can both allow and deny access. */
    @TestInfo(
      level = TestLevel.PARTIAL,
      purpose = "Haven't separate case for getObject() method",
      targets = {
        @TestTarget(
          methodName = "GuardedObject",
          methodArgs = {Object.class, Guard.class}
        )
    })
    public void testGuard() {
        final String message = "test message";
        final StringBuffer objBuffer = new StringBuffer("235345 t");
        GuardedObject go = new GuardedObject(objBuffer, new Guard() {

            public void checkGuard(Object object) throws SecurityException {
                if (object == objBuffer && objBuffer.length() == 0) {
                    throw new SecurityException(message);
                }
            }
        });
        assertEquals(objBuffer, go.getObject());

        objBuffer.setLength(0);
        try {
            go.getObject();
            fail("SecurityException is not thrown");
        } catch (Exception ok) {
            assertEquals(message, ok.getMessage());
        }
    }
}