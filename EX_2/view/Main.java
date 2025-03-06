package EX_2.view;

import javax.swing.JOptionPane;
import EX_2.controller.KillController;

public class Main {
	public static void main(String[] args) {
		KillController controller = new KillController();
		
		int opc = 0;
		
		while(opc != 9) {
			controller.listaProcessos();
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Matar por PID\n2 - Matar por Nome\n9 - Finalizar Programa"));
			switch (opc) {
			case 1:
				controller.mataPid(JOptionPane.showInputDialog("Insira o PID do processo:"));
				break;
			case 2:
				controller.mataNome(JOptionPane.showInputDialog("Insira o nome do processo:"));
				break;
			case 9:
				System.out.println("\n Programa Finalizado");
				break;
			default:
				break;
			}
		}
	}
}