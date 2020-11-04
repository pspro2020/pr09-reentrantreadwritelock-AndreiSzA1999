import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Añadir implements Runnable {

    protected Almacen almacen;

    public Añadir(Almacen almacen){

        this.almacen=almacen;

    }


    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()){

            try {

                almacen.añadirProductos();
                Thread.sleep(2000);
            }catch (InterruptedException e){

                System.out.println("Error");

            }
        }

    }
}