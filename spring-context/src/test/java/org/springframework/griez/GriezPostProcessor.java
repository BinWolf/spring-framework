package org.springframework.griez;

/**
 * Created on 2020/7/31 15:29.
 * @author Griez
 */
public class GriezPostProcessor {

	private String connectionString;

	private String password;

	private String username;

	public String getConnectionString() {
		return connectionString;
	}

	public GriezPostProcessor setConnectionString(String connectionString) {
		this.connectionString = connectionString;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public GriezPostProcessor setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public GriezPostProcessor setUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public String toString() {
		return String.format("GriezPostProcessor {connectionString:%s, password:%s, username:%s}", connectionString, password, username);
	}
}
