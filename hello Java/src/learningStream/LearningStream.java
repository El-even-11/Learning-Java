package learningStream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class LearningStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket=new Socket(InetAddress.getByName("localhost"),12345);
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			
			out.println("hello");
			out.close();
			socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
