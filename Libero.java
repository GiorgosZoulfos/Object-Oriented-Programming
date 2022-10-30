
public class Libero extends Defender {
    //Constructor
    Libero(int y ,String name ,int number ,int moveLine ,int targetLine ,String teamName) {
        super(y, name, number, moveLine, targetLine, teamName);
    }
    //Methods
    public void specialMove(Ball b) {//Ο Libero θα παιρνει τη μπαλα στη κατοχη του παντα
        if(b.currentPlayer != null) {//Αν εχει καποιος τη μπαλα
            if((b.x == moveLine-1) | (b.x == moveLine) | (b.x == moveLine+1)) {//Αν ειναι στις κοντινες γραμμες
                if((b.y == y-1) | (b.y == y) | (b.y == y+1)) {//Αν ειναι στις κοντινες στηλες
                    if(!b.currentPlayer.teamName.equals(teamName)) {//Αν την εχει αντιπαλος
                        b.x = moveLine;
                        b.y = y;
                        b.exPlayer = b.currentPlayer;
                    }
                }
            }
        }
    }
}