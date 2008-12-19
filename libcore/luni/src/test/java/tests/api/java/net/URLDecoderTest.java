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

package tests.api.java.net;

import dalvik.annotation.TestTargetClass; 
import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import tests.support.Support_Configuration;

@TestTargetClass(URLDecoder.class) 
public class URLDecoderTest extends junit.framework.TestCase {

    /**
     * @tests java.net.URLDecoder#URLDecoder()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "URLDecoder",
          methodArgs = {}
        )
    })
    public void test_Constructor() throws Exception {
        URLDecoder ud = new URLDecoder();
        assertNotNull("Constructor failed.", ud);
    }

    /**
     * @tests java.net.URLDecoder#decode(java.lang.String)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "decode",
          methodArgs = {java.lang.String.class}
        )
    })
    public void test_decodeLjava_lang_String() throws Exception {
        // Test for method java.lang.String
        // java.net.URLDecoder.decode(java.lang.String)
        final String URL = "http://" + Support_Configuration.HomeAddress;
        final String URL2 = "telnet://justWantToHaveFun.com:400";
        final String URL3 = "file://myServer.org/a file with spaces.jpg";
        assertTrue("1. Incorrect encoding/decoding", URLDecoder.decode(
                URLEncoder.encode(URL)).equals(URL));
        assertTrue("2. Incorrect encoding/decoding", URLDecoder.decode(
                URLEncoder.encode(URL2)).equals(URL2));
        assertTrue("3. Incorrect encoding/decoding", URLDecoder.decode(
                URLEncoder.encode(URL3)).equals(URL3));
    }

    /**
     * @tests java.net.URLDecoder#decode(java.lang.String, java.lang.String)
     */
@TestInfo(
      level = TestLevel.PARTIAL,
      purpose = "Regression test",
      targets = {
        @TestTarget(
          methodName = "decode",
          methodArgs = {java.lang.String.class, java.lang.String.class}
        )
    })
    public void test_decodeLjava_lang_String_Ljava_lang_String() {
        // Regression for HARMONY-467
        try {
            URLDecoder.decode("", "");
            fail("UnsupportedEncodingException expected");
        } catch (UnsupportedEncodingException e) {
        }
    }
}