import java.util.*;

/**
 * <p>
 * The NetworkManager class is responsible for instantiating a network instance. It
 * also initializes the StatisticalData class to re-establish its variables.
 * This class also initializes the configuration parameters in the IConstants
 * class by the input parameters in the system retrieve from the input file.
 * </p>
 * 
 * <p>
 * The NetworkManager class implements the Singleton Design Pattern.
 * </p>
 * 
 * @version 1.0
 * 
 */

public class NetworkManager_3D {
	/**
	 * An static instance of the
	 * 
	 * {@link NetworkManager_3D} class which is useful for the implementation of
	 * Singleton design pattern.
	 */
	private static NetworkManager_3D netManager = null;

	/**
	 * An instance of the
	 * 
	 * {@link Network} class to refer to the current simulating network.
	 */
	private static Network_3D network = null;

	/**
	 * An instance of the
	 * 
	 * {@link StatisticalData_3D} class to perform the related statistical
	 * computations.
	 */
	private static StatisticalData_3D statData = null;

	/**
	 * An instance of the
	 * 
	 * {@link HelpingUtility_3D} class to re-initialize the random seed and read
	 * the input file.
	 */
	private static HelpingUtility_3D helpUtility = null;

	// private static int networkType=0;

	/**
	 * Keeps track of the current simulating network to read the relevant input
	 * parameters.
	 */
	private static int curSet;

	/**
	 * Name of the input configuration file.
	 */
	private static String paramFile;

	/**
	 * Default percentage of warm_up_cycles to that of total simulation cycles.
	 */
	private static double warm_up_percentage = 0.1;

	/**
	 * Constructor of the NetworkManager class. Initializes the HelpingUtility
	 * class and invokes its pertinent method read parameters from the input
	 * file.
	 * 
	 * @param parameterFile
	 *            Name of the input configuration file
	 * 
	 * @see HelpingUtility_3D
	 */
	public NetworkManager_3D(String parameterFile) {
		NetworkManager_3D.paramFile = parameterFile;

		helpUtility = new HelpingUtility_3D();
		helpUtility.readParameterFromFile(NetworkManager_3D.paramFile);
		curSet = 0;
	}

	/**
	 * Creates a Network class instance and loads the related configuration
	 * parameters in the IConstants class. It also re-initializes the
	 * StatisticalData class.
	 * 
	 * @return true if a Network class instance is created, false otherwise.
	 * 
	 * @see IConstants_3D
	 * @see HelpingUtility_3D
	 * @see Network
	 * @see StatisticalData_3D
	 */
	public boolean createNextNetwork() {
		helpUtility.setRandomSeed();
		Vector paramSet = helpUtility.getParamSet(curSet);
		if (null != paramSet) {
			curSet++;
			loadSet(paramSet);
			network = new Network_3D(IConstants_3D.CURRENT_NET);
			statData = new StatisticalData_3D(IConstants_3D.CURRENT_NET);
			return true;
		}
		return false;
	}

	/**
	 * Initializes the current simulating network and the statistical counters.
	 * 
	 * @see Network
	 * @see StatisticalData_3D
	 */
	public void initializeNetwork() {
		if (null != network) {
			network = new Network_3D(IConstants_3D.CURRENT_NET);
			statData = new StatisticalData_3D(IConstants_3D.CURRENT_NET);
		}
	}

