package EX_1.view;

import javax.swing.JOptionPane;
import EX_1.controller.RedesController;

public class Main 
{
    public static void main(String[] args) {
        RedesController controller = new RedesController();
        int opc = 0;
            while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Nome Adaptador IPV4 \n 2 - PING(10) \n 9 - SAIR"));
			switch(opc) {
				//case 0:
					//controller.os();					
					//break;
				case 1:
					controller.ip();
					break;
				case 2:
					controller.ping();
					break;
				case 9:
					System.out.println("Finalizado!");
					break;				
				default:
					System.out.println("Valor inválido!");
					break;
			}
            }
    }
}