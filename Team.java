import java.lang.Math;
import java.util.*;

public class Team {
    String teamName;
    int mistakes = 0;
    int passes = 0;
    int goals = 0;
    int shotsOnTarget = 0;//ΕΠΙΠΛΕΟΝ(3/3) μεταβλητη που μετρα τις συνολικες προσπαθειες προς το αντιπαλο τερμα
    List<Player> players = new ArrayList<Player>();
    //Constructor
    Team() {
    }
    //Methods
    public void action(Ball b, Team ba, Team re) {
        
        for(int i=0; i<players.size(); i++) {
            
            int poss = (int)Math.floor(Math.random()*100);
            
            if(poss < Adjust.RUN_MOVE) {
                
                players.get(i).move(b);//Κληση της μεθοδου κινησης 
                Main.field[players.get(i).moveLine][players.get(i).y] = players.get(i);//Καταχωρηση του παικτη στη νεα του θεση
                
            }else if(poss < Adjust.RUN_PASS) {
                
                if(b.currentPlayer != null) {
                    
                    if(b.currentPlayer.name.equals(players.get(i).name)) {//Αν εχει τη μπαλα
                        players.get(i).pass(b);//Κληση της μεθοδου πασας
                        b.exPlayer = players.get(i);//Εφοσον εκανε πασα ειναι πλεον πρωην παικτης
                    }
                    
                }
                
            }else if(poss < Adjust.RUN_SPECIAL_MOVE){
                
                if((players.get(i)).getClass().getName() == "Defender") {//Αν ειναι αμυντικος
                    
                    ((Defender)players.get(i)).specialMove(b);//Κληση της specialMove με διευκρινιση οτι προκειται
                    // για υποσταση της κλάσης Defender
                    if(((Defender)players.get(i)).redCard == true) {//Αν παρει κοκκινη μετα τη specialMove()
                        
                        Main.field[players.get(i).moveLine][players.get(i).y] = null;//Εξοδος απο το "γηπεδο"
                        players.remove(i);//Διαγραφει απο τη λιστα                        
                    }
                    
                    if(b.currentPlayer != null) {
                        
                        if((b.currentPlayer.y != b.y) | (b.currentPlayer.moveLine != b.x)) {//Αν τρεχων παικτης και η μπαλα
                            
                            b.exPlayer = b.currentPlayer;
                            b.currentPlayer = players.get(i);//εχουν εστω και μια συντεταγμενη διαφορετικη ο Defender εκλεψε τη                   
                        }//μπαλα και ειναι ο νεος τρεχων παικτης               
                    }
                    
                }else if((players.get(i)).getClass().getName() == "Attacker") {//Ομοιως για τον Attacker
                    
                    ((Attacker)players.get(i)).specialMove(b);
                     Main.field[players.get(i).moveLine][players.get(i).y] = players.get(i);//Μετακινηση του παικτη στο γηπεδο
                     
                }else if((players.get(i)).getClass().getName() == "Libero") {//Ομοιως για τον Libero
                    
                    ((Libero)players.get(i)).specialMove(b);
                    
                    if(b.currentPlayer != null) {
                        
                        if((b.currentPlayer.y != b.y) | (b.currentPlayer.moveLine != b.x)) {
                            b.currentPlayer = players.get(i);//Εκλεψε τη μπαλα αρα νεος τρεχων παικτης
                        }
                    }
                    
                }else{//Ομοιως για τον CenterFor
                    
                    ((CenterFor)players.get(i)).specialMove(b);
                    Main.field[players.get(i).moveLine][players.get(i).y] = players.get(i);//Μετακινηση του παικτη στο γηπεδο 
                }
            }
            
                b.assignement(players.get(i), ba, re);                
        }
        
        Print.ballInfo(b);
    }
    
    
     public void set(Libero p0 ,Defender p1 ,Defender p2 ,Defender p3 ,Attacker p4 ,Attacker p5 ,CenterFor p6) {
         
        players.add(p0);//Δημιουργια λιστας των παικτων της καθε ομαδας
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
    }
}
                        
        