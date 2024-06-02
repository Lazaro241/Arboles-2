public class Nodo {
    private int valor;
    private Nodo izq;
    private Nodo der;

    public Nodo(int valor, Nodo a, Nodo b){
        this.valor=valor;
        this.izq=a;
        this.der=b;
    }
    public Nodo(int valor){
        this.valor=valor;
        this.izq=null;
        this.der=null;
    }

    public int getValor(){ return this.valor; }
    public Nodo getIzq(){ return this.izq; }
    public Nodo getDer(){ return this.der; }
    public void setValor(int valor){ this.valor=valor; }
    public void setIzq(Nodo nuevo){ this.izq=nuevo; }
    public void setDer(Nodo nuevo){ this.der=nuevo; }
}
