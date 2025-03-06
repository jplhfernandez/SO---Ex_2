package EX_1.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void ip(){
		String os = os();
		String processo = "";
		String nome ="";
		String[] nomeAdapt = null;
		String[] ipv4 = null;
		
		try{
			if(os.contains("Windows")){
				processo = "IPCONFIG";
			}
			if(os.contains("Linux")) {
				processo = "ip addr";
			}
			String[] processoArray = processo.split(" ");
			Process p = Runtime.getRuntime().exec(processoArray);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null){
				if(os.contains("Windows")) {
					if(linha.contains("Adaptador")) {
						nomeAdapt = linha.split(":");
						nome = nomeAdapt[0];
					}
					if(linha.contains("IPv4")) {
						ipv4 = linha.split(":");
						System.out.println("Nome: " + nome + "\nIPv4: " + ipv4[1] + "\n");
					}
				}
				if(os.contains("Linux")) {
					if(linha.contains("mtu")) {
						nomeAdapt = linha.split(": ");
						nome = nomeAdapt[1];
					}
					if(linha.contains("inet ")) {
						ipv4 = linha.split(" ");
						System.out.println("Nome: " + nome + "\nIPv4: " + ipv4[5] + "\n");						
					}
				}
				linha =  buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		catch(Exception e1){
			System.err.println(e1.getMessage());
		}
		
	}
	
	public void ping() {
		String osName = os();
		if(osName.contains("Windows")) {
			String procWin = "ping -4 -n 10 www.google.com.br";
			String[] vetCmd = procWin.split(" ");
			try {
				Process p = Runtime.getRuntime().exec(vetCmd);
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("dia")) {
						System.out.println(linha.substring(34));
					}
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				stream.close();
			} catch (Exception e) {
				String erro = e.getMessage();
				System.err.println(erro);
			}
		}
		else {
			String procLinux = "ping -4 -c 10 www.google.com.br";
			String[] vetCmd = procLinux.split(" ");
			try {
				Process p = Runtime.getRuntime().exec(vetCmd);
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("avg")) {
						System.out.println("Avg: "+linha.substring(30, 36)+"ms");
					}
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				stream.close();
			} catch (Exception e) {
				String erro = e.getMessage();
				System.err.println(erro);
			}
		}
	}
}	