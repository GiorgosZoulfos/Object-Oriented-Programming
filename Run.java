//Μεσα σε αυτη τη κλαση καλειται η runTurn() ετσι ωστε να μπορει το προγραμμα
//να περιμενει το χρηστη να πατησει το κουμπι Next Round της παραθυρικης εφαρμογης
//μεσω της χρησης νηματων
public class Run implements Runnable {
    //Δημουργια νηματος
    private Thread runner;
    //Αυτη τη μεταβλητη γινεται true αν ο χρηστης πατησει Next Round
    static boolean goOn = false;
    //Αντικειμενα οπου θα αποθηκευτουν τα ορισματα για επεξεργασια
    Game game = new Game();
    Ball ball = new Ball(4,4);
    
    int count = 1;
    
    //Constructor
    public Run(Game g ,Ball b) {
        if(runner == null) {
            runner = new Thread(this);
            runner.start();//Αρχη νηματος
        }
        game = g;
        ball = b;
    }
    
    //Methods
    public void run() {
        //Οσο ο χρηστης θελει το προγραμμα να συνεχιζει
        while(!Window.end) {
            try{
                synchronized(runner){//Συχγρονισμος νηματος
                    //Οσο ο χρηστης δεν εχει πατησει Next Round
                    while(!goOn & !Window.end) {
                        runner.wait(100);//Περιμενε
                    }
                }
            }catch(InterruptedException ie) {
                System.out.println("Exception: " + ie.toString());
            }catch(IllegalMonitorStateException imse) {
                System.out.println("Exception :" + imse.toString());
            }
            try {
                synchronized(runner) {
                    while(goOn) {
                        runner.notify();//Ξυπνημα του νηματος
                        game.runTurn(ball);//Καλειται η runTurn()
                        count++;  
                        //Ελεγχος για εκπληρωση προυποθεσεων τερματισμου
                        if(count > Adjust.MAX_ROUNDS) {
                            Window.end = true;
                            System.out.println("Max rounds reached!Game is over!");
                        }else if(game.bayern.goals == Adjust.MAX_GOALS) {
                            Window.end = true;
                            System.out.println("Bayern scored " +  Adjust.MAX_GOALS + " !Game is over!");
                        }else if(game.real.goals == Adjust.MAX_GOALS) {
                            Window.end = true;
                            System.out.println("Real scored " +  Adjust.MAX_GOALS + " !Game is over!");
                        }
                        goOn = false;//Η μεταβλητη γινεται ξανα false ωστε να κληθει η runTurn μονο αν
                    }//ο χρηστης πατησει ξανα το Next Round
                }
            }catch(IllegalMonitorStateException imse) {
                System.out.println("Exception :" + imse.toString());
            }         
        }
    }
}