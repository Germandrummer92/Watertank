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
		tick = 30;
	}
	
	/*@ public normal_behavior
	  @ requires tick > 20  && y >= 10 && y <= 120 && (old == 10 || old == -20) && y + 2 * old <= 120 && y + 2 * old >= 10;
	  @ ensures \result * (tick - 2) + y + 2 * old >= 10 && \result * (tick - 2) + y + 2 * old <= 120;
	  @*/
	public int getControlValue (int y, int old) {
		int inTwo = y + 2 * old;
		
		if (old == 10) {
			if (inTwo + (tick - 20) * 1 <= 120) {
				return 10;
			}
			else {
				return -20;
			}
			
		}
		if (old == -20) {
			if (inTwo - (tick - 20) * 2 >= 10) {
				return -20;
			}
			else {
				return 10;
			}
		}
			return old;
	}
}


