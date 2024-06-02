public class Arbol {
    private Nodo raiz;
    public Arbol(){
        this.raiz=null;
    }
    public Arbol(Nodo raiz){
        this.raiz=raiz;
    }
    public Nodo getRaiz(){ return this.raiz;}
    
    public void setRaiz(Nodo raiznueva){ this.raiz=raiznueva;}
    public boolean insertar(Nodo nuevo){

        if(this.raiz==null){
            this.raiz=nuevo;
            return true;
        } else {
            Nodo auxNodo = this.raiz;
            Nodo padre = null;
            while(auxNodo!=null){
                padre=auxNodo;
                if(auxNodo.getValor()==nuevo.getValor()){
                    return false;
                }else{
                    if(nuevo.getValor()<auxNodo.getValor()){
                        auxNodo=auxNodo.getIzq();
                    } else {
                        auxNodo=auxNodo.getDer();
                    }
                }
            }
            if(padre.getValor()<nuevo.getValor()){
                padre.setDer(nuevo);
            } else {
                padre.setIzq(nuevo);
            }
            return true;
        }
    }
    public void ModificarArbol(int valor){
        //le asignamos a la raiz principal todos los cambios que implicará una posible eliminación de algun nodo que contenga el valor dado por parametro
        this.raiz= buscarYEliminarNodo(this.raiz, valor);
    }
    public Nodo buscarYEliminarNodo(Nodo root, int valor) {
        if (root == null){
            //Caso de árbol vacio o nodo no encontrado, devolvemos la misma raiz vacia
            return root;
        }
        // Recorremos el árbol para encontrar el nodo a eliminar
        if (valor < root.getValor()) {
            //Si el nodo buscado es menor que el valor que pose el actual, utilizamos esta misma función con el hijo izquierdo para seguir buscando
            root.setIzq(buscarYEliminarNodo(root.getIzq(), valor));
            //le asignamos al hijo izquierdo del actual los cambios que se haran si se encuentra el nodo a eliminar en las siguientes recursividades
        }
        else{
            if (valor> root.getValor()) {
                //Si el nodo buscado es mayor que el valor que posee el actual, utilizamos esta misma función con el hijo derecho para seguir buscando
                root.setDer(buscarYEliminarNodo(root.getDer(), valor));
                //le asignamos al hijo derecho del actual los cambios que se haran si se encuentra el nodo a eliminar en las siguientes recursividades
            } 
            //Si el valor no es ni menor ni igual al actual, entonces solo pueden ser iguales, por ende se procede a la eliminación del nodo 
            else {
                // Caso 1: Nodo sin hijos (el nodo a eliminar es una hoja)
                if (root.getIzq()== null && root.getDer() == null) {
                     //le asignaremos null ya sea a la misma raiz que es el nodo a eliminar(cero busquedas) o a un hijo de un antiguo nodo actual, osea, de recursividades previas a esta en donde en las lineas 52 y 58 se le asignan a sus hijos un nodo o null, si ese hijo es el nodo a eliminar, se le asigna null, sino, se asigna el mismo hijo pero con los cambios que se harán a más profundidad del arbol con mas recursividad (SI SE ENCUENTRA EL NODO A ELIMINAR HABRA CAMBIOS)
                    return null;
                }
                else{ 
                    // Caso 2: Nodo con un solo hijo
                    if (root.getIzq() == null){
                    //Si el nod, le asignaremos a la recursividad previa el hijo derecho, reemplazando este nodo actual con su unico hijo. Si el nodo a eliminar es el nodo raiz, se asigna como raiz a su hijo derecho
                    return root.getDer();
                    } 
                    else{ 
                        if (root.getDer() == null) {
                            //Si tiene hijo izquierdo pero no derecho, entonces le asignaremos a la recursividad previa el hijo izquierdo, reemplazando este nodo actual con su unico hijo. Si el nodo a eliminar es el nodo raiz, se asigna como raiz a su hijo izquierdo
                            return root.getIzq();
                        }
                        else{
                            // Caso 3: Nodo con dos hijos
                            //Cuando el nodo a eliminar tiene dos hijos, lo reemplazamos asignandole a su campo de datos el valor menor de su subarbol derecho(menor de los mayores), por lo tanto tendremos temporalmente dos nodos iguales en el arbol, pero en la siguiente linea cambiaremos eso
                            root.setValor(getValorMinimoMayores(root.getDer()));
                            //luego debemos eliminar el nodo que quedó duplicado, el menor de las mayores que está en el subarbol derecho del actual, buscandolo y eliminandolo ya sea con el primer o segundo caso(como es un minimo, este minimo solo puede tener un hijo y seria uno derecho)
                            root.setDer(buscarYEliminarNodo(root.getDer(), root.getValor()));
                            //le asignaremos al hijo derecho del actual los cambios que realizará eliminar el duplicado
                        }
                    }
                }
            }
        }
        //luego para cerrar la recursividad con una eliminación exitosa devolvemos el actual con sus cambios hechos, o si no se encontró devolveremos al nodo sin cambios
        return raiz;
    }
    public int getValorMinimoMayores(Nodo root) {
        //aqui se pasa por parametro a el hijo derecho del nodo que se quiere eliminar (o mejor dicho reemplazar), y se busca por la izquierda el más pequeño del subarbol que tiene como raiz el hijo derecho del nodo a eliminar
        int minValue = root.getValor();
        while (root.getIzq() != null) {
            minValue = root.getIzq().getValor();
            root = root.getIzq();
        }
        //una vez encontrado, devolvemos el valor o los datos que contiene el menor de los mayores
        return minValue;
    }
    public void recorrerPreOrden(Nodo root){
        if(root!=null){
            System.out.print("- " + root.getValor() + " ");
            recorrerPreOrden(root.getIzq());
            recorrerPreOrden(root.getDer());
        }
    }
    public void recorrerInOrden(Nodo root){
        if(root!=null){
            recorrerPreOrden(root.getIzq());
            System.out.print("- " + root.getValor() + " ");
            recorrerPreOrden(root.getDer());
        }
    }
    public void recorrerPostOrden(Nodo root){
        if(root!=null){
            recorrerPreOrden(root.getIzq());
            recorrerPreOrden(root.getDer());
            System.out.print("- " + root.getValor() + " ");
        }
    }
    public boolean isVoid(){ return this.raiz==null;}
    public int numNodos(Nodo raiz){
        if (raiz == null)
            return 0;
        else{
            return 1 + numNodos(raiz.getDer()) + numNodos(raiz.getIzq());
        }
    }
}

