/**
 * The package contain classes for the correct use of SAKE.
 */
package de.tud.swt.evaluation;

import com.google.gson.Gson;

/**
 * Static Constants for the test case and the output of the evaluation documents.
 * 
 * @author Christopher Werner
 *
 */
public class EvaluationConstants {
	
	//global configuration for all
	public static final Gson gson = new Gson();
		
	//for multiple simulations if no input comes
	//public static final int maxThreadCount = 1;
	//public static final String simulationPathpfad = "..\\Simulations\\Simulation-Testland\\target\\classes";
		
	//important for use GUI at configuration page
	public static boolean local_gui_use = true;
	
}
