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
	//private int old;
	
	public Controller() {
		state = 0;
		//old = 10;
		tick = 30;
	}
	
	/*@ public normal_behavior
	  @ requires tick == 30 && y >= 10 && y <= 120 && y + 2 * old <= 120 && y + 2 * old >= 10 && (old == 10 || old == -20);
	  @ ensures \result * (tick / 10) + y + 2 * old  >= 12 & \result * (tick / 10) + y + 2 * old <= 116 && (\result == 10 || \result == -20);
	  @*/
	public int getControlValue (int y, int old) {
		//Waterlevel in two time units
		int inTwo = y + 2 * old;
		
		//IF we are raising level, keep raising if possible without hitting max_level before next tick
		if (old == 10) {
			if (inTwo + tick * 1 <= 116) {
			//	old = 10;
				return 10;
			}
			else {
				//	old = -20;
					return -20;
			}
		}
		//ELSE if we are currently lowering level, keep lowering if we can lower further without hitting min_level b4 next tick
		else {
			if (old == -20) {
		
				if (inTwo - tick * 2 >= 12) {
				//	old = -20;
					return -20;
				}
				else {
				//		old = 10;
						return 10;
				
				}
		
			}
		}
		
		//Only returned if old != 10 && old != -20, unreachable.
		return 0;
	}
}


