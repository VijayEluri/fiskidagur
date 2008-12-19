/* 
 * Licensed to the Apache Software Foundation (ASF) under one or more
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

package org.apache.harmony.archive.tests.java.util.jar;

import dalvik.annotation.TestTargetClass; 
import dalvik.annotation.TestInfo;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTarget;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import junit.framework.TestCase;

@TestTargetClass(Attributes.class) 
public class AttributesTest extends TestCase {
    private Attributes a;

    @Override
    protected void setUp() {
        a = new Attributes();
        a.putValue("1", "one");
        a.putValue("2", "two");
        a.putValue("3", "three");
        a.putValue("4", "four");
    }

    /**
     * @tests java.util.jar.Attributes#Attributes(java.util.jar.Attributes)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "Attributes",
          methodArgs = {java.util.jar.Attributes.class}
        )
    })
    public void test_ConstructorLjava_util_jar_Attributes() {
        Attributes a2 = new Attributes(a);
        assertEquals(a, a2);
        a.putValue("1", "one(1)");
        assertTrue("equal", !a.equals(a2));
    }

    /**
     * @tests java.util.jar.Attributes#clear()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "clear",
          methodArgs = {}
        )
    })
    public void test_clear() {
        a.clear();
        assertNull("a) All entries should be null after clear", a.get("1"));
        assertNull("b) All entries should be null after clear", a.get("2"));
        assertNull("c) All entries should be null after clear", a.get("3"));
        assertNull("d) All entries should be null after clear", a.get("4"));
        assertTrue("Should not contain any keys", !a.containsKey("1"));
    }

    /**
     * @tests java.util.jar.Attributes#containsKey(java.lang.Object)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "containsKey",
          methodArgs = {java.lang.Object.class}
        )
    })
    public void test_containsKeyLjava_lang_Object() {
        assertTrue("a) Should have returned false", !a.containsKey(new Integer(1)));
        assertTrue("b) Should have returned false", !a.containsKey("0"));
        assertTrue("Should have returned true", a.containsKey(new Attributes.Name("1")));
    }

    /**
     * @tests java.util.jar.Attributes#containsValue(java.lang.Object)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "containsValue",
          methodArgs = {java.lang.Object.class}
        )
    })
    public void test_containsValueLjava_lang_Object() {
        assertTrue("Should have returned false", !a.containsValue("One"));
        assertTrue("Should have returned true", a.containsValue("one"));
    }

    /**
     * @tests java.util.jar.Attributes#entrySet()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "entrySet",
          methodArgs = {}
        )
    })
    public void test_entrySet() {
        Set<Map.Entry<Object, Object>> entrySet = a.entrySet();
        Set<Object> keySet = new HashSet<Object>();
        Set<Object> valueSet = new HashSet<Object>();
        Iterator<?> i;
        assertEquals(4, entrySet.size());
        i = entrySet.iterator();
        while (i.hasNext()) {
            java.util.Map.Entry<?, ?> e;
            e = (Map.Entry<?, ?>) i.next();
            keySet.add(e.getKey());
            valueSet.add(e.getValue());
        }
        assertTrue("a) Should contain entry", valueSet.contains("one"));
        assertTrue("b) Should contain entry", valueSet.contains("two"));
        assertTrue("c) Should contain entry", valueSet.contains("three"));
        assertTrue("d) Should contain entry", valueSet.contains("four"));
        assertTrue("a) Should contain key", keySet.contains(new Attributes.Name("1")));
        assertTrue("b) Should contain key", keySet.contains(new Attributes.Name("2")));
        assertTrue("c) Should contain key", keySet.contains(new Attributes.Name("3")));
        assertTrue("d) Should contain key", keySet.contains(new Attributes.Name("4")));
    }

    /**
     * @tests java.util.jar.Attributes#get(java.lang.Object)
     */
