public class Termo {
    private String texto;
    private int peso;
    private int qtd;

    Termo(){
        texto = "";
        peso = 0;
        qtd = 0;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public String getTexto(){
        return texto;
    }

    public int getPeso(){
        return peso;
    }

    public int getQtd(){
        return qtd;
    }

    static int getPontuacao(Termo termo){
        return termo.getPeso()*termo.getQtd();
    }

}
