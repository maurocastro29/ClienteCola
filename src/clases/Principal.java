package clases;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] Argv){
        Cola ColaCajero = new Cola();
        Cola ColaEspera = new Cola();
        PilaAtendidos pilaAtendidos = new PilaAtendidos();
        menuPrincipal(ColaCajero, ColaEspera, pilaAtendidos);
    }
    public static void menuPrincipal(Cola ColaCajero, Cola ColaEspera, PilaAtendidos pilaAtendidos){
        int op;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "      CLIENTES CAJERO\n"
                    + "1. Ingresar Cliente a la cola\n"
                    + "2. Mostrar cola cajero\n"
                    + "3. Mostrar cola espera\n"
                    + "4. Atender Cliente\n"
                    + "5. Mostrar atendidos\n"
                    + "6. Salir\n"
                    ));
            switch(op){
                case 1:{
                    Cliente c = ColaCajero.crearCliente();
                    boolean estado = ColaCajero.encolar(c);
                    if(estado){
                        JOptionPane.showMessageDialog(null, "Cliente ingresado con exito");
                    }else{
                        if(ColaEspera.encolar(c)){
                            JOptionPane.showMessageDialog(null, "Cliente ingresado a la cola de espera");
                        }else{
                            JOptionPane.showMessageDialog(null, "El cliente no pudo ser ingresado a ninguna de las dos colas");
                        }
                    }
                    break;
                }
                case 2:{
                    ColaCajero.verColaClientes();
                    break;
                }
                case 3:{
                    ColaEspera.verColaClientes();
                    break;
                }
                case 4:{
                    atenderClientes(ColaCajero, ColaEspera, pilaAtendidos);
                    break;
                }
                case 5:{
                    pilaAtendidos.verPilaAtendidos();
                    break;
                }
                case 6:{
                    System.exit(0);
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "OPCION INVALIDA.");
                    break;
                }
            }
        }while(op!=7);
    }
    public static void atenderClientes(Cola ColaCajero, Cola ColaEspera, PilaAtendidos pilaAtendidos){
        Cliente clientes = ColaCajero.atenderCliente();
        Cliente enEspera = null;
        if(clientes!=null){
            pilaAtendidos.ingresarAtendido(clientes);
            enEspera = ColaEspera.desencolar();
            if(enEspera!=null){
                ColaCajero.encolar(enEspera);
            }
            JOptionPane.showMessageDialog(null, "Cliente atendido con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No hay clientes para atender");
        }
    }
}
