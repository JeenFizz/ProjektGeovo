package model;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class HelloWorld extends Entity {

	/** The id. */
	private int			id;

	/** The message. */
	private String	Map;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id
	 *          the id
	 * @param key
	 *          the key
	 * @param message
	 *          the message
	 */
	public HelloWorld(final int id, final String Map) {
		this.setId(id);
		this.setMap(Map);
	}

	/**
	 * Instantiates a new hello world.
	 */
	public HelloWorld() {
		this(0, "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}


	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMap() {
		return this.Map;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public void setMap(final String Map) {
		this.Map = Map;
	}

}
