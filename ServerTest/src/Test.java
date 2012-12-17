import java.io.*;
import java.net.*;


public class Test {
	private Socket mySocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public Test(String host,int port){
		try {
			mySocket = new Socket(host, port);
			out = new PrintWriter(mySocket.getOutputStream(), true);
			in = new BufferedReader( new InputStreamReader(mySocket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test("141.45.200.104",2007);
	}
	
	public void listen(){
	}

}
