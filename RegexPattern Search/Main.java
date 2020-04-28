import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
        
      //Creating the Frame
        JFrame frame = new JFrame("Pattern Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
        frame.setLocation(600,400);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Enter The Pattern: ");        
        JLabel label1 = new JLabel("Enter The String: ");        
        
       // creating textfields for pattern, string to verify and answer field
        JTextField patternField = new JTextField(50);        
        JTextField inputStringfield = new JTextField(50);  
        JTextField answerField = new JTextField(50);
        answerField.setEditable(false);
        
        // check button with action listener        
        JButton send = new JButton("Check");
        send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String patternStr = patternField.getText();
				String inputStr = inputStringfield.getText();
				Pattern pattern = null;
				
				
				if(!patternStr.equals("")) { // the patternfield must not be empty
				try {
		        		pattern = Pattern.compile(patternStr);	// create the pattern	        		
		        	
		        //check if the pattern is invalid	 
		        }catch (PatternSyntaxException exception) {     
		        	System.err.println(exception.getDescription());		        	
		        	System.out.println("Invalid Syntax");
		        	System.exit(1);
		        }
		        if(!inputStr.equals("")) { // the input stringfield must not be empty	        	
		        	Matcher matcher = pattern.matcher(inputStr);       
		           boolean matchFound = matcher.matches(); // matches the regular expression against the whole string passed to the Pattern.matcher() method
		        	matchFound = matcher.lookingAt(); // attempts to match the input sequence, starting at the beginning, against the pattern.
		        									  // can be replaced with matches() - that attempts to match the entire input sequence against the pattern.
		        	if(matchFound) {
		        		
		        		answerField.setText("In the string '" + inputStr + "' the pattern IS present");
		        	}
		        	else
		        		answerField.setText("In the string '" + inputStr + "' the pattern is NOT present");
		        }
		        else answerField.setText("Input a string first!");
				}
				else answerField.setText("Input a pattern first!");
			}
		});
        
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { // clear the textfields
				patternField.setText("");
				inputStringfield.setText("");
				answerField.setText("");
				
			}
		});
        
        //adding the components to the panel
        panel.add(label); 
        panel.add(patternField);
        panel.add(label1);
        panel.add(inputStringfield);
        panel.add(send);
        panel.add(reset);
        panel.add(answerField); 
        
        //Adding Components to the frame.
        frame.add(panel);   
        //setting the frame visible
        frame.setVisible(true);
         
    }
}
