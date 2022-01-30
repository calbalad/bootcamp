import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JuegoDelNumero {
	
	private static final int randomlimit = 100;
    private static Random random;
	
	public JuegoDelNumero() {
		random = new Random();
	}
	
	public void start() {
        String command;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("commands: salir, jugar");
            System.out.print(">> ");

            command = input.next();

            if (command.equals("salir")) {
                return;
            }

            if (command.equals("jugar")) {
                nextTurn(input);
            } else {
                System.out.println("comando desconocido");
            }
        }
    }

    private void nextTurn(Scanner input) {
        int tries = 10;
        int secretNumber = random.nextInt(randomlimit);
        int inputNumber;
        System.out.println("N�mero: " + secretNumber);
        for (int i = 0; i < tries; i++) {
			try {
				inputNumber = Integer.parseInt(
			            JOptionPane.showInputDialog("Introduce n�mero: ")); 
				if (inputNumber == secretNumber) {
					JOptionPane.showMessageDialog(null, "�Ganaste!");
					break;
				} else if (inputNumber < secretNumber) {
					JOptionPane.showMessageDialog(null, "El n�mero es mayor");
				} else if (inputNumber > secretNumber) {
					JOptionPane.showMessageDialog(null, "El n�mero es menor");
				}
			} catch (NumberFormatException e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Entrada no v�ida", "Error", JOptionPane.ERROR_MESSAGE);
				if (i >= 0) {
					i--;
				}
			}
		}
       
        System.out.println("You needed too many attempts!");

        return;
    }
	

}
