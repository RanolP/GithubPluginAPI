package me.ranol.gpapi.github;

public class GithubProject {
	private String url;
	private Version version;
	private boolean connected = false;

	public GithubProject(String userName, String projectName) {
		url = "https//github.com/RanolP/GithubPluginAPI";
	}

	public void connect() {
		connected = true;
	}

	public String getRepositoryUrl() {
		return url;
	}

	public Version getVersion() {
		return version;
	}

	public boolean isConnected() {
		return connected;
	}
}
