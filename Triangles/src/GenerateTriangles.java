import java.awt.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;


public class GenerateTriangles extends JFrame {
	Random r = new Random();
	JFrame frame;

	public GenerateTriangles() {
		super();
		setTitle("Sierpinski Triangle");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 * paints a first Equilateral Triangle based on the size of the frame
	 * and starts drawing of the recursive Triangles
	 */
	public void paint(Graphics g){
		Dimension size = this.getSize();
		//space from the border
		int frameBorder = 50;
		//different formulas needen weather width is geater height or not
		
		Point a,b,c;
		if(size.width > size.height){
			int height = size.height -frameBorder;
			double length = 2 * height / Math.sqrt(3);
			
			a = new Point((int) (size.width / 2 - length/2),size.height-frameBorder/2);
			b = new Point((int) (size.width / 2 + length/2) ,size.height-frameBorder/2);
		    c = new Point(size.width / 2,frameBorder/2); 
			
		    drawTriangle(a,b,c,g);
		}else{
			int length = size.width - frameBorder;
			int height = (int) (Math.sqrt(3) * length / 2);
			
			a = new Point (frameBorder/2,size.height-frameBorder/2);
			b = new Point (size.width - frameBorder/2,size.height-frameBorder/2);
			c = new Point (size.width / 2,size.height-frameBorder/2-height);
			
			drawTriangle(a,b,c,g);
		}
			drawAllOtherTraingles(a,b,c,g);
	}
	
	/*
	 * Daraws a Triangle from three given Points to a Graphics panel
	 */
	private void drawTriangle(Point a, Point b, Point c, Graphics g){
		int[] x = { a.x, b.x, c.x };
		int[] y = { a.y, b.y, c.y };
		
		//set random Color for the triangle
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.fillPolygon(x, y, 3);
	}
	
	private void drawAllOtherTraingles(Point a, Point b, Point c, Graphics g){
		//Base Case
		if(b.x - a.x < 10){
			return;
		}
		
		//Set new Points a_ b_ c_ at the medians of the triangle
		Point a_ = new Point ((a.x +c.x)/2,(a.y +c.y)/2);
		Point b_ = new Point ((c.x +b.x)/2,(c.y +b.y)/2);
		Point c_ = new Point ((b.x +a.x)/2,(b.y +a.y)/2);
		
		drawTriangle(a_,b_,c_,g);
		
		//draw inner Triangles
		drawAllOtherTraingles(a,a_,c_,g); //tringagle on the bottom left
		drawAllOtherTraingles(c_,b_,b,g); //tringagle on the bottom right
		drawAllOtherTraingles(a_,c,b_,g); //tringagle on the top
	}
	
	/**
	 * The main Method
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		new GenerateTriangles();
	}

}
