import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.HashMap;
public class Map extends JPanel{
    
    JPanel fullSchool,buildingAmath,buildingAeng1,buildingAeng2,buildingAeng3,buildingB,buildingC,buildingD,gym;
    JLabel fullS,buildA1,buildA2,buildB,buildC,buildD,buildG;
    JPanel bigBuildAmath, bigBuildB, bigBuildAeng;
    JLabel mapbackbutton;
    int turn;
    JLabel carrButton, gulacButton, floresButton, yeeButton, hernanButton;
    JLabel carrImage;
    JPanel b220;
    JPanel teamMember1,teamMember2,teamMember3,teamMember4,bigBossMan;
    JLabel teamMember1Icon,teamMember1atk,teamMember1skill;
    JLabel teamMember2Icon,teamMember2atk,teamMember2skill;
    JLabel teamMember3Icon,teamMember3atk,teamMember3skill;
    JLabel teamMember4Icon,teamMember4atk,teamMember4skill;
    JProgressBar teamMember1hp,teamMember2hp,teamMember3hp,teamMember4hp,bigBossHp;
    JProgressBar teamMember1mana,teamMember2mana,teamMember3mana,teamMember4mana;
    int t1mana=0,t2mana=0,t3mana=0,t4mana = 0;
    JPanel boss;
    CharStats[] turnOrder = new CharStats[5];
    CharStats bossStats = new CharStats(6942,45,150,150,"Mr. Carr");
    Teacher carr = new Teacher("Mr. Carr",bossStats,new ImageIcon("resources\\UI\\CARR\\big man.png"),new ImageIcon("resources\\UI\\CARR\\big man angry.png"));
    Team team;
    int bossTurnCounter = 0;

