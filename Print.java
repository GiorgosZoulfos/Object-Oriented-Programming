//Αυτη η κλαση περιεχει μεθοδους εκτυπωσης πληροφοριων

import java.util.*;

public class Print {
    
    //Methods
    public static void playersInfo(List<Player> p) {
        
        for(int i=0; i<p.size(); i++) {
            
            System.out.println(p.get(i).name + " is playing for " + p.get(i).teamName + " wears the shirt with number "
            + p.get(i).number + " he is at " + p.get(i).moveLine + "," + p.get(i).y + " and has covered " 
            + p.get(i).distanceCovered + " space in field");
            
        }   
        
        System.out.println();
    }
    
    
    public static void ballInfo(Ball b) {
        
        System.out.print("Ball is at " + b.x + "," + b.y);
        
        if(b.exPlayer != null) {            
            System.out.print(" ,it was at possesion of " + b.exPlayer.name);            
        }
        
        if(b.currentPlayer != null) {           
            System.out.println(" and now " + b.currentPlayer.name + " has it");            
        }else {            
            System.out.println(" and now nobody has it");           
        }
        
        System.out.println();
    }
    
    public static void gameInfo(Game g) {
        
        System.out.println("Current round : " + g.rounds);
        System.out.println("Steals : " + Defender.steals);
        System.out.println("Fouls : " + Defender.fouls);
        System.out.println();
        
    }
    
    
    public static void teamInfo(Team t) {
        
        System.out.println("\t\t**********");
        System.out.println("**Statistics of " + t.teamName + " are : ");
        System.out.println("GOALS : " + t.goals);
        System.out.println("SHOTHS ON TARGET : " + t.shotsOnTarget);
        System.out.println("PASSES : " + t.passes);
        System.out.println("MISTAKES : " + t.mistakes);
        System.out.println();        
    }
    
    
    public static void fieldInfo(Player[][] field , Ball ball) {
        
        System.out.println("\n\n**** Players in field ****");
        System.out.println("(G A = goal area)\n" +
                            "(B for Bayern and R for Real)" );
        for(int j=0; j<Adjust.FIELD_WIDTH-1; j++) {
            System.out.print(" _____");
        }
        
        System.out.println();
        
        for(int i=0; i<Adjust.FIELD_LENGTH; i++) { 
            
            for(int c=0; c<2; c++) {  
                
                for(int j=0; j<Adjust.FIELD_WIDTH; j++) {
                    
                     boolean b = false;
                     if(ball.x == i & ball.y == j & c == 0) {
                        System.out.print("|ball ");
                        b = true;
                     }
                     
                     if(field[i][j] != null & c == 1) {
                         
                         if(field[i][j].teamName.equals("Bayern")) {                             
                             System.out.print("|  B  ");
                         }else {
                             System.out.print("|  R  ");
                         }
                         
                     }else if(i == 0 | i == 8) {
                         
                         if(j == 3 & c == 1) {
                             System.out.print("|  G  ");
                         }else if(j == 4 & c == 1) {
                             System.out.print("|  A  ");
                         }else {
                             System.out.print("|     ");
                         }  
                         
                     }else if(!b) {
                         System.out.print("|     ");
                     }
                }
                System.out.println();
            }
            
            for(int j=0; j<Adjust.FIELD_WIDTH-1; j++) {
                System.out.print("|");
                System.out.print("_____");  
            }
            
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }
}
        
    
        
    

                    
                
            
        

        
        
