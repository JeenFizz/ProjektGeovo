package model;

import model.motionless.Bone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.DataBufferByte;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.motionless.Bone;

public class ElementTest {
	private Bone bone;
@Before
public void setUp() throws Exception {
    this.bone = new Bone();
}

@Test
public void loadSprite() throws Exception {
    this.bone.loadSprite("bone.png");
    Assert.assertArrayEquals(((DataBufferByte) ImageIO.read(getClass().getResource(String.format("../model/src/main/java/model/sprite/%s", "bone.png"))).getData().getDataBuffer()).getData(), ((DataBufferByte) this.bone.getImage().getData().getDataBuffer()).getData());
}

}
