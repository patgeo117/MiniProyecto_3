package Customers;

import java.io.*;

public class ArchivoCustomers {
    // Metodo encargado de escribir los datos de los clientes
    public void setDataC(Clientes[] clientes, String archivo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(clientes);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    // Metodo encargado de leer los datos de los clientes del bin
    public Clientes[] getDataC(String archivo) {
            Clientes[] clientes = new Clientes[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            clientes = (Clientes[]) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Clientes e : clientes) {
            System.out.println(e);
        }
        System.out.println("\n");
        return clientes;
    }
}
