// Imports
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimonEvent implements ItemListener, ActionListener, Runnable
{
    // Assosiates the game board with the event
    Simon gameboard;
    //Highscore scoreboard;
    
    // Declare variables
    int patternNum; // Tracks the number of elements in the sequence
    int clicks;     // Stores the number of times the player has pressed buttons
    int patternLoc; // Tracks the postition in the sequence
    int timerDelay = 700;
    boolean playerTurn;
    ArrayList sequence = new ArrayList();   // Stores elements in the sequence
    ArrayList player = new ArrayList();     // Stores the player's inputs
    ArrayList score = new ArrayList();      // Stores high scores
    JFrame frameLose;
    
    // Assosiates the main file with this file(event)
    public SimonEvent(Simon in)
    {
        gameboard = in;
    }
    
    void play()
    {
        /**
         * Disable menu buttons
         */
        //Set the score
        gameboard.score.setText(""+score);
        // Disable menu buttons
        gameboard.play.setEnabled(false);   // Disable play button
        gameboard.highscore.setEnabled(false);  // Disable highscore button
        gameboard.rule.setEnabled(false);   // Disable rules button
        // Add a dummy placeholder
        sequence.add("");
        // Generate a colour
        gen();
    }
    
    void gen()
    {
        /**
         * Method to generate the pattern
         * Generates numbers 1-4 corresponding to a color
         * Adds that color to ArrayList sequence
         */
        // Set clicks to 1
        clicks = 1;
        patternLoc = 1;
        // Clear player cache
        player.clear();
        player.add("");
        // Disable colour buttons
        for(int x = 0; x <= 1; x++)
        {
            for(int y = 0; y <= 1; y++)
            {
                gameboard.boxes[x][y].setEnabled(false);
            }
        }
        // Generate a random number (1-4)
        int temp = (int)Math.floor(Math.random()*4+1);
        // Convert number to a colour
        switch(temp)
        {
            case 1:
                sequence.add("Red");
                pattern();
                break;
            case 2:
                sequence.add("Yellow");
                pattern();
                break;
            case 3:
                sequence.add("Blue");
                pattern();
                break;
            case 4:
                sequence.add("Green");
                pattern();
                break;
        }
    }
    
    void pattern()
    {
        /**
         * Method to make buttons "light up"
         * Changes button color to white, waits, then back to original color
         */
        gameboard.boxes[0][0].setBackground(Color.RED);     // Change box 0,0 to red
        gameboard.boxes[0][1].setBackground(Color.YELLOW);  // Change box 0,1 to yellow
        gameboard.boxes[1][0].setBackground(Color.BLUE);    // Change box 1,0 to blue
        gameboard.boxes[1][1].setBackground(Color.GREEN);   // Change box 1,1 to green
        if(patternLoc < sequence.size())
        {
            String temp = (String)sequence.get(patternLoc);
            patternLoc++;
            System.out.println(patternLoc);
            switch(temp)
            {
                case "Red":
                    gameboard.boxes[0][0].setBackground(Color.WHITE);   // Change box 0,0 to white
                    timerR.start(); // Start timerR
                    break;
                case "Yellow":
                    gameboard.boxes[0][1].setBackground(Color.WHITE);   // Change box 0,1 to white
                    timerY.start(); // Start timerY
                    break;
                case "Blue":
                    gameboard.boxes[1][0].setBackground(Color.WHITE);   // Change box 1,0 to white
                    timerB.start(); // Start timerB
                    break;
                case "Green":
                    gameboard.boxes[1][1].setBackground(Color.WHITE);   // Change box 1,0 to white
                    timerG.start(); // Start timerG
                    break;
            }
            // Enable colour buttons
            for(int x = 0; x <= 1; x++)
            {
                for(int y = 0; y <= 1; y++)
                {
                    gameboard.boxes[x][y].setEnabled(true);
                }
            }
        }
    }
    
    // Red timer
    ActionListener timerListenerR = new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            gameboard.boxes[0][0].setBackground(Color.RED);     // Change box 0,0 to red
            System.out.println("Red");
            pattern();
            timerR.stop();
        }
    };
    Timer timerR = new Timer(timerDelay,timerListenerR);
    // Yellow timer
    ActionListener timerListenerY = new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            gameboard.boxes[0][1].setBackground(Color.YELLOW);  // Change box 0,1 to yellow
            System.out.println("Yellow");
            pattern();
            timerY.stop();
        }
    };
    Timer timerY = new Timer(timerDelay,timerListenerY);
    // Blue timer
    ActionListener timerListenerB = new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            gameboard.boxes[1][0].setBackground(Color.BLUE);    // Change box 1,0 to blue
            System.out.println("Blue");
            pattern();
            timerB.stop();
        }
    };
    Timer timerB = new Timer(timerDelay,timerListenerB);
    // Green timer
    ActionListener timerListenerG = new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            gameboard.boxes[1][1].setBackground(Color.GREEN);   // Change box 1,1 to green
            System.out.println("Green");
            timerG.stop();
            pattern();
        }
    };
    Timer timerG = new Timer(timerDelay,timerListenerG);
    
    public void actionPerformed(ActionEvent event)
    {
        //Check what button has been clicked
        String command = event.getActionCommand();
        //call the appropriate method
        switch(command)
        {
            case "Play":
                play();
                break;
            case "Highscore":
                highscore();
                break;
            case "Return":
                returns();
                break;
            case "Rules":
                rule();
                break;
            case "Sort":
                sort();
                break;
            case "Red":
                red();
                break;
            case "Yellow":
                yellow();
                break;
            case "Blue":
                blue();
                break;
            case "Green":
                green();
                break;
        }
    }
    
    void red()
    {
        clicks++;
        // Add red to the player sequence
        player.add("Red");
        System.out.println("pRed");
        // Check method
        check();
    }
    void yellow()
    {
        clicks++;
        // Add yellow to the player sequence
        player.add("Yellow");
        System.out.println("pYellow");
        // Check method
        check();
    }
    void blue()
    {
        clicks++;
        // Add blue to the player sequence
        player.add("Blue");
        System.out.println("pBlue");
        // Check method
        check();
    }
    void green()
    {
        clicks++;
        // Add green to the player sequence
        player.add("Green");
        System.out.println("pGreen");
        // Check method
        check();
    }
    
    void check()
    {
        // Check if the player has clicked a number of times equal to the sequence size
        if(clicks == sequence.size())
        {
            for(int i = 0; i < sequence.size(); i++)
            {
                if(player.get(i) != sequence.get(i))
                {
                    lose();
                }
            }
            gen();  
        }
    }
    
    void lose()
    {
        /**
	 * Open dialogue box displaying lose message
	 * Add score to scoreboard
	 * Reset all counters
	 */
        System.out.println("Loser");    // Print to console
        // Clear counters and Arraylists
        patternLoc = 0;
        clicks = 0;
        sequence.clear();
        player.clear();
        // Enable menu buttons
        gameboard.play.setEnabled(true);   // Enable play button
        gameboard.highscore.setEnabled(true);  // Enable highscore button
        gameboard.rule.setEnabled(true);   // Enable rules button
        JOptionPane.showMessageDialog(frameLose,"You Lost! Nice Try.","Game Over",JOptionPane.PLAIN_MESSAGE);
    }
    
    void highscore()
    {
        /**
         * Method to open up the score
         */
         gameboard.rules.setVisible(false);//set rules invisible
         gameboard.board.setVisible(false);//set the board invisible
         gameboard.highscores.setVisible(true);//set the board visible
         gameboard.rule.setVisible(false);//set the rule button invisible
         gameboard.returns.setVisible(true);//set the return button visible on this screen
         gameboard.extras.setVisible(false);
    }
    void rule()
    {
        /*
        Create a method to open up the rules board
        */
         gameboard.board.setVisible(false);//set the board invisible
         gameboard.highscores.setVisible(false);//set the board invisible
         gameboard.rules.setVisible(true);//set rules visible
         gameboard.rule.setVisible(false);//set the rule button invisible
         gameboard.extras.setVisible(false);//set buttons invisible
    }
    void returns()
    {
        /*
        Create a method to use the return button
        Send you back the original screen
        */
         gameboard.rules.setVisible(false);//set rules invisible
         gameboard.highscores.setVisible(false);//set the board invisible
         gameboard.board.setVisible(true);//set the board visible
         gameboard.rule.setVisible(true);//set the rule button visible
         gameboard.extras.setVisible(true);//set button visible
    }
    void sort()
    {
        /*
     create a method to sort the highscores
     */
     // Sort names
       // Collections.sort();
    }
    void search()
    {
         /*// Declare variables
        String input;
        int position;
        //set values to the variables
        input = gameboard.namesearch.getText();//get the name input and store in a variable
        position = gameboard.score.indexOf(input);//store in a variable to get positon
        switch(position)//set up a case to get position
        {
            //when not found
            case -1:
                nameOutput.setText(input+" This is not found");
                //clear the the input
                nameInput.setText("");
                break;//break the loop
                //set up case when found
                default:
                    //print message and show input and position
                nameOutput.setText(input+" is found at position "+position);
                //clear the the input
                nameInput.setText("");
                break;//break the loop
        }
*/
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}