/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;



/**
 *
 * @author BOT
 */
public class ImageView extends JLabel {
    
  //  private Graphics2D graphic;
    private BufferedImage canvas;
    private int width,height;
    public ImageView(){
//        super();
      /*  canvas = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
        graphic = (Graphics2D)canvas.createGraphics();
        width = w;
        height =  h;
        setSize( w, h); */
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(canvas, 0, 0,width, height, null);
        g2d.setFont(new Font("Arial", 0, 30));
    } 
    
    public void setImage(BufferedImage image){
       /* graphic.setBackground(Color.black);
        graphic.clearRect(0, 0, width, height);
        graphic.drawImage(image, 0, 0, width, height, null);*/
        canvas = image;
        this.width = this.getWidth();
        this.height = this.getHeight();
        repaint();
    }
}
