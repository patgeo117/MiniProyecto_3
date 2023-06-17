package Filtros;

import javax.swing.*;
import javax.swing.table.TableModel;

public class filtro {
    public RowFilter<TableModel, Integer> filter1 = new RowFilter<>() {
        public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
            // Obtener el valor de la segunda columna de la fila actual
            Object value = entry.getValue(1);

            // Filtrar solo las filas cuya segunda columna sea "TERROR"
            return "TERROR".equals(value);
        }
    };

    public RowFilter<TableModel, Integer> filter2 = new RowFilter<>() {
        public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
            // Obtener el valor de la segunda columna de la fila actual
            Object value = entry.getValue(1);

            // Filtrar solo las filas cuya segunda columna sea "TERROR"
            return "NOVELAS".equals(value);
        }
    };
    public RowFilter<TableModel, Integer> filter3 = new RowFilter<>() {
        public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
            // Obtener el valor de la segunda columna de la fila actual
            Object value = entry.getValue(1);

            // Filtrar solo las filas cuya segunda columna sea "TERROR"
            return "INGENIERÍA".equals(value);
        }
    };

}
