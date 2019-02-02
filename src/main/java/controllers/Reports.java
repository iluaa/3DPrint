package controllers;

import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Reports {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:mysql://localhost:3300/printing?useSSL=false";
    private Connection connection = null;
    public void customerList(ActionEvent actionEvent) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            JasperReport report = (JasperReport) JasperCompileManager.compileReport("C:\\Users\\Илья\\JaspersoftWorkspace\\MyReports\\Customers.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report,null, connection);
            JRViewer jv = new JRViewer(print);
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(800, 600));
            //jf.setLocation(300, 100);
        } catch (JRException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void orderList(ActionEvent actionEvent) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            JasperReport report = (JasperReport) JasperCompileManager.compileReport("C:\\Users\\Илья\\JaspersoftWorkspace\\MyReports\\Plastic.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report,null, connection);
            JRViewer jv = new JRViewer(print);
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(800, 600));
            //jf.setLocation(300, 100);
        } catch (JRException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
