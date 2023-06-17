package Bibliotecarios;

import java.io.*;

public class SerizalizaDeseralizaUs {

    public void setDataB(Employees[] employees, String archivo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(employees);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Employees[] getDataB(String archivo) {
        Employees[] users = new Employees[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            users = (Employees[]) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Employees e : users) {
            System.out.println(e);
        }
        System.out.println("\n");
        return users;
    }
}