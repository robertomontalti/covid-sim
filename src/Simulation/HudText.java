/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import java.util.List;

/**
 *
 * @author json
 */
public class HudText {

    private List<BitmapText> text;
    private final int backX;
    private final int backY;
     public HudText(List<BitmapText> text, int backX, int backY){
        this.text = text;
        this.backX = backX;
        this.backY = backY;
         
     }
     
     public List<BitmapText> attach(){
         int count = text.size();
         for(var t : text){
             t.setColor(ColorRGBA.White);
             t.setLocalTranslation(0, backY/count++, 0);
             t.setText("Test");
         }
         
         return text;
     }
}

