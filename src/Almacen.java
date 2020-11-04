import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Almacen {


    protected ArrayList<Integer> productos = new ArrayList<>();

    protected final ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    protected final Lock readLock = reentrantReadWriteLock.readLock();
    protected final Lock writeLock = reentrantReadWriteLock.writeLock();


    public void getProductos(int producto) {

        readLock.lock();

        try {
            consultar(producto);
        } finally {
            readLock.unlock();
        }

    }




    public void consultar(int producto){

        int cont =0;

        for(Integer produ : productos){

            if(produ==producto){
                cont++;
            }

            System.out.printf("Hay %d productos del tipo %d \n",cont,producto);

        }

    }


    public void añadirProductos() {

        writeLock.lock();

        try {
            int añadido = ThreadLocalRandom.current().nextInt(1,4);

            productos.add(añadido);

            System.out.printf("Se ha añadido el producto de tipo %d \n",añadido);

        } finally {
            writeLock.unlock();
        }
    }

}
