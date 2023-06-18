package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InEstadoLibros extends JFrame implements ActionListener {
    public JPanel panel ;
    JButton ok;
    public InEstadoLibros(){
        // Panel
        panel = new JPanel();
        panel.setBounds(20,20,520,150);
        add(panel);
        // Botones
        ok = new JButton("OK");
        ok.setBounds(250, 240, 60, 20);
        ok.setBackground(Color.green);
        ok.setVisible(true);
        ok.addActionListener(this);
        add(ok);

        setLayout(null);
        setSize(600, 300);
        setTitle("Estado Libros");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb == ok){
            setVisible(false);
        }
    }
}
