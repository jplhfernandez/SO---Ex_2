package EX_Exemplo.view;

import EX_Exemplo.controller.ProcessosController;

public class Principal {
    public static void main(String[] args) {
        ProcessosController pCont = new ProcessosController();
        pCont.os();

        String proc = "calc.exe";
        //exibe ou abre qualquer processo
        pCont.callProcess(proc);
        pCont.readProcess(proc);

        String valor = "calc.exe";
        pCont.killProcess(valor);


    }
}
