import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Main {
    
    static Player[][] field = new Player[Adjust.FIELD_LENGTH][Adjust.FIELD_WIDTH];
    
    public static void main() {
        Game game = new Game();
        //Δημιουργια των αντικειμενων
        Libero boateng = null;
        Defender lahm = null;
        Defender vidal = null;
        Defender martinez = null;
        Attacker ribery = null;
        Attacker robben = null;
        CenterFor lewa = null;
        
        Libero ramos = null;
        Defender pepe = null;
        Defender marcelo = null;
        Defender kroos = null;
        Attacker ronaldo = null;
        Attacker bale = null;
        CenterFor benzema = null;
        //Διαβασμα απο αρχειο
        try {
            FileReader fr0 = new FileReader("in.txt");
            BufferedReader br0 = new BufferedReader(fr0);
            game.bayern.teamName = br0.readLine();
            
            for(int i=0; i<7; i++) {//Αρχικοποιηση των παικτων της Bayern               
                    String strY = br0.readLine();//Διαβασμα των στοιχειων καθε παικτη
                    int y = Integer.parseInt(strY);
                    
                    String name = br0.readLine();
                    
                    String strNumber = br0.readLine();
                    int number = Integer.parseInt(strNumber);
                    
                    String strML = br0.readLine();
                    int moveLine = Integer.parseInt(strML);
                    
                    String strTl = br0.readLine();                   
                    int targetLine = Integer.parseInt(strTl);
                    
                    String teamName = br0.readLine();
                    if( i == 0 ) {
                        boateng = new Libero(y, name, number, moveLine, targetLine, teamName);                       
                    }else if(i == 1) {
                        lahm = new Defender(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 2) {
                        vidal = new Defender(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 3) {
                        martinez = new Defender(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 4) {
                        ribery = new Attacker(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 5) {
                        robben = new Attacker(y, name, number, moveLine, targetLine, teamName);
                    }else {
                        lewa = new CenterFor(y, name, number, moveLine, targetLine, teamName);
                    }                          
            }//end  for 
            game.real.teamName = br0.readLine();            
            
            for(int i=0; i<7; i++) {//Αρχικοποιηση των παικτων της Bayern               
                    String strY = br0.readLine();//Διαβασμα των στοιχειων καθε παικτη
                    int y = Integer.parseInt(strY);
                    
                    String name = br0.readLine();                   
                    
                    String strNumber = br0.readLine();                    
                    int number = Integer.parseInt(strNumber);
                    
                    String strML = br0.readLine();                    
                    int moveLine = Integer.parseInt(strML);
                    
                    String strTl = br0.readLine();                   
                    int targetLine = Integer.parseInt(strTl);
                    
                    String teamName = br0.readLine();
                    if( i == 0 ) {                        
                        ramos = new Libero(y, name, number, moveLine, targetLine, teamName);                         
                    }else if(i == 1) {
                        pepe = new Defender(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 2) {
                        marcelo = new Defender(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 3) {
                        kroos = new Defender(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 4) {
                        ronaldo = new Attacker(y, name, number, moveLine, targetLine, teamName);
                    }else if(i == 5) {
                        bale = new Attacker(y, name, number, moveLine, targetLine, teamName);
                    }else {
                        benzema = new CenterFor(y, name, number, moveLine, targetLine, teamName);
                    }                          
            }//end  for 
            br0.close();//κλεισιμο αρχειου
        }catch (FileNotFoundException fnfe) {
            System.out.println("Exception:" + fnfe.toString());
        }catch (IOException ioe) {
            System.out.println("Exception:" + ioe.toString());
        }catch (NumberFormatException nfe) {
            System.out.println("Exception:" + nfe.toString());
        }
        //Αρχικοποιηση των ομαδων
        game.bayern.set(boateng,lahm,vidal,martinez,ribery,robben,lewa);
        game.real.set(ramos,pepe,marcelo,kroos,ronaldo,bale,benzema);
        //Φορτωση των παικτων στο γηπεδο
        for(int i=0; i<7; i++) {
            field[game.bayern.players.get(i).moveLine][game.bayern.players.get(i).y] = game.bayern.players.get(i);
            field[game.real.players.get(i).moveLine][game.real.players.get(i).y] = game.real.players.get(i);
        }
        //Αρχη παιχνιδιου
        System.out.println("Welcome to the Champions League final in Milano!Bayern Munich vs Real Madrid!");
        Ball ball = new Ball(4, 4);
        Window w = new Window(game ,ball ,field);
        Run r = new Run(game ,ball); 
       
    }
}


