
public class Team {
    static int count;

    int teamSize = 4;
    static Character teamMembers[]  = new Character[4];     

    public Team(){}

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

    public boolean isTeamFull(){
        for(int i = 0; i<teamMembers.length; i++){
            if(teamMembers[i] == null){
                return false;
            }
        }
        return true;
    }
    

   
}
