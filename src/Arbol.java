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
    public

}

