import java.util.Stack;

/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  David J. Barnes and Michael Kolling // edited by Manuel & Kay
 * @version 2012.11.13
 */
public class CalcEngine
{

    // The current Information shown in the display.
    private String displayValue;


    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
        clear();
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
     * or convert it to postfix
     * @param number The button pressed on the calculator.
     */
    public void input(String inpt){
    	if (inpt.equals("=")){
    		int result = calulatePostfix(covertToPostfix(displayValue));
    		displayValue = Integer.toString(result);
    	}
    	else if (inpt.equals("Clear")){
    		clear();
    	}
    	else if (inpt.equals("?")){
    		displayValue = getVersion();
    	}
    	else{
            displayValue += inpt;
    	}
    }

    /**
     * The 'C' (clear) button was pressed.
     * Reset everything to a starting state.
     */
    public void clear()
    {
        displayValue = "";
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

    /**
     * converts a infix to a postfix 
     * @param input the infix String
     * @return the postfix String
     */
    private String covertToPostfix(String input){
    	char ch;
    	String output = "";
    	Stack<Character> s = new Stack<Character>();
    	//for every character in the String
    	for (int i = 0; i < input.length(); i++){
    		//read next token
    		ch = input.charAt(i);
    		//if (token is operand) append token to postfix
    		if(Character.isLetterOrDigit(ch)){
    			output += ch;
    		}
//    	    if (token is left parenthesis) push token to stack
    		else if(ch == '('){
    			s.push(ch);
    		}
//    	    if (token is right parenthesis) pop all operators until left parenthesis and append those operators to postfix    
    		else if(ch == ')'){
    			while(s.peek()!= '('){
    				output += s.pop();
    			}
    			//pop left parenthesis
    			s.pop();
    		}
//        	if (token is operator) 
    		else{
//      	    pop all operators with higher or equal precedence than token and append those operators to postfix
    			while(!s.isEmpty() && priority(ch)<=priority(s.peek())){
    					output += s.pop();
    			}
//      	    push token	
    			s.push(ch);
    		}
//    	  end while // no more tokens
    	}
//    	  pop all operators
//    	  append those operators to postfix
    	while(!s.isEmpty()){
    		output += s.pop();
    	}
    	return output;
    }
    
    private int priority(char op){
    		if(op=='^')
    	       return 3;
    	    if(op=='/'||op=='*')
    	       return 2;
    	    if(op=='+'||op=='-')
    	       return 1;
    	    return 0;
    }
    /**
     * evaluates the result of a postfix String
     * @param postfix a String in postfix form
     * @return a int representing the result
     */
    private int calulatePostfix(String postfix){
    	Stack<Integer> numbers = new Stack<Integer>();
    	char ch;
    	int first;
    	int second;
    	//for every Character in the String
    	for (int i = 0; i<postfix.length();i++){
    		ch = postfix.charAt(i);
    		//if it is a digit put it on the Stack
    		if(Character.isLetterOrDigit(ch)){
    			String s = Character.toString(ch);
    			numbers.push(Integer.decode("#"+s));
       		}
    		//if it is an opereator take two numbers of the Stack and calculate them with the given operator
    		else{
    			second = numbers.pop();
    			first = numbers.pop();
    			System.out.println(ch);
    			numbers.push(calculateResult(first,second,ch));
    		}
    	}
    	return numbers.pop();
    	
    }
    
    
    /**
     * Combine firstOperand, secondOperator,
     * and calculate them together with the given operator
     */
    private int calculateResult(int first, int second, char op){
        switch(op) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            case '^':
                return first ^ second;
            default:
            	keySequenceError();
                return -1;
        }
    }
    
    /**
  

    /**
     * Report an error in the sequence of keys that was pressed.
     */
    private void keySequenceError()
    {
        System.out.println("A key sequence error has occurred.");
        // Reset everything.
        clear();
    }
}
