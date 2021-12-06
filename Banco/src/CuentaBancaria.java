import java.util.Scanner;

public class CuentaBancaria {
    String nombreCliente, dniCliente, opcionElegida;
    double saldo, ultimoMovimiento, cantidad;
    Scanner scanner = new Scanner(System.in);


    public CuentaBancaria(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }

    public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.saldo = saldo;
    }
    //Metodos
    public void depositar(double cantidad) {
        ultimoMovimiento=0+cantidad;
        saldo+=cantidad;
    }
    public void retirar(double cantidad){
        if (cantidad<=saldo){
            ultimoMovimiento=0-cantidad;
            saldo-=cantidad;
        } else {
            System.out.println("No tiene tanto dinero en el banco.");
        }
    }

    public void consultarUltimoMovimiento(){
        if (ultimoMovimiento>0){
            System.out.println("Cantidad depositada: $" + Math.abs(ultimoMovimiento));
        } else if (ultimoMovimiento<0) {
            System.out.println("Cantidad retirada: $" + Math.abs(ultimoMovimiento));
        } else {
            System.out.println("No se han realizado transacciones");
        }
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido " + nombreCliente + " . Es un placer tenerlo devuelta!");
        do {
            System.out.println("\nIngrese una opción para continuar\nOpción A: Consultar Saldo\nOpción B: Depositar\nOpción C:" +
                    " Retirar\nOpción D: Consultar ultimo movimiento\nOpción E: Salir");
            opcionElegida = scanner.next();
            if (opcionElegida.equalsIgnoreCase("A")){
                System.out.println("Su saldo es de: $" + saldo);
            } else if (opcionElegida.equalsIgnoreCase("B")) {
                System.out.println("Ingrese la cantidad a depositar: ");
                cantidad= Double.parseDouble(scanner.next());
                depositar(cantidad);

            } else if (opcionElegida.equalsIgnoreCase("C")) {
                if (saldo==0) {
                    System.out.println("Usted no tiene dinero en su cuenta");
                } else {
                    System.out.println("Ingrese la cantidad a retirar: ");
                    cantidad= Double.parseDouble(scanner.next());
                    retirar(cantidad);
                }

            } else if (opcionElegida.equalsIgnoreCase("D")) {
                consultarUltimoMovimiento();

            } else if (!opcionElegida.equalsIgnoreCase("E")) {
                System.out.println("Opcion invalida, intente de nuevo");
            }

        }while (!"E".equalsIgnoreCase(opcionElegida));
        System.out.println("Hasta Luego!");
    }
}