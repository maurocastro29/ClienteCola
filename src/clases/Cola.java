package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cola {
    private Cliente inicio;
    private Cliente ultimo;

    public Cola() {
        this.inicio = null;
        this.ultimo = null;
    }

    public Cliente getInicio() {
        return inicio;
    }

    public void setInicio(Cliente inicio) {
        this.inicio = inicio;
    }

    public Cliente getUltimo() {
        return ultimo;
    }

    public void setUltimo(Cliente ultimo) {
        this.ultimo = ultimo;
    }
        
    public boolean ColaVacia(){
        return this.getInicio() == null;
    }
    
    public int tamCola(){
        int i=0;
        if(!this.ColaVacia()){
            Cliente clientes = this.getInicio();
            while(clientes!=null){
                i++;
                clientes = clientes.getAnt();
            }
        }
        return i;
    }
    
    public boolean encolar(Cliente c){
        if(this.ColaVacia()){
            this.setInicio(c);
            this.setUltimo(c);
            return true;
        }else{
            if(this.tamCola()<3){
                this.getUltimo().setAnt(c);
                this.setUltimo(c);
                return true;
            }
        }
        return false;
    }
    
    public Cliente desencolar(){
        Cliente aux = null;
        if(!this.ColaVacia()){
            aux = this.getInicio();
            if(this.getInicio() == this.getUltimo()){
                aux.setAnt(null);
                this.setInicio(null);
                this.setUltimo(null);
            }else{
                this.setInicio(this.getInicio().getAnt());
                aux.setAnt(null);
            }
        }
        return aux;
    }
    
    public void verdatos(Cliente clientes){
        if(clientes!=null){
            JOptionPane.showMessageDialog(null, "Nombre cliente: "+clientes.getNombre()+"\n"+
                                                "ID cliente: "+clientes.getId()+"\n"+
                                                "Saldo inicial: "+clientes.getSaldoActual()+"\n"+
                                                "Tipo de operacion: "+clientes.getTipOperacion()+"\n"+
                                                "Valor de operacion: "+clientes.getValorOperacion()+"\n"+
                                                "Fecha de opereacion: "+clientes.getFechaOperacion()+"\n"+
                                                "Saldo despues: "+clientes.getSaldoDespues());
        }
    }
    
    public void verColaClientes(){
        Cliente aux = this.getInicio();
        if(!this.ColaVacia()){
            while(aux!=null){
                verdatos(aux);
                aux = aux.getAnt();
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay clientes en la cola");
        }
    }
    
    public Cliente crearCliente(){
        boolean sw = false;
        int id = new Integer(JOptionPane.showInputDialog("Digite el ID del cliente"));
        String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente");
        float saldoActual;
        do{
            saldoActual = new Float(JOptionPane.showInputDialog("Ingrese el saldo del cliente"));
        }while(saldoActual < 0);
        int tipOp;
        String tipOperacion = "";
        float valorOp;
        do{
            tipOp = new Integer(JOptionPane.showInputDialog("Digite el Tipo de operacion\n"+
                                                            "1. Consignacion\n"+
                                                            "2. Retiro\n"));
        }while(tipOp < 1 || tipOp >2);
        if(tipOp==1){
            tipOperacion = "Consignacion";
        }else{
            tipOperacion = "Retiro";
        }
        do{
            valorOp = new Float(JOptionPane.showInputDialog("Digite el monto que va a usar en la opereacion"));
            if(tipOp == 2){
                if(valorOp <= saldoActual){
                    sw = true;
                }else{
                    sw = false;
                    JOptionPane.showMessageDialog(null, "Operacion invalida.");
                }
            }else{
                sw = true;
            }
        }while(valorOp < 0 || !sw);
        return new Cliente(id, nombre, saldoActual, tipOperacion, valorOp);
    }
    
    public Cliente atenderCliente(){
        Cliente c=null;
        if(!this.ColaVacia()){
            c = desencolar();
            if(c.getTipOperacion().equals("Consignacion")){
                c.setSaldoDespues((c.getSaldoActual() + c.getValorOperacion()));
            }else{
                c.setSaldoDespues((c.getSaldoActual() - c.getValorOperacion()));
            }
            Date fecha = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
            c.setFechaOperacion(formatoFecha.format(fecha));
        }
        return c;
    }
    
}