    HashMap<Integer,ImageIcon> uiIcon = new HashMap<Integer,ImageIcon>(){
        { put(0,new ImageIcon("resources\\UI\\FIST.png"));}
        { put(1,new ImageIcon("resources\\UI\\DMG.png"));}
        { put(2,new ImageIcon("resources\\UI\\BUFFDMG.png"));}
        { put(3,new ImageIcon("resources\\UI\\DEF.png"));}
        { put(4,new ImageIcon("resources\\UI\\SPED+.png"));}
        { put(5,new ImageIcon("resources\\UI\\SPED-.png"));}
        { put(6,new ImageIcon("resources\\UI\\DEF-.png"));}
        { put(7,new ImageIcon("resources\\UI\\DEBUFF.png"));}
        { put(8,new ImageIcon("resources\\UI\\HEAL.png"));}
    };
    Map(Team t){
        
        team = t;

        this.setBounds(0,0,1080,720);
        this.setVisible(false);
        this.setLayout(null);

        //------------------------ MAP STUFF ----------------------------------
        fullSchool = new JPanel();
        fullSchool.setBounds(0,-10,1080,720);
        fullSchool.setBackground(Color.RED);
        fullSchool.setVisible(true);
        fullSchool.setLayout(null);

        JLabel fullS = new JLabel(new ImageIcon("resources\\UI\\map.PNG"));
        fullS.setBounds(0,-10,1080,720);
        fullS.setOpaque(true);

        buildingB = new JPanel();
        buildingB.setBounds(0,75,405,160);
        buildingB.setBackground(new Color(5,10,15,0));
        //buildingB.setBorder(BorderFactory.createMatteBorder(5,0,5,5,Color.RED));
        buildingB.setVisible(true);
        buildingB.setOpaque(true);
        buildingB.addMouseListener(buildingBListener);

        buildingAmath = new JPanel();
        buildingAmath.setBounds(470,25,130,495);
        buildingAmath.setBackground(new Color(5,10,15,0));
        // buildingAmath.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.RED));
        buildingAmath.setVisible(true);
        buildingAmath.setOpaque(true);
        buildingAmath.addMouseListener(buildingAmathListener);

        buildingAeng1 = new JPanel();
        buildingAeng1.setBounds(405,515,320,115);
        buildingAeng1.setBackground(new Color(5,10,15,0));
        //buildingAeng1.setBorder(BorderFactory.createMatteBorder(5,0,0,5,Color.RED));
        buildingAeng1.setVisible(true);
        buildingAeng1.setOpaque(true);
        buildingAeng1.addMouseListener(buildingAengListener);

        buildingAeng2 = new JPanel();
        buildingAeng2.setBounds(45,515,360,115);
        buildingAeng2.setBackground(new Color(5,10,15,0));
        //buildingAeng2.setBorder(BorderFactory.createMatteBorder(5,5,5,0,Color.RED));
        buildingAeng2.setVisible(true);
        buildingAeng2.setOpaque(true);
        buildingAeng2.addMouseListener(buildingAengListener);

        buildingAeng3 = new JPanel();
        buildingAeng3.setBounds(405,625,320,45);
        buildingAeng3.setBackground(new Color(5,10,15,0));
        //buildingAeng3.setBorder(BorderFactory.createMatteBorder(0,5,5,5,Color.RED));
        buildingAeng3.setVisible(true);
        buildingAeng3.setOpaque(true);
        buildingAeng3.addMouseListener(buildingAengListener);

        //----------------------- MAP STUFF ----------------------
        

        //---------------------- BUILDINGS -----------------------

        bigBuildAmath = new JPanel();
        bigBuildAmath.setBounds(0,0,1080,720);
        bigBuildAmath.setVisible(false);

        bigBuildAeng = new JPanel();
        bigBuildAeng.setBounds(0,0,1080,720);
        bigBuildAeng.setVisible(false);
        
        carrButton = new JLabel();
        carrButton.setBackground(new Color(3,3,3,80));
        carrButton.setBounds(440,275,200,70);
        carrButton.setVisible(true);
        carrButton.setOpaque(true);
        carrButton.addMouseListener(b220Listener);
        carrButton.setText("Enter");
        carrButton.setHorizontalAlignment(JLabel.CENTER);
        carrButton.setForeground(Color.BLACK);
        carrButton.setFont(new Font("G2 Sans Serif",Font.PLAIN,30));
        
        bigBuildB = new JPanel();
        bigBuildB.setBounds(0,0,1080,720);
        bigBuildB.setBackground(Color.BLACK);
        bigBuildB.setVisible(false);
        bigBuildB.setOpaque(true);
        bigBuildB.setLayout(null);
        JLabel tempo = new JLabel(new ImageIcon("resources\\UI\\b220hall.png"));
        tempo.setBounds(0,0,1080,720);
        bigBuildB.add(carrButton);
        bigBuildB.add(tempo);

        

        b220 = new JPanel();
        b220.setBounds(0,0,1080,720);
        b220.setBackground(Color.GRAY);
        b220.setVisible(false);
        b220.setLayout(null);
        JLabel tempii = new JLabel(new ImageIcon("resources\\UI\\classroom.png"));
        tempii.setBounds(0,0,1080,720);
        

        mapbackbutton = new JLabel();
        mapbackbutton.setBounds(975,25,50,50);
        mapbackbutton.setBackground(Color.BLACK);
        mapbackbutton.setVisible(true);
        mapbackbutton.setOpaque(true);
        ImageIcon image = new ImageIcon("resources\\UI\\Back.png");
        Image temp = image.getImage();
        Image newImg = temp.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        mapbackbutton.setIcon(new ImageIcon(newImg));


        //---------------------- BUILDINGS -----------------------

        //------------------------ b220 --------------------------

        boss = new JPanel();
        boss.setBounds(0,100,1080,410);
        boss.setBackground(new Color(255,255,255,0));
        boss.setLayout(null);
        boss.setVisible(true);
        bigBossHp = new JProgressBar();
        bigBossHp.setValue(100);
        bigBossHp.setBounds(0,0,1080,10);
        bigBossHp.setForeground(Color.GREEN);
        carrImage = new JLabel(new ImageIcon(carr.getStage1().getImage().getScaledInstance(1080, 400, java.awt.Image.SCALE_SMOOTH)));
        carrImage.setBounds(0,10,1080,400);
        boss.add(carrImage);
        boss.add(bigBossHp);
        b220.add(boss);

        teamMember1 = new JPanel();
        teamMember1.setBounds(10,550,254,100);
        teamMember1.setBackground(Color.RED);
        teamMember1.setVisible(true);
        teamMember1.setLayout(null);
        teamMember1.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember1Icon = new JLabel();
        teamMember1Icon.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember1Icon.setIcon(new ImageIcon(team.getTeamMember(0).getSmall().getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
        teamMember1Icon.setBounds(0,0,100,100);
        teamMember1Icon.setVerticalAlignment(JLabel.CENTER);
        teamMember1Icon.setHorizontalAlignment(JLabel.CENTER);
        teamMember1hp = new JProgressBar();
        teamMember1hp.setValue(100);
        teamMember1hp.setBounds(100,5,149,10);
        teamMember1hp.setForeground(Color.GREEN);
        //======================== MANA
        teamMember1mana = new JProgressBar();
        teamMember1mana.setValue(0);
        teamMember1mana.setBounds(100,15,149,10);
        teamMember1mana.setForeground(new Color(0,0,139));
        teamMember1.add(teamMember1mana);

        teamMember1atk = new JLabel();
        teamMember1atk.setBounds(100,25,70,70);
        teamMember1atk.setBackground(Color.ORANGE);
        teamMember1atk.setOpaque(true);
        teamMember1atk.setLayout(null);
        teamMember1atk.setIcon(uiIcon.get(0));
        teamMember1.add(teamMember1atk);
        teamMember1skill = new JLabel();
        teamMember1skill.setBounds(179,25,70,70);
        teamMember1skill.setBackground(Color.CYAN);
        teamMember1skill.setOpaque(true);
        teamMember1skill.setLayout(null);
        teamMember1skill.setIcon(uiIcon.get(team.getTeamMember(0).getSkill()));
        teamMember1.add(teamMember1skill);
        teamMember1.add(teamMember1hp);
        teamMember1.add(teamMember1Icon);
        

        teamMember2 = new JPanel();
        teamMember2.setBounds(274,550,254,100);
        teamMember2.setBackground(Color.RED);
        teamMember2.setVisible(true);
        teamMember2.setLayout(null);
        teamMember2.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember2Icon = new JLabel();
        teamMember2Icon.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember2Icon.setIcon(new ImageIcon(team.getTeamMember(1).getSmall().getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
        teamMember2Icon.setBounds(0,0,100,100);
        teamMember2Icon.setVerticalAlignment(JLabel.CENTER);
        teamMember2Icon.setHorizontalAlignment(JLabel.CENTER);
        teamMember2hp = new JProgressBar();
        teamMember2hp.setValue(100);
        teamMember2hp.setBounds(100,5,149,10);
        teamMember2hp.setForeground(Color.GREEN);
        teamMember2mana = new JProgressBar();
        teamMember2mana.setValue(0);
        teamMember2mana.setBounds(100,15,149,10);
        teamMember2mana.setForeground(new Color(0,0,139));
        teamMember2.add(teamMember2mana);
        teamMember2atk = new JLabel();
        teamMember2atk.setBounds(100,25,70,70);
        teamMember2atk.setBackground(Color.ORANGE);
        teamMember2atk.setOpaque(true);
        teamMember2atk.setLayout(null);
        teamMember2atk.setIcon(uiIcon.get(0));
        teamMember2.add(teamMember2atk);
        teamMember2skill = new JLabel();
        teamMember2skill.setBounds(179,25,70,70);
        teamMember2skill.setBackground(Color.CYAN);
        teamMember2skill.setOpaque(true);
        teamMember2skill = new JLabel();
        teamMember2skill.setBounds(179,25,70,70);
        teamMember2skill.setBackground(Color.CYAN);
        teamMember2skill.setOpaque(true);
        teamMember2skill.setLayout(null);
        teamMember2skill.setIcon(uiIcon.get(team.getTeamMember(1).getSkill()));
        teamMember2.add(teamMember2skill);
        teamMember2.add(teamMember2hp);
        teamMember2.add(teamMember2Icon);

        teamMember3 = new JPanel();
        teamMember3.setBounds(538,550,254,100);
        teamMember3.setBackground(Color.RED);
        teamMember3.setVisible(true);
        teamMember3.setLayout(null);
        teamMember3.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember3Icon = new JLabel();
        teamMember3Icon.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember3Icon.setIcon(new ImageIcon(team.getTeamMember(2).getSmall().getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
        teamMember3Icon.setBounds(0,0,100,100);
        teamMember3Icon.setVerticalAlignment(JLabel.CENTER);
        teamMember3Icon.setHorizontalAlignment(JLabel.CENTER);
        teamMember3hp = new JProgressBar();
        teamMember3hp.setValue(100);
        teamMember3hp.setBounds(100,5,149,10);
        teamMember3hp.setForeground(Color.GREEN);
        teamMember3mana = new JProgressBar();
        teamMember3mana.setValue(0);
        teamMember3mana.setBounds(100,15,149,10);
        teamMember3mana.setForeground(new Color(0,0,139));
        teamMember3.add(teamMember3mana);
        teamMember3atk = new JLabel();
        teamMember3atk.setBounds(100,25,70,70);
        teamMember3atk.setBackground(Color.ORANGE);
        teamMember3atk.setOpaque(true);
        teamMember3atk.setLayout(null);
        teamMember3atk.setIcon(uiIcon.get(0));
        teamMember3.add(teamMember3atk);
        teamMember3skill = new JLabel();
        teamMember3skill.setBounds(179,25,70,70);
        teamMember3skill.setBackground(Color.CYAN);
        teamMember3skill.setOpaque(true);
        teamMember3skill = new JLabel();
        teamMember3skill.setBounds(179,25,70,70);
        teamMember3skill.setBackground(Color.CYAN);
        teamMember3skill.setOpaque(true);
        teamMember3skill.setLayout(null);
        teamMember3skill.setIcon(uiIcon.get(team.getTeamMember(2).getSkill()));
        teamMember3.add(teamMember3skill);
        teamMember3.add(teamMember3hp);
        teamMember3.add(teamMember3Icon);

        teamMember4 = new JPanel();
        teamMember4.setBounds(802,550,254,100);
        teamMember4.setBackground(Color.RED);
        teamMember4.setVisible(true);
        teamMember4.setLayout(null);
        teamMember4.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember4Icon = new JLabel();
        teamMember4Icon.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
        teamMember4Icon.setIcon(new ImageIcon(team.getTeamMember(3).getSmall().getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
        teamMember4Icon.setBounds(0,0,100,100);
        teamMember4Icon.setVerticalAlignment(JLabel.CENTER);
        teamMember4Icon.setHorizontalAlignment(JLabel.CENTER);
        teamMember4hp = new JProgressBar();
        teamMember4hp.setValue(100);
        teamMember4hp.setBounds(100,5,149,10);
        teamMember4hp.setForeground(Color.GREEN);
        teamMember4mana = new JProgressBar();
        teamMember4mana.setValue(0);
        teamMember4mana.setBounds(100,15,149,10);
        teamMember4mana.setForeground(new Color(0,0,139));
        teamMember4.add(teamMember4mana);
        teamMember4atk = new JLabel();
        teamMember4atk.setBounds(100,25,70,70);
        teamMember4atk.setBackground(Color.ORANGE);
        teamMember4atk.setOpaque(true);
        teamMember4atk.setLayout(null);
        teamMember4atk.setIcon(uiIcon.get(0));
        teamMember4.add(teamMember4atk);
        teamMember4skill = new JLabel();
        teamMember4skill.setBounds(179,25,70,70);
        teamMember4skill.setBackground(Color.CYAN);
        teamMember4skill.setOpaque(true);
        teamMember4skill = new JLabel();
        teamMember4skill.setBounds(179,25,70,70);
        teamMember4skill.setBackground(Color.CYAN);
        teamMember4skill.setOpaque(true);
        teamMember4skill.setLayout(null);
        teamMember4skill.setIcon(uiIcon.get(team.getTeamMember(3).getSkill()));
        teamMember4.add(teamMember4skill);
        teamMember4.add(teamMember4hp);
        teamMember4.add(teamMember4Icon);



        b220.add(teamMember1);
        b220.add(teamMember2);
        b220.add(teamMember3);
        b220.add(teamMember4);
        b220.add(tempii);
        //------------------------ b220 --------------------------
        buildA1 = new JLabel(new ImageIcon("resources\\UI\\Disaster.png"));
        buildA1.setBounds(0,0,1080,720);
        buildA1.setVisible(true);
        bigBuildAeng.add(buildA1);
        buildA2 = new JLabel(new ImageIcon("resources\\UI\\Disaster.png"));
        buildA2.setBounds(0,0,1080,720);
        buildA2.setVisible(true);
        bigBuildAmath.add(buildA2);

        fullSchool.add(buildingAeng1);
        fullSchool.add(buildingAeng2);
        fullSchool.add(buildingAeng3);
        fullSchool.add(buildingAmath);
        fullSchool.add(buildingB);
        fullSchool.add(fullS);
        this.add(mapbackbutton);
        this.add(fullSchool);
        this.add(bigBuildAmath);
        this.add(bigBuildAeng);
        this.add(bigBuildB);
        this.add(b220);
        team.getTeamMember(0).getStats().cSpd(1);
        team.getTeamMember(2).getStats().cSpd(2);
        team.getTeamMember(1).getStats().cSpd(3);
        team.getTeamMember(3).getStats().cSpd(4);
        CharStats p1 = team.getTeamMember(0).getStats();
        CharStats p2 = team.getTeamMember(1).getStats();
        CharStats p3 = team.getTeamMember(2).getStats();
        CharStats p4 = team.getTeamMember(3).getStats();
        CharStats boss = bossStats;
        turnOrder[0] = p1;
        turnOrder[1] = p2;
        turnOrder[2] = p3;
        turnOrder[3] = p4;
        turnOrder[4] = boss;
    }

    Map(){
        
        this.setBounds(0,0,1080,720);
        this.setVisible(false);
        this.setLayout(null);

        //------------------------ MAP STUFF ----------------------------------
        fullSchool = new JPanel();
        fullSchool.setBounds(0,-10,1080,720);
        fullSchool.setVisible(true);
        fullSchool.setLayout(null);

        JLabel fullS = new JLabel(new ImageIcon("resources\\UI\\map.PNG"));
        fullS.setBounds(0,-10,1080,720);
        fullS.setOpaque(true);

        buildingB = new JPanel();
        buildingB.setBounds(0,75,405,160);
        buildingB.setBackground(new Color(5,10,15,0));
        //buildingB.setBorder(BorderFactory.createMatteBorder(5,0,5,5,Color.RED));
        buildingB.setVisible(true);
        buildingB.setOpaque(true);
        buildingB.addMouseListener(buildingBListener);

        buildingAmath = new JPanel();
        buildingAmath.setBounds(470,25,130,495);
        buildingAmath.setBackground(new Color(5,10,15,0));
        // buildingAmath.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.RED));
        buildingAmath.setVisible(true);
        buildingAmath.setOpaque(true);
        buildingAmath.addMouseListener(buildingAmathListener);

        buildingAeng1 = new JPanel();
        buildingAeng1.setBounds(405,515,320,115);
        buildingAeng1.setBackground(new Color(5,10,15,0));
        //buildingAeng1.setBorder(BorderFactory.createMatteBorder(5,0,0,5,Color.RED));
        buildingAeng1.setVisible(true);
        buildingAeng1.setOpaque(true);
        buildingAeng1.addMouseListener(buildingAengListener);

        buildingAeng2 = new JPanel();
        buildingAeng2.setBounds(45,515,360,115);
        buildingAeng2.setBackground(new Color(5,10,15,0));
        //buildingAeng2.setBorder(BorderFactory.createMatteBorder(5,5,5,0,Color.RED));
        buildingAeng2.setVisible(true);
        buildingAeng2.setOpaque(true);
        buildingAeng2.addMouseListener(buildingAengListener);

        buildingAeng3 = new JPanel();
        buildingAeng3.setBounds(405,625,320,45);
        buildingAeng3.setBackground(new Color(5,10,15,0));
        //buildingAeng3.setBorder(BorderFactory.createMatteBorder(0,5,5,5,Color.RED));
        buildingAeng3.setVisible(true);
        buildingAeng3.setOpaque(true);
        buildingAeng3.addMouseListener(buildingAengListener);

        //----------------------- MAP STUFF ----------------------
        

        //---------------------- BUILDINGS -----------------------

        bigBuildAmath = new JPanel();
        bigBuildAmath.setBounds(0,0,1080,720);
        bigBuildAmath.setVisible(false);

        bigBuildAeng = new JPanel();
        bigBuildAeng.setBounds(0,0,1080,720);
        bigBuildAeng.setVisible(false);

        bigBuildB = new JPanel();
        bigBuildB.setBounds(0,0,1080,720);
        bigBuildB.setVisible(false);
        bigBuildB.setLayout(null);

        carrButton = new JLabel();
        carrButton.setBackground(new Color(50,50,50,80));
        carrButton.setBounds(440,275,200,70);
        carrButton.setVisible(true);
        carrButton.setOpaque(true);
        carrButton.addMouseListener(b220Listener);
        bigBuildB.add(carrButton);

        b220 = new JPanel();
        b220.setBounds(0,0,1080,720);
        b220.setBackground(Color.RED);
        b220.setVisible(false);
        b220.setLayout(null);

        mapbackbutton = new JLabel();
        mapbackbutton.setBounds(975,25,50,50);
        mapbackbutton.setBackground(Color.BLACK);
        mapbackbutton.setVisible(true);
        mapbackbutton.setOpaque(true);

        //---------------------- BUILDINGS -----------------------

        fullSchool.add(buildingAeng1);
        fullSchool.add(buildingAeng2);
        fullSchool.add(buildingAeng3);
        fullSchool.add(buildingAmath);
        fullSchool.add(buildingB);
        fullSchool.add(fullS);
        this.add(mapbackbutton);
        this.add(fullSchool);
        this.add(bigBuildAmath);
        this.add(bigBuildAeng);
        this.add(bigBuildB);
        fullSchool.addMouseListener(thefinalstraw);
  


    }
//======================================================================================================================



public void startFight(){
    turnOrder = sortByActValue(turnOrder);
    turn = charConverter(turnOrder);
    turnOrder = subtractActionValue(turnOrder);
    if(bossStats.getHp() < 4800){
        carrImage.setIcon(new ImageIcon(carr.getStage2().getImage().getScaledInstance(1080, 400, java.awt.Image.SCALE_SMOOTH)));
    }
    if(team.getTeamMember(0).getStats().getHp() <= 0 && team.getTeamMember(1).getStats().getHp() <= 0 && team.getTeamMember(2).getStats().getHp() <= 0 && team.getTeamMember(3).getStats().getHp() <= 0 ){
        carrImage.setFont(new Font("G2 sans serif",Font.BOLD,150));
        carrImage.setHorizontalTextPosition(JLabel.CENTER);
        carrImage.setVerticalTextPosition(JLabel.CENTER);
        carrImage.setForeground(Color.RED);
        carrImage.setText("FAILED");
        repaint();
        return;
    }
    if(bossStats.getHp() <= 0){
        carrImage.setFont(new Font("G2 sans serif",Font.BOLD,150));
        carrImage.setHorizontalTextPosition(JLabel.CENTER);
        carrImage.setVerticalTextPosition(JLabel.CENTER);
        carrImage.setForeground(Color.GREEN);
        carrImage.setText("PASSED");
        repaint();
        return;
    }
    if(turn == 4){
        if(bossStats.getHp() > 5800){
            if(bossTurnCounter < 2){
                tempText(2000,"Prepping lab");
                bossStats.cAtk(15);
            }
            else{
                tempText(2000,"...");
                bossStats.cDef(15);
            }
            if(bossTurnCounter > 5){
                carrImage.setForeground(Color.RED);
                tempText(2000,"NO CHEATING");
                bossDoDamage(20);
            }
        }
        else if(bossStats.getHp() > 2500){
            if(bossTurnCounter % 5 == 0){
                tempText(2000,"Lunchtime");
                bossStats.cHp(500);
            }
            else if(bossTurnCounter % 2 == 0){
                tempText(2000,"Test Corrections");
                bossDoDamage(1);
            }
            else if(bossTurnCounter % 2 == 1){
                tempText(2000,"Walking around class");
                bossStats.cAtk(5);
                bossStats.cDef(5);
                bossStats.cSpd(5);
                bossDoDamage(1);
            }
            else if(bossTurnCounter % 7 == 0){
                tempText(2000,"Unit Test");
                bossDoDamage(5);
            }
        }
        else if(bossStats.getHp() > 1000 ){
            if(bossTurnCounter % 2 == 0){
            carrImage.setForeground(Color.RED);
            tempText(2000,"BRAINLESS PARTICLE");
            team.getTeamMember(0).getStats().cDef(-10);
            team.getTeamMember(1).getStats().cDef(-10);
            team.getTeamMember(2).getStats().cDef(-10);
            team.getTeamMember(3).getStats().cDef(-10);
            bossDoDamage(4);
            }
            else{
                tempText(2000,"Materials Check");
                team.getTeamMember(0).getStats().cSpd(-4);
                team.getTeamMember(1).getStats().cSpd(-4);
                team.getTeamMember(2).getStats().cSpd(-4);
                team.getTeamMember(3).getStats().cSpd(-4);
            }
        }
        else{
                tempText(2000,"14 DAY FINAL");
                bossDoDamage(6);
        }
        repaint();
        bossTurnCounter++;
        startFight();
    }
    else{
        if(turn == 0){
            if(team.getTeamMember(0).getStats().getHp() > 0){
                teamMember1atk.addMouseListener(teamMember1atkListener);
                teamMember1skill.addMouseListener(teamMember1skillListener);
                teamMember1atk.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
                if(t1mana == 100){
                teamMember1skill.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
                }
            }
            else{
                team.getTeamMember(0).getStats().cHp(-100000);
                teamMember1atk.setOpaque(false);
                teamMember1skill.setOpaque(false);
                removeBorderFromPlayer();
                repaint();
                startFight();
                }
        }
        else if(turn == 1){
            if(team.getTeamMember(1).getStats().getHp() > 0){
            teamMember2atk.addMouseListener(teamMember2atkListener);
            teamMember2skill.addMouseListener(teamMember2skillListener);
            teamMember2atk.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
            if(t2mana == 100){
                teamMember2skill.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
            }
        }
            else{
                team.getTeamMember(1).getStats().cHp(-100000);
                teamMember2atk.setOpaque(false);
                teamMember2skill.setOpaque(false);
                removeBorderFromPlayer();
                repaint();
                startFight();
                }
        }

        else if(turn == 2){
            if(team.getTeamMember(2).getStats().getHp() > 0){
            teamMember3atk.addMouseListener(teamMember3atkListener);
            teamMember3skill.addMouseListener(teamMember3skillListener);
            teamMember3atk.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
            if(t3mana == 100){
                teamMember3skill.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
            }
        }
            else{
                team.getTeamMember(2).getStats().cHp(-100000);
                teamMember3atk.setOpaque(false);
                teamMember3skill.setOpaque(false);
                removeBorderFromPlayer();
                repaint();
                startFight();
                }
        }

        
        else if(turn == 3){
            if(team.getTeamMember(3).getStats().getHp() > 0){
            teamMember4atk.addMouseListener(teamMember4atkListener);
            teamMember4skill.addMouseListener(teamMember4skillListener);
            teamMember4atk.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
            if(t4mana == 100){
                teamMember4skill.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.YELLOW));
            }
        }
            else{
                team.getTeamMember(3).getStats().cHp(-100000);
                teamMember4atk.setOpaque(false);
                teamMember4skill.setOpaque(false);
                removeBorderFromPlayer();
                repaint();
                startFight();
                }
        }
     
    }
    System.out.println(bossStats.getHp());

}





//======================================================================================================================
MouseListener buildingAengListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        mapHide();
        bigBuildAeng.setVisible(true);
        repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        buildingAeng1.setBorder(BorderFactory.createMatteBorder(5,0,0,5,new Color(120,120,120,200)));
        buildingAeng2.setBorder(BorderFactory.createMatteBorder(5,5,5,0,new Color(120,120,120,200)));
        buildingAeng3.setBorder(BorderFactory.createMatteBorder(0,5,5,5,new Color(120,120,120,200)));
        repaint();
    }

    @Override
   public void mouseExited(MouseEvent e){
        buildingAeng1.setBorder(null);
        buildingAeng2.setBorder(null);
        buildingAeng3.setBorder(null);
        repaint();
   }

   };

MouseListener buildingAmathListener = new MouseAdapter() {

    @Override
    public void mouseClicked(MouseEvent e){
        mapHide();
        bigBuildAmath.setVisible(true);
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e){
        buildingAmath.setBorder(BorderFactory.createMatteBorder(5,5,5,5,new Color(120,120,120,200)));
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e){
        buildingAmath.setBorder(null);
        repaint();
    }

};

MouseListener buildingBListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        mapHide();
        bigBuildB.setVisible(true);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e){
        buildingB.setBorder(BorderFactory.createMatteBorder(5,0,5,5,new Color(120,120,120,200)));
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e){
        buildingB.setBorder(null);
        repaint();
    }
};

MouseListener thefinalstraw = new MouseAdapter() {
    
    @Override
    public void mouseEntered(MouseEvent e){
        repaint();
    }
};

MouseListener b220Listener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        bigBuildB.setVisible(false);
        b220.setVisible(true);
 
        teamMember1atk.setOpaque(true);
        teamMember1skill.setOpaque(true);
        teamMember2atk.setOpaque(true);
        teamMember2skill.setOpaque(true);
        teamMember3atk.setOpaque(true);
        teamMember3skill.setOpaque(true);
        teamMember4atk.setOpaque(true);
        teamMember4skill.setOpaque(true);

        turnOrder[0].resetDefault();
        turnOrder[1].resetDefault();
        turnOrder[2].resetDefault();
        turnOrder[3].resetDefault();
        turnOrder[4].resetDefault();

        bigBossHp.setValue(100);
        teamMember1mana.setValue(t1mana = 0);
        teamMember2mana.setValue(t2mana = 0);
        teamMember3mana.setValue(t3mana = 0);
        teamMember4mana.setValue(t4mana = 0);
        teamMember1hp.setValue(100);
        teamMember2hp.setValue(100);
        teamMember3hp.setValue(100);
        teamMember4hp.setValue(100);
        
        carrImage.setIcon(new ImageIcon(carr.getStage1().getImage().getScaledInstance(1080, 400, java.awt.Image.SCALE_SMOOTH)));
        carrImage.setForeground(Color.BLACK);
        carrImage.setFont(new Font("G2 sans serif",Font.BOLD,100));
        carrImage.setHorizontalTextPosition(JLabel.CENTER);
        carrImage.setVerticalTextPosition(JLabel.CENTER);
        carrImage.setText("");

        bossTurnCounter = 0;
        startFight();
    }
};

MouseListener teamMember1atkListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        bossStats.cHp(-1*calcDmg(team.getTeamMember(0).getStats().getAtk(),bossStats.getDef()));
        if(t1mana < 100){
            t1mana+=50;
            teamMember1mana.setValue(t1mana);
        }
        bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        teamMember1atk.removeMouseListener(teamMember1atkListener);
        teamMember1skill.removeMouseListener(teamMember1skillListener);
        removeBorderFromPlayer();
        repaint();
        //atk animation
        startFight();
    }
};

