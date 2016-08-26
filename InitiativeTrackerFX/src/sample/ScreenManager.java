/**
 * Created by GreenManPDX on 7/5/2016.
 */
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

public class ScreenManager {

    private GraphicsDevice vc;

    //give video card access to monitor
    public ScreenManager(){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = e.getDefaultScreenDevice();
    }

    //get all compatible DM
    public DisplayMode[] getCompatibleDisplayModes(){return vc.getDisplayModes();}

    //compares DM passed in to vc DM and see if they match
    public DisplayMode findFirstCompatibleMode(DisplayMode modes[]){

        DisplayMode goodModes[] = vc.getDisplayModes();
        for(int i = 0; i < modes.length; i++){
            for(int k =0; k < goodModes.length;k++) {
                if (displayModesMatch(modes[i], modes[k])) {
                    return modes[i];
                }
            }
        }
        return null;
    }

    //get current DM
    public DisplayMode getCurrentDisplayMode(){return vc.getDisplayMode();}

    //checks for matching modes
    public boolean displayModesMatch(DisplayMode m1, DisplayMode m2){
        if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()){return false;}

        if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()){return false;}

        if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()){
            return false;
        }

        return true;
    }

    public void drawScreen(DisplayMode dm, JFrame window){

        //window.setUndecorated(false);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // window.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        JLabel textLabel = new JLabel("Test", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300,100));

        //Display Window
        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);


        if(dm != null && vc.isDisplayChangeSupported()){
            try{
                vc.setDisplayMode(dm);
            }catch(Exception ex){}
        }
    }

}
