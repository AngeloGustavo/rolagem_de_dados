import java.io.IOException;

public class RolagemConcorrente{   
    public static void main(String[] args) throws IOException, InterruptedException {
        int[] rodadas  = {10, 100, 500, 1000};

        for(int i=0; i<rodadas.length; i++){
            long inicioRodada = System.currentTimeMillis();
            for(int j=0; j<20; j++){
                Thread threads[] = new Thread[rodadas[i]];
                for(int l=0; l<rodadas[i]; l++){
                    threads[l] = new Thread(new ThreadDeRolagem());
		            threads[l].start();
                }
                for(int k=0; k<rodadas[i]; k++){
                    threads[k].join();
                }       
            }                    
            long fimRodada = System.currentTimeMillis();
            System.out.println("Media de tempo da rodada "+(i+1)+" ["+rodadas[i]+" requisições]: "+(fimRodada - inicioRodada)/20 +" milisegundos. ");
        }
    }
}