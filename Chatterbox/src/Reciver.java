import java.io.*;
import java.net.*;

/**
 * 
 * @author Manu und Kay
 *
 */
public class Reciver {
	private int reciverPort;
	
	public Reciver(int reciverPort){
		this.reciverPort = reciverPort;
	}
	
	public void start() throws IOException{
		ServerSocket serverSocket = null;
		try {
		    serverSocket = new ServerSocket(reciverPort);
		} 
		catch (IOException e) {
		    System.out.println("Could not listen on port: " + reciverPort);
		    System.exit(1);
		}
		
		Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
  
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {   
            System.out.println(inputLine);
            if(inputLine == "bye") break;
        }
        
        in.close();
        clientSocket.close();
        serverSocket.close();
		
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Thread sender = new Thread(new Sender(4478));
        sender.start();
		Reciver reciver = new Reciver(4492);
        reciver.start();
	}


}
