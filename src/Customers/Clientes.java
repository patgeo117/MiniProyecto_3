package Customers;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Clientes implements Serializable {
    // Clase que recibe los valores de los clientes y los serealiza
    private String name;
    private String libro;
    private String id;
    private int deuda;
    private String fechaFin;
    private String fechainicio;

    private int daysAtraso; // Almacena los dias de atraso

    public Clientes(String name, String libro, String id, String fechaI, String fechaF, int deuda) {
        this.name = name;
        this.libro = libro;
        this.id = id;
        this.fechainicio = fechaI;
        this.fechaFin = fechaF;
        this.deuda = deuda;
    }


    public String getName() {
        return name;
    }

    public String getLibro() {
        return libro;
    }

    public String getId() {
        return id;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    // Calcula la duda según la fecha de inicio y la fecha de entrega
    public int getDeuda() throws ParseException {
        Date fechaF = new SimpleDateFormat("dd/MM/yyyy").parse(getFechaFin());
        Date fechaI = new SimpleDateFormat("dd/MM/yyyy").parse(getFechainicio());

        int milisecondsByDay = 86400000;

        if (Objects.equals(fechaFin, "00/00/00")) {
            deuda = 0;
        } else {
            daysAtraso = (int) (((fechaF.getTime() - fechaI.getTime()) / milisecondsByDay));
            if (daysAtraso > 7) {
                deuda = (daysAtraso-7) * 1000;
            } else {
                deuda = 0;
            }
        }
        return deuda;
    }

    public int getDaysAtraso() {
        return daysAtraso;
    }

    // toma los datos y se muestran donde sea pertinente
    @Override
    public String toString() {
        try {
            return ("# ID:" + getId() + "--> Nombre: " + getName() + ", reservó: " + getLibro() +
                    "\nFecha de prestamo: " + getFechainicio() + " -- Fecha de retorno:´" + getFechaFin() +
                    "\nDeuda = " + getDeuda() + ", Días de prestamo: " + getDaysAtraso());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
