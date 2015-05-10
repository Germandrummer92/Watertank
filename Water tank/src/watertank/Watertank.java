/**
 * 
 */
package watertank;


/**
 * @author Daniel Draper
 * @version 1.0
 *
 */
public class Watertank extends Thread {
	//For Modelling Purposes polling Rate of Control should be known to make sure of invariant.
	protected static int pollingRate  = 50;
	
	int state = 0;
	WatertankData wtd = null;
	Env env;
	int oldYForPrint = -10;
	
	Watertank() {
		state = 0;
		wtd = new WatertankData(0, 10);
		env = new Env(10, 10, wtd);
		env.start();
	}
	
	
	public int step(int y) {
		if (oldYForPrint != wtd.y/10 || wtd.x == 0) {
			printState();
			oldYForPrint = wtd.y/10;
		}
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
				if (wtd.x == 20) {
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
					//for (int i = 0; i < 20; i++) {
						//y-=1;
						//this.x+=1;
						//if (y == 50) {
							//printState();
					return -20;	//	this.x = 0; state = 3;
							//break;
						//}
					}
			case 3:
				if (wtd.x == 20) {
					state = 0;
					return 10;
				}
				else {
					//wtd.x+=10;
					return -20;		//x+=10;		
				}

			}
			return y;
	}

	/**
	 * 
	 */
	private void printState() {
		System.out.println("Time: " + wtd.x/10 + " State: " + state + " Fillstatus:");
		for (int i = 0; i < wtd.y/10; i++) {
			System.out.print("X ");
		}
		for (int i = 0; i < 12 - wtd.y/10; i++) {
			System.out.print("_ ");
		}
		System.out.println();
		
	}
	
	public void run() {
		//printState();
		do {

				env.difY = step(wtd.y);
			try {
				sleep(Watertank.pollingRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(true);
		
	}
	/*@ public normal_behavior
	  @  requires wtd.y >= 10 && wtd.y <= 120 && (state == 0 || state == 1 || state == 2 || state == 3) ;
	  @  ensures(wtd.y >= 10 && wtd.y <= 120);
	  @*/
	public static void main(String[] args) {
		Watertank wt = new Watertank();
		wt.start();
	}

}
