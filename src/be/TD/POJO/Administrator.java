package be.TD.POJO;

import java.io.Serializable;

public class Administrator extends User implements Serializable{

	private static final long serialVersionUID = 2659764972800808607L;

	public Administrator(int id, String username, String password) {
		super(id, username, password);
	}
}