MouseListener teamMember2atkListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        bossStats.cHp(-1*calcDmg(team.getTeamMember(1).getStats().getAtk(),bossStats.getDef()));
        if(t2mana < 100){
            t2mana+=50;
            teamMember2mana.setValue(t2mana);
        }
        bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        teamMember2atk.removeMouseListener(teamMember2atkListener);
        teamMember2skill.removeMouseListener(teamMember2skillListener);
        removeBorderFromPlayer();
        repaint();
        //atk animation
        startFight();
    }
};

MouseListener teamMember3atkListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        bossStats.cHp(-1*calcDmg(team.getTeamMember(2).getStats().getAtk(),bossStats.getDef()));
        if(t3mana < 100){
            t3mana+=50;
            teamMember3mana.setValue(t3mana);
        }
        bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        teamMember3atk.removeMouseListener(teamMember3atkListener);
        teamMember3skill.removeMouseListener(teamMember3skillListener);
        removeBorderFromPlayer();
        repaint();
        //atk animation
        startFight();
    }
};

MouseListener teamMember4atkListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        bossStats.cHp(-1*calcDmg(team.getTeamMember(3).getStats().getAtk(),bossStats.getDef()));
        if(t4mana < 100){
            t4mana+=50;
            teamMember4mana.setValue(t4mana);
        }
        bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        teamMember4atk.removeMouseListener(teamMember4atkListener);
        teamMember4skill.removeMouseListener(teamMember4skillListener);
        removeBorderFromPlayer();
        repaint();
        //atk animation
        startFight();
    }
};

