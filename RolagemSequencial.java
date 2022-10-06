import java.io.IOException;

public class RolagemSequencial {
    public static void main(String[] args) throws IOException, InterruptedException {
        int[] rodadas  = {1, 2, 5, 10, 15, 20, 30};
        
        for(int i=0; i<rodadas.length; i++){
            long inicioRodada = System.currentTimeMillis();
            for(int j=0; j<20; j++)
                for(int k=0; k<rodadas[i]; k++)
                    RollDice.getDiceNumber();
                    
            long fimRodada = System.currentTimeMillis();
            System.out.println("Media de tempo da rodada "+(i+1)+" ["+rodadas[i]+" vezes]: "+(fimRodada - inicioRodada)/20 +" milisegundos. ");
        }
    }
}