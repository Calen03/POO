import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        int op = 0;
        Scanner input = new Scanner(System.in);
        List<Computadora> inventario = new ArrayList<Computadora>();
        Computadora computadoras = new Computadora();
        Computadora compu1 =  new Computadora("dell", "g3", 8, 2020);
        Computadora compu2 =  new Computadora("hp", "pavilion");
        inventario.add(compu1);
        inventario.add(compu2);
        while (op != 5) {
            System.out.println("\ncomputadoras en inventario: "+ computadoras.getNumComputadoras());
            System.out.println("1)Crear computadora nueva\n2 Modificar existente" +
                    "\n3)Ver computadoras actuales\n4)Eliminar computadora");
            
            op = input.nextInt();
            switch (op) {
                case 1:
                    computadoras.crear(inventario);
                    break;
                case 2:
                    computadoras.modificar(inventario);
                    break;
                case 3:
                    computadoras.mostrar(inventario);
                    break;
                case 4:
                    computadoras.eliminar(inventario);
                    break;
                case 5:
                    System.out.println("adios");
                    break;
                default:
            }
            input.nextLine();
        }
        input.close();
    }
}