@TestInfo(
      level = TestLevel.PARTIAL,
      purpose = "IllegalArgumentException checking missed.",
      targets = {
        @TestTarget(
          methodName = "getValue",
          methodArgs = {java.lang.String.class}
        )
    })
    public void test_getLjava_lang_Object() {
        assertEquals("a) Incorrect value returned", "one", a.getValue("1"));
        assertNull("b) Incorrect value returned", a.getValue("0"));
    }

    /**
     * @tests java.util.jar.Attributes#isEmpty()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "isEmpty",
          methodArgs = {}
        )
    })
    public void test_isEmpty() {
        assertTrue("Should not be empty", !a.isEmpty());
        a.clear();
        assertTrue("a) Should be empty", a.isEmpty());
        a = new Attributes();
        assertTrue("b) Should be empty", a.isEmpty());
    }

    /**
     * @tests java.util.jar.Attributes#keySet()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "keySet",
          methodArgs = {}
        )
    })
    public void test_keySet() {
        Set<?> s = a.keySet();
        assertEquals(4, s.size());
        assertTrue("a) Should contain entry", s.contains(new Attributes.Name("1")));
        assertTrue("b) Should contain entry", s.contains(new Attributes.Name("2")));
        assertTrue("c) Should contain entry", s.contains(new Attributes.Name("3")));
        assertTrue("d) Should contain entry", s.contains(new Attributes.Name("4")));
    }

    /**
     * @tests java.util.jar.Attributes#putAll(java.util.Map)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "putAll",
          methodArgs = {java.util.Map.class}
        )
    })
    public void test_putAllLjava_util_Map() {
        Attributes b = new Attributes();
        b.putValue("3", "san");
        b.putValue("4", "shi");
        b.putValue("5", "go");
        b.putValue("6", "roku");
        a.putAll(b);
        assertEquals("Should not have been replaced", "one", a.getValue("1"));
        assertEquals("Should have been replaced", "san", a.getValue("3"));
        assertEquals("Should have been added", "go", a.getValue("5"));
        Attributes atts = new Attributes();
        assertNull("Assert 0: ", atts.put(Attributes.Name.CLASS_PATH, "tools.jar"));
        assertNull("Assert 1: ", atts.put(Attributes.Name.MANIFEST_VERSION, "1"));
        Attributes atts2 = new Attributes();
        atts2.putAll(atts);
        assertEquals("Assert 2:", "tools.jar", atts2.get(Attributes.Name.CLASS_PATH));
        assertEquals("Assert 3: ", "1", atts2.get(Attributes.Name.MANIFEST_VERSION));
        try {
            atts.putAll(Collections.EMPTY_MAP);
            fail("Assert 4: no class cast from attrib parameter");
        } catch (ClassCastException e) {
            // Expected
        }
    }

    /**
     * @tests java.util.jar.Attributes#putAll(java.util.Map)
     */
@TestInfo(
      level = TestLevel.PARTIAL,
      purpose = "Regression test",
      targets = {
        @TestTarget(
          methodName = "putAll",
          methodArgs = {java.util.Map.class}
        )
    })
    public void test_putAllLjava_util_Map2() {
        // Regression for HARMONY-464
        try {
            new Attributes().putAll((Map) null);
            fail("ClassCastException expected");
        } catch (ClassCastException e) {
        }
        // verify that special care for null is done in the Attributes.putAll()
        // method
        try {
            new Attributes() {
                @Override
                public void putAll(Map<?, ?> attrib) {
                    map.putAll(attrib);
                }
            }.putAll((Map<?, ?>) null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * @tests java.util.jar.Attributes#remove(java.lang.Object)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "remove",
          methodArgs = {java.lang.Object.class}
        )
    })
    public void test_removeLjava_lang_Object() {
        a.remove(new Attributes.Name("1"));
        a.remove(new Attributes.Name("3"));
        assertNull("Should have been removed", a.getValue("1"));
        assertEquals("Should not have been removed", "four", a.getValue("4"));
    }

    /**
     * @tests java.util.jar.Attributes#size()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "size",
          methodArgs = {}
        )
    })
    public void test_size() {
        assertEquals("Incorrect size returned", 4, a.size());
        a.clear();
        assertEquals(0, a.size());
    }

    /**
     * @tests java.util.jar.Attributes#values()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "values",
          methodArgs = {}
        )
    })
    public void test_values() {
        Collection<?> valueCollection = a.values();
        assertTrue("a) Should contain entry", valueCollection.contains("one"));
        assertTrue("b) Should contain entry", valueCollection.contains("two"));
        assertTrue("c) Should contain entry", valueCollection.contains("three"));
        assertTrue("d) Should contain entry", valueCollection.contains("four"));
    }

    /**
     * @tests java.util.jar.Attributes#clone()
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "clone",
          methodArgs = {}
        )
    })
    public void test_clone() {
        Attributes a2 = (Attributes) a.clone();
        assertEquals(a, a2);
        a.putValue("1", "one(1)");
        assertTrue("equal", !a.equals(a2));
    }

    /**
     * @tests java.util.jar.Attributes#equals(java.lang.Object)
     */
