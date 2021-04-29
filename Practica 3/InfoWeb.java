import java.io.*;
import java.net.*;
public class InfoWeb {

	public void descargarPagina() 
	{	
		try {
			URL url = new URL("http://moodle.itescam.edu.mx/moodle3/login/"); 
			BufferedReader t = new BufferedReader(new InputStreamReader(url.openStream()));			
			File txt = new File("Info.txt");
			BufferedWriter x = new BufferedWriter(new FileWriter(txt));
			String l;
			while((l = t.readLine()) != null) {x.write(l);}
			t.close();
			x.close();
			System.out.println("El archivo se ha creado");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		InfoWeb test = new InfoWeb();
		test.descargarPagina();
	}
}