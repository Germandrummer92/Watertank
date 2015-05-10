/**
 * 
 */
package watertankSplit;

/**
 * @author Daniel Draper
 * @version 1.0
 *
 */
public class Controller {
	
	private int state;
	private int tick;
	
	public Controller() {
		state = 0;
		tick = 3;
	}
	
	/*@ public normal_behavior
	  @ requires ((state == 0) || (state == 1)) && y >= 10 && y <= 120 
	  @ ensures \return * (tick - 2) + y + 2 * old >= 1 && \return * (tick - 2) + y + 2 * old <= 12 && y + 2 * old >= 1 && y + 2 * old <= 12
	  @*/
	public int getControlValue (int y, int old) {
		int inTwoTicks = y + 2 * old;
		
		switch (state) {
		case 0:
			if (y >= 100) {
				state = 1;
				return -20;
			}
			else {
				return 10;
			}
		
		case 1:
			if (y <= 50) {
				state = 0;
				return 10;
			}
			else {
				return -20;
			}
		default: return 0;
	}
}

}
