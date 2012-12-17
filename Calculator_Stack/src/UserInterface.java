import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the calculator. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class UserInterface
    implements ActionListener
{
    private CalcEngine calc;
    private boolean showingAuthor;
    private boolean showHEX;

    private JFrame frame;
    private JTextField display;
    private JLabel status;
    
    private JPanel contentPane;
    private JPanel buttonPanel;

    /**
     * Create a user interface.
     * @param engine The calculator engine.
     */
    public UserInterface(CalcEngine engine)
    {
        calc = engine;
        showingAuthor = true;
        
        showHEX = false;
        
        makeFrame();
        frame.setVisible(true);
    }

    /**
     * Set the visibility of the interface.
     * @param visible true if the interface is to be made visible, false otherwise.
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

    /**
     * Make the frame for the user interface.
     */
    private void makeFrame()
    {
        frame = new JFrame(calc.getTitle());
        
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

//		if(showHEX==true)
//		{
	         buttonPanel = new JPanel(new GridLayout(8, 6));
	        
	        	addButton(buttonPanel, "HEX ON/OFF");
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		addButton(buttonPanel, "C");
	    		addButton(buttonPanel, "?");
	    		
				buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    	
	    		addButton(buttonPanel, "A");
	    		addButton(buttonPanel, "B");
	    		addButton(buttonPanel, "C");
	        	addButton(buttonPanel, "D");
	        	addButton(buttonPanel, "E");
	        	addButton(buttonPanel, "F");
	
				buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		buttonPanel.add(new JLabel(" "));
	    		
	            addButton(buttonPanel, "7");
	            addButton(buttonPanel, "8");
	            addButton(buttonPanel, "9");
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "+");
	            addButton(buttonPanel, "*");
	            
	            addButton(buttonPanel, "4");
	            addButton(buttonPanel, "5");
	            addButton(buttonPanel, "6");
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "-");
	            addButton(buttonPanel, "^");
	            addButton(buttonPanel, "/");
	            
	            addButton(buttonPanel, "1");
	            addButton(buttonPanel, "2");
	            addButton(buttonPanel, "3");
	            buttonPanel.add(new JLabel(" "));
	            buttonPanel.add(new JLabel(" "));
	            buttonPanel.add(new JLabel(" "));
	            
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "0");
	            buttonPanel.add(new JLabel(" "));
	            buttonPanel.add(new JLabel(" "));
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "=");
	            
	            contentPane.add(buttonPanel, BorderLayout.CENTER);
//		}
//		else
//		{
//	        JPanel buttonPanel = new JPanel(new GridLayout(6, 6));
//	        
//	        	addButton(buttonPanel, "HEX ON/OFF");
//	    		buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		addButton(buttonPanel, "C");
//	    		addButton(buttonPanel, "?");
//	    		
//				buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		buttonPanel.add(new JLabel(" "));
//	    		
//	            addButton(buttonPanel, "7");
//	            addButton(buttonPanel, "8");
//	            addButton(buttonPanel, "9");
//	            buttonPanel.add(new JLabel(" "));
//	            addButton(buttonPanel, "+");
//	            addButton(buttonPanel, "*");
//	            
//	            addButton(buttonPanel, "4");
//	            addButton(buttonPanel, "5");
//	            addButton(buttonPanel, "6");
//	            buttonPanel.add(new JLabel(" "));
//	            addButton(buttonPanel, "-");
//	            addButton(buttonPanel, "/");
//	            
//	            addButton(buttonPanel, "1");
//	            addButton(buttonPanel, "2");
//	            addButton(buttonPanel, "3");
//	            buttonPanel.add(new JLabel(" "));
//	            buttonPanel.add(new JLabel(" "));
//	            buttonPanel.add(new JLabel(" "));
//	            
//	            buttonPanel.add(new JLabel(" "));
//	            addButton(buttonPanel, "0");
//	            buttonPanel.add(new JLabel(" "));
//	            buttonPanel.add(new JLabel(" "));
//	            buttonPanel.add(new JLabel(" "));
//	            addButton(buttonPanel, "=");
//	            
//	            contentPane.add(buttonPanel, BorderLayout.CENTER);
//		}

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);
        frame.pack();
    }

    /**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    private void addButton(Container panel, String buttonText)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
    }

    /**
     * An interface action has been performed.
     * @param event The event that has occured.
     */
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("HEX ON/OFF")){
        	if(calc.hexa){
        		calc.hexa = false;
        	}else{
        		calc.hexa = true;
        	}
        }
        else{
        	calc.input(event.getActionCommand());
        	redisplay();
        }
    }

    /**
     * Update the interface display to show the current value of the 
     * calculator.
     */
    private void redisplay()
    {
        display.setText("" + calc.getDisplayValue());
    }

    /**
     * Toggle the info display in the calculator's status area between the
     * author and version information.
     */
    private void showInfo()
    {
        if(showingAuthor)
            status.setText(calc.getVersion());
        else
            status.setText(calc.getAuthor());

        showingAuthor = !showingAuthor;
    }
}
