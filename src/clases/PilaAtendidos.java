package clases;

import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaAtendidos {
    private Stack<Cliente> pila = new Stack<Cliente>();

    public PilaAtendidos() {
    }
    public Stack<Cliente> getPila() {
        return pila;
    }
    public void setPila(Stack<Cliente> pila) {
        this.pila = pila;
    }
    
    public void ingresarAtendido(Cliente c){
        this.pila.push(c);
    }
    public void verPilaAtendidos(){
        Stack<Cliente> pelis = new Stack<Cliente>();
        Cliente p;
        Cola c = new Cola();
        if(!pila.empty()){
            while(!pila.empty()){
                if(!pila.empty()){
                    p = pila.pop();
                    c.verdatos(p);
                    pelis.push(p);
                }
            }
            while(!pelis.empty()){
                if(!pelis.empty()){
                    p = pelis.pop();
                    pila.push(p);
                }else{
                    break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pila Vacia.");
        }
    }
}
