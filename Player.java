import java.lang.Math;
public abstract class Player {
    
    int y;//Στηλη κινησης
    int moveLine;//Γραμμη κινησης
    int targetLine;//Γραμμη μεταβιβασης μπαλας
    int number;//Αριθμος φανελας
    String name;//Οναμα παικτη
    String teamName;//Ονομα ομαδας παικτη
    int distanceCovered = 0;//ΕΠΙΠΛΕΟΝ(1/3) μεταβλητη που μετρα τη αποσταση που εχει διανυσει ο παικτης
    
    //Constructor
    Player(int y ,String name ,int number ,int moveLine ,int targetLine ,String teamName) {
        
        this.y = y;
        this.moveLine = moveLine;
        this.targetLine = targetLine;
        this.number = number;
        this.name = name;
        this.teamName = teamName;
        
    }
    //Methods
    public void move(Ball b){
        
        if(y == 0) {//Ελεγχος αν βρισκεται στη πρωτη στηλη
            
            if(Main.field[moveLine][1] == null) {//Ελεγχος αν η θεση στο γηπεδο ειναι κενη
                
                y += 1;//Αναγκαστικη κινηση προς τα δεξια
                distanceCovered++;
                Main.field[moveLine][0] = null;//Η προηγουμενη θεση στο γηπεδο μενει κενη
                
            }
            
        }else if(y == (Adjust.FIELD_WIDTH -2)) {//Ομοιως αν βρισκεται στη τελευταια στηλη
            
            if(Main.field[moveLine][6] == null) {
                
                y -= 1;
                distanceCovered++;
                Main.field[moveLine][Adjust.FIELD_WIDTH-2] = null;//Η προηγουμενη θεση στο γηπεδο μενει κενη
                
            }
            
        }else if((int)Math.floor(Math.random()*2) == 0) {//Τυχαια μετακινηση
            
            if(Main.field[moveLine][y-1] == null) {
                
                Main.field[moveLine][y] = null;//Η προηγουμενη θεση στο γηπεδο μενει κενη
                y -= 1; 
                distanceCovered++;
                
            }
            
        }else {
            
            if(Main.field[moveLine][y+1] == null) {
                
                Main.field[moveLine][y] = null;//Η προηγουμενη θεση στο γηπεδο μενει κενη
                y += 1;
                distanceCovered++;
                
            }
            
        }
        
        if(b.currentPlayer != null) {
            
            if (b.currentPlayer.teamName == teamName) {//Αν εχει τη μπαλα στη κατοχη του 
                
                b.y = y;//Αλλαγη συντεταγμενων μπαλας
                
            }
            
        }
        
    }
    
    
    public void pass(Ball b) {
        
        if(b.currentPlayer != null) {
            
            if(b.currentPlayer.name.equals(name)) {//Αν εχει τη μπαλα στη κατοχη του 
                b.x = targetLine;//Νεα γραμμη μπαλας  
                b.y = (int)Math.floor(Math.random()*8);//Τυχαια σε μια απο τις στηλες
                b.currentPlayer = null;
                
            }
            
        }
        
    }
    
    public abstract void specialMove(Ball b);
}
    
    
    
                