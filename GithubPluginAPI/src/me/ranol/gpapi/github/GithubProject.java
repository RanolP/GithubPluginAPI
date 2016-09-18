package me.ranol.gpapi.github;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;

import com.google.common.util.concurrent.UncheckedExecutionException;

public class GithubProject {
	private String url;
	private String ymlDir;
	private String authors;
	private String name;
	private Version version;
	private boolean connected = false;
	private String user;
	private String projectName;

	public GithubProject(String userName, String projectName, String descDir) {
		url = "https//github.com/" + userName + "/" + projectName;
		this.user = userName;
		this.projectName = projectName;
		ymlDir = descDir;
	}

	public void connect() {
		connect(false);
	}

	public void connect(boolean logging) {
		connected = true;
		String ymlUrl = "https://raw.githubusercontent.com/" + user + "/"
				+ projectName + "/master/" + ymlDir + "/plugin.yml";
		BufferedReader reader = null;
		try {
			URL url = new URL(ymlUrl);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			List<String> readed = new ArrayList<>();
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				if (readLine.startsWith("version: "))
					version = new Version(readLine.split(":")[1].trim());
				if (readLine.startsWith("name: "))
					name = readLine.split(":")[1].trim();
				if (readLine.startsWith("author: ")
						|| readLine.startsWith("authors: "))
					authors = readLine.split(":")[1].trim();
				readed.add(readLine);
			}
		} catch (Exception e) {
			throw new UncheckedExecutionException(e);
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				throw new UncheckedExecutionException(e);
			}
		}
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

	public String getAuthors() {
		return authors;
	}

	public String getName() {
		return name;
	}
}
