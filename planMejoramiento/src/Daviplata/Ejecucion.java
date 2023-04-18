package Daviplata;

import java.util.Scanner;

public class Ejecucion {

    public static void main(String[] args) {

        String usuario, clave;
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese el usuario");
        usuario = scanner.next();
        System.out.println("ingrese la clave");
        clave = scanner.next();
        BolsilloElectronicoDaviplata bolsillo = new BolsilloElectronicoDaviplata(usuario, clave);

        boolean seguir = bolsillo.iniciarSesion();

        if (!seguir) {
            System.out.println("usuario o contraseña invalido");
        }

        while (seguir) {
            System.out.println("\n¿Qué operación desea realizar?");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Realizar recarga");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de dinero a ingresar: ");
                    double cantidadIngreso = scanner.nextDouble();
                    bolsillo.ingresarDinero(cantidadIngreso);
                    System.out.println("Dinero ingresado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad de dinero a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    if (bolsillo.sacarDinero(cantidadRetiro)) {
                        System.out.println("Dinero retirado exitosamente.");
                    } else {
                        System.out.println("No es posible retirar esa cantidad de dinero.");
                    }
                    break;

                case 3:
                    System.out.println("Saldo actual: " + bolsillo.consultarSaldo());
                    break;

                case 4:
                    System.out.print("Ingrese la cantidad de dinero a recargar: ");
                    double cantidadRecarga = scanner.nextDouble();
                    bolsillo.realizarRecarga(cantidadRecarga);
                    System.out.println("Recarga realizada exitosamente.");
                    break;

                case 5:
                    System.out.println("Gracias por utilizar Daviplata.");
                    seguir = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}
