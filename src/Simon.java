/**
 *
 * @author Darren, Bryan
 * 
 */
// Imports
import java.awt.*;
import javax.swing.*;

public class Simon extends JFrame
{
    SimonEvent simon = new SimonEvent(this);
    // Create outline box
    JPanel board = new JPanel();
    // Create a second panel
    JPanel highscores = new JPanel();
    //Create a panel for extras
    JPanel extras = new JPanel();
    // Create a rules panel
    JPanel rules = new JPanel();
    // Create a button for rules
    JButton rule = new JButton("Rules");
    // Create a 2x2 array of buttons
    JButton[][] boxes = new JButton[2][2];
    // Create a 'play' button
    JButton play = new JButton("Play");
    // Create a 'High scores' button
    JButton highscore = new JButton("Highscore");
    //Create a sort button
    JButton sort = new JButton("Sort");
    //Create a return button
    JButton returns = new JButton("Return");
    JButton return2 = new JButton("Return");
    //Create a label for points
    JLabel points = new JLabel("Points:");
    //Create a box for the points
    JLabel games = new JLabel();
    //Create a label of the rules
    JLabel win= new JLabel("1: Click on the buttons to repeat the pattern.");
    //Create a label for the rules
    JLabel lose = new JLabel("2: You lose once you click in the incorrect order.");
    //Create label to label points
    JLabel ingame = new JLabel("Points:");
    //Create label to display the points per playing
    JLabel score = new JLabel();
    JTextArea namesearch = new JTextArea();
    JButton searching = new JButton("Search");
    
    public Simon()
    {
        //Set the title
        super ("Simon");
        //set the size of the window
        setSize(500,550);
        //make the program stop running when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set formatting to arrange the boxes
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        //Display the layout specified
        GridLayout layout1 = new GridLayout(3,2,20,20);
        GridLayout layout2 = new GridLayout(2,1,40,40);
        GridLayout layout3 = new GridLayout(0,1,1,0);
        GridLayout layout4 = new GridLayout(0,1,1,0);
        extras.setLayout(layout4);
        board.setLayout(layout1);
        highscores.setLayout(layout2);
        rules.setLayout(layout3);
        // Assign new button to the array and set their colour
        // Red
        boxes[0][0] = new JButton("Red");
        boxes[0][0].setBackground(Color.RED);
        // Yellow
        boxes[0][1] = new JButton("Yellow");
        boxes[0][1].setBackground(Color.YELLOW);
        // Blue
        boxes[1][0] = new JButton("Blue");
        boxes[1][0].setBackground(Color.BLUE);
        // Green
        boxes[1][1] = new JButton("Green");
        boxes[1][1].setBackground(Color.GREEN);
        //places the button on each board
        for(int x = 0; x <= 1; x++)
        {
            for(int y = 0; y <= 1; y++)
            {
                //assign different box size
                boxes[x][y].setPreferredSize(new Dimension(150, 150));
                // Set the button to be unabled by default
                boxes[x][y].setEnabled(false);
                //add the box to the board
                board.add(boxes[x][y]);
            }
        }
        //add the board to the GUI
        add(board);
        //create a listener for the play again button
        play.addActionListener(simon);
        //create listeners to each of the tictac boxes
        for(int x = 0; x<=1; x++)
        {
            for(int y = 0; y<=1; y++)
            {
            boxes[x][y].addActionListener(simon);
            }
        }
        setVisible(true);
        add(extras);
        // add the play and highscore button to the board
        extras.add(play);
        extras.add(highscore);
        extras.add(rule);
        //add the points display
        extras.add(ingame);
        extras.add(score);
        //add the highscore to the board
        add(highscores);
        //set the highscore board invisible
        highscores.setVisible(false);
        //add the buttons to the highscore panel as well as the search to look for a name
        highscores.add(points);
        highscores.add(games);
        highscores.add(sort);
        highscores.add(return2);
        highscores.add(namesearch);
        highscores.add(searching);
        //add the rules panel to the board
        add(rules);
        //set the rules board invisible
        rules.setVisible(false);
        //add action listener to allow GUI to open
        rule.addActionListener(simon);
        //Add labels to the rule panels
        rules.add(win);
        rules.add(lose);
        rules.add(returns);
        //when highscore is clicked allow the action to be read in the main screen
        highscore.addActionListener(simon);
        //create action listener to the return
        returns.addActionListener(simon);
        return2.addActionListener(simon);
    }
    

    public static void main(String[] args) {
        //Set main class
        Simon frame = new Simon();   
    }   
}