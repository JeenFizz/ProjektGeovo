package model;

import contract.IElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


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
    
    /* allow us to load sprite from a package with a pathname */
 //show pathname to ensure the path and display error if it have ones
    protected void loadSprite(String path) {
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Pathname is '%s'%n", path);
        }
    }

    /*
     * (non-Javadoc)
     * @see contract.IElement#getImage()
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /*
     * (non-Javadoc)
     * @see contract.IElement#getPermeability()
     */
    public boolean getPermeability()
    {
        return permeability;
    }


}
