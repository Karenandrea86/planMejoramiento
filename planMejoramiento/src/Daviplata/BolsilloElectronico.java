package Daviplata;

public abstract class BolsilloElectronico {

    double saldo;
    String usuario;
    String contrasena;

    public abstract void ingresarDinero(double monto);

    public abstract boolean  sacarDinero(double monto);

    public abstract boolean iniciarSesion();

    public abstract double consultarSaldo();

    public abstract void realizarRecarga(double monto);
}
