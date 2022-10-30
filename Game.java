import java.lang.Math;
public class Game {
    
    int rounds = 0;
    
    Team bayern = new Team();
    Team real = new Team();
    
    //Methods
    public void runTurn(Ball b) {
        
        System.out.println("****** The round begins!!! ******");
        
        if((int)Math.floor(Math.random()*2) == 0) {//Εκτελεση της action με τυχαια σειρα
            
            System.out.println("Bayern first!!");
            bayern.action(b, bayern, real);
            System.out.println("Now Real!!");
            real.action(b, bayern, real);
            
        }else {
            
             System.out.println("Real first!!");
             real.action(b, bayern, real);
             System.out.println("Now Bayern!!");
             bayern.action(b, bayern, real);
             
        }
        
        if((b.x == 0) & ((b.y == 3) | (b.y == 4))) {//Αν ειναι κοντα στο τερμα
            
            if((int)Math.floor(Math.random()*100) < 50){//Τοτε με πιθανοτητα 50% 
                
                bayern.goals++;//+1 τα γκολ
                System.out.println("Bayern scored a goal");
                
            }
            
            bayern.shotsOnTarget++;
            
        }else if((b.x == 8) & ((b.y == 3) | (b.y == 4))) {//Αν ειναι κοντα στο τερμα
            
             if((int)Math.floor(Math.random()*100) < 50){//Τοτε με πιθανοτητα 50%
                 
                real.goals++;//+1 τα γκολ
                System.out.println("Real Madrid scored a goal");
                
            }
            
             real.shotsOnTarget++;
        }
        if(b.x == 0 | b.x == 8) {
            
            b.assignement();
        }
        
        rounds++;
    }
}
            
            
            
        