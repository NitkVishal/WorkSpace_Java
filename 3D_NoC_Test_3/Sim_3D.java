/**
 * <p>Title: gpNoCsim - General Purpose Netowork-on-Chip Simulation
 * 	  					Framework</p>
 *  * <p>Developed: Department of Computer Science and Engineering</p>
 * @version 1.0
 */

/**
 * gpNoCsim is the starting class of the simulator.
 * <p>
 * Contains the main method and initiates the {@link Controller_3D} instance.
 * 
 * @version 1.0
 * 
 */
public class Sim_3D {

	/**
	 * starting point of the simulator
	 * 
	 * @param args
	 *            command line arguements
	 * @see Controller_3D
	 */
	public static void main(String[] args) {
		Controller_3D controller = new Controller_3D();
		controller.main_loop();

	}
}
