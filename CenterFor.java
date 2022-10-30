import java.lang.Math;
public class CenterFor extends Attacker {
    //Constructor
    CenterFor(int y ,String name ,int number ,int moveLine ,int targetLine ,String teamName) {
     super(y, name, number, moveLine, targetLine, teamName);
    }
    //Methods
    public void pass(Ball b) {//Ο CenterFor θα στελνει τη μπαλα μονο στις κεντρικες στηλες
        
        if(b.currentPlayer != null) {
            
            if(b.currentPlayer.name == name) {//Αν ειναι ο τρεχων παικτης 
                
                b.x = targetLine;//Αλλαγη γραμμης της μπαλας
                
                if((int)Math.floor(Math.random()*2) == 0) {//Πιθανοτητα 50% για τις δυο κεντρικες στηλες
                    b.y = 3;
                }else {
                    b.y = 4;
                }
                
                b.currentPlayer = null;//Τρεχων παικτης το κενο
            }
        }
    }
}
            