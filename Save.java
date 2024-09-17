
public class Save implements java.io.Serializable{
    int copy;
    String name;
    int upgraded;

    Save(int c, String n,int u){
        copy = c;
        name = n;
        upgraded = u;
    }

    public int getCopy(){ return copy;}
    public String getName(){ return name;}
    public int getUpgradednum(){ return upgraded; }
}