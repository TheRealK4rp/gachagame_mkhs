import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.HashMap;

/* TO DO LIST
 *  1) Finish rarity system "Hashmap string -> int" (just need to assign rarities not at random)
 *  2) make inventory system work (copies work, player inventory works)
 *  3) make save data (need to make previous one work with copies) 
 *  4) make things glow when you hover over them (prob not doing this one)
 *  5) add sounds for stuff
 *  6) combat system also team builder <- SUPER IMPORTANT BECAUSE I HAVENT DONE IT YET
 *  7) 
 */




public class MainScreen extends JFrame {
     

    JPanel banner1, banner2, mainBanner1, mainBanner2, pull1, pull2, backButton, inventory, main, stars, charArt, teamBuilderButton;
    JPanel bigpanel = new JPanel();
    JPanel invpanel = new JPanel();
    JPanel teamBuilderMain = new JPanel();
    JPanel icons, icons2;
    JLabel name, grade;
    JLabel infoboard, timesPulled;
    JLabel bannerName1,bannerName2;
    JLabel teamMember1, teamMember2, teamMember3, teamMember4;
    Team team = new Team();
    ArrayList<Character> tempChars = new ArrayList<Character>();
    int hold = 0;
    int current = 0;
    boolean switcher = false;
    ImageIcon placeholder = new ImageIcon("project\\resources\\character\\main\\placeholder.png");


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
    // check if character has already been palled so i can jsut add 1 to the copy count of the Character
    HashMap<Character,Boolean> hasBeenPulled = new HashMap<Character,Boolean>();
     //every person
     Character joel = new Character("Joel Tsang", new ImageIcon("project\\resources\\character\\main\\test.png"), placeholder,"lmao hahahahahahaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaa aaaaaaa aaaaaaaaaaaaaaaaaa");
     Character fake = new Character("fake",new ImageIcon("project\\resources\\character\\main\\joel-1.png"),placeholder,"random shi adsadasdasdasdasdasdasdasdasdsat");
     Character vincent = new Character("Vincent Wu",placeholder,placeholder,"im vincent");
     Character jasonh = new Character("Jason Huynh",placeholder,placeholder,"im jason");
     Character jimmy = new Character("Jimmy Liang",placeholder,placeholder,"i love joel tsang");
     Character leo = new Character("Leo Chan",placeholder,placeholder,"im leo");
     Character kevin = new Character("Kevin Lin", placeholder, placeholder, "im kevin");
     Character ivan = new Character("Ivan Kuang", placeholder, placeholder, "i am cool and mysterious");
     Character yuping = new Character("Yuping Wang", placeholder, placeholder, "im yuping");
     Character swanyie = new Character("Swanyie Htet", placeholder, placeholder, "im swanyie");
     Character kaitlyn = new Character("Kaitlyn Cao", placeholder, placeholder, "im kaitlyn");
     Character ruize = new Character("Ruize Tian", placeholder, placeholder, "im ruize");
     Character jolie = new Character("Jolie Hseih",placeholder,placeholder,"im jolie");
     Character amber = new Character("Amber Cai", placeholder, placeholder, "im amber");
     Character avian = new Character("Avian Thai", new ImageIcon("project\\resources\\character\\AVIAN\\ncGDEV_AVIAN_BANNER.png"), new ImageIcon("project\\resources\\character\\AVIAN\\ncGDEV_AVIAN_ICON.png"), "im avian");
     Character cory = new Character("Cory Tsan", placeholder, placeholder, "im cory");
     Character harrison = new Character("Harrison Duong", placeholder, placeholder, "im harrison");
     Character ethan11 = new Character("Ethan Dang",placeholder,placeholder,"im ethan",11);
     Character bill = new Character("Bill Tran", placeholder, placeholder, "im bill");
     Character brandon = new Character("Brandon Martinez", placeholder, placeholder, "im brandon");
     Character jasonw = new Character("Jason Wu", placeholder, placeholder, "im jason");
     Character yuuki = new Character("Yuuki Haishima", placeholder, placeholder, "im yuuki");
     Character kenny = new Character("Kenny Be", placeholder, placeholder, "im kenny");
     Character johnny = new Character("Johnny Nguyen", placeholder, placeholder, "im johnny");
     Character sherry = new Character("Sherry Keung", placeholder, placeholder, "im sherry");
     Character timothy = new Character("Timothy Pengshung", placeholder, placeholder, "im tim");
     Character matthew = new Character("Matthew Pena",placeholder,placeholder,"im matthew");
     Character jonathand = new Character("Jonathan Der",placeholder,placeholder,"im der");
     Character ruby = new Character("Ruby Yao", placeholder, placeholder, "im ruby");
     Character colin = new Character("Colin Shiung",placeholder,placeholder,"The main character.");
     Character noah = new Character("Noah Tsang",placeholder,placeholder,"im sailo",9);
     Character vicky = new Character("Vicky Huang",placeholder,placeholder,"im vicky");
     Character alton = new Character("Alton Qian",placeholder,placeholder,"im alton");
     Character peter = new Character("Peter Luu",placeholder,placeholder,"im peter");
     Character joleen = new Character("Joleen Wong",placeholder,placeholder,"im joleen");
     Character rachel = new Character("Rachel Wang",placeholder,placeholder,"im rachel");
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
        { add(amber);}
        { add(avian);}
        { add(cory);}
        { add(harrison);}
        { add(ethan11);}
        { add(bill);}
        { add(brandon);}
        { add(jasonw);}
        { add(yuuki);}
        { add(kenny);}
        { add(johnny);}
        { add(sherry);}
        { add(timothy);}
        { add(matthew);}
        { add(jonathand);}
        { add(ruby);}
        { add(noah);}
        { add(colin);}
        { add(vicky);}
        { add(alton);}
        { add(peter);}
        { add(joleen);}
        { add(rachel);}
    };

    // sorted into rarity list to make the RNG for pulling easier (sorts at startup see constructor)
    ArrayList<Character> rarity1 = new ArrayList<Character>(){
        { add(fake);}
        { add(avian);}
    };

    ArrayList<Character> rarity2 = new ArrayList<Character>(){
        { add(fake);}
    };

    ArrayList<Character> rarity3 = new ArrayList<Character>(){
        { add(fake);}
    };

    ArrayList<Character> rarity4 = new ArrayList<Character>(){
        { add(fake);}
    };

    ArrayList<Character> rarity5 = new ArrayList<Character>(){
        { add(fake);}
    };

    ArrayList<Character> rarity6 = new ArrayList<Character>(){
        { add(fake);}
    };

    // puts it all the rarities to one list, the rarity for each person in a lsit is the same
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

        team.addMember(fake);
        team.addMember(fake);
        team.addMember(fake);
        team.addMember(fake);


        // sets the window
        this.setTitle("Stupid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1080,720);
        this.setVisible(true);
         //RNG.serialize("test.ser",playerInventory);
        main = new JPanel();
        main.setBounds(0,0,1080,720);
        main.setVisible(true);
        main.setLayout(null);

        invpanel.setBounds(0,0,1080,720);
        invpanel.setVisible(false);
        invpanel.setLayout(null);

        icons = new JPanel();
        icons.setBackground(Color.BLUE);
        icons.setBounds(0,0,220,720);
        icons.setVisible(true);
        icons.setLayout(new FlowLayout(FlowLayout.LEFT,8,10)  );
        invpanel.add(icons);


        //--------------------------------
        teamBuilderMain.setBounds(0,0,1080,720);
        teamBuilderMain.setVisible(false);
        teamBuilderMain.setLayout(null);

        teamMember1 = new JLabel();
        teamMember1.setBackground(Color.RED);
        teamMember1.setBounds(60,20,180,460);
        teamMember1.setOpaque(true);

        teamMember2 = new JLabel();
        teamMember2.setBackground(Color.RED);
        teamMember2.setBounds(280,20,180,460);
        teamMember2.setOpaque(true);

        teamMember3 = new JLabel();
        teamMember3.setBackground(Color.RED);
        teamMember3.setBounds(500,20,180,460);
        teamMember3.setOpaque(true);

        teamMember4 = new JLabel();
        teamMember4.setBackground(Color.RED);
        teamMember4.setBounds(720,20,180,460);
        teamMember4.setOpaque(true);

        

        icons2 = new JPanel();
        icons2.setBackground(Color.BLUE);
        icons2.setBounds(0,500,1080,270);
        icons2.setVisible(true);
        icons2.setLayout(new FlowLayout(FlowLayout.CENTER,8,10)  );
        
        teamBuilderMain.add(icons2);
        teamBuilderMain.add(teamMember1);
        teamBuilderMain.add(teamMember2);
        teamBuilderMain.add(teamMember3);
        teamBuilderMain.add(teamMember4);

        //--------------------------------

        stars = new JPanel();
        stars.setBackground(Color.PINK);
        stars.setBounds(220,110,350,70);
        stars.setVisible(true);
        invpanel.add(stars);

        name = new JLabel();
        name.setBackground(Color.GREEN);
        name.setBounds(220,0,700,80);
        name.setText("Jia Hua Vincent Wu Zhang ");
        name.setHorizontalTextPosition(JLabel.LEFT);
        name.setVerticalTextPosition(JLabel.CENTER);
        name.setFont(new Font("Times New Roman", Font.PLAIN,50));
        name.setVisible(true);
        invpanel.add(name);

        grade = new JLabel();
        grade.setBounds(220,80,400,30);
        grade.setText("Grade 12");
        grade.setHorizontalTextPosition(JLabel.LEFT);
        grade.setVerticalTextPosition(JLabel.CENTER);
        grade.setFont(new Font("Times New Roman", Font.PLAIN,28));
        grade.setForeground(Color.LIGHT_GRAY);
        grade.setVisible(true);
        invpanel.add(grade);

        charArt = new JPanel();
        charArt.setBackground(Color.LIGHT_GRAY);
        charArt.setBounds(570,10,510,666);
        charArt.setVisible(true);
        // charArt.setLayout(null);
        ImageIcon tempy = scaleImage(new ImageIcon("project\\resources\\character\\AVIAN\\ncGDEV_AVIAN_MAIN.png"),370,666);
        JLabel charArtMain = new JLabel(tempy);
        charArtMain.setVisible(true);
        charArtMain.setBounds(new Rectangle(370,666));
        charArtMain.setVerticalAlignment(JLabel.CENTER);
        charArtMain.setHorizontalAlignment(JLabel.CENTER);
        charArt.add(charArtMain);

        timesPulled = new JLabel();
        timesPulled.setBounds(1030,90,100,20);
        timesPulled.setText("0");
        timesPulled.setFont(new Font("Times New Roman", Font.PLAIN,17));
        timesPulled.setHorizontalTextPosition(JLabel.RIGHT);
        timesPulled.setForeground(Color.RED);
        timesPulled.setVisible(true);
        invpanel.add(timesPulled);
        invpanel.add(charArt);

        infoboard = new JLabel();
        infoboard.setBackground(Color.RED);
        infoboard.setBounds(220,180,350,540);
        infoboard.setText("<html>"+"Very interesting text that will help me define the bounds of the text box i hope this is helpful so basically it didn't work because i had long word, there ain't no way</html>");
        infoboard.setFont(new Font("Times New Roman", Font.PLAIN,20));
        infoboard.setVerticalAlignment(JLabel.TOP);
        infoboard.setVisible(true);
        invpanel.add(infoboard);

        /* banner 1 default (0,100,150,58) */
        banner1 = new JPanel();
        banner1.setBackground(Color.RED);
        banner1.setBounds(0,100,160,65);
        banner1.setOpaque(true);
        banner1.addMouseListener(banner1update);

        /* banner 2 default (0,200,150,58) */
        banner2 = new JPanel();
        banner2.setBackground(Color.BLUE);
        banner2.setBounds(0, 175, 150,58);
        banner2.addMouseListener(banner2update);
        banner2.setOpaque(true);

        mainBanner1 = new JPanel();
        mainBanner1.setBackground(Color.GREEN);
        mainBanner1.setBounds(210, 80, 800,510);
        mainBanner1.setOpaque(true);
        mainBanner1.setVisible(true);
        mainBanner1.setLayout(null);
        
        //animate(mainBanner1, new Point((95)-10,0),60,100);

        bannerName1 = new JLabel();
        
        bannerName1.setText("<html>MKHS Student Recruitment");
        bannerName1.setFont(new Font("Times New Roman", Font.PLAIN,35));
        bannerName1.setVerticalAlignment(JLabel.TOP);
        bannerName1.setHorizontalAlignment(JLabel.CENTER);
        bannerName1.setVisible(true);
        bannerName1.setBounds(10,10,250,80);
        mainBanner1.add(bannerName1);
        
        
        mainBanner2 = new JPanel();
        mainBanner2.setBackground(Color.ORANGE);
        mainBanner2.setBounds(210, 80, 800,510);
        mainBanner2.setOpaque(true);

        inventory = new JPanel();
        inventory.setBackground(Color.YELLOW);
        inventory.setBounds(50,580,175,45);
        inventory.setVisible(true);
        inventory.addMouseListener(invScreen);

        //right button
        pull1 = new JPanel();
        pull1.setBackground(Color.BLACK);
        pull1.setBounds(840, 580, 175,45);
        pull1.addMouseListener(pull10);

        //left button
        pull2 = new JPanel();
        pull2.setBackground(Color.BLACK);
        pull2.setBounds(657, 580, 175,45);

        teamBuilderButton = new JPanel();
        teamBuilderButton.setBackground(Color.BLACK);
        teamBuilderButton.setBounds(474, 580, 175,45);
        teamBuilderButton.addMouseListener(teamBuilderButtonMouseListener);
        
        //-------------------------- Team Members button
        teamMember1.addMouseListener(teamMember1Listener);
        teamMember2.addMouseListener(teamMember2Listener);
        teamMember3.addMouseListener(teamMember3Listener);
        teamMember4.addMouseListener(teamMember4Listener);


        //-------------------------- 

        bigpanel.setBounds(60,140,950,400);
        bigpanel.setVisible(false);
        bigpanel.setLayout(new GridLayout(1,10,5,0));
       
        backButton = new JPanel();
        backButton.setBounds(1010,25,50,50);
        backButton.setBackground(Color.BLACK);
        backButton.setVisible(false);


        
        this.add(backButton);
        
        this.add(bigpanel);
        main.add(inventory);
        main.add(pull1);
        main.add(pull2);
        main.add(teamBuilderButton);
        main.add(mainBanner1);
        main.add(mainBanner2);
        main.add(banner1);
        main.add(banner2);
        this.add(teamBuilderMain);
        this.add(invpanel);
        this.add(main);
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

    }
    
    //mouse listeners make the panels do stuff when they get clicked
   MouseListener banner1update = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        banner1.setBounds(0,100,160,65);
        banner2.setBounds(0, 175,  150,58);
        mainBanner1.setVisible(true);
        mainBanner2.setVisible(false);
        
    }
   };

   MouseListener banner2update = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        banner1.setBounds(0, 100, 150,58);
        banner2.setBounds(0, 169,160,65);
        mainBanner1.setVisible(false);
        mainBanner2.setVisible(true);
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
        if(teamBuilderMain.isVisible()){
            icons2.removeAll();
        }
        hide();
    }
    
   };

   //------------------------- TEAM BUILDER

   

   MouseListener teamBuilderButtonMouseListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        hide();
        backButton.addMouseListener(back);
       // invpanel.removeAll();

       addTeam(icons2);
       System.out.println("yes");
       teamBuilderMain.setVisible(true);
    }
   };

   int teamSelectMember = 0;

   MouseListener teamMember1Listener = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        teamMember1.setBounds(60,20,190,470);
        teamMember2.setBounds(280,20,180,460);
        teamMember3.setBounds(500,20,180,460);
        teamMember4.setBounds(720,20,180,460);


        System.out.println("Team Slot 1 Selected");
        teamSelectMember = 0;

    }
   };

   MouseListener teamMember2Listener = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        teamMember1.setBounds(60,20,180,460);
        teamMember2.setBounds(280,20,190,470);
        teamMember3.setBounds(500,20,180,460);
        teamMember4.setBounds(720,20,180,460);


        System.out.println("Team Slot 2 Selected");
        teamSelectMember = 1;

    }
   };

   MouseListener teamMember3Listener = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        teamMember1.setBounds(60,20,180,460);
        teamMember2.setBounds(280,20,180,460);
        teamMember3.setBounds(500,20,190,470);
        teamMember4.setBounds(720,20,180,460);

        System.out.println("Team Slot 3 Selected");
        teamSelectMember = 2;

    }
   };
   MouseListener teamMember4Listener = new MouseAdapter() {
        
    @Override
    public void mouseClicked(MouseEvent e){
        teamMember1.setBounds(60,20,180,460);
        teamMember2.setBounds(280,20,180,460);
        teamMember3.setBounds(500,20,180,460);
        teamMember4.setBounds(720,20,190,470);

        System.out.println("Team Slot 4 Selected");
        teamSelectMember = 3;

    }
   };



   //------------------------- 

   MouseListener invScreen = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        hide();
        backButton.addMouseListener(back);
       // invpanel.removeAll();
       
        addIcon(icons);
        invpanel.setVisible(true);
    }
   };
   // for change screen 
   public void hide(){

    if(!main.isVisible()){
        bigpanel.removeAll();
        bigpanel.setVisible(false);
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
        if(switcher){
            backButton.removeMouseListener(back);
        }
        switcher = !switcher;

        for(Character i : team.getTeamArray()){
            System.out.println(i.getName());
        }

   }

   //functio nthat adds all the icons (need to make it based off)
    public void addIcon(JPanel place){
        int length = allChar.size();
        current = 0;
        for(;current < length;current++){
        
            
            JLabel iIcon = new JLabel();
            // iIcon.setBounds(0,0,10,10);
            
            ImageIcon im = allChar.get(current).getSmall(); //new ImageIcon("./resources/character/main/Blade.png");
            Image imm = im.getImage();
            Image newimg = imm.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH);
            im = new ImageIcon(newimg); 
            iIcon.setIcon(im); 
            iIcon.setBackground(Color.BLACK);
            iIcon.setVisible(true);
            MouseAdapter tempA = new MouseAdapter() {
                int temp = current;
                @Override
                public void mouseClicked(MouseEvent e){
                    Character tempChar = allChar.get(temp);
                    infoboard.removeAll();
                    infoboard.setText("<html>"+ tempChar.getLore());
                    name.setText(tempChar.getName());
                    grade.setText("<html>Grade " + tempChar.getGrade());
                    timesPulled.setText(""+tempChar.getCopies());
                    // add text and image stuff here
                }
            };
            iIcon.addMouseListener(tempA); 
            place.add(iIcon);
        }
    }

    //----=====-----
    
    public void addTeam(JPanel place){
        int length = allChar.size();
        current = 0;
        for(;current < length;current++){
        
            
            JLabel iIcon = new JLabel();
            // iIcon.setBounds(0,0,10,10);
            
            ImageIcon im = allChar.get(current).getSmall(); //new ImageIcon("./resources/character/main/Blade.png");
            Image imm = im.getImage();
            Image newimg = imm.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH);
            im = new ImageIcon(newimg); 
            iIcon.setIcon(im); 
            iIcon.setBackground(Color.BLACK);
            iIcon.setVisible(true);

            MouseAdapter tempA = new MouseAdapter(){
                int temp = current;

                @Override
                public void mouseClicked(MouseEvent e){
                    Character tempChar = allChar.get(temp);
                    team.replaceMember(teamSelectMember, tempChar);
                    if(teamSelectMember == 0){
                        if(tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(2) && tempChar != team.getTeamMember(3) ){
                            team.replaceMember(0, tempChar);
                            teamMember1.setIcon(new ImageIcon(tempChar.getMain().getImage().getScaledInstance(180, 420, Image.SCALE_DEFAULT)));
                        }
                        repaint();
                    }
                    else if(teamSelectMember == 1){
                        if(tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(2) && tempChar != team.getTeamMember(3) ){
                            team.replaceMember(1, tempChar);
                            teamMember2.setIcon(new ImageIcon(tempChar.getMain().getImage().getScaledInstance(180, 420, Image.SCALE_DEFAULT)));
                            repaint();
                        }
                    }
                    else if(teamSelectMember == 2){
                        if(tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(3) ){
                            team.replaceMember(2, tempChar);
                            teamMember3.setIcon(new ImageIcon(tempChar.getMain().getImage().getScaledInstance(180, 420, Image.SCALE_DEFAULT)));
                            repaint();
                    }
                    }
                    else if(teamSelectMember == 3){
                        if(tempChar != team.getTeamMember(0) && tempChar != team.getTeamMember(1) && tempChar != team.getTeamMember(2) ){
                            team.replaceMember(3, tempChar);
                            teamMember4.setIcon(new ImageIcon(tempChar.getMain().getImage().getScaledInstance(180, 420, Image.SCALE_DEFAULT)));
                            repaint();
                        }
                    }
                    else{
                        System.out.println("Please Select a Slot"); 
                    }
                }
            };

            iIcon.addMouseListener(tempA); 
            place.add(iIcon);
        }
    }
    
    
    // for the pulling part
    public void itspullingtime(){
        System.out.println(colin.getStar());
        
        bigpanel.setVisible(true);
        for(int i = 0;i<10;i++){
            ArrayList<Character> temparray = rarity.get(RNG.odds()-1);
            int index = RNG.randomize(temparray.size()-1);
            Character temp = temparray.get(index);
            tempChars.add(temp);
            if(hasBeenPulled.get(temp) == null){
                playerInventory.add(temp);
                hasBeenPulled.put(temp,true);
                temp.addCopy();
            }
            else{
                temp.addCopy();
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
                pull.setBackground(Color.GRAY);
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

    private ImageIcon scaleImage(ImageIcon image,int w,int h){
        Image temp = image.getImage();
        Image newImg = temp.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    // make sure frames and interval % == 0 ;
    private void animate(JComponent component, Point newPoint, int frames, int interval) {
        Rectangle compBounds = component.getBounds();
    
        Point oldPoint = new Point(compBounds.x, compBounds.y),
              animFrame = new Point((newPoint.x - oldPoint.x) / frames,
                                    (newPoint.y - oldPoint.y) / frames);
    
        new Timer(interval, new ActionListener() {
            int currentFrame = 0;
            public void actionPerformed(ActionEvent e) {
                component.setBounds(oldPoint.x + (animFrame.x * currentFrame),
                                    oldPoint.y + (animFrame.y * currentFrame),
                                    compBounds.width,
                                    compBounds.height);
    
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