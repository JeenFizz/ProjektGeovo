package model.mobile;

import model.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.DataBufferByte;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpellTest {

	 /**
     * FireBall object used for tests
     */
    private Spell    spell;
    /**
     * Element object used for tests
     */
    private Element     element;

    /** Used to set up the test variables
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.spell = new Spell(new Point(0, 0));
        this.element = new Element("fireball_1.png", false) {
            @Override
            protected void loadSprite(String path) {
                super.loadSprite(path);
            }
        };
    }

    /** Testing the animate function
     * @throws Exception
     */
    @Test
    public void animate() throws Exception {
        Assert.assertEquals(1, this.spell.getStep());
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.spell.getImage().getData().getDataBuffer()).getData());
        this.spell.animate();
        this.element = new Element("fireball_2.png", false) {
            @Override
            protected void loadSprite(String path) {
                super.loadSprite(path);
            }
        };
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.spell.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(2, this.spell.getStep());
        this.spell.animate();
        this.element = new Element("fireball_3.png", false) {
            @Override
            protected void loadSprite(String path) {
                super.loadSprite(path);
            }
        };
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.spell.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(3, this.spell.getStep());
        this.spell.animate();
        this.element = new Element("fireball_4.png", false) {
            @Override
            protected void loadSprite(String path) {
                super.loadSprite(path);
            }
        };
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.spell.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(4, this.spell.getStep());
        this.spell.animate();
        this.element = new Element("fireball_5.png", false) {
            @Override
            protected void loadSprite(String path) {
                super.loadSprite(path);
            }
        };
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.spell.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(5, this.spell.getStep());
        this.spell.animate();
        Assert.assertEquals(6, this.spell.getStep());
    }
}