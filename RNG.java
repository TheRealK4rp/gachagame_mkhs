import java.util.ArrayList;
import java.io.*;
/* This is the class where i put all my static methods
 * 
 */
public class RNG {
    // for pulling odds
    public static int odds(){
        int random = (int) (Math.random()*1000);
        if(random <=6){
            return 6;
        }
        if(6 < random && random <= 27){
            return 5;
        }
        if(27 < random && random <= 102){
            return 4;
        }
        if(152 < random && random <= 500){
            return 3;
        }
        if(500 < random && random <= 740){
            return 2;
        }
        return 1;
    }
    // so i dont have to type out the other stuff every time
    public static int randomize(int length){
        return (int) (Math.random()*length + 1);
    }

    // not sure if this actually works 
    public static ArrayList<Character> sortByRarity(ArrayList<Character> unsorted){
        ArrayList<Character> sorted = new ArrayList<Character>();
        sorted.add(unsorted.get(0));
        for(int i = 1;i < unsorted.size();i++){
            Character temp = unsorted.get(i);
            for(int a = 0;a<sorted.size();a++){
                if(temp == sorted.get(a)){
                    sorted.add(a,temp);
                    a = sorted.size();
                }
                else if(sorted.get(a).getStar() < temp.getStar()){
                    sorted.add(a,temp);
                    a = sorted.size();
                }
                else if(a == sorted.size()-1){
                    sorted.add(temp);
                    a++;
                }
            }
        }
        System.out.println(sorted.size() +"\n =============================== \n name => star");
        for(int i = 0;i<sorted.size();i++){
            System.out.println(sorted.get(i).getName() + " => " + sorted.get(i).getStar());
        }
        System.out.println("=========================================");
        return sorted;
    }

    //ignore this for now, this is for makign save data ill work on it later
    public static void serialize(String outputFileName, Object obj){
        try{
            FileOutputStream fileOut = new FileOutputStream(outputFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

    /*
     * FileInputStream file
     */

}
