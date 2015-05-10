/**
 * 
 */
package seq;

/**
 * @author Daniel Draper
 * @version 1.0
 *
 */
public class Watertank {

	WatertankData wtd;
	int state;
	//private int oldYForPrint = -10;
	
	Watertank() {
		state = 0;
		wtd = new WatertankData();
	}
	
	
	public /*@ pure @*/ int step(int y) {
		/*if (oldYForPrint  != wtd.y/10 || wtd.x == 0) {
			printState();
			oldYForPrint = wtd.y/10;
		}*/
			switch(state) {
			case 0:
				if (y == 100) {
					wtd.x = 0; 
					state = 1;
					return 10;
				}
				else {
					return 10;
				}
			case 1:
				if (wtd.x >= 20) {
					state = 2; 
					return -20;
				}
				else {
					return 10;
					
				}
			case 2:
				if (y == 50) {
					wtd.x = 0;
					state = 3;
					return -20;
				}
				else {
					return -20;	
					}
			case 3:
				if (wtd.x >= 20) {
					state = 0;
					return 10;
				}
				else {

					return -20;				
				}
			
			default: return 0;
			}
	}
	/**
	 * 
	 */
	private void printState() {
	/*	System.out.println("Time: " + wtd.x/10 + " State: " + state + " Fillstatus:");
		for (int i = 0; i < wtd.y/10; i++) {
			System.out.print("X ");
		}
		for (int i = 0; i < 12 - wtd.y/10; i++) {
			System.out.print("_ ");
		}
		System.out.println();*/
		
	}
	
	/*@ public normal_behavior
	  @ requires (state == 0) && (wtd.y >= 10 && wtd.y <= 120) && wtd.x == 0;
	  @ ensures(wtd.y >= 10 && wtd.y <= 120);
	  @ diverges true;
	  @*/
	public void run() {
		int xDif = 10;
		int yDif = 10;
		//int i = 0;
		do {
			//if (wtd.x % (xDif/2) == 0) {
				yDif = step(wtd.y);
				//i++;
			//}
			wtd.x+=xDif/2;
			wtd.y+=yDif/2;
		} while(true);
	}
	
	public static void main(String[] args) {
		Watertank wt = new Watertank();
		int xDif = 10; //change of clock always 10 for us
		do {
			int yDif = wt.step(wt.wtd.y);
			wt.wtd.x+=xDif/2;
			wt.wtd.y+=yDif/2;
		} while(true);
	}
	
	
}
