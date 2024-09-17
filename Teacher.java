import javax.swing.*;
public class Teacher {
    String name;
    CharStats stats;
    ImageIcon stage1;
    ImageIcon stage2;

    Teacher(String n, CharStats s,ImageIcon img1,ImageIcon img2){
        name = n;
        stats = s;
        stage1 = img1;
        stage2 = img2;
    }

    public String getName(){return name;}
    public CharStats getTstats(){return stats;}
    public ImageIcon getStage1(){return stage1;}
    public ImageIcon getStage2(){return stage2;}

    public void updateStats(CharStats s){stats = s;}
}
