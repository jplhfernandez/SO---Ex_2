package EX_Exemplo.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {

    public ProcessosController(){
        super();
    }

    public void os(){
        String os = System.getProperty("os.name");
        String ver = System.getProperty("os.version");
        String arch = System.getProperty("os.arch");
        System.out.println(os + " - " + ver + " - " + arch);
    }

    public void callProcess(String proc){
        String[] procArr = proc.split(" ");
        try{
            Runtime.getRuntime().exec(procArr);
        } catch (Exception e){
            String msg = e.getMessage();
            //System.err.println(msg);
            if (msg.contains("740")) {
                StringBuffer buffer = new StringBuffer();   
                buffer.append("cmd /c");
                buffer.append(" ");
                buffer.append(proc);
                try{
                    String[] procArrCred = buffer.toString().split(" ");
                    Runtime.getRuntime().exec(buffer.toString());
                } catch (Exception e1){
                    System.err.println(e1.getMessage());
                }
            } else {
                System.err.println(msg);
            }
        }
    }

    public void readProcess(String proc){
        String[] procArr = proc.split(" ");
        try{
            Process p = Runtime.getRuntime().exec(procArr);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while (linha != null) {
            if (linha.contains("opera")) {
                System.out.println(linha);
            }
            linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void killProcess(String valor){
        String cmdPid = "TASKKILL /PID";
        String cmdNome = "TASKKILL /IM";
        StringBuffer buffer = new StringBuffer();
        int pid = 0;

        try {
            pid = Integer.parseInt(valor);  
            buffer.append(cmdPid);          
            buffer.append(" ");          
            buffer.append(pid);          
        } catch (Exception e) {
            buffer.append(cmdNome);          
            buffer.append(" ");          
            buffer.append(valor);          
        }
        String matar = buffer.toString();
        callProcess(matar);
    }
}

/*
 * 
 */