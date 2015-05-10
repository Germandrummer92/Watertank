/**
 * 
 */
package watertankSplit;

/**
 * @author Daniel Draper
 * @version 1.0
 *
 */

public class Simulator {
	
	private int TICK = 30;
	private Controller contr;
	private int y;
	private int x;
	private int state;
	private int oldDif;
	private int newDif;
	
	public Simulator() {
		contr = new Controller();
		state = 0;
		y = 10;
		x = 0;
		oldDif = 0;
		newDif = 0;
	}
	
	private void step() {
		switch (state) {
		case 0:
			/*if (x == TICK) {
				oldDif = newDif;
				System.out.println("Controlled!");
				newDif = contr.getControlValue(y);
				if (newDif == oldDif) {
					state = 0;
					//x = 0;
				}
				else {
					state = 0;
					x = 0;
				}
			}*/
			if (x == 20) {
				state = 1;
			}
			else {
				y+=oldDif;
				x+=10;
			}
		case 1:
			if (x == TICK) {
				oldDif = newDif;
				System.out.println("Controlled!");
				newDif = contr.getControlValue(y, oldDif);
				if (newDif == oldDif) {
					state = 1;
					x = 0;
				}
				else {
					state = 0;
					x = 0;
				}
			}
			else {
				y+=newDif;
				x+=10;
			}
	}
	}
	
	public static void main(String args[]) {
		Simulator s = new Simulator();
		do {
			s.step();
			s.printState();
		} while(true);
	}

	/**
	 * 
	 */
	private void printState() {
		System.out.println("Time: " + x/10 + " State: " + state + " Fillstatus:");
		for (int i = 0; i < y/10; i++) {
			System.out.print("X ");
		}
		for (int i = 0; i < 12 - y/10; i++) {
			System.out.print("_ ");
		}
		System.out.println();
		
	}
}
