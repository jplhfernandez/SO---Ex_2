package EX_3.view;

import javax.swing.JOptionPane;
import EX_3.controller.DistroController;

public class Main {
	public static void main(String[] args) {
		DistroController distro = new DistroController();
		
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Exibir Distro\n9 - Finaliza Programa"));
			
			switch (opc) {
			case 1:
				distro.ExibeDistro();;
				break;
			case 9:
				System.out.println("\nPrograma Finalizado");
				break;

			default:
				break;
			}
		}
	}
}
