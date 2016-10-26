/**
 * This class contains all configuration variables.
 * 
 * @version 1.0
 * 
 */

public class IConstants_3D {
	public IConstants_3D() {
	}

	/** Input file name */
	public static String PARAM_FILE = "nocSimParameter.txt";

	/** Output file name */
	public static String OUT_FILE = "nocSimOutput.txt";

	/** Debug file name */
	public static String TRACE_FILE = "nocSimTrace.txt";

	/** Type of the Header Flit */
	public static int HEADER_FLIT = 0;

	/** Type of the Data Flit */
	public static int DATA_FLIT = 1;

	/** Type of the NULL Flit */
	public static int NULL_FLIT = 2;

	// public static int INNER_NUM_FLIT_BUFFER = 10;

	/** Number of rows in the Mesh/Torus Network */
	public static int MESH_ROW = 10;

	/** Number of columns in the Mesh/Torus Network */
	public static int MESH_COL = 10;

	/**
	 * Number of bits required to encode the row information in the Mesh/Torus
	 * Network
	 */
	public static int MESH_ROW_BITS = 14;

	/**
	 * Number of bits required to encode the column information in the
	 * Mesh/Torus Network
	 */
	public static int MESH_COL_BITS = 14;

	/** Number of adjacent nodes per switch in the Mesh/Torus Network */
	public static int MESH_ADJ_NODE = 1;

	/**
	 * Number of bits required to encode the adjacent node index in the
	 * Mesh/Torus Network
	 */
	public static int MESH_NODE_BITS_REQ = 2;

	/** Number of bits in an integer value */
	public static int INT_SIZE = 32;

	// / usually used in the mesh and torus network
	/** Link no for the switch to the left */
	public static int SWITCH_LEFT = 0;

	/** Link no for the switch to the top */
	public static int SWITCH_TOP = 1;

	/** Link no for the switch to the right */
	public static int SWITCH_RIGHT = 2;

	/** Link no for the switch to the bottom */
	public static int SWITCH_BOTTOM = 3;
	
	
	public static int SWITCH_UP = 4;
	
	public static int SWITCH_DOWN = 5;

	/** Number of bits required to encode the address of a node. */
	public static int NUM_ADDR_BITS = 6;

	/** Number of bits required to encode the virtual channel. */
	public static int NUM_VCID_BITS = 3;

	public static int Z_AXIS_BITS = 0 ;
	/**
	 * Number of bits requird in the header flit to encode the total number of
	 * flits per packet
	 */
	public static int NUM_FLITS_BITS = 16;

	/** Number of bits required to encode the type of the flit. */
	public static int NUM_FLIT_TYPE_BITS = 1;

	/** Current simulation cycle */
	public static int CUR_CYCLE = 0;

	// public static int MAX_VC_COUNT = 16;

	/** Maximum number of packet storage in the Node's internal buffer. */
	public static int MAX_MESSAGE_NUMBER = 200;

	/** Default number of virtual channels per physical channel */
	public static int DEFAULT_VC_COUNT = 6;

	// Traffic Generation

	/** Type of the Traffic */
	public static int TRAFFIC_TYPE = 0;

	/** Type of the Union Traffic Distribution */
	public static int TRAFFIC_UNIFORM = 0;

	/** Type of the Local Traffic Distribution */
	public static int TRAFFIC_LOCAL = 1;

	/**
	 * Type of the message size. If true, then message size is uniform, else
	 * exponentially distributed
	 */
	public static boolean FIXED_MESSAGE_LENGTH = false;


	// Network Type


	/** Type of the Mesh Network */
	public static int NET_MESH = 1;



	/** Number of warm up cycles. */
	public static int WARM_UP_CYCLE = 0;

	// input from file rquired

	/** Type of the current network topology */
	public static int CURRENT_NET = 2;

	/** Average message generation interval in cycles */
	public static int AVG_INTER_ARRIVAL = 20;

	/** Average message length in bytes */
	public static int AVG_MESSAGE_LENGTH = 100;// bytes

	/** Flit length in bits */
	public static int FLIT_LENGTH = 64; // bits

	/** Number of IP nodes in the network */
	public static int NUMBER_OF_IP_NODE = 100;

	/** Number of switches in the network */
	public static int NUMBER_OF_SWITCH = 100;

	/** Number of maximum adjacent switches in the Mesh/Torus Network */
	public static int CURRENT_ADJ_SWITCH = 6;

	/** Number of maximum physical links per switch */
	public static int CURRENT_LINK_COUNT = 8;

	/** Number of virtual channels per physical link */
	public static int CURRENT_VC_COUNT = 6;

	/** Number of flits per buffer for a virtual channel */
	public static int NUM_FLIT_PER_BUFFER = 2;

	/**
	 * Number of simulation cycles. Statistics are collected only for these
	 * number of cycles, excluding the warm-up cycles.
	 */
	public static int NUM_CYCLE = 300;

	/** Number of total simulation runs */
	public static int NUM_RUN = 4;

	/** Trace-on variable. If debug-mode is on, then it is true. Otherwise, false */
	public static boolean TRACE = false;

	/**
	 * Asycnchronous/Synchronous mode. If asynchronous operation, then it is
	 * true. Otherwise, false
	 */
	public static boolean ASYNCHRONOUS = false;


}
