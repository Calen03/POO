
import java.util.List;
import java.util.Scanner;

public class Computadora {

    static Scanner input = new Scanner(System.in);
    private static int numComputadoras = 0;
    private String marca;
    private String modelo;
    private int year;
    private int Ram;

    public Computadora() {

    }

    public Computadora(String marca, String modelo, int year, int Ram) {
        numComputadoras++;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.Ram = Ram;
    }

    public Computadora(String marca, String modelo) {
        numComputadoras++;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getNumComputadoras() {
        return numComputadoras;
    }

    public void datos(String modelo) {
        this.modelo = modelo;
    }

    public void datos(int ram, int year) {
        this.Ram = ram;
        this.year = year;
    }

    public void datos(String modelo, int ram) {
        this.modelo = modelo;
        this.Ram = ram;
    }

    public void crear(List<Computadora> inventario) {
        String marca, modelo;
        int ram, year;
        System.out.println("ingresa la marca: ");
        marca = input.nextLine();
        System.out.println("Ingresa el modelo: ");
        modelo = input.nextLine();
        System.out.println("Ingresa la memoria RAM: ");
        ram = input.nextInt();
        System.out.println("Ingresa el año");
        year = input.nextInt();
        input.nextLine();
        System.out.println(marca + " " + modelo + " " + ram + " " + year);
        Computadora aux = new Computadora(marca, modelo, year, ram);
        inventario.add(aux);
        input.nextLine();
    }

    public void mostrar(List<Computadora> inventario) {
        if (numComputadoras != 0) {
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println(inventario.get(i).toString(i));
            }
            /*for (Computadora x : inventario){
                System.out.println(String.valueOf(x));
            }*/
        } else {
            System.out.println("No existen computadoras");
        }
    }

    public void modificar(List<Computadora> inventario) {
        if (numComputadoras != 0) {
            String dato1;
            int dato2=0;
            System.out.println("inventario:");
            mostrar(inventario);
            System.out.println("Elige la computadora a modificar");
            int mod = input.nextInt();
            System.out.println(inventario.get(mod - 1).toString(mod - 1));
            System.out.println("escribe el dato a modificar (modelo, ram-modelo, ram-year)");
            input.nextLine();
            dato1 = input.nextLine();
            switch (dato1.toLowerCase()) {
                case "marca":
                    break;
                case "modelo":
                    System.out.println("Ingresa el nuevo modelo");
                    dato1=input.nextLine();
                    inventario.get(mod-1).datos(dato1);
                    break;
                case "ram-modelo":
                    System.out.println("Ingresa el nuevo modelo");
                    dato1=input.nextLine();
                    System.out.println("Ingresa la nueva cantidad RAM");
                    dato2=input.nextInt();
                    inventario.get(mod-1).datos(dato1, dato2);
                    break;
                case "ram-year":
                    System.out.println("Ingresa la nueva cantidad RAM");
                    dato1=input.nextLine();
                    System.out.println("ingresa el año de salida");
                    dato2=input.nextInt();
                    inventario.get(mod-1).datos(Integer.parseInt(dato1), dato2);
                    break;
                default:
                    System.out.println("error");
            }
        } 
        else {
            System.out.println("No hay nada");
        }
    }

    public void eliminar(List<Computadora> inventario) {
        if (numComputadoras > 0) {
            int elim;
            System.out.println("inventario:");
            mostrar(inventario);
            System.out.println("Elige la computadora a eliminar");
            elim = input.nextInt();
            System.out.println("Se eliminara " + inventario.get(elim - 1).marca + 
            " " + inventario.get(elim - 1).modelo);
            inventario.remove(elim - 1);
            numComputadoras--;
        } 
        else {
            System.out.println("No hay inventario");
        }
    }

    public String toString(int i) {
        return "Computadora " + (i + 1) + " [Marca= " + marca + 
        " Modelo= " + modelo + " year= " + year + " RAM= " + Ram + "]";
    }
}