MouseListener teamMember1skillListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(t1mana >=100){
        int skill = team.getTeamMember(0).getSkill();
        int mult = team.getTeamMember(0).getStar();
        if(skill == 1){
            bossStats.cHp(-2*mult*calcDmg(team.getTeamMember(0).getStats().getAtk(),bossStats.getDef()));
            bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        }
        else if(skill == 2){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cAtk(mult*10);
                }
            }
        }
        else if(skill == 3){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cDef(mult*10);
                }
            }
        }
        else if(skill == 4){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cSpd(mult*2);
                }
            }
        }
        else if(skill == 5){
            bossStats.cSpd(-10*mult);
        }
        else if(skill == 6){
            bossStats.cAtk(-1*(mult*5));
        }
        else if(skill == 7){
            bossStats.cDef(-1*(mult*5));
        }
        else if(skill == 8){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cHp(mult*50);
                    if(turnOrder[i].getHp() > turnOrder[i].getBaseHp()){
                        turnOrder[i].sHp(turnOrder[i].getBaseHp());
                    }
                }
            }
            teamMember1hp.setValue((int) (((double) turnOrder[0].getHp()/turnOrder[0].getBaseHp())*100));
            teamMember2hp.setValue((int) (((double) turnOrder[1].getHp()/turnOrder[1].getBaseHp())*100));
            teamMember3hp.setValue((int) (((double) turnOrder[2].getHp()/turnOrder[2].getBaseHp())*100));
            teamMember4hp.setValue((int) (((double) turnOrder[3].getHp()/turnOrder[3].getBaseHp())*100));
        }
        teamMember1mana.setValue(0);
        teamMember1skill.removeMouseListener(teamMember1skillListener);
        teamMember1atk.removeMouseListener(teamMember1atkListener);
        t1mana=0;
        removeBorderFromPlayer();
        repaint();
        startFight();
    }
    }
};

