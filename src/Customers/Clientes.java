package Customers;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Clientes implements Serializable {
    private String name;
    private String libro;
    private String id;
    private int deuda;
    private String fechaFin;
    private String fechainicio;

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

    public int getDeuda() throws ParseException {
        Date fechaF = new SimpleDateFormat("dd/MM/yyyy").parse(getFechaFin());
        Date fechaI = new SimpleDateFormat("dd/MM/yyyy").parse(getFechainicio());

        int milisecondsByDay = 86400000;

        if (Objects.equals(fechaFin, "00/00/00")) {
            deuda = 0;
        } else {
            int daysAtraso = (int) (((fechaF.getTime() - fechaI.getTime()) / milisecondsByDay));

            if (daysAtraso > 7) {
                deuda = (daysAtraso - 7) * 1000;
            } else {
                deuda = 0;
            }

        }
        return deuda;
    }

    @Override
    public String toString() {
        try {
            return ("# " + getId() + " " + getName() + " reservó: " + getLibro() + ", el: " + getFechainicio() + " " + getFechaFin() + "\nDeuda = " + getDeuda());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
