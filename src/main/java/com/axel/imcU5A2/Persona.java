package com.axel.imcU5A2;

public class Persona {
    private double peso;
    private double estatura;

    public Persona (double peso, double estaturaCM){
        this.peso = peso;
        this.estatura = estaturaCM/100; 
    }

    public double calcularIMC() {
        double imc = peso / (estatura * estatura);
        return Math.round(imc * 100.0) / 100.0;
    }

    public String obtenerDiagnostico(double imc) {
        if (imc < 18.5) return "Bajo de peso";
        if (imc < 25.0) return "Peso saludable";
        if (imc < 30.0) return "Sobrepeso";
        return "Obesidad";
    }
}
