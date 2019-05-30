package net.etfbl.sanja.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class HttpSlowClient implements Runnable{

	@Override
	public void run() {
		try {
			Socket s = new Socket(InetAddress.getByName("localhost"), 3333);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.print("GET /SigurnostSafe/SlowServlet HTTP/1.1\r\n");
			TimeUnit.SECONDS.sleep(10);
			pw.print("Host: localhost:8080\r\n");
			TimeUnit.SECONDS.sleep(10);
			pw.print("Accept-Encoding: gzip, deflate, br\r\n");
			TimeUnit.SECONDS.sleep(10);
			pw.print("Accept-Language: en-US,en;q=0.9\r\n");
			//TimeUnit.SECONDS.sleep(10);
			pw.print("Connection: close\r\n");
			//TimeUnit.SECONDS.sleep(10);
			pw.print("\r\n");
			pw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String t;
			while((t = br.readLine()) != null) {
				System.out.println(t);
			} 
			System.out.println("Connected.");
			br.close();
			pw.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
