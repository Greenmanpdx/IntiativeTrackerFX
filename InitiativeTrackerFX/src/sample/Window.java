/**
 * Created by GreenManPDX on 7/5/2016.
 */


import java.awt.*;

import javax.swing.*;

/**
 * Created by GreenMan on 3/22/2016.
 */
public class Window extends JFrame{

    public static void main(String[] args) {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        Window i = new Window();
        i.run(dm);
    }

    private ScreenManager s;
    private Image bg;
    private Image pic;
    private boolean loaded;

    public void run(DisplayMode dm){
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 24));
        loaded = false;

        ScreenManager s = new ScreenManager();

        //try{
        //s.setFullScreen(dm, this);
        s.drawScreen(dm, this);
        loadpics();
           /* try{
                Thread.sleep(5000);
            }catch(Exception ex){}
        }finally{
           // s.restoreScreen();
        }*/
    }

    //loads pics
    public void loadpics(){
        bg = new ImageIcon("C:\\test\\Soth.jpg").getImage();
        pic = new ImageIcon("C:\\test\\hill.jpg").getImage();
        loaded = true;
        repaint();
    }
    public void paint(Graphics g){
        if(g instanceof Graphics2D){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        if(loaded){
            g.drawImage(bg, 0, 0, null);
            g.drawImage(pic, 170, 180, null);
        }

    }
}