MouseListener teamMember2skillListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(t2mana >=100){
        int skill = team.getTeamMember(1).getSkill();
        int mult = team.getTeamMember(1).getStar();
        if(skill == 1){
            bossStats.cHp(-2*mult*calcDmg(team.getTeamMember(1).getStats().getAtk(),bossStats.getDef()));
            bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        }
        else if(skill == 2){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cAtk(mult*10);
                }
            }
        }
        else if(skill == 3){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cDef(mult*10);
                }
            }
        }
        else if(skill == 4){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cSpd(mult*2);
                }
            }
        }
        else if(skill == 5){
            bossStats.cSpd(-10*mult);
        }
        else if(skill == 6){
            bossStats.cAtk(-1*(mult*5));
        }
        else if(skill == 7){
            bossStats.cDef(-1*(mult*5));
        }
        else if(skill == 8){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cHp(mult*50);
                    if(turnOrder[i].getHp() > turnOrder[i].getBaseHp()){
                        turnOrder[i].sHp(turnOrder[i].getBaseHp());
                    }
                }
            }
            teamMember1hp.setValue((int) (((double) turnOrder[0].getHp()/turnOrder[0].getBaseHp())*100));
            teamMember2hp.setValue((int) (((double) turnOrder[1].getHp()/turnOrder[1].getBaseHp())*100));
            teamMember3hp.setValue((int) (((double) turnOrder[2].getHp()/turnOrder[2].getBaseHp())*100));
            teamMember4hp.setValue((int) (((double) turnOrder[3].getHp()/turnOrder[3].getBaseHp())*100));
        }
        teamMember2mana.setValue(0);
        teamMember2skill.removeMouseListener(teamMember2skillListener);
        teamMember2atk.removeMouseListener(teamMember2atkListener);
        t2mana=0;
        removeBorderFromPlayer();
        repaint();
        startFight();
    }
    }
};

