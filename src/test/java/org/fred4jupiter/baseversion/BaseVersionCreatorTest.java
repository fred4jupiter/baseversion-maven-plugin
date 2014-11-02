package org.fred4jupiter.baseversion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BaseVersionCreatorTest {

    private BaseVersionCreator creator = new BaseVersionCreator();

    @Test
    public void in2Out3() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0-SNAPSHOT", 3));
    }

    @Test
    public void in3Out3() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 3));
    }

    @Test
    public void in4Out3() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 3));
    }

    @Test
    public void in4Out3NoSnapshot() {
        assertEquals("1.0.0", creator.createBaseVersionFrom("1.0.0.2", 3));
    }

    // --------
    @Test
    public void in2Out2() {
        assertEquals("1.0", creator.createBaseVersionFrom("1.0-SNAPSHOT", 2));
    }

    @Test
    public void in3Out2() {
        assertEquals("1.0", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 2));
    }

    @Test
    public void in4Out2() {
        assertEquals("1.0", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 2));
    }

    // --------

    @Test
    public void in2Out1() {
        assertEquals("1", creator.createBaseVersionFrom("1.0-SNAPSHOT", 1));
    }

    @Test
    public void in3Out1() {
        assertEquals("1", creator.createBaseVersionFrom("1.0.0-SNAPSHOT", 1));
    }

    @Test
    public void in4Out1() {
        assertEquals("1", creator.createBaseVersionFrom("1.0.0.2-SNAPSHOT", 1));
    }
}
