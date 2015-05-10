/**
 * 
 */
package watertank;

/**
 * @author Daniel Draper
 * @version 1.0
 *
 */
public class Env extends Thread {

	int difY;
	private int difX;
	private WatertankData wtd;
	
	Env(int x, int y, WatertankData wtd) {
		difX = x;
		difY = y;
		this.wtd=wtd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	//@Override
	public void run() {
		do {
			wtd.y += difY/2;
			wtd.x += difX/2;
			try {
				sleep(2*Watertank.pollingRate+100);
			}
			
			catch(InterruptedException e) {
				
			}
			
			
		} while(true);
		
		}
}
