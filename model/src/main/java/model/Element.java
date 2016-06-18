package model;

import contract.IElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Yog on 13/06/2016.
 */
public abstract class Element implements IElement {
    protected BufferedImage image = null;
    protected boolean permeability;

    public Element(String path, boolean permeability)
    {
        if(!path.equals("")) {
            this.loadSprite(String.format("../model/src/main/java/model/sprite/%s", path));
        }
        this.permeability = permeability;
    }

    protected void loadSprite(String path) {
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Pathname is '%s'%n", path);
        }
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public boolean getPermeability()
    {
        return permeability;
    }


}
