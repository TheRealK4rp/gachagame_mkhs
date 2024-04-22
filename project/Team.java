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

public class Team {
    static int count;

    int teamSize = 4;
    static Character teamMembers[]  = new Character[4];     

    public Team(){

    }

    public void addMember(Character addedCharacter){
        teamMembers[count] = addedCharacter;
        count++;
    }

    public void replaceMember(int i, Character addedCharacter){
        teamMembers[i] = addedCharacter;
    }

    public Character[] getTeamArray(){
        return teamMembers;
    }

    public Character getTeamMember(int i){
        return teamMembers[i];
    }


    

   
}
