
/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  David J. Barnes and Michael Kolling // edited by Manuel & Kay
 * @version 2012.11.13
 */
public class CalcEngine
{
	private Postfix p;
	public boolean hexa = false;

    // The current Information shown in the display.
    private String displayValue;
    private int tempNumber;



    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
        clear();
        tempNumber = 0;
        p = new Postfix();
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayValue()
    {
        return displayValue;
    }

    /**
     * Save the input to a String
     * or calculate it
     * @param number The button pressed on the calculator.
     */
    public void input(String inpt){
    	if (inpt.equals("=")){
    		int result;
			try {
				result = p.evaluate(p.infixToPostfix(displayValue),hexa);
				displayValue = Integer.toString(result);
			} catch (Exception e) {
				displayValue = "Fehler:";
				System.out.println(e);
			}
    	}
    	else if (inpt.equals("Clear")){
    		clear();
    	}
    	else if (inpt.equals("?")){
    		displayValue = getVersion();
    	}
    	else if(inpt.matches("\\w")){
    		if(tempNumber != 0){
				//erase last number from String
				int last = displayValue.lastIndexOf(' ') + 1;
				displayValue = displayValue.substring(0, last);
			}
    		if(!hexa){
    			tempNumber = tempNumber * 10 + Integer.parseInt(inpt);
    			displayValue += String.valueOf(tempNumber); 
    		}else{
    			tempNumber = tempNumber * 16 + Integer.decode("#"+inpt);
    			displayValue += String.valueOf(tempNumber); 
    		}
    	}
    	else{
    		tempNumber = 0;
            displayValue += " " + inpt + " ";
    	}
    }

    /**
     * The 'C' (clear) button was pressed.
     * Reset everything to a starting state.
     */
    public void clear()
    {
        displayValue = "";
        tempNumber = 0;
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "Manuel und Kay";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion()
    {
       return "Version 2.0";
    }
}