	/**
	 * Loads the configuration parameters in the IConstants class for the
	 * current simulating network.
	 * 
	 * @param set
	 *            total set of pairs of input parameter and its value
	 */
	private void loadSet(Vector set) {
		int i;
		ParamDTO_3D parDTO;
		String param, val;

		if (null != set) {
			for (i = 0; i < set.size(); i++) {
				parDTO = (ParamDTO_3D) set.get(i);
				param = parDTO.getParam();
				val = parDTO.getVal();
				if (param.equalsIgnoreCase("CURRENT_NET"))
					IConstants_3D.CURRENT_NET = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("AVG_INTER_ARRIVAL"))
					IConstants_3D.AVG_INTER_ARRIVAL = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("AVG_MESSAGE_LENGTH"))
					IConstants_3D.AVG_MESSAGE_LENGTH = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("FLIT_LENGTH"))
					IConstants_3D.FLIT_LENGTH = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("NUMBER_OF_IP_NODE"))
					IConstants_3D.NUMBER_OF_IP_NODE = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("CURRENT_ADJ_SWITCH"))
					IConstants_3D.CURRENT_ADJ_SWITCH = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("CURRENT_LINK_COUNT"))
					IConstants_3D.CURRENT_LINK_COUNT = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("CURRENT_VC_COUNT"))
					IConstants_3D.CURRENT_VC_COUNT = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("NUM_FLIT_PER_BUFFER"))
					IConstants_3D.NUM_FLIT_PER_BUFFER = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("NUM_CYCLE"))
					IConstants_3D.NUM_CYCLE = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("NUM_RUN"))
					IConstants_3D.NUM_RUN = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("TRACE"))
					IConstants_3D.TRACE = Boolean.valueOf(val).booleanValue();
				else if (param.equalsIgnoreCase("ASYNCHRONOUS"))
					IConstants_3D.ASYNCHRONOUS = Boolean.valueOf(val)
							.booleanValue();
				else if (param.equalsIgnoreCase("TRAFFIC_TYPE"))
					IConstants_3D.TRAFFIC_TYPE = Integer.parseInt(val);
				else if (param.equalsIgnoreCase("WARM_UP_CYCLE"))
					warm_up_percentage = Double.parseDouble(val);
				else if (param.equalsIgnoreCase("FIXED_MESSAGE_LENGTH"))
					IConstants_3D.FIXED_MESSAGE_LENGTH = Boolean.valueOf(val)
							.booleanValue();
				
			}
		}

		// default value of warm_up_percentage= 0.1
		IConstants_3D.WARM_UP_CYCLE = (int) (IConstants_3D.NUM_CYCLE * warm_up_percentage);
	}

	/**
	 * Returns a NetworkManager class instance, if not already defined.
	 * Otherwise, returns the previously defined object.
	 * 
	 * @param paramFile
	 *            name of the input configuration file
	 * @return an instance of the NetworkManager class
	 */
	public static NetworkManager_3D getInstance(String paramFile) {
		if (netManager == null) {
			netManager = new NetworkManager_3D(paramFile);
		}
		return netManager;
	}

	/**
	 * Returns a NetworkManager class instance, if not already defined.
	 * Otherwise, returns the previously defined object.
	 * 
	 * @return an instance of the NetworkManager class
	 */
	public static NetworkManager_3D getInstance() {
		if (netManager == null) {
			netManager = new NetworkManager_3D(IConstants_3D.PARAM_FILE);
		}
		return netManager;
	}

	/**
	 * Returns the network variable of this class. 'network' is an instance of
	 * the Network class.
	 * 
	 * @return reference to the current simulating network
	 */
	public static Network_3D getNetworkInstance() {
		return network;
	}

	/**
	 * Returns the helpUtility variable of this class. 'helpUtility' is an
	 * instance of the HelpingUtility class.
	 * 
	 * @return instance of the HelpingUtility class
	 * @see HelpingUtility_3D
	 */
	public static HelpingUtility_3D getHelpingUtility() {
		return helpUtility;
	}

	/**
	 * Returns the statData variable of this class. 'statData' is an instance of
	 * the StatisticalData class
	 * 
	 * @return instance of the StatisticalData class
	 * 
	 * @see StatisticalData_3D
	 */
	public static StatisticalData_3D getStatDataInstance() {
		if (netManager == null) {
			netManager = new NetworkManager_3D(paramFile);
		}
		return statData;
	}

}