MouseListener teamMember3skillListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(t3mana >=100){
        int skill = team.getTeamMember(2).getSkill();
        int mult = team.getTeamMember(2).getStar();
        if(skill == 1){
            bossStats.cHp(-2*mult*calcDmg(team.getTeamMember(2).getStats().getAtk(),bossStats.getDef()));
            bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        }
        else if(skill == 2){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cAtk(mult*10);
                }
            }
        }
        else if(skill == 3){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cDef(mult*10);
                }
            }
        }
        else if(skill == 4){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cSpd(mult*2);
                }
            }
        }
        else if(skill == 5){
            bossStats.cSpd(-10*mult);
        }
        else if(skill == 6){
            bossStats.cAtk(-1*(mult*5));
        }
        else if(skill == 7){
            bossStats.cDef(-1*(mult*5));
        }
        else if(skill == 8){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cHp(mult*50);
                    if(turnOrder[i].getHp() > turnOrder[i].getBaseHp()){
                        turnOrder[i].sHp(turnOrder[i].getBaseHp());
                    }
                }
            }
            teamMember1hp.setValue((int) (((double) turnOrder[0].getHp()/turnOrder[0].getBaseHp())*100));
            teamMember2hp.setValue((int) (((double) turnOrder[1].getHp()/turnOrder[1].getBaseHp())*100));
            teamMember3hp.setValue((int) (((double) turnOrder[2].getHp()/turnOrder[2].getBaseHp())*100));
            teamMember4hp.setValue((int) (((double) turnOrder[3].getHp()/turnOrder[3].getBaseHp())*100));
        }
        teamMember3mana.setValue(0);
        teamMember3skill.removeMouseListener(teamMember3skillListener);        
        teamMember3atk.removeMouseListener(teamMember3atkListener);
        t3mana=0;
        removeBorderFromPlayer();
        repaint();
        startFight();
    }
    }
};

