
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
	private JulianDate storedDate;
	private JulianDate date;
	
	//Save the current input of the Date
	public int storedDay;
	public int storedMonth;
	public int storedYear;
	private char operator = '0';
	
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
    	if (inpt.equals("Clear")){
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
    	else if(inpt.equals("Save Date")){
    		displayValue = String.valueOf(storedDay) +"."+ String.valueOf(storedMonth) +"."+ String.valueOf(storedYear);
    		date = new JulianDate(storedYear,storedMonth,storedDay);
    	}
    	else if(inpt.equals("Show Weekday")){
    		if(date != null){
    			displayValue = date.getWeekday();
    		}
    		else{
    			displayValue = "save date first";
    		}
    	}
    	else if(date != null && inpt.equals("-")){
    			storedDate = date;
    			date = null;
    			operator = '-';
    			displayValue = "";
    			
    	}
    	else if(date != null && inpt.equals("+")){
			storedDate = date;
			date = null;
			operator = '+';
			displayValue = "";
	}
    	else if (inpt.equals("=")){
    		//two different dates stored calculate time difference
    		if(date != null && storedDate != null){
    			displayValue = String.valueOf(date.calculateTimeDifference(storedDate));
    		}
    		//less than two dates stored but operator given subtract or add days
    		else if(operator != '0'){
    			int oldDate = storedDate.getJDate();
    			int newDate;
    			
    			switch (operator){
    			case '-':
    				newDate = oldDate - Integer.parseInt(displayValue);
    				break;
    			case '+':
    				newDate = oldDate + Integer.parseInt(displayValue);
    				break;
    			default:
    				newDate = oldDate;
    			}
    			date = new JulianDate (newDate);
    			displayValue = String.valueOf( date.getGergDate()[2]+1 ) +"." +String.valueOf( date.getGergDate()[1] ) +"."+String.valueOf( date.getGergDate()[0] );
    			
    		}
    		//nothing with date just normal numbers
    		else{
    			int result;
    			try {
    				result = p.evaluate(p.infixToPostfix(displayValue),hexa);
    				displayValue = Integer.toString(result);
    			} catch (Exception e) {
    				displayValue = "Fehler:";
    				System.out.println(e);
    			}
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
