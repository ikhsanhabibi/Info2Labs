import java.util.Stack;


public class Postfix {
	/**
     * converts a infix to a postfix 
     * @param input the infix String
     * @return the postfix String
     */
    public String infixToPostfix(String input){
    	String[] splittet = input.split(" ");
    	String st;
    	String output = "";
    	Stack<String> s = new Stack<String>();
    	//for every character in the String
    	for (int i = 0; i < splittet.length; i++){
    		//read next token
    		st = splittet[i];
    		//if (token is operand) append token to postfix
    		if(st.matches("\\w+")){
    			output += st + " ";
    		}
//    	    if (token is left parenthesis) push token to stack
    		else if(st.equals("(")){
    			s.push(st);
    		}
//    	    if (token is right parenthesis) pop all operators until left parenthesis and append those operators to postfix    
    		else if(st.equals(")")){
    			while(!s.peek().equals("(")){
    				output += s.pop() + " ";
    			}
    			//pop left parenthesis
    			s.pop();
    		}
//        	if (token is operator) 
    		else{
//      	    pop all operators with higher or equal precedence than token and append those operators to postfix
    			while(!s.isEmpty() && priority(st)<=priority(s.peek())){
    					output += s.pop() + " ";
    			}
//      	    push token	
    			s.push(st);
    		}
//    	  end while // no more tokens
    	}
//    	  pop all operators
//    	  append those operators to postfix
    	while(!s.isEmpty()){
    		output += s.pop() + " ";
    	}
    	return output;
    }
    
    private int priority(String op){
    		if(op.equals("^"))
    	       return 3;
    	    if(op.equals("/")||op.equals("*"))
    	       return 2;
    	    if(op.equals("+")||op.equals("-"))
    	       return 1;
    	    return 0;
    }
    
    /**
     * evaluates the result of a postfix String
     * @param postfix a String in postfix form
     * @return a int representing the result
     */
    public int evaluate(String postfix,boolean hexa) throws Exception{
    	Stack<Integer> numbers = new Stack<Integer>();
    	String[] splitted = postfix.split(" ");
    	String st;
    	int first;
    	int second;
    	//for every Character in the String
    	for (int i = 0; i<splitted.length;i++){
    		st = splitted[i];
    		//if it is a digit put it on the Stack
    		if(st.matches("\\w+")){
    			if(!hexa){
    				numbers.push(Integer.parseInt(st));
    			}else{
    				numbers.push(Integer.decode("#"+st));
    			}
    		}
    		//if it is an opereator take two numbers of the Stack and calculate them with the given operator
    		else{
    			second = numbers.pop();
    			first = numbers.pop();
    			numbers.push(calculateResult(first,second,st.toCharArray()[0]));
    		}
    	}
    	int result = numbers.pop();
    	if(numbers.empty()){
    		return result;
    	}else{
    		throw new Exception("Wrong formated String");
    	}
    	
    }
    
    /**
     * Combine firstOperand, secondOperator,
     * and calculate them together with the given operator
     */
    private int calculateResult(int first, int second, char op) throws Exception{
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
                return (int) Math.pow(first, second);
            default:
                throw new Exception("Unkown Operand");
        }
    }

}