@TestInfo(
      level = TestLevel.COMPLETE,
      purpose = "",
      targets = {
        @TestTarget(
          methodName = "equals",
          methodArgs = {java.lang.Object.class}
        )
    })
    public void test_equalsLjava_lang_Object() {
        Attributes.Name n1 = new Attributes.Name("name"), n2 = new Attributes.Name("Name");
        assertEquals(n1, n2);
        Attributes a1 = new Attributes();
        a1.putValue("one", "1");
        a1.putValue("two", "2");
        Attributes a2 = new Attributes();
        a2.putValue("One", "1");
        a2.putValue("TWO", "2");
        assertEquals(a1, a2);
    }

    /**
     * @tests java.util.jar.Attributes.put(java.lang.Object, java.lang.Object)
     */
@TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "Regression test. Checks ClassCastException",
      targets = {
        @TestTarget(
          methodName = "put",
          methodArgs = {java.lang.Object.class, java.lang.Object.class}
        )
    })
    public void test_putLjava_lang_ObjectLjava_lang_Object() {
        Attributes atts = new Attributes();
        assertNull("Assert 0: ", atts.put(Attributes.Name.CLASS_PATH, "tools.jar"));
        assertEquals("Assert 1: ", "tools.jar", atts.getValue(Attributes.Name.CLASS_PATH));
        // Regression for HARMONY-79
        try {
            atts.put("not a name", "value");
            fail("Assert 2: no class cast from key parameter");
        } catch (ClassCastException e) {
            // Expected
        }
        try {
            atts.put(Attributes.Name.CLASS_PATH, Boolean.TRUE);
            fail("Assert 3: no class cast from value parameter");
        } catch (ClassCastException e) {
            // Expected
        }
    }
    
    /**
     * @tests java.util.jar.Attributes.put(java.lang.Object, java.lang.Object)
     */
@TestInfo(
      level = TestLevel.PARTIAL_OK,
      purpose = "ClassCastException checking missed.",
      targets = {
        @TestTarget(
          methodName = "put",
          methodArgs = {java.lang.Object.class, java.lang.Object.class}
        )
    })
    public void test_putLjava_lang_ObjectLjava_lang_Object_Null() {

        Attributes attribute = new Attributes();

        assertFalse(attribute.containsKey(null));
        assertFalse(attribute.containsValue(null));
        attribute.put(null, null);
        attribute.put(null, null);
        assertEquals(1, attribute.size());
        assertTrue(attribute.containsKey(null));
        assertTrue(attribute.containsValue(null));
        assertNull(attribute.get(null));

        String value = "It's null";
        attribute.put(null, value);
        assertEquals(1, attribute.size());
        assertEquals(value, attribute.get(null));

        Attributes.Name name = new Attributes.Name("null");
        attribute.put(name, null);
        assertEquals(2, attribute.size());
        assertNull(attribute.get(name));
    }

}