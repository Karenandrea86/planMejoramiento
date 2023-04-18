
package Daviplata;

public class BolsilloElectronicoDaviplata extends BolsilloElectronico {

    private double LIMITE_SACAR = 1000000;

    private String usuarioBD = "karen";
    private String claveBD = "12345";

    public BolsilloElectronicoDaviplata(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.saldo = 0;
    }
    
   
    public boolean iniciarSesion() {
        return usuarioBD.equals(this.usuario) && claveBD.equals(this.contrasena);

    }

    public void ingresarDinero(double monto) {
        this.saldo += monto;
    }

    public boolean sacarDinero(double monto) {
        if (monto > saldo || monto > LIMITE_SACAR) {
            return false;
        } else {
            saldo -= monto;
            return true;
        }
    }

   

    public double consultarSaldo() {
        return this.saldo;
    }

    public void realizarRecarga(double monto) {
        if (monto > saldo) {
            System.out.println("No es posible realizar la operación.");
        } else {
            this.saldo -= monto;
            System.out.println("Recarga exitosa.");
        }
    }
}
