/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests.api.javax.xml.parsers;

import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;
import dalvik.annotation.TestTargetClass;

import junit.framework.TestCase;

import javax.xml.parsers.ParserConfigurationException;

@TestTargetClass(ParserConfigurationException.class) 
public class ParserConfigurationExceptionTest extends TestCase{

    /**
     * @tests javax.xml.parsers.ParserConfigurationException#ParserConfigurationException()
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "ParserConfigurationException",
          methodArgs = {}
        )
    })
    public void test_Constructor() {
        ParserConfigurationException pce = new ParserConfigurationException();
        assertNull(pce.getMessage());
        assertNull(pce.getLocalizedMessage());
        assertNull(pce.getCause());
    }

    /**
     * @tests javax.xml.parsers.ParserConfigurationException
     *     #ParserConfigurationException(java.lang.String)
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "ParserConfigurationException",
          methodArgs = {java.lang.String.class}
        )
    })
    public void test_ConstructorLjava_lang_String() {
        ParserConfigurationException pce =
            new ParserConfigurationException("fixture");
        assertEquals("fixture", pce.getMessage());
        assertEquals("fixture", pce.getLocalizedMessage());
        assertNull(pce.getCause());
    }
}