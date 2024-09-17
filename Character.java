import javax.swing.*;
/* need to add a place for full image in the constructers (yes you will have to change every single constructor in the MainScreen class)
 * need to add a place for the stats of each char (maybe merge both into just this class? your choice)
 */
public class Character {
    
    String name;
    ImageIcon mainImage;
    ImageIcon icon;
    ImageIcon fullImage;
    String lore;
    int grade = 12;
    int type = 1; 
    int star = 1;
    int timesUpgraded = 1;
    int copies = 0;
    CharStats stats = new CharStats(500,100,100,100);
    int skill;
    /*  1 = DMG
     *  2 = BUFF/DMG
     *  3 = BUFF/DEF
     *  4 = BUFF/SPD
     *  5 = DEBUFF/SPD
     *  6 = DEBUFF/DMG
     *  7 = DEBUFF/DEF
     *  8 = HEAL
     */
    //maybe add another imageicon for rarities since im menacing them
    

    Character(int s,String n,int sk, ImageIcon main, ImageIcon smallIcon, ImageIcon full, String l){
        icon = smallIcon;
        name = n;
        mainImage = main;
        lore = l;
        fullImage = full;
        star = s;
        stats.adjustByRarity(s);
        stats.addName(n);
        skill = sk;
    }

    Character(String n,int sk, ImageIcon main, ImageIcon smallIcon, ImageIcon full, String l){
        icon = smallIcon;
        name = n;
        mainImage = main;
        lore = l;
        fullImage = full;
        star = 3;
        stats.adjustByRarity(3);
        stats.addName(n);
        skill = sk;

    }

    Character(int s,String n,int sk, ImageIcon main, ImageIcon smallIcon,ImageIcon full, String l,int g){
        icon = smallIcon;
        name = n;
        mainImage = main;
        lore = l;
        grade = g;
        fullImage = full;
        star = s;
        stats.adjustByRarity(3);
        stats.addName(n);
        skill = sk;

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
    public ImageIcon getFull() {return fullImage;}
    public CharStats getStats(){return stats;}
    public int getSkill(){return skill;}
    public boolean checkUpgradable(){
        if((((int) Math.pow(timesUpgraded,timesUpgraded))) < copies){
            return true;
        }
        return false;
    }
    public int neededForUpgrade(){return (int) Math.pow(timesUpgraded,timesUpgraded); }

    public void upgrade() {
        timesUpgraded++;
        star++;
    }
    public void setUpgrade(int n) {
        timesUpgraded = n;
        star+=(n-1);
    }
    public void addCopy() {copies++;}
    public void setCopy(int n) { copies = n;}
    
}
