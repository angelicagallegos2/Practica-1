package practica1_20084;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Hilo2 extends Thread{
    private JTextArea area;
    private Boolean pausa;
    private Boolean terminar;
    public Hilo2(JTextArea area){
        this.area=area;
        pausa=false;
        terminar=false;
    }
    synchronized void pausarhilo(){
         pausa=true;
        try {
            wait(1500);
            pausa=false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     public void setTerminar (boolean terminar){
        this.terminar=terminar;
    }
    public void run(){
        int i=0;
        while(!terminar){
            area.append(i + "\n");
            i++;
        }
    }
}
