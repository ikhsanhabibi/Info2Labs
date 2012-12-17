import java.io.*;
import java.net.*;


public class Sender implements Runnable {
	private int senderPort;
	
	public Sender(int senderPort){
		this.senderPort = senderPort;
	}

	@Override
	public void run() {
		Socket sendSocket = null;
		PrintWriter out = null;
		
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		String userString = null;
		
		
		while(userInput != null){
			try {
				userString = userInput.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(userString.equals("connect")){
				try {
					sendSocket = new Socket("localhost",senderPort);
					out = new PrintWriter(sendSocket.getOutputStream(),true);
				} catch (UnknownHostException e) {
					System.out.println("unkown host ");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Could not connect to Port: " + senderPort);
					e.printStackTrace();
				}
			}
			if(out != null) {
				out.println(userString);
				System.out.println(userString);
			}
		}
		
		
		out.close();
		try {
			sendSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
