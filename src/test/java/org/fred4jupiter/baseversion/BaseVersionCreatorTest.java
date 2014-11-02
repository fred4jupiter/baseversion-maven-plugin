package org.fred4jupiter.baseversion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BaseVersionCreatorTest {

    private BaseVersionCreator creator = new BaseVersionCreator();

    @Test
    public void in2Out1() {
        assertEquals("1", creator.createBaseVersionFrom("1.0-SNAPSHOT", 1));
        assertEquals("32", creator.createBaseVersionFrom("32.44-SNAPSHOT", 1));
    }

    @Test
    public void in3Out1() {
        assertEquals("1", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 1));
        assertEquals("32", creator.createBaseVersionFrom("32.44.456-SNAPSHOT", 1));
    }

    @Test
    public void in4Out1() {
        assertEquals("1", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 1));
        assertEquals("32", creator.createBaseVersionFrom("32.44.456.33-SNAPSHOT", 1));
    }

    // --------

    @Test
    public void in2Out2() {
        assertEquals("1.0", creator.createBaseVersionFrom("1.0-SNAPSHOT", 2));
        assertEquals("42.33", creator.createBaseVersionFrom("42.33-SNAPSHOT", 2));
    }

    @Test
    public void in3Out2() {
        assertEquals("1.0", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 2));
        assertEquals("42.33", creator.createBaseVersionFrom("42.33.234-SNAPSHOT", 2));
    }

    @Test
    public void in4Out2() {
        assertEquals("1.0", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 2));
        assertEquals("42.33", creator.createBaseVersionFrom("42.33.234.4542-SNAPSHOT", 2));
    }

    // --------

    @Test
    public void in2Out3() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0-SNAPSHOT", 3));
        assertEquals("42.33.0", creator.createBaseVersionFrom("42.33-SNAPSHOT", 3));
    }

    @Test
    public void in3Out3() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 3));
        assertEquals("42.33.123", creator.createBaseVersionFrom("42.33.123-SNAPSHOT", 3));
    }

    @Test
    public void in4Out3() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 3));
        assertEquals("42.33.123", creator.createBaseVersionFrom("42.33.123.22-SNAPSHOT", 3));
    }

    @Test
    public void in4Out3NoSnapshot() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0.0.2", 3));
        assertEquals("42.33.123", creator.createBaseVersionFrom("42.33.123.22", 3));
    }

    // --------

    @Test
    public void in2Out4() {
        assertEquals("1.0.0.0", creator.createBaseVersionFrom("1.0-SNAPSHOT", 4));
        assertEquals("42.33.0.0", creator.createBaseVersionFrom("42.33-SNAPSHOT", 4));
    }

    @Test
    public void in3Out4() {
        assertEquals("1.0.0.0", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 4));
        assertEquals("42.33.123.0", creator.createBaseVersionFrom("42.33.123-SNAPSHOT", 4));
    }

    @Test
    public void in4Out4() {
        assertEquals("1.0.0.2", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 4));
        assertEquals("42.33.123.22", creator.createBaseVersionFrom("42.33.123.22-SNAPSHOT", 4));
    }

    @Test
    public void in4Out4NoSnapshot() {
        assertEquals("1.0.0.2", creator.createBaseVersionFrom("1.0.0.2", 4));
        assertEquals("42.33.123.22", creator.createBaseVersionFrom("42.33.123.22", 4));
    }
}
