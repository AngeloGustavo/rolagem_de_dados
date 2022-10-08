import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections; 
public class RolagemConcorrente{   
    public static void main(String[] args) throws IOException, InterruptedException {
        int[] rodadas  = {5, 10, 20, 30, 50, 75, 100};

        for(int i=0; i<rodadas.length; i++){
            ArrayList<Long> array = new ArrayList<>();
            long inicioRodada = System.currentTimeMillis();
            for(int j=0; j<20; j++){
                Thread threads[] = new Thread[rodadas[i]];
                long inicio = System.currentTimeMillis();
                for(int l=0; l<rodadas[i]; l++){
                    threads[l] = new Thread(new ThreadDeRolagem());
		            threads[l].start();
                }
                for(int k=0; k<rodadas[i]; k++){
                    try {
                        threads[k].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long fim = System.currentTimeMillis();
                array.add(fim - inicio);     
            }                    
            long fimRodada = System.currentTimeMillis();

            long media = (fimRodada - inicioRodada)/20;
            int tam = array.size();
            Long desvPadrao = 0L;
            for (Long vlr : array) {
                Long aux = vlr - media;
                desvPadrao += aux * aux;
            }
            System.out.println("Rodada "+(i+1)+" ["+rodadas[i]+" vezes] | Média: "+(fimRodada - inicioRodada)/20 +" milisegundos | Desvio padrão: " + Math.sqrt(desvPadrao / tam) + " milisegundos | Tempo máximo: " + Collections.max(array)+ " milisegundos | Tempo mínimo: " + Collections.min(array)+ " milisegundos");
        }
    }
}