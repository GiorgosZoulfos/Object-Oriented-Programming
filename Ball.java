import java.lang.Math;
public class Ball {
    
    Player exPlayer = null;
    Player currentPlayer = null;
    
    int x;
    int y;
        
    //Constructor
    Ball(int x ,int y) {
        this.x = x;
        this.y = y;
    }
    
    
    //Methods
    public void assignement(Player p ,Team ba ,Team re) {
        if(currentPlayer == null) {//Αν η μπαλα ειναι ελευθερη
            if((x == p.moveLine-1) | (x == p.moveLine) | (x == p.moveLine+1)) {//Αν ειναι σε κοντινη γραμμη
                if((y == p.y-1) | (y == p.y) | (y == p.y+1)) {//Αν ειναι σε κοντινη στηλη
                    
                    currentPlayer = p;//Αλλαγη τρεχων παικτη
                    x = p.moveLine;//Αλλαγη συντεταγμενων μπαλας
                    y = p.y;
                    
                    if(exPlayer != null) {
                        if(currentPlayer.teamName.equals("Bayern")) {//Αν ο τωρινος παικτης ειναι Bayern
                            
                            if(exPlayer.teamName.equals("Bayern")) {//Και ο πρωην παικτης ειναι Bayern
                                ba.passes++;//+1 οι πασες της Bayern;
                            }else {
                                re.mistakes++;//Αλλιως +1 τα λαθη της Real
                            }                        
                        }else {//Αλλιως αν ο τρεχων παικτης ειναι της Real
                            if(exPlayer.teamName.equals("Real")) {//Και ο πρωην παικτης ειναι Bayern
                                re.passes++;// +1 οι πασες Real
                            }else {
                                ba.mistakes++;//Αλλιως +1 τα λαθη της Bayern
                            }
                        }                   
                    }
                }   
            }
        }
    }
    
    
    public void assignement() {//Το ψαξιμο περιοριζεται στη γραμμη της μπαλας
        if(currentPlayer == null) {//Αν ειναι ελευθερη           
            if(x == 0) {//Σε αυτη τη γραμμη δεν υπαρχει παικτης
                
                int column = 8;//Στηλη που θα αποθηκευτει η στηλη του κοντινοτερου παικτη
                int min = 10;//Μεταβλητη αποθηκευσης μικροτερης αποστασης
                
                for(int i=0; i<Adjust.FIELD_WIDTH; i++) {
                    
                    if(Main.field[x+1][i] != null) {//Αν υπαρχει παικτης
                        
                        if(Math.abs(y-i) < min) {
                            
                            min = Math.abs(y-i);
                            column = i;
                        }
                        
                    }
                    
                }
                
                currentPlayer = Main.field[x+1][column]; 
                x = x + 1;//Αλλαγη συντεταγμενων μπαλας
                y = column;
                
            }else if(x == 8) { //Ομιως για τη 8η γραμμη που δεν υπαρχει παικτης
                
                int column = 8;
                int min = 10;
                
                for(int i=0; i<Adjust.FIELD_WIDTH; i++) {
                    
                    if(Main.field[x-1][i] != null) {
                        
                        if(Math.abs(y-i) < min) {
                            
                            min = Math.abs(y-i);
                            column = i;
                            
                        }
                        
                    }
                    
                }
                
                currentPlayer = Main.field[x-1][column]; 
                x = x - 1;
                y = column;
                
            }else {//Ομοιως για τις υπολοιπες γραμμες
                
                int column = 8;
                int min = 10;
                
                for(int i=0; i<8; i++) {
                    
                    if(Main.field[x][i] != null) {
                        
                        if(Math.abs(y-i) < min) {
                            
                            min = Math.abs(y-i);
                            column = i;
                        }
                                            
                    }
                    
                }
                
                currentPlayer = Main.field[x][column]; 
                y = column;
            }
        }
    }
}
                
            
        
    
    