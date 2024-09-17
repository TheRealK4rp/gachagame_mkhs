import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */




/* TO DO LIST
 *  1) Finish rarity system "Hashmap string -> int" (just need to assign rarities not at random) not doing this
 *  2) make inventory system work (copies work, player inventory works) 
 *  3) make save data (need to make previous one work with copies)  
 *  4) make things glow when you hover over them (prob not doing this one) done enoguhaad
 *  5) add sounds for stuff -- lmao no
 *  6) combat system also team builder <- SUPER IMPORTANT BECAUSE I HAVENT DONE IT YET (ok i did it)
 *  7)  zzzz
 * 
 * 
 * 
 *  -------------------------------------- PART 2 ------------------------------------------
 *  1) for the team selecter, make the backgrounds semitransparent (like setting opacity to 50% or smth)
 *  2) make the map (its time, image is in resources/UI)
 *  3) (IMPORTANT) make saving data a lot faster , maybe use xml?
 * 
 * I know i can make this all run faster but i already wrote all the code in this inefficient way and i dont want to fix it lol
 */ 

public class MainScreen extends JFrame {

    Team team = new Team();
    Map map = new Map();
    JPanel mapButton;
    JPanel banner1, banner2, mainBanner1, mainBanner2, pull1, pull2,  inventory, main, stars, charArt, teamBuilderButton;
    JPanel bigpanel = new JPanel();
    JPanel invpanel = new JPanel();
    JPanel teamBuilderMain = new JPanel();
    JPanel icons, icons2;
    JLabel backButton, name, grade, bkg4;
    JLabel infoboard, timesPulled,charArtMain;
    JLabel bannerName1,bannerName2;
    JLabel teamMember1, teamMember2, teamMember3, teamMember4;
    JLabel skills;
    JLabel upStar;
    JScrollPane iconScroll;
    ArrayList<Character> tempChars = new ArrayList<Character>();
    int hold = 0;
    int current = 0;
    int selected = 0;
    boolean switcher = false;
    Character globaltemp;
    ImageIcon placeholder = new ImageIcon("resources\\character\\main\\placeholder.png");
    JLabel bkg = new JLabel(new ImageIcon("resources\\UI\\bkg.PNG"));
/* 
    final HashMap<String,Integer> rarityTable = new HashMap<String,Integer>(){
        { put("R",1);}
        { put("C",1);}
        { put("1star",1);}
        { put("common",1);}

        { put("SR",2);}
        { put("B",2);}
        { put("2star",2);}
        { put("uncommon",2);}

        { put("SSR",3);}
        { put("A",3);}
        { put("3star",3);}
        { put("rare",3);}

        { put("USSR",4);}
        { put("S",4);}
        { put("4star",4);}
        { put("epic",4);}

        { put("USSSR",5);}
        { put("SS",5);}
        { put("5star",5);}
        { put("legendary",5);}

        { put("USSSR",6);}
        { put("SSS",6);}
        { put("6star",6);}
        { put("mythic",6);}
    };
/* 
    final HashMap<String,String> rarityUp = new HashMap<String,String>(){
        { put("R","SR");}
        { put("SR","SSR");}
        { put("SSR","UR");}
        { put("UR","USSR");}
        { put("USSR","USSSR");}

        { put("C","B");}
        { put("B","A");}
        { put("A","S");}
        { put("S","SS");}
        { put("SS","SSS");}

        { put("1star","2star");}
        { put("2star","3star");}
        { put("3star","4star");}
        { put("4star","5star");}
        { put("5star","6star");}

        { put("common","uncommon");}
        { put("uncommon","rare");}
        { put("rare","epic");}
        { put("epic","legendary");}
        { put("legendary","mythic");}

    };
    */
    // check if character has already been palled so i can jsut add 1 to the copy count of the Character
    HashMap<String,Boolean> hasBeenPulled = new HashMap<String,Boolean>();
     //every person
     Character joel = new Character(6,"Joel Tsang",1, new ImageIcon("resources\\character\\JOEL\\ncGDEV_JOEL (1).png"), new ImageIcon("resources\\character\\JOEL\\ncGDEV_JOEL (2).png"),new ImageIcon("resources\\character\\JOEL\\ncGDEV_JOEL.png"),"bro...");
     //Character fake = new Character("fake",new ImageIcon("resources\\character\\main\\joel-1.png"),placeholder,placeholder,"random shi adsadasdasdasdasdasdasdasdasdsat");
     Character vincent = new Character(1,"Vincent Wu",1, new ImageIcon("resources\\character\\VINCENT\\ncGDEV_VINCENT_BANNER.png"),new ImageIcon("resources\\character\\VINCENT\\ncGDEV_VINCENT_ICON.png"),new ImageIcon("resources\\character\\VINCENT\\ncGDEV_VINCENT_MAIN.png"),"im vincent");
     Character jasonh = new Character(3,"Jason Huynh",2,new ImageIcon("resources\\character\\JASONH\\ncGDEV_JASONH_BANNER.png"),new ImageIcon("resources\\character\\JASONH\\ncGDEV_JASONH_ICON.png"),new ImageIcon("resources\\character\\JASONH\\ncGDEV_JASONH_MAIN.png"),"im jason");
     Character jimmy = new Character(1,"Jimmy Liang",3,new ImageIcon("resources\\character\\JIMMY\\ncGDEV_JIMMY_BANNER.png"),new ImageIcon("resources\\character\\JIMMY\\ncGDEV_JIMMY_ICON.png"),new ImageIcon("resources\\character\\JIMMY\\ncGDEV_JIMMY_MAIN.png"),"i love joel tsang");
     Character leo = new Character(2,"Leo Chan",7,new ImageIcon("resources\\character\\LEO\\ncGDEV_LEO_BANNER.png"),new ImageIcon("resources\\character\\LEO\\ncGDEV_LEO_ICON.png"),new ImageIcon("resources\\character\\LEO\\ncGDEV_LEO_MAIN.png"),"im leo");
     Character kevin = new Character(3,"Kevin Lin",3, new ImageIcon("resources\\character\\KEVIN\\ncGDEV_KEVIN_BANNER.png"),new ImageIcon("resources\\character\\KEVIN\\ncGDEV_KEVIN_ICON.png"), new ImageIcon("resources\\character\\KEVIN\\ncGDEV_KEVIN_MAIN.png"), "im kevin");
     Character ivan = new Character(1,"Ivan Kuang",5, new ImageIcon("resources\\character\\IVAN\\ncGDEV_IVAN_BANNER.png"),new ImageIcon("resources\\character\\IVAN\\ncGDEV_IVAN_ICON.png"), new ImageIcon("resources\\character\\IVAN\\ncGDEV_IVAN_MAIN.png"), "i am cool and mysterious like Sung Jin Woo");
     Character yuping = new Character(5,"Yuping Wang",4, new ImageIcon("resources\\character\\YUPING\\ncGDEV_YUPING (1).png"),new ImageIcon("resources\\character\\YUPING\\ncGDEV_YUPING (2).png"), new ImageIcon("resources\\character\\YUPING\\ncGDEV_YUPING.png"), "im yuping");
     Character swanyie = new Character(3,"Swanyie Htet",1, new ImageIcon("resources\\character\\SWANYIE\\ncGDEV_SWANYIE_BANNER.png"),new ImageIcon("resources\\character\\SWANYIE\\ncGDEV_SWANYIE_ICON.png"), new ImageIcon("resources\\character\\SWANYIE\\ncGDEV_SWANYIE_MAIN.png"), "im swanyie");
     Character kaitlyn = new Character(3,"Kaitlyn Cao",1, new ImageIcon("resources\\character\\KAITLYN\\ncGDEV_KAILTNY_BANNER.png"),new ImageIcon("resources\\character\\KAITLYN\\ncGDEV_KAILTNY_ICON.png"), new ImageIcon("resources\\character\\KAITLYN\\ncGDEV_KAILTNY_MAIN.png"), "im kaitlyn");
     Character ruize = new Character(3,"Ruize Tian",2, new ImageIcon("resources\\character\\RUIZE\\ncGDEV_RUIZE (1).png"),new ImageIcon("resources\\character\\RUIZE\\ncGDEV_RUIZE (2).png"), new ImageIcon("resources\\character\\RUIZE\\ncGDEV_RUIZE.png"), "im ruize");
     Character jolie = new Character(5,"Jolie Hsieh",1,new ImageIcon("resources\\character\\JOLIE\\ncGDEV_JOLIE (1).png"),new ImageIcon("resources\\character\\JOLIE\\ncGDEV_JOLIE (2).png"),new ImageIcon("resources\\character\\JOLIE\\ncGDEV_JOLIE.png"),"im jolie");
     Character amber = new Character(3,"Amber Cai",8, new ImageIcon("resources\\character\\AMBER\\ncGDEV_AMBER_BANNER.png"), new ImageIcon("resources\\character\\AMBER\\ncGDEV_AMBER_ICON.png"),new ImageIcon("resources\\character\\AMBER\\ncGDEV_AMBER_MAIN.png"), "im amber");
     Character avian = new Character(6,"Avian Thai",6, new ImageIcon("resources\\character\\AVIAN\\ncGDEV_AVIAN_BANNER.png"), new ImageIcon("resources\\character\\AVIAN\\ncGDEV_AVIAN_ICON.png"), new ImageIcon("resources\\character\\AVIAN\\ncGDEV_AVIAN_MAIN.png"),"im avian");
     Character alison = new Character(5,"Alison Fu",1, new ImageIcon("resources\\character\\ALISON\\ncGDEV_ALISON (1).png"),new ImageIcon("resources\\character\\ALISON\\ncGDEV_ALISON (2).png"), new ImageIcon("resources\\character\\ALISON\\ncGDEV_ALISON.png"), "im alison");
     Character cory = new Character(4,"Cory Tsan",1, new ImageIcon("resources\\character\\CORY\\ncGDEV_CORY_BANNER.png"), new ImageIcon("resources\\character\\CORY\\ncGDEV_CORY_ICON.png"),new ImageIcon("resources\\character\\CORY\\ncGDEV_CORY_MAIN.png"), "im cory");
     Character harrison = new Character(3,"Harrison Duong",7, new ImageIcon("resources\\character\\HARRISON\\ncGDEV_HARRISON_BANNER.png"),new ImageIcon("resources\\character\\HARRISON\\ncGDEV_HARRISON_ICON.png"), new ImageIcon("resources\\character\\HARRISON\\ncGDEV_HARRISON_MAIN.png"), "im harrison");
     Character ethan11 = new Character(3,"Ethan Dang",4,new ImageIcon("resources\\character\\ETHAN\\ncGDEV_ETHAN_BANNER.png"),new ImageIcon("resources\\character\\ETHAN\\ncGDEV_ETHAN_ICON.png"),new ImageIcon("resources\\character\\ETHAN\\ncGDEV_ETHAN_MAIN.png"),"im ethan",11);
     Character bill = new Character(2,"Bill Tran",2, new ImageIcon("resources\\character\\BILL\\ncGDEV_BILL_BANNER.png"),new ImageIcon("resources\\character\\BILL\\ncGDEV_BILL_ICON.png"), new ImageIcon("resources\\character\\BILL\\ncGDEV_BILL_MAIN.png"), "im bill");
     Character brandon = new Character(2,"Brandon Martinez",3,new ImageIcon("resources\\character\\BRANDON\\ncGDEC_BRANDON_BANNER.png"), new ImageIcon("resources\\character\\BRANDON\\ncGDEC_BRANDON_ICON.png"), new ImageIcon("resources\\character\\BRANDON\\ncGDEC_BRANDON_MAIN.png"), "im brandon");
     Character yuuki = new Character(2,"Yuuki Haishima",1, new ImageIcon("resources\\character\\YUUKI\\ncGDEV_YUUKI_BANNER.png"),new ImageIcon("resources\\character\\YUUKI\\ncGDEV_YUUKI_ICON.png"), new ImageIcon("resources\\character\\YUUKI\\ncGDEV_YUUKI_MAIN.png"), "im yuuki");
     Character kenny = new Character(4,"Kenny Be",1, new ImageIcon("resources\\character\\KENNY\\ncGDEV_KENNY_BANNER.png"),new ImageIcon("resources\\character\\KENNY\\ncGDEV_KENNY_ICON.png"), new ImageIcon("resources\\character\\KENNY\\ncGDEV_KENNY_MAIN.png"), "im kenny");
     Character johnny = new Character("Johnny Nguyen",2, new ImageIcon("resources\\character\\JOHNNY\\ncGDEV_JOHNNY (1).png"),new ImageIcon("resources\\character\\JOHNNY\\ncGDEV_JOHNNY (2).png"), new ImageIcon("resources\\character\\JOHNNY\\ncGDEV_JOHNNY.png"), "im johnny");
     Character sherry = new Character("Sherry Keung",6, new ImageIcon("resources\\character\\SHERRY\\ncGDEV_SHERRY_BANNER.png"),new ImageIcon("resources\\character\\SHERRY\\ncGDEV_SHERRY_ICON.png"), new ImageIcon("resources\\character\\SHERRY\\ncGDEV_SHERRY_MAIN.png"), "im sherry");
     Character timothy = new Character("Timothy Pengshung",7,new ImageIcon("resources\\character\\TIMOTHY\\ncGDEV_TIMOTHY (1).png"), new ImageIcon("resources\\character\\TIMOTHY\\ncGDEV_TIMOTHY (2).png"), new ImageIcon("resources\\character\\TIMOTHY\\ncGDEV_TIMOTHY.png"), "im tim");
     Character matthew = new Character(2,"Matthew Pena",5,new ImageIcon("resources\\character\\MATTHEW\\ncGDEV_MATTHEW_MAIN (1).png"),new ImageIcon("resources\\character\\MATTHEW\\ncGDEV_MATTHEW_MAIN (2).png"),new ImageIcon("resources\\character\\MATTHEW\\ncGDEV_MATTHEW_MAIN.png"),"im matthew");
     Character jonathand = new Character(1,"Jonathan Der",5,new ImageIcon("resources\\character\\JONATHAN\\ncGDEV_JONATHAN (1).png"),new ImageIcon("resources\\character\\JONATHAN\\ncGDEV_JONATHAN (2).png"),new ImageIcon("resources\\character\\JONATHAN\\ncGDEV_JONATHAN.png"),"im der");
     Character ruby = new Character("Ruby Yao",7, new ImageIcon("resources\\character\\RUBY\\ncGDEV_RUBY_BANNER.png"), new ImageIcon("resources\\character\\RUBY\\ncGDEV_RUBY_ICON.png"), new ImageIcon("resources\\character\\RUBY\\ncGDEV_RUBY_MAIN.png"), "im ruby");
     Character colin = new Character(6,"Colin Shiung",8,new ImageIcon("resources\\character\\COLIN\\ncGDEV_COLIN_BANNER.png"),new ImageIcon("resources\\character\\COLIN\\ncGDEV_COLIN_ICON.png"),new ImageIcon("resources\\character\\COLIN\\ncGDEV_COLIN_MAIN.png"),"im colin");
     Character vicky = new Character(5,"Vicky Huang",8,new ImageIcon("resources\\character\\VICKY\\ncGDEV_VICKY_BANNER.png"),new ImageIcon("resources\\character\\VICKY\\ncGDEV_VICKY_ICON.png"),new ImageIcon("resources\\character\\VICKY\\ncGDEV_VICKY_MAIN.png"),"im vicky");
     Character alton = new Character(2,"Alton Qian",1,new ImageIcon("resources\\character\\ALTON\\ncGDEV_ALTON (1).png"),new ImageIcon("resources\\character\\ALTON\\ncGDEV_ALTON (2).png"),new ImageIcon("resources\\character\\ALTON\\ncGDEV_ALTON.png"),"im alton");
     Character peter = new Character("Peter Luu",4,new ImageIcon("resources\\character\\PETER\\ncGDEV_PETER_BANNER.png"),new ImageIcon("resources\\character\\PETER\\ncGDEV_PETER_ICON.png"),new ImageIcon("resources\\character\\PETER\\ncGDEV_PETER_MAIN.png"),"im peter");
     Character joleen = new Character(5,"Joleen Wong",1,new ImageIcon("resources\\character\\JOLEEN\\ncGDEV_JOLEEN_BANNER.png"),new ImageIcon("resources\\character\\JOLEEN\\ncGDEV_JOLEEN_ICON.png"),new ImageIcon("resources\\character\\JOLEEN\\ncGDEV_JOLEEN_MAIN.png"),"im joleen");
     Character rachel = new Character(5,"Rachel Wang",1,new ImageIcon("resources\\character\\RACHEL\\ncGDEV_RACHEL_BANNER.png"),new ImageIcon("resources\\character\\RACHEL\\ncGDEV_RACHEL_ICON.png"),new ImageIcon("resources\\character\\RACHEL\\ncGDEV_RACHEL_MAIN.png"),"im rachel");
     Character eva = new Character(5,"Eva Wong",6,new ImageIcon("resources\\character\\EVA\\ncGDEV_EVA (1).png"),new ImageIcon("resources\\character\\EVA\\ncGDEV_EVA (2).png"),new ImageIcon("resources\\character\\EVA\\ncGDEV_EVA.png"),"im eva");
     Character dylan = new Character(5,"Dylan Campos",7,new ImageIcon("resources\\character\\DYLAN\\ncGDEV_DYLAN_BANNER.png"),new ImageIcon("resources\\character\\DYLAN\\ncGDEV_DYLAN_ICON.png"),new ImageIcon("resources\\character\\DYLAN\\ncGDEV_DYLAN_MAIN.png"),"im rachel");
     Character yang = new Character(4,"Yang Hai",1,new ImageIcon("resources\\character\\YANG\\ncGDEV_YANG_BANNER.png"),new ImageIcon("resources\\character\\YANG\\ncGDEV_YANG_ICON.png"),new ImageIcon("resources\\character\\YANG\\ncGDEV_YANG_MAIN.png"),"im yang");
     Character christopher = new Character(4,"Christopher Young",1,new ImageIcon("resources\\character\\CHRISTOPHER\\ncGDEV_CHRISTOPHER_BANNER.png"),new ImageIcon("resources\\character\\CHRISTOPHER\\ncGDEV_CHRISTOPHER_ICON.png"),new ImageIcon("resources\\character\\CHRISTOPHER\\ncGDEV_CHRISTOPHER_MAIN.png"),"im christopher");
     Character nicole = new Character("Nicole Chan",3,new ImageIcon("resources\\character\\NICOLE\\ncGDEV_NICOLE (1).png"),new ImageIcon("resources\\character\\NICOLE\\ncGDEV_NICOLE (2).png"),new ImageIcon("resources\\character\\NICOLE\\ncGDEV_NICOLE.png"),"im nicole");
     Character daniel = new Character("Daniel Au",2,new ImageIcon("resources\\character\\DANIEL\\ncGDEV_DANIEL_BANNER.png"),new ImageIcon("resources\\character\\DANIEL\\ncGDEV_DANIEL_ICON.png"),new ImageIcon("resources\\character\\DANIEL\\ncGDEV_DANIEL_MAIN.png"),"im daniel");
    final ArrayList<Character> allChar = new ArrayList<Character>(){
        { add(joel);}
        // { add(fake);}
        { add(vincent);}
        { add(jasonh);}
        { add(jimmy);}
        { add(leo);}
        { add(kevin);}
        { add(ivan);}
        { add(yuping);}
        { add(swanyie);}
        { add(kaitlyn);}
        { add(ruize);}
        { add(jolie);}
        { add(alison);}
        { add(amber);}
        { add(avian);}
        { add(cory);}
        { add(harrison);}
        { add(ethan11);}
        { add(bill);}
        { add(brandon);}
        { add(yuuki);}
        { add(kenny);}
        { add(johnny);}
        { add(sherry);}
        { add(timothy);}
        { add(matthew);}
        { add(jonathand);}
        { add(ruby);}
        { add(colin);}
        { add(vicky);}
        { add(alton);}
        { add(peter);}
        { add(joleen);}
        { add(rachel);}
        { add(nicole);}
        { add(christopher);}
        { add(yang);}
        { add(eva);}
        { add(dylan);}
        { add(daniel);}
    };

