import java.lang.Math;
public class Attacker extends Player {
    
    //Constructor
    Attacker(int y ,String name ,int number ,int moveLine ,int targetLine ,String teamName) {
     super(y, name, number, moveLine, targetLine, teamName);
    }
    //Methods
    public void pass(Ball b) {
        if(b.currentPlayer != null) {
            if(b.currentPlayer.name == name) {//Αν εχει τη μπαλα
                b.x = targetLine;//Αλλαγη γραμμης για τη μπαλα
                int poss = (int)Math.floor(Math.random()*100);//Αποθηκευση τυχαιου αριθμου 
                if(poss < 20) {//Πιθανοτητα 20%
                    b.y = 3;
                }else if(poss < 40) {//Πιθανοτητα 20%
                    b.y = 4;
                }else if(poss < 50) {//Πιθανοτητα 20%
                    b.y = 0;
                }else if(poss < 60) {//Πιθανοτητα 10%
                    b.y = 1;
                }else if(poss < 70) {//Πιθανοτητα 10%
                    b.y =2;
                }else if(poss < 80) {//Πιθανοτητα 10%
                    b.y = 5;
                }else if(poss < 90) {//Πιθανοτητα 10%
                    b.y = 6;
                }else {//Πιθανοτητα 10%
                    b.y = 7;
                }
                b.currentPlayer = null;//Κανεις δεν την εχει στην κατοχη του
            }
        }
    }
        
    public void specialMove(Ball b) {
        if(b.currentPlayer != null) {
            if(b.currentPlayer.teamName == teamName) {
                int column = 0;
                for(int i=0; i<8; i++) {//Ψαξιμο στις στηλες
                    if(Main.field[moveLine][i] != null) {//Αν υπαρχει παικτης
                        if(i != y) {//Αν ο παικτης ειναι αντιπαλος(αφου εχει διαφορετικες συντεταγμενες)
                            column = i;
                        }
                    }
                }
                Main.field[moveLine][y] = null;//Η προηγουμενη θεση μενει κενη
                if(column < y) {//Αν ο αντιπαλος ειναι αριστερα
                    if((y+2) < 7) {
                        y += 2;
                    }else if((y+1) < 7) {
                        y += 1;
                    }
                }else {//Αν ειναι δεξια
                    if((y-2) > 0) {
                        y -= 2;
                    }else if((y-1) > 0) {
                        y -= 1;
                    }
                } 
            }
        }
    }
}
                   
                       
                        
               
            
                