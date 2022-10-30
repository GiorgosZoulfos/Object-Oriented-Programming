//Αυτη η κλαση περιεχει τη παραθυρικη εφαρμογη
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    //Δημιουργια των κουμπιων
    JButton b1 = new JButton("Players details");
    JButton b2 = new JButton("Team detalais");
    JButton b3 = new JButton("Ball details");
    JButton b4 = new JButton("Game details");
    JButton b5 = new JButton("Stop");
    JButton b6 = new JButton("Next round");
    JButton b7 = new JButton("Field details");
    //Σε αυτα τα ανικειμενα αποθηκευονται τα ορισματα ωστε να επεξεργαστουν
    Game game = null;
    Ball ball = null;
    Player[][] field = null;
    //Μεταβλητη που γινεται true αν ο χρηστης πατησει το stop η αν το παιχνιδι ολοκληρωσει ορισμενους γυρους η μπουν
    static boolean end = false;//ορισμενα γκολ
    
    public Window(Game g, Ball b, Player[][] f) {
        super("Final in Milan");//Οναμα παραθυρου
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Να κλεινει η εφαρμογη οταν κλεινει το παραθυρο
        
        //Συνδεση των κουμπιων με την ActionListener ωστε να επιτελουν
        //τη λειτουργια τους στο πρoγραμμα
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        
        //Προσθεση των κουμπιων στο Panel
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        pack();
        
        setVisible(true);
        
        //αποθηκευση των ορισματων
        game = g;
        ball = b;
        field = f;
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == b1) {
            
            System.out.println("\n\n**** Lineup of Bayern ****"); 
            Print.playersInfo(game.bayern.players);
            System.out.println("\n\n**** Lineup of Real ****");
            Print.playersInfo(game.real.players);
            
        }else if(source == b2) {
            
            Print.teamInfo(game.bayern);
            Print.teamInfo(game.real);
            
        }else if(source == b3) {               
            Print.ballInfo(ball); 
            
        }else if(source == b4) {            
            Print.gameInfo(game);   
            
        }else if(source == b5) {            
            Window.end = true;     
            
        }else if(source == b6) {           
            Run.goOn = true;       
            
        }else if(source == b7) {            
            Print.fieldInfo(field , ball);            
        }
    }
}
