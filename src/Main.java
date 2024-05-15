public class Main {
    public static void main(String[] args) {
        LeitorArquivo leitor = new LeitorArquivo();

        String[] arquivo_termos = leitor.lerArquivo("src/termos.txt").split(";");

        Termo[] termos = new Termo[arquivo_termos.length];

        for (int i = 0; i < arquivo_termos.length; i++) {
            termos[i] = new Termo();

            // Setando o texto do termo com a primeira parte da string depois do split
            termos[i].setTexto(arquivo_termos[i].split("-")[0].trim());

            // Setando o peso do termo com a segunda parte da string depois do split
            termos[i].setPeso(Integer.parseInt(arquivo_termos[i].split("-")[1].trim())); //
        }

        String spam = leitor.lerArquivo("src/spam.txt").toLowerCase();

        //Obtendo a quantidade de vezes que um determinado termo aparece no spam
        // Exemplo: Olá Gabriel, você ganhou 1000 reais!
        // Se o termo for "você ganhou", o split resultará em um array de duas Strings: "olá Gabriel, " e " 1000 reais!"
        // A quantidade de vezes que o termo aparece é sempre o tamanho do array depois do split com o termo -1.

        int pontuacao = 0;
        for (Termo termo : termos) {
            termo.setQtd(termo.getQtd()+(spam.split(termo.getTexto()).length-1));
            System.out.printf("Termo: %s | Peso: %d | Qtd: %d\n",termo.getTexto(),termo.getPeso(),termo.getQtd());
            pontuacao += Termo.getPontuacao(termo);
        }
        System.out.println("Pontuação: "+pontuacao);
        if(pontuacao >= 5 && pontuacao <= 30){
            System.out.println("Fracamente suspeito.");
        } else if (pontuacao >= 31 && pontuacao <= 70) {
            System.out.println("Potencialmente suspeito.");
        } else {
            System.out.println("Spam");
        }
    }
}