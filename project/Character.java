import java.awt.*;
import javax.swing.*;

/* need to add a place for full image in the constructers (yes you will have to change every single constructor in the MainScreen class)
 * need to add a place for the stats of each char (maybe merge both into just this class? your choice)
 */
public class Character implements java.io.Serializable {
    
    String name;
    ImageIcon mainImage;
    ImageIcon icon;
    String lore;
    int grade = 12;
    int type = 1; 
    int star = 1;
    int timesUpgraded = 1;
    int copies = 0;
    //maybe add another imageicon for rarities since im menacing them
    

    Character(String n, ImageIcon main, ImageIcon smallIcon, String l){
        icon = smallIcon;
        name = n;
        mainImage = main;
        lore = l;
        star = RNG.randomize(6);
    }

    Character(String n, ImageIcon main, ImageIcon smallIcon, String l,int g){
        icon = smallIcon;
        name = n;
        mainImage = main;
        lore = l;
        grade = g;
        star = (int) (Math.random()*6);
    }

    public ImageIcon getMain() {return mainImage;}
    public ImageIcon getSmall() {return icon;}
    public String getName() {return name;}
    public int getType() {return type;}
    public int getStar() {return star;}
    public String getLore() {return lore;}
    public int getGrade() {return grade;}
    public int getTimesUpgraded() {return timesUpgraded;}
    public int getCopies() {return copies;}

    public void upgrade() {timesUpgraded++;}
    public void addCopy() {copies++;}
    
}