    // sorted into rarity list to make the RNG for pulling easier (sorts at startup see constructor)
    ArrayList<Character> rarity1 = new ArrayList<Character>(){
    };

    ArrayList<Character> rarity2 = new ArrayList<Character>(){
    };

    ArrayList<Character> rarity3 = new ArrayList<Character>(){
    };

    ArrayList<Character> rarity4 = new ArrayList<Character>(){
    };

    ArrayList<Character> rarity5 = new ArrayList<Character>(){
    };

    ArrayList<Character> rarity6 = new ArrayList<Character>(){
    };

    // puts it all the rarities to one list, the rarity for each person in a list is the same
    ArrayList<ArrayList<Character>> rarity = new ArrayList<ArrayList<Character>>(){
        { add(rarity1);}
        { add(rarity2);}
        { add(rarity3);}
        { add(rarity4);}
        { add(rarity5);}
        { add(rarity6);}
    };

    // inventory of the player, i need to tune the save data stuff
    static ArrayList<Character> playerInventory = new ArrayList<Character>(){
        // add stuff here later
    };

    //tester for gui elements, call the constructor with any int value and comment the other one in main class
    /* MainScreen(int x){
        this.setTitle("Stupid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1080,720);
        this.setVisible(true);

        /* mainBanner1 = new JPanel();
        mainBanner1.setBackground(Color.GREEN);
        mainBanner1.setBounds(210, 80, 800,510);
        mainBanner1.setOpaque(true);
        mainBanner1.setLayout(null);
        
        // label = new JLabel();
        label.setBackground(Color.RED);
        // ImageIcon icon = new ImageIcon(getClass().getResource("/resources/character/main/joel.png"));
        // ImageIcon icon = new ImageIcon("./resources/character/main/joel.png");
        // label.setIcon(icon);
        label.setBounds(0,0,88,400);
        label.setOpaque(true);
        
        this.add(label);
        // this.add(mainBanner1);
        
    } */
 
