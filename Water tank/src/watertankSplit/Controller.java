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
		tick = 40;
	}
	
	/*@ public normal_behavior
	  @ requires ((state == 0) || (state == 1)) && y >= 10 && y <= 120 
	  @ ensures \return * (tick - 2) + y + 2 * old >= 1 && \return * (tick - 2) + y + 2 * old <= 12 && y + 2 * old >= 1 && y + 2 * old <= 12
	  @*/
	public int getControlValue (int y, int old) {
		//int inTwo = y + 2 * old;
		
		if (y == 10 && old  == 0) {
			return 10;
		}
		else {
			if (y >= (120 - (tick + 10))  && old == 10) {
				return -20;
			}
			else {
				if (y <= (10 + (tick * 3 + 10)) && old == -20) {
					return 10;
				}
				else {
					return old;
				}
			}
		}
	}
}


