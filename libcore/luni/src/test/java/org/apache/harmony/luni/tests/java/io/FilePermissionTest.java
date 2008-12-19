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

package org.apache.harmony.luni.tests.java.io;

import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;
import dalvik.annotation.TestTargetClass;

import java.io.File;
import java.io.FilePermission;

import junit.framework.TestCase;
@TestTargetClass(FilePermission.class)
public class FilePermissionTest extends TestCase {

    /**
     * @tests java.io.FilePermission#implies(java.security.Permission)
     */
    @TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "implies",
          methodArgs = {java.security.Permission.class}
        )
    })
    public void test_impliesLjava_io_FilePermission() {
        // Regression for HARMONY-47
        char separator = File.separatorChar;
        char nonSeparator = (separator == '/') ? '\\' : '/';

        FilePermission fp1 = new FilePermission(nonSeparator + "*", "read");
        FilePermission fp2 = new FilePermission(separator + "a", "read");
        assertFalse("Assert 0: non-separator worked", fp1.implies(fp2));
        fp1 = new FilePermission(nonSeparator + "-", "read");
        assertFalse("Assert 1: non-separator worked", fp1.implies(fp2));
    }
}