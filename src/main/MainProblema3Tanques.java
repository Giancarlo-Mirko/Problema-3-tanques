/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import interfaz.Caso1;
import interfaz.Interfaz3Tanques;
import interfaz.VistaInformacion;
import java.awt.BorderLayout;
import java.lang.Math;

/**
 *
 * @author PROPIETARIO
 */
public class MainProblema3Tanques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Interfaz3Tanques interfaz = new Interfaz3Tanques();
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
        
        interfaz.jLabel19.setVisible(false);
        interfaz.jLabel20.setVisible(false);
        interfaz.jLabel21.setVisible(false);
        interfaz.txtLongitudC1.setVisible(false);
        interfaz.txtDiametroC1.setVisible(false);
        interfaz.txtCoeficienteCC1.setVisible(false);
        
        VistaInformacion informacion = new VistaInformacion();
        informacion.setSize(505, 320);
        informacion.setLocation(0, 0);
        interfaz.content.removeAll();
        interfaz.content.add(informacion.jPanel6, BorderLayout.CENTER);
        interfaz.content.revalidate();
        interfaz.content.repaint();
        
    }
    public static double sumarNumeros(double num1, double num2) {
        return num1 + num2;
    }
    public static double calcularQ(double altura, double longitud, double diametro, double coeficienteC,double cota  ) {
        double Hf = Math.abs(cota-altura);
        double result = (0.849 * coeficienteC) * (Math.pow(diametro / 4, 0.63))* (Math.pow(Hf / longitud, 0.54)) * ((Math.PI / 4) * Math.pow(diametro, 2));
        return result;
    }
    public static double calcularQarreglo(double[] arreglo,double cota  ) {
        double Hf = Math.abs(cota-arreglo[0]);
        double result = (0.849 * arreglo[3]) * (Math.pow(arreglo[2]/ 4, 0.63))* (Math.pow(Hf / arreglo[1], 0.54)) * ((Math.PI / 4) * Math.pow(arreglo[2], 2));
        return result;
    }
    public static double calcularError(double[] arregloA, double[] arregloB, double[] arregloC, double cota){
        double QA = calcularQarreglo(arregloA, cota);
        double QB = calcularQarreglo(arregloB, cota);
        double QC = calcularQarreglo(arregloC, cota);
        double result = QA-QB-QC;
        return result;
    }
    public static double calcularError2(double[] arregloA, double[] arregloB, double[] arregloC, double cota){
        double QA = calcularQarreglo(arregloA, cota);
        double QB = calcularQarreglo(arregloB, cota);
        double QC = calcularQarreglo(arregloC, cota);
        double result = QA+QB-QC;
        return result;
    }
    public static double interpolacion(double error1, double cota1, double error2, double cota2){
        double result = (((error2-0)/(error2-error1))*cota1)+(((0-error1)/(error2-error1))*cota2);
        return result;
    }
//    public static void mostrarCaso1() {
//        Caso1 interfaz = new Caso1();
//        interfaz.setVisible(true);
//        interfaz.setLocationRelativeTo(null);
//    }
}
