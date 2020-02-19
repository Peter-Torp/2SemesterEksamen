package module;

public class Workspace {
	
	private String ws_ID;
	private int maxWeight;

	public Workspace(String ws_ID, int maxWeight)
	{
		this.setWs_ID(ws_ID);
		this.setMaxWeight(maxWeight);
	}

	/**
	 * return ws_Id
	 * @return String ws_Id
	 */
	public String getWs_ID() {
		return ws_ID;
	}

	/**
	 * set ws_Id
	 * @param String ws_Id
	 */
	public void setWs_ID(String ws_ID) {
		this.ws_ID = ws_ID;
	}

	/**
	 * return maxWeight
	 * @return int maxWeight
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * set maxWeight
	 * @param int maxWeight
	 */
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	
	
}
