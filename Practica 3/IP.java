import java.io.*;
import java.net.*;
public class IP {

	public static void main(String[] args) {
		
		try {
		
			String host = "moodle.itescam.edu.mx";
			String ip = "La dirección IP de " + host + " es: " + InetAddress.getByName(host).getHostAddress();
			File Ip = new File("IP.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(Ip));			
			br.write(ip);
			br.close();			
			System.out.println("Archivo se ha creado");
		}
		catch(Exception e) {
			e.printStackTrace();	
		}	
	}
}