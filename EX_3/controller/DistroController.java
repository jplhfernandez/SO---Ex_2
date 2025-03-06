package EX_3.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class DistroController {
	public DistroController() {
		super();
	}
	
	private String os() {
		String name = System.getProperty("os.name");
		return name;
	}
	
	public void ExibeDistro() {
		String nameOs = os();
		
		if(nameOs.contains("Windows")) {
			JOptionPane.showMessageDialog(null, "Sistema Operacional Incompativel");
		}
		else {
			String proc = "cat /etc/os-release";
			String[] splitProc = proc.split(" ");
			try {
				Process p = Runtime.getRuntime().exec(splitProc);
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				while (linha != null) {
					
					if(linha.contains("VERSION=")) {
						System.out.println("OS: "+os());
						System.out.println("Version: "+System.getProperty("os.version"));
						System.out.println("Distro: "+linha.substring(8));	
					}
					
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				stream.close();
			} catch (Exception e) {
				String erro = e.getMessage();
				System.out.println(erro);
			}
		}
	}
}
