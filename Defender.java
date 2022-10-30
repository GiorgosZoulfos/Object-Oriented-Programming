import java.lang.Math;
public class Defender extends Player {
    
    boolean yellowCard = false;
    public boolean redCard = false;
    static int steals = 0;
    static int fouls = 0;//ΕΠΙΠΛΕΟΝ(2/3) μεταβλητη που μετρα τα φαουλ ολων των αμυντικων
    
    //Constructor
    Defender(int y ,String name ,int number ,int moveLine ,int targetLine ,String teamName) {
        super(y, name, number, moveLine, targetLine, teamName);
    }
    //Methods
    public void specialMove(Ball b) {
        if(b.currentPlayer != null) {//Αν εχει καποιος τη μπαλα
            
            if((b.x == moveLine-1) | (b.x == moveLine) | (b.x == moveLine+1)) {//Αν ειναι στις κοντινες γραμμες
                
                if((b.y == y-1) | (b.y == y) | (b.y == y+1)) {//Αν ειναι στις κοντινες στηλες
                    
                    if(!b.currentPlayer.teamName.equals(teamName)) {//Αν την εχει αντιπαλος
                        int pos = (int)Math.floor(Math.random()*100);
                        
                        if(pos < Adjust.DEFENDER_GET_BALL) {//Πιθανοτητα 70% να την παρει
                             steals++;//+1 τα κλεψιματα
                             b.x = moveLine;//Μπαλα και παικτης ιδιες συντεταγμενες
                             b.y = y;
                             b.exPlayer = b.currentPlayer;//Ο τρεχων παικτης ειναι πλεον πρωην παικτης
                             
                        }else {
                            
                            fouls++;
                            if(pos < Adjust.DEFENDER_CARD) {
                                if(yellowCard == false) {//Αν δεν εχει κιτρινη
                                    yellowCard = true;
                                    System.out.println(name + " got a yellow card!");
                                
                                }else {//Αν εχει ηδη κιτρινη
                                    redCard = true;
                                    System.out.println(name + " got a red card!He is out of the game!");   
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
                       
                   