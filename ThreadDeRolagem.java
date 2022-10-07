import java.io.IOException;

public class ThreadDeRolagem implements Runnable{
    @Override
	public void run() {
		try {
			RollDice.getDiceNumber();
		} catch (InterruptedException | IOException e) {
			//e.printStackTrace();
            System.out.print("exceção. ");
		}
	}
}