MouseListener teamMember4skillListener = new MouseAdapter() {
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(t4mana >=100){
        int skill = team.getTeamMember(3).getSkill();
        int mult = team.getTeamMember(3).getStar();
        if(skill == 1){
            bossStats.cHp(-2*mult*calcDmg(team.getTeamMember(3).getStats().getAtk(),bossStats.getDef()));
            bigBossHp.setValue((int) (((double) bossStats.getHp()/bossStats.getBaseHp()) * 100));
        }
        else if(skill == 2){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cAtk(mult*10);
                }
            }
        }
        else if(skill == 3){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cDef(mult*10);
                }
            }
        }
        else if(skill == 4){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cSpd(mult*2);
                }
            }
        }
        else if(skill == 5){
            bossStats.cSpd(-10*mult);
        }
        else if(skill == 6){
            bossStats.cAtk(-1*(mult*5));
        }
        else if(skill == 7){
            bossStats.cDef(-1*(mult*5));
        }
        else if(skill == 8){
            for(int i =0;i<5;i++){
                if(!turnOrder[i].getName().equals("Mr. Carr")){
                    turnOrder[i].cHp(mult*50);
                    if(turnOrder[i].getHp() > turnOrder[i].getBaseHp()){
                        turnOrder[i].sHp(turnOrder[i].getBaseHp());
                    }
                }
            }
            teamMember1hp.setValue((int) (((double) turnOrder[0].getHp()/turnOrder[0].getBaseHp())*100));
            teamMember2hp.setValue((int) (((double) turnOrder[1].getHp()/turnOrder[1].getBaseHp())*100));
            teamMember3hp.setValue((int) (((double) turnOrder[2].getHp()/turnOrder[2].getBaseHp())*100));
            teamMember4hp.setValue((int) (((double) turnOrder[3].getHp()/turnOrder[3].getBaseHp())*100));
        }
        teamMember4mana.setValue(0);
        t4mana = 0;
        teamMember4skill.removeMouseListener(teamMember4skillListener);
        teamMember4atk.removeMouseListener(teamMember4atkListener);
        removeBorderFromPlayer();
        repaint();
        startFight();
    }
    }
};

