
/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    private CalcEngine engine;
    private UserInterface gui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        engine = new CalcEngine();
        gui = new UserInterface(engine);
        
        //Test 1
        engine.input("5");
        engine.input("+");
        engine.input("5");
        engine.input("*");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 15:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 2
        engine.input("5");
        engine.input("+");
        engine.input("5");
        engine.input("+");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 12:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 3
        engine.input("5");
        engine.input("+");
        engine.input("2");
        engine.input("*");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 9:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 4
        engine.input("5");
        engine.input("^");
        engine.input("2");
        engine.input("+");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 27:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 5
        engine.input("5");
        engine.input("*");
        engine.input("5");
        engine.input("*");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 50:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 6
        engine.input("5");
        engine.input("^");
        engine.input("2");
        engine.input("^");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 625:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 7
        engine.input("6");
        engine.input("-");
        engine.input("3");
        engine.input("+");
        engine.input("3");
        engine.input("=");
        System.out.println("assert 6:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 8
        engine.input("5");
        engine.input("*");
        engine.input("2");
        engine.input("*");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 20:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 9
        engine.input("2");
        engine.input("0");
        engine.input("/");
        engine.input("5");
        engine.input("=");
        System.out.println("assert 4:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 10
        engine.input("2");
        engine.input("*");
        engine.input("5");
        engine.input("/");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 5:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 11
        engine.input("5");
        engine.input("+");
        engine.input("5");
        engine.input("-");
        engine.input("2");
        engine.input("0");
        engine.input("=");
        System.out.println("assert -10:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 12
        engine.input("1");
        engine.input("0");
        engine.input("/");
        engine.input("2");
        engine.input("*");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 10:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 13
        engine.input("0");
        engine.input("*");
        engine.input("5");
        engine.input("0");
        engine.input("0");
        engine.input("+");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 2:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 14
        engine.hexa = true;
        engine.input("F");
        engine.input("F");
        engine.input("-");
        engine.input("5");
        engine.input("5");
        engine.input("=");
        System.out.println("assert 464:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
        
      //Test 15
        engine.input("A");
        engine.input("+");
        engine.input("A");
        engine.input("/");
        engine.input("2");
        engine.input("=");
        System.out.println("assert 24:");
        System.out.println(engine.getDisplayValue());
        engine.input("Clear");
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
    
    /**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Calculator ca = new Calculator();
		
	}
}