    // dont mess with this stuff
    /*  How things are loaded
     *  
     *  1) make 4 big panels (main,bigpanel,invpanel, teambuilder) 
     *      main -> first screen
     *      bigpanel -> for the pull screen
     *      invpanel -> invetory screen
     *      teambuilder -> build screen
     *  2) load all elements onto each panel
     *      bigpanel -> temporary panels are made for the banner art, these aren't saved anywhere
     *      invpanel -> icons -> these icons are not preloaded, they are creating whenever the switch to invpanel is made, 
     *  3) hiding the parent panel holding all elements hides everything
     */
    MainScreen(){
        
        // sets the window
        this.setTitle("name");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1080,720);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                // RNG.serialize("playerInventory.ser", playerInventory);
                // RNG.serialize("playerInventory.ser", allChar);
                ArrayList<Save> saveData = new ArrayList<Save>();
                for(int i =0;i<playerInventory.size();i++){
                    Character temp = playerInventory.get(i);
                    saveData.add(new Save(temp.getCopies(),temp.getName(),temp.getTimesUpgraded()));
                }
                RNG.serialize("save.ser", saveData);
                dispose();
                System.exit(0);
            }
        });
        // RNG.serialize("test.ser",playerInventory);
        main = new JPanel();
        main.setBounds(0,0,1080,720);
        bkg.setVisible(true);
        bkg.setBounds(0,0,1080,720);
        bkg.setOpaque(true);
        main.setVisible(true);
        main.setLayout(null);
        
        //--------------------------------
        teamBuilderMain.setBounds(0,0,1080,720);
        teamBuilderMain.setVisible(false);
        teamBuilderMain.setLayout(null);

        teamMember1 = new JLabel();
        teamMember1.setBackground(new Color(211,211,211,123));
        teamMember1.setBounds(50,15,200,500);
        teamMember1.setOpaque(true);
        teamMember1.setHorizontalAlignment(JLabel.CENTER);
        teamMember1.setVerticalAlignment(JLabel.CENTER);

        teamMember2 = new JLabel();
        teamMember2.setBackground(new Color(211,211,211,123));
        teamMember2.setBounds(270,15,200,500);
        teamMember2.setOpaque(true);
        teamMember2.setHorizontalAlignment(JLabel.CENTER);
        teamMember2.setVerticalAlignment(JLabel.CENTER);

        teamMember3 = new JLabel();
        teamMember3.setBackground(new Color(211,211,211,123));
        teamMember3.setBounds(490,15,200,500);
        teamMember3.setOpaque(true);
        teamMember3.setHorizontalAlignment(JLabel.CENTER);
        teamMember3.setVerticalAlignment(JLabel.CENTER);

        teamMember4 = new JLabel();
        teamMember4.setBackground(new Color(211,211,211,123));
        teamMember4.setBounds(710,15,200,500);
        teamMember4.setOpaque(true);
        teamMember4.setHorizontalAlignment(JLabel.CENTER);
        teamMember4.setVerticalAlignment(JLabel.CENTER);

        icons2 = new JPanel();
        icons2.setBackground(new Color(3,3,3,80));
        icons2.setBounds(25,545,1010,110);
        icons2.setVisible(true);
        icons2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5)  );
        
        teamBuilderMain.add(icons2);
        teamBuilderMain.add(teamMember1);
        teamBuilderMain.add(teamMember2);
        teamBuilderMain.add(teamMember3);
        teamBuilderMain.add(teamMember4);

        //--------------------------------
        invpanel.setBounds(0,0,1080,720);
        invpanel.setVisible(false);
        invpanel.setLayout(null);

        icons = new JPanel();
        icons.setBackground(new Color(3,3,3,120));
        icons.setBounds(0,0,320,720);
        icons.setVisible(true);
        icons.setOpaque(true);
        //icons.setLayout(new FlowLayout(FlowLayout.LEFT,8,10)  );
        icons.setLayout(new GridLayout(10,2,8,15));
        //invpanel.add(icons);

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };
        
        scrollBar.addAdjustmentListener(onScroll);
        scrollBar.setBackground(new Color(0,0,0,255));
        
        iconScroll = new JScrollPane();
        iconScroll.setBounds(740,100,320,550);
        iconScroll.setBackground(new Color(0,3,3,255));
        iconScroll.setVisible(true);
        iconScroll.setVerticalScrollBar(scrollBar);
        iconScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        iconScroll.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
        iconScroll.setOpaque(false);
        iconScroll.getVerticalScrollBar().setUnitIncrement(20);
        iconScroll.setViewportView(icons);
        invpanel.add(iconScroll);
         

        stars = new JPanel();
        stars.setBackground(null);
        stars.setOpaque(false);
        stars.setBounds(20,600,420,45);
        stars.setVisible(true);
        stars.setLayout(new FlowLayout(FlowLayout.CENTER,-20,0));
        invpanel.add(stars);

        name = new JLabel();
        name.setBackground(Color.GREEN);
        name.setBounds(400,0,700,80);
        name.setText("Joel Tsang");
        name.setHorizontalTextPosition(JLabel.LEFT);
        name.setVerticalTextPosition(JLabel.CENTER);
        name.setFont(new Font("G2 Sans Serif", Font.PLAIN,50));
        name.setVisible(true);
        invpanel.add(name);

        grade = new JLabel();
        grade.setBounds(400,80,400,30);
        grade.setText("Grade 12");
        grade.setHorizontalTextPosition(JLabel.LEFT);
        grade.setVerticalTextPosition(JLabel.CENTER);
        grade.setFont(new Font("Times new roman", Font.PLAIN,28));
        grade.setForeground(Color.BLACK);
        grade.setVisible(true);
        invpanel.add(grade);

        charArt = new JPanel();
        charArt.setBounds(-25,10,510,666);
        charArt.setVisible(true);
        charArt.setOpaque(false);
        // charArt.setLayout(null); ./resources/character/AVIAN/ncGDEV_AVIAN_MAIN.png
        ImageIcon tempy = scaleImage(new ImageIcon("resources\\character\\JOEL\\ncGDEV_JOEL.png"),370,666);
        charArtMain = new JLabel(tempy);
        charArtMain.setVisible(true);
        charArtMain.setOpaque(false);
        charArtMain.setBounds(0,0,370,666);
        charArtMain.setVerticalAlignment(JLabel.CENTER);
        charArtMain.setHorizontalAlignment(JLabel.CENTER);
        charArt.add(charArtMain);

        timesPulled = new JLabel();
        timesPulled.setBounds(530,88,90,20);
        timesPulled.setText("Copies: 0");
        timesPulled.setFont(new Font("G2 Sans Serif", Font.PLAIN,17));
        timesPulled.setHorizontalTextPosition(JLabel.RIGHT);
        timesPulled.setForeground(Color.RED);
        timesPulled.setVisible(true);
        invpanel.add(timesPulled);
        invpanel.add(charArt);

        upStar = new JLabel();
        upStar.setBounds(610,80,120,72);
        upStar.setIcon(new ImageIcon("resources\\UI\\upgrade.png"));
        upStar.setBackground(Color.BLACK);
        upStar.setVisible(true);
        upStar.setOpaque(false);
        upStar.setVerticalTextPosition(JLabel.BOTTOM);
        upStar.setHorizontalTextPosition(JLabel.CENTER);
        upStar.setVerticalAlignment(JLabel.TOP);
        upStar.setIconTextGap(1);
        upStar.setForeground(Color.YELLOW);
        upStar.setFont(new Font("G2 Sans Serif", Font.PLAIN,10));
        upStar.setHorizontalAlignment(JLabel.CENTER);
        invpanel.add(upStar);

        skills = new JLabel();
        skills.setBounds(400,520,270,100);
        skills.setFont(new Font("G2 Sans Serif", Font.BOLD,17));
        skills.setForeground(Color.BLACK);
        invpanel.add(skills);

        infoboard = new JLabel();
        infoboard.setBackground(Color.RED);
        infoboard.setBounds(400,180,340,340);
        infoboard.setText("<html>"+"hey whats up</html>");
        infoboard.setFont(new Font("Times new roman", Font.PLAIN,20));
        infoboard.setVerticalAlignment(JLabel.TOP);
        infoboard.setVisible(true);
        invpanel.add(infoboard);

        /* banner 1 default (0,100,150,58) */
        banner1 = new JPanel();
        banner1.setBackground(Color.RED);
        banner1.setBounds(0,100,160,65);
        banner1.setOpaque(true);
        banner1.setLayout(null);
        JLabel banner1icon = new JLabel(scaleImage(new ImageIcon("resources\\UI\\bkg.PNG"),160,107));
        banner1icon.setBounds(0,-20,160,107);
        banner1.add(banner1icon);
        banner1.addMouseListener(banner1update);

        /* banner 2 default (0,200,150,58) */
        banner2 = new JPanel();
        banner2.setBackground(Color.BLUE);
        banner2.setBounds(0, 175, 150,58);
        banner2.setLayout(null);
        JLabel banner2icon = new JLabel(scaleImage(new ImageIcon("resources\\UI\\THANK_YOU.PNG"),320,214));
        banner2icon.setBounds(-80,0,320,214);
        banner2.addMouseListener(banner2update);
        banner2.add(banner2icon);        
        banner2.setOpaque(true);

        mainBanner1 = new JPanel();
        mainBanner1.setBackground(Color.GREEN);
        mainBanner1.setBounds(210, 80, 800,510);
        mainBanner1.setOpaque(true);
        mainBanner1.setVisible(true);
        mainBanner1.setLayout(null);
        JLabel banban = new JLabel(new ImageIcon("resources\\UI\\Banner1.png"));
        banban.setBounds(0,0,800,510);
        banban.setVisible(true);
        mainBanner1.add(banban);
        
        //animate(mainBanner1, new Point((95)-10,0),60,100);

        bannerName1 = new JLabel();
        
        bannerName1.setText("<html>MKHS Student Recruitment");
        bannerName1.setFont(new Font("Times new roman", Font.PLAIN,35));
        bannerName1.setVerticalAlignment(JLabel.TOP);
        bannerName1.setHorizontalAlignment(JLabel.CENTER);
        bannerName1.setVisible(true);
        bannerName1.setBounds(10,10,250,80);
        mainBanner1.add(bannerName1);
        
        
        mainBanner2 = new JPanel();
        mainBanner2.setBackground(Color.ORANGE);
        mainBanner2.setBounds(210, 80, 800,510);
        mainBanner2.setOpaque(true);
        mainBanner2.setLayout(null);
        JLabel ty = new JLabel(new ImageIcon("resources\\UI\\THANK_YOU.png"));
        ty.setBounds(0,0,800,510);
        ty.setVisible(true);
        mainBanner2.add(ty);

        inventory = new JPanel();
        inventory.setBackground(Color.YELLOW);
        inventory.setBounds(50,580,60,60);
        inventory.setVisible(true);
        inventory.setLayout(null);
        JLabel tempInv = new JLabel(scaleImage(new ImageIcon("resources\\UI\\StudentList.png"),60,60));
        tempInv.setBounds(0,0,60,60);
        inventory.add(tempInv);
        inventory.addMouseListener(invScreen);

        //right button
        pull1 = new JPanel();
        pull1.setBackground(Color.BLACK);
        pull1.setBounds(840, 580, 175,45);
        pull1.addMouseListener(pull10);
        pull1.setLayout(null);
        JLabel tempPull = new JLabel(new ImageIcon("resources\\UI\\10pull.png"));
        tempPull.setBounds(0,0,175,45);
        pull1.add(tempPull);

        //left button
        /* 
        pull2 = new JPanel();
        pull2.setBackground(Color.BLACK);
        pull2.setBounds(657, 580, 175,45);*/

        bigpanel.setBounds(60,140,950,400);
        bigpanel.setVisible(false);
        bigpanel.setOpaque(false);
        bigpanel.setLayout(new GridLayout(1,10,5,0));
       
        backButton = new JLabel();
        backButton.setBounds(975,25,50,50);
        backButton.setBackground(Color.BLACK);
        backButton.setVisible(false);
        backButton.setOpaque(true);
        backButton.setIcon(scaleImage(new ImageIcon("resources\\UI\\Back.png"),50,50));

        teamBuilderButton = new JPanel();
        teamBuilderButton.setBackground(Color.BLACK);
        teamBuilderButton.setBounds(140, 580, 60,60);
        teamBuilderButton.setLayout(null);
        JLabel teamTemp = new JLabel(scaleImage(new ImageIcon("resources\\UI\\Team.png"),60,60));
        teamTemp.setBounds(0,0,60,60);
        teamBuilderButton.add(teamTemp);
        teamBuilderButton.addMouseListener(teamBuilderButtonMouseListener);

        //-------------------------- Team Members button
        teamMember1.addMouseListener(teamMember1Listener);
        teamMember2.addMouseListener(teamMember2Listener);
        teamMember3.addMouseListener(teamMember3Listener);
        teamMember4.addMouseListener(teamMember4Listener);


        //-------------------------- 
        JLabel bkg2 = new JLabel(new ImageIcon("resources\\UI\\bkg.PNG"));
        bkg2.setBounds(0,0,1080,720);
        bkg2.setVisible(true); 
        JLabel bkg3 = new JLabel(new ImageIcon("resources\\UI\\bkg.PNG"));
        bkg3.setBounds(0,0,1080,720);
        bkg3.setVisible(true);
        bkg4 = new JLabel(new ImageIcon("resources\\UI\\bkg.PNG"));
        bkg4.setBounds(0,0,1080,720);
        bkg4.setVisible(true);
        //---------------------------
        mapButton = new JPanel();
        mapButton.setBounds(975,100,50,50);
        mapButton.setBackground(Color.BLUE);
        mapButton.setVisible(true);
        mapButton.setOpaque(true);
        mapButton.addMouseListener(openMap);
        JLabel mappy = new JLabel(scaleImage(new ImageIcon("resources\\UI\\MAPUI.png"),50,50));
        mappy.setBounds(0,0,50,50);
        mapButton.setLayout(null);
        mapButton.add(mappy);

        //--------------------------

        this.add(backButton);  
        this.add(bigpanel);
        main.add(inventory);
        main.add(pull1);
       // main.add(pull2);
        main.add(teamBuilderButton);
        main.add(mainBanner1);
        main.add(mainBanner2);
        main.add(banner1);
        main.add(banner2);
        main.add(bkg);
        invpanel.add(bkg2);
        teamBuilderMain.add(mapButton);
        teamBuilderMain.add(bkg3);
        this.add(teamBuilderMain);
        this.add(invpanel);
        this.add(map);
        this.add(main);
        this.add(bkg4);
        repaint(); //THIS SINGLE LINE IS THE MOST OP THING

        for(int i =0; i < allChar.size();i++){
            Character temp = allChar.get(i);
            if(temp.getStar() == 1){
                rarity1.add(temp);
            }
            if(temp.getStar() == 2){
                rarity2.add(temp);
            }
            if(temp.getStar() == 3){
                rarity3.add(temp);
            }
            if(temp.getStar() == 4){
                rarity4.add(temp);
            }
            if(temp.getStar() == 5){
                rarity5.add(temp);
            }
            if(temp.getStar() == 6){
                rarity6.add(temp);
            }
        }
         
      try {
         FileInputStream fileIn = new FileInputStream("save.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         @SuppressWarnings("unchecked")
         ArrayList<Save> oldsave = (ArrayList<Save>) in.readObject();
         in.close();
         fileIn.close();
         for(int i = 0; i<oldsave.size();i++){
            String tempName = oldsave.get(i).getName();
            for(int c =0;c<allChar.size();c++){
                String tempName2 = allChar.get(c).getName();
                if(tempName.equals(tempName2)){
                    playerInventory.add(allChar.get(c));
                    playerInventory.get(i).setCopy(oldsave.get(i).getCopy());
                    playerInventory.get(i).setUpgrade(oldsave.get(i).getUpgradednum());
                    c = allChar.size();

                }
            }
         }
         for(int ss = 0; ss<playerInventory.size();ss++){
            hasBeenPulled.put(playerInventory.get(ss).getName(),true);
          }
      } catch (IOException i) {
         playerInventory.add(allChar.get(0));
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         c.printStackTrace();
         return;
      }

     
    }
    
    AdjustmentListener onScroll = new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e){
            repaint();
        }
    };
    //mouse listeners make the panels do stuff when they get clicked
    MouseListener starUpListener = new MouseAdapter() {
        
        @Override
        public void mouseClicked(MouseEvent e){
            upStar.removeMouseListener(starUpListener);
            globaltemp.upgrade();
            repaint();
                stars.removeAll();
                for(int i = 0; i < globaltemp.getStar(); i++){
                    JLabel star = new JLabel(scaleImage(new ImageIcon("resources\\UI\\star.png"),45,45));
                    star.setHorizontalAlignment(JLabel.LEFT);
                    star.setBounds(new Rectangle(45,45));
                    star.setVisible(true);
                    stars.add(star);
                    repaint();
                }
            if(globaltemp.checkUpgradable()){
                upStar.setForeground(Color.GREEN);
                upStar.setText("Upgrade! #" + globaltemp.getTimesUpgraded());
                upStar.addMouseListener(starUpListener);
                repaint();
            }
            else{
                upStar.setForeground(Color.RED);
                upStar.setText((globaltemp.neededForUpgrade()+1)+" Copies needed");
            }
            repaint();
        }
    };

    MouseListener openMap = new MouseAdapter() {
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(team.isTeamFull()){
            map = new Map(team);
            add(map);
            map.setVisible(true);
            map.setOpaque(true);
            teamBuilderMain.setVisible(false);
            backButton.removeMouseListener(back); 
            backButton.addMouseListener(mapBack);
            bkg4.setVisible(false);
            repaint();
            map.rerepaint();  
            }
        }
    };

    MouseListener mapBack = new MouseAdapter() {
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(map.fullSchoolVisible()){
                map.setVisible(false);
                teamBuilderMain.setVisible(true);
                backButton.removeMouseListener(mapBack);
                backButton.addMouseListener(back);
                bkg4.setVisible(true);
                repaint();
            }
            else if(map.isBigBuildVisible()){
                map.backToMap();
            }
            else if(map.isB220Visible()){
                map.leaveClassroom();
            }
        }
    };

   MouseListener banner1update = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        banner1.setBounds(0,100,160,65);
        banner2.setBounds(0, 175,  150,58);
        mainBanner1.setVisible(true);
        mainBanner2.setVisible(false);
        pull1.setVisible(true);
        teamBuilderButton.setVisible(true);
        
    }
   };

   MouseListener banner2update = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        banner1.setBounds(0, 100, 150,58);
        banner2.setBounds(0, 169,160,65);
        mainBanner1.setVisible(false);
        mainBanner2.setVisible(true);
        pull1.setVisible(false);
    }
   };

   MouseListener pull10 = new MouseAdapter(){

    @Override
    public void mouseClicked(MouseEvent e){
        hide();
        itspullingtime();
    }

   };

   MouseListener back = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(invpanel.isVisible()){
            icons.removeAll();
        }
        hide();
    }
    
   };

   MouseListener invScreen = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        hide();
        backButton.addMouseListener(back);
       // invpanel.removeAll();
       
        addIcon();
        invpanel.setVisible(true);
    }
   };
   // for change screen 

    //------------------------- TEAM BUILDER

   

    MouseListener teamBuilderButtonMouseListener = new MouseAdapter() {
    
        @Override
        public void mouseClicked(MouseEvent e){
            hide();
            backButton.addMouseListener(back);
           // invpanel.removeAll();
            
           playerInventory = RNG.sortByRarity(playerInventory);
           addTeam(icons2);
           teamBuilderMain.setVisible(true);
        }
       };
    
       int teamSelectMember = -1;
    
       MouseListener teamMember1Listener = new MouseAdapter() {
            
        @Override
        public void mouseClicked(MouseEvent e){
            teamMember1.setForeground(Color.WHITE);
            teamMember1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            teamMember2.setBorder(null);
            teamMember3.setBorder(null);
            teamMember4.setBorder(null);
            System.out.println("Team Slot 1 Selected");
            teamSelectMember = 0;
            repaint();
    
        }
       };
    
       MouseListener teamMember2Listener = new MouseAdapter() {
            
        @Override
        public void mouseClicked(MouseEvent e){
            teamMember2.setForeground(Color.WHITE);
            teamMember2.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            teamMember1.setBorder(null);
            teamMember3.setBorder(null);
            teamMember4.setBorder(null);
            System.out.println("Team Slot 2 Selected");
            teamSelectMember = 1;
            repaint();

        }
       };
    
       MouseListener teamMember3Listener = new MouseAdapter() {
            
        @Override
        public void mouseClicked(MouseEvent e){
            teamMember3.setForeground(Color.WHITE);
            teamMember3.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            teamMember2.setBorder(null);
            teamMember1.setBorder(null);
            teamMember4.setBorder(null);
            System.out.println("Team Slot 3 Selected");
            teamSelectMember = 2;
            repaint();

    
        }
       };
       MouseListener teamMember4Listener = new MouseAdapter() {
            
        @Override
        public void mouseClicked(MouseEvent e){
            teamMember4.setForeground(Color.WHITE);
            teamMember4.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            teamMember2.setBorder(null);
            teamMember3.setBorder(null);
            teamMember1.setBorder(null);
            System.out.println("Team Slot 4 Selected");
            teamSelectMember = 3;
            repaint();

    
        }
       };
    
    
    
       //-------------------------
   public void hide(){

    if(!main.isVisible()){
        bigpanel.removeAll();
        bigpanel.setVisible(false);
        icons2.removeAll();
    }
   
        invpanel.setVisible(false);
        teamBuilderMain.setVisible(false);
        backButton.setVisible(!backButton.isVisible());

        main.setVisible(!main.isVisible());
        /* banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        mainBanner1.setVisible(false);
        mainBanner2.setVisible(false);
        pull1.setVisible(!pull1.isVisible());
        pull2.setVisible(!pull2.isVisible());
        */
        teamMember1.setBorder(null);
        teamMember2.setBorder(null);
        teamMember3.setBorder(null);
        teamMember4.setBorder(null);
        if(switcher){
            backButton.removeMouseListener(back);
        }
        switcher = !switcher;
        repaint();

   }

   //functio nthat adds all the icons (need to make it based off)
    public void addIcon(){
        int length = allChar.size();
        current = 0;
        for(;current < length;current++){
            Character tchar = allChar.get(current);
            for(int i = 0;i<playerInventory.size();i++){
                if(tchar.getName().equals(playerInventory.get(i).getName())){
                    tchar = playerInventory.get(i);
                    System.out.println(tchar.getName() + "->>>>" + tchar.getCopies());
                }
            }
            globaltemp = tchar;
            JLabel iIcon = new JLabel();
            // iIcon.setBounds(0,0,10,10);
            
            ImageIcon im = tchar.getSmall(); //new ImageIcon("./resources/character/main/Blade.png");
            Image imm = im.getImage();
            Image newimg = imm.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
            im = new ImageIcon(newimg); 
            iIcon.setIcon(im); 
            iIcon.setBackground(Color.BLACK);
            iIcon.setVisible(true);
            iIcon.setText(tchar.getName().substring(0,tchar.getName().indexOf(" ")));
            iIcon.setHorizontalTextPosition(JLabel.CENTER);
            iIcon.setVerticalTextPosition(JLabel.BOTTOM);
            iIcon.setFont(new Font("G2 Sans Serif", Font.PLAIN,10));
            iIcon.setForeground(Color.BLACK);
            int s = current;
            MouseAdapter tempA = new MouseAdapter() {
                Character tchar2= globaltemp;
                @Override
                public void mouseClicked(MouseEvent e){
                    upStar.removeMouseListener(starUpListener);
                    Character tempChar = tchar2;
                    if(s != selected){
                    selected = s;
                    System.out.println(s + ":" + selected);
                    infoboard.removeAll();
                    infoboard.setText("<html>"+ tempChar.getLore());
                    name.setText(tempChar.getName());
                    grade.setText("<html>Grade " + tempChar.getGrade());
                    timesPulled.setText("Copies: "+tempChar.getCopies());
                    stars.removeAll();
                    for(int i = 0; i < tempChar.getStar(); i++){
                        JLabel star = new JLabel(scaleImage(new ImageIcon("resources\\UI\\star.png"),45,45));
                        star.setHorizontalAlignment(JLabel.LEFT);
                        star.setBounds(new Rectangle(45,45));
                        star.setVisible(true);
                        stars.add(star);
                    }
                    int starlvl = tempChar.getStar();
                    HashMap<Integer,String> skills1 = new HashMap<Integer,String>(){
                        { put(1,"Main Attack: Deals 100% ATK\nSkill: Deals "+ starlvl*200+"% ATK");}
                        { put(2,"Main Attack: Deals 100% ATK\nSkill: Increase all allies ATK by "+ 10*starlvl);}
                        { put(3,"Main Attack: Deals 100% ATK\nSkill: Increase all allies DEF by "+ 10*starlvl);}
                        { put(4,"Main Attack: Deals 100% ATK\nSkill: Increase all allies SPD by "+ 2*starlvl);}
                        { put(5,"Main Attack: Deals 100% ATK\nSkill: Decrease boss SPD by "+ 10*starlvl);}
                        { put(6,"Main Attack: Deals 100% ATK\nSkill: Decrease boss ATK by "+ 5*starlvl);}
                        { put(7,"Main Attack: Deals 100% ATK\nSkill: Decrease boss DEF by "+ 5*starlvl);}
                        { put(8,"Main Attack: Deals 100% ATK\nSkill: Heals all allies by "+ 50*starlvl);}
                    };
                    
                    skills.setText("<html>"+skills1.get(tempChar.getSkill()));
                    globaltemp = tempChar;

                    if(globaltemp.checkUpgradable()){
                        upStar.setForeground(Color.GREEN);
                        upStar.setText("Upgrade!");
                        upStar.addMouseListener(starUpListener);
                    }
                    else{
                        upStar.setForeground(Color.RED);
                        upStar.setText((tempChar.neededForUpgrade()+1)+" Copies needed");
                    }

                    if(tempChar.getName().equals("Yuuki Haishima")){
                        charArtMain.setIcon(scaleImage(tempChar.getFull(),504,666));
                    }       
                    else{
                        charArtMain.setIcon(scaleImage(tempChar.getFull(),370,666));
                    }
                    repaint();
                    // add text and image stuff here
                }
                }
            };
            iIcon.addMouseListener(tempA); 
            icons.add(iIcon);
        }
    }

    //----=====-----
    
    public void addTeam(JPanel place){
        int length = playerInventory.size();
        current = 0;
        for(;current < length;current++){
            if(length == 0){
                return;
            }
            
            JLabel iIcon = new JLabel();
            // iIcon.setBounds(0,0,10,10);
            
            ImageIcon im = playerInventory.get(current).getSmall(); //new ImageIcon("./resources/character/main/Blade.png");
            Image imm = im.getImage();
            Image newimg = imm.getScaledInstance(45,45,  java.awt.Image.SCALE_SMOOTH);
            im = new ImageIcon(newimg); 
            iIcon.setIcon(im); 
            iIcon.setBackground(Color.BLACK);
            iIcon.setVisible(true);

            MouseAdapter tempA = new MouseAdapter(){
                int temp = current;

                @Override
                public void mouseClicked(MouseEvent e){
                    Character tempChar = playerInventory.get(temp);
                    if((teamSelectMember >= 0) && tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(2) && tempChar != team.getTeamMember(3) ){
                        team.replaceMember(teamSelectMember, tempChar);
                    }
                    if(teamSelectMember == 0){
                        if(tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(2) && tempChar != team.getTeamMember(3) ){
                            team.replaceMember(0, tempChar);
                            if(tempChar.getName().equals("Yuuki Haishima")){
                                teamMember1.setIcon(scaleImage(tempChar.getFull(),360,475));
                            }
                            else{
                                teamMember1.setIcon(scaleImage(tempChar.getFull(),250,450));
                            }
                            teamMember1.setBorder(null);
                            teamSelectMember = -1;
                        } //108 480
                        
                        repaint();
                    }
                    else if(teamSelectMember == 1){
                        if(tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(2) && tempChar != team.getTeamMember(3) ){
                            team.replaceMember(1, tempChar);
                            if(tempChar.getName().equals("Yuuki Haishima")){
                                teamMember2.setIcon(scaleImage(tempChar.getFull(),360,475));
                            }
                            else{
                                teamMember2.setIcon(scaleImage(tempChar.getFull(),250,450));
                            }
                            teamMember2.setBorder(null);
                            teamSelectMember = -1;
                            repaint();
                        }
                    }
                    else if(teamSelectMember == 2){
                        if(tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(3) ){
                            team.replaceMember(2, tempChar);
                            if(tempChar.getName().equals("Yuuki Haishima")){
                                teamMember3.setIcon(scaleImage(tempChar.getFull(),360,475));
                            }
                            else{
                                teamMember3.setIcon(scaleImage(tempChar.getFull(),250,450));
                            }
                            teamMember3.setBorder(null);
                            teamSelectMember = -1;
                            repaint();
                    }
                    }
                    else if(teamSelectMember == 3){
                        if(tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(2) ){
                            team.replaceMember(3, tempChar);
                            if(tempChar.getName().equals("Yuuki Haishima")){
                                teamMember4.setIcon(scaleImage(tempChar.getFull(),360,475));
                            }
                            else{
                                teamMember4.setIcon(scaleImage(tempChar.getFull(),250,450));
                            }
                            teamMember4.setBorder(null);
                            teamSelectMember = -1;
                            repaint();
                        }
                    }
                }
            };

            iIcon.addMouseListener(tempA); 
            place.add(iIcon);
        }
    }
    
    
    // for the pulling part
    public void itspullingtime(){
        
        bigpanel.setVisible(true);
        for(int i = 0;i<10;i++){
            ArrayList<Character> temparray = rarity.get(RNG.odds()-1);
            int index = (int) RNG.randomize(temparray.size());
            index--;
            Character temp = temparray.get(index);
            tempChars.add(temp);
            String nam = temp.getName();
            if(hasBeenPulled.get(nam) == null){
                playerInventory.add(temp);
                for(int h = 0; h<playerInventory.size();h++){
                    int county = 0;
                    if(nam.equals(playerInventory.get(playerInventory.size()-1).getName())){
                        county++;
                    }
                    if(county > 1){
                    System.out.println(county);
                    }
                }
                hasBeenPulled.put(nam,true);
                playerInventory.get(playerInventory.size()-1).addCopy();
            }
            else{
                for(int b = 0;b < playerInventory.size();b++){
                    if(nam.equals(playerInventory.get(b).getName())){
                        playerInventory.get(b).addCopy();
                        System.out.println(playerInventory.get(b).getName() + " ---->>>> " + playerInventory.get(b).getCopies());
                        b = 1000;
                    }
                }
            }
            System.out.println(temp.getName() + ", " + temp.getCopies());

        }
        tempChars = RNG.sortByRarity(tempChars);
        Timer timer = new Timer(100, new ActionListener() {
            int x = -1;
            @Override
            public void actionPerformed(ActionEvent e){
                x+=1;
                JPanel pull = new JPanel();
                pull = new JPanel();
                pull.setBounds((x*95)+2,0,90,400);
                pull.setBackground(new Color(200,200,200,200));
                pull.setVisible(true);
                bigpanel.add(pull);
                ImageIcon im = scaleImage(tempChars.get(x).getMain(),90,400);
                JLabel label = new JLabel(im);
                label.setBounds(0,0,90,400);
                label.setBackground(Color.RED);
                label.setVisible(true); 
                pull.add(label);
                if(x>8){
                    backButton.addMouseListener(back);
                    tempChars = new ArrayList<Character>();
                    ((Timer)e.getSource()).stop();
                }
                repaint();
                animate(pull, new Point(((x*95)),0),2,2);
            }
            
            
        });
        timer.start();
    }

    public static ImageIcon scaleImage(ImageIcon image,int w,int h){
        Image temp = image.getImage();
        Image newImg = temp.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    // make sure frames and interval % == 0 ;
    public void animate(JComponent component, Point newPoint, int frames, int interval) {
        Rectangle compBounds = component.getBounds();
    
        Point oldPoint = new Point(compBounds.x, compBounds.y),
              animFrame = new Point((newPoint.x - oldPoint.x) / frames, (newPoint.y - oldPoint.y) / frames);
    
        new Timer(interval, new ActionListener() {
            int currentFrame = 0;
            public void actionPerformed(ActionEvent e) {
                component.setBounds(oldPoint.x + (animFrame.x * currentFrame), oldPoint.y + (animFrame.y * currentFrame), compBounds.width, compBounds.height);
                if (currentFrame != frames)
                    currentFrame++;
                else{
                    ((Timer)e.getSource()).stop();
                }
                repaint();  
            }
            
        }).start();
    }

 
    




}



/* 
    This is all of the stuff you can do with mouseListeners

    @Override
    public void mouseClicked(MouseEvent e){
        
        this.setBounds(0,100, 170, 80);
    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    */