//========================================================================================================================


private CharStats[] sortByActValue(CharStats[] statlist){
    CharStats[] output = statlist.clone();
    for(int i = 0;i < statlist.length;i++){
        for(int k = i+1;k<statlist.length;k++){
            if((output[i].getCurrentAV() > output[k].getCurrentAV()) && (i!=k)){
                CharStats switcher = output[k];
                output[k] = output[i];
                output[i] = switcher;
            }
        }
    }
    return output;
}

private CharStats[] subtractActionValue(CharStats[] stats){
    int base = stats[0].getCurrentAV();
    for(int i = 0;i < stats.length;i++){
        CharStats temp = stats[i];
        temp.cActionValue(base);
        stats[i] = temp;
    }
    for(int i = 0;i< stats.length-1;i++){
        if(stats[i].getCurrentAV() == stats[i+1].getCurrentAV()){
            stats[i+1].cActionValue(-1);
        }
    }
    return stats;
}

private int charConverter(CharStats[] stats){
    String identify = stats[0].getName();
    for(int i = 0; i<4;i++){
        if(identify.equals(team.getTeamMember(i).getName())){
            return i;
        }
    }
    return 4;
}

private void removeBorderFromPlayer(){
    teamMember1atk.setBorder(null);
    teamMember2atk.setBorder(null);
    teamMember3atk.setBorder(null);
    teamMember4atk.setBorder(null);
    teamMember1skill.setBorder(null);
    teamMember2skill.setBorder(null);
    teamMember3skill.setBorder(null);
    teamMember4skill.setBorder(null);
}

private void bossDoDamage(int x){
    
                team.getTeamMember(0).getStats().cHp(-x*calcDmg(bossStats.getAtk(),team.getTeamMember(0).getStats().getDef()));
                teamMember1hp.setValue(((int) (((double) team.getTeamMember(0).getStats().getHp()/team.getTeamMember(0).getStats().getBaseHp()) * 100)));
                team.getTeamMember(1).getStats().cHp(-x*calcDmg(bossStats.getAtk(),team.getTeamMember(1).getStats().getDef()));
                teamMember2hp.setValue(((int) (((double) team.getTeamMember(1).getStats().getHp()/team.getTeamMember(1).getStats().getBaseHp()) * 100)));
                team.getTeamMember(2).getStats().cHp(-x*calcDmg(bossStats.getAtk(),team.getTeamMember(2).getStats().getDef()));
                teamMember3hp.setValue(((int) (((double) team.getTeamMember(2).getStats().getHp()/team.getTeamMember(2).getStats().getBaseHp()) * 100)));
                team.getTeamMember(3).getStats().cHp(-x*calcDmg(bossStats.getAtk(),team.getTeamMember(3).getStats().getDef()));
                teamMember4hp.setValue(((int) (((double) team.getTeamMember(3).getStats().getHp()/team.getTeamMember(3).getStats().getBaseHp()) * 100)));
    
    
        boolean yeah = true;
        if(!(team.getTeamMember(0).getStats().getHp() <= 0 && team.getTeamMember(1).getStats().getHp() <= 0 && team.getTeamMember(2).getStats().getHp() <= 0 && team.getTeamMember(3).getStats().getHp() <= 0 )){

        
        while(yeah){
            int a = (int) (Math.random()*4);
            if( team.getTeamMember(a).getStats().getHp() > 0){
                team.getTeamMember(a).getStats().cHp(-x*calcDmg(bossStats.getAtk(),team.getTeamMember(a).getStats().getDef())/2);
                yeah = false;
                if(a == 0){
                    teamMember1hp.setValue(((int) (((double) team.getTeamMember(a).getStats().getHp()/team.getTeamMember(a).getStats().getBaseHp()) * 100)));
                }
                if(a == 1){
                    teamMember2hp.setValue(((int) (((double) team.getTeamMember(a).getStats().getHp()/team.getTeamMember(a).getStats().getBaseHp()) * 100)));
                }
                if(a == 2){
                    teamMember3hp.setValue(((int) (((double) team.getTeamMember(a).getStats().getHp()/team.getTeamMember(a).getStats().getBaseHp()) * 100)));
                }
                if(a == 3){
                    teamMember4hp.setValue(((int) (((double) team.getTeamMember(a).getStats().getHp()/team.getTeamMember(a).getStats().getBaseHp()) * 100)));
                }
            }
        }        
    }
    
}



private int calcDmg(int atker,int defer){
    return (int) (atker *(100.0/(defer + 15)));
}


public void mapHide(){
    fullSchool.setVisible(!fullSchool.isVisible());
    repaint();
}

public boolean fullSchoolVisible(){
    return fullSchool.isVisible();
}

public boolean isBigBuildVisible(){
    return bigBuildAeng.isVisible() || bigBuildAmath.isVisible() || bigBuildB.isVisible();
}

public boolean isB220Visible(){
    return b220.isVisible();
}

public void leaveClassroom(){
    b220.setVisible(false);
    bigBuildB.setVisible(true);
}

public void backToMap(){
    bigBuildAeng.setVisible(false);
    bigBuildAmath.setVisible(false);
    bigBuildB.setVisible(false);
    fullSchool.setVisible(true);
}

public void rerepaint(){
    repaint();
}

public void tempText(int time,String text){
    carrImage.setText("<html>" +text);
    repaint();
    Timer timer = new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                carrImage.setForeground(Color.BLACK);
                    carrImage.setText("");
                    repaint();
                    ((Timer)e.getSource()).stop();
            }
            
            
        });
        timer.start();
    }



   
}
