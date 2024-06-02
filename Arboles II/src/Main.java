import java.util.Scanner;

public class Main {
    public static void mensajeVoid(){
        System.out.println("El árbol está vacío.");
    }
    public static void darDeAltaNodos(Arbol root, Scanner t){
        Nodo nuevoNodo;
        System.out.println("Ingrese el valor del nuevo nodo para insertar en el árbol");
        nuevoNodo = new Nodo(t.nextInt());
        if(!root.insertar(nuevoNodo)){
            System.out.println("El valor ingresado ya se encuentra dentro del árbol.");
        }
        else{
            System.out.println("Se insertó " + nuevoNodo.getValor() + " con éxito.");
        }
    }
    public static void darDeBajaNodos(Arbol root, Scanner t){
        int valorAEliminar;
        if(!root.isVoid()){
            System.out.println("Ingrese el valor del nodo que quiere eliminar");
            valorAEliminar=t.nextInt();
            root.ModificarArbol(valorAEliminar);
        }
        else{
            mensajeVoid();
        }     
    }
    public static void inOrden(Arbol root){
        if(!root.isVoid()){
            root.recorrerInOrden(root.getRaiz());
        }
        else{
            mensajeVoid();
        }
    }
    public static void preOrden(Arbol root){
        if(!root.isVoid()){
            root.recorrerPreOrden(root.getRaiz());
        }
        else{
            mensajeVoid();
        }
    }
    public static void postOrden(Arbol root){
        if(!root.isVoid()){
            root.recorrerPostOrden(root.getRaiz());
        }
        else{
            mensajeVoid();
        }
    }
    public static void cantidadNodos (Arbol root){
        int cantidad=root.numNodos(root.getRaiz());
        System.out.println("Cantidad de nodos en el árbol actualmente: " + cantidad);
    }
    public static void mostrarMenu(){
        System.out.println(" ");
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Insertar un nodo nuevo en el árbol.");
        System.out.println("2. Eliminar un nodo del árbol.");
        System.out.println("3. Recorrer árbol en preorden.");
        System.out.println("4. Recorrer árbol en inorden.");
        System.out.println("5. Recorrer árbol en postorden.");
        System.out.println("6. Ver cantidad de nodos actual en el árbol");
        System.out.println("7. Salir.");
    }
    public static void main(String[]args) {
        int menu;
        Scanner teclado = new Scanner(System.in);
        Arbol raiz = new Arbol();
        System.out.println("ABM DE ARBOL BINARIO DE BUSQUEDA");
        do{
            mostrarMenu();
            menu=teclado.nextInt();
            switch(menu){
                case 1:
                    darDeAltaNodos(raiz, teclado);
                break;
                case 2:
                    darDeBajaNodos(raiz, teclado);
                break;
                case 3:
                    preOrden(raiz);
                break;
                case 4:
                    inOrden(raiz);
                break;
                case 5:
                    postOrden(raiz);
                break;
                case 6:
                    cantidadNodos(raiz);
                break;
                case 7:
                    System.out.println("Se finalizó el programa");
                break;
                default:
                    System.out.println("Opción inválida");
                break;
            }
        }while(menu!=7);
    }
}
