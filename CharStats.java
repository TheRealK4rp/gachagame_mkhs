



public class CharStats {
    private int baseAV;
    private int currentAV;
    private String name;
    private int health;
    private int atk;
    private int speed;
    private int def;
    //pretty sure this just referenes them
    private int[] baseStats = new int[4];

    CharStats(int h, int a, int s, int d){
        health = h;
        atk = a;
        speed = s;
        def = d;
        baseAV = getActionValue();
        currentAV = getActionValue();
    }

    CharStats(int h, int a, int s, int d, String n){
        name = n;
        health = h;
        atk = a;
        speed = s;
        def = d;
        baseStats[0] = h;
        baseStats[1] = a;
        baseStats[2] = s;
        baseStats[3] = d;
        baseAV = getActionValue();
        currentAV = getActionValue();
    }

    public void cHp(int c){health+=c;}
    public void sHp(int c){health = c;}
    public void cAtk(int c){atk+=c;}
    public void cSpd(int c){
        speed+=c;
        baseAV = getActionValue();
        currentAV = (int) (currentAV * (double) speed / (speed+c));
    }
    public void cDef(int c){def+=c;}
    public void addName(String n){name = n;}
    public void cActionValue(int av){
        currentAV -= av;
        if(currentAV<=0){
            currentAV = baseAV;
        }
    }
    public void resetDefault(){health = baseStats[0]; atk = baseStats[1]; speed = baseStats[2]; def = baseStats[3];}
    public void adjustByRarity(int rar){
        health+= rar*50;
        atk += rar*15;
        speed += rar*6;
        def += rar*1.2;
        baseAV = getActionValue();
        currentAV = getActionValue();
        baseStats[0] = health;
        baseStats[1] = atk;
        baseStats[2] = speed;
        baseStats[3] = def;
    }

    public int getHp(){return health;}
    public int getAtk(){return atk;}
    public int getSpd(){return speed;}
    public int getDef(){return def;}
    public int getActionValue(){return 10000/speed;}
    public int getCurrentAV(){return currentAV;}
    public int getBaseHp(){return baseStats[0];}
    public int getBaseAtk(){return baseStats[1];}
    public int getBaseSpd(){return baseStats[2];}
    public int getBaseDef(){return baseStats[3];}
    public String getName(){return name;}

    

    //setters and getters here
}


