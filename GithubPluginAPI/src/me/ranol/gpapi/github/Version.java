package me.ranol.gpapi.github;

import java.util.Arrays;

public class Version {
	int[] versions = new int[0];

	public Version(String version) {
		if (version.contains(".")) {
			for (String s : version.split("\\.")) {
				int[] temp = Arrays.copyOf(versions, versions.length + 1);
				temp[temp.length - 1] = Integer.parseInt(s);
				versions = temp.clone();
			}
		} else {
			versions = new int[] { Integer.parseInt(version) };
		}
	}

	public boolean isMoreThan(Version version) {
		boolean result = false;
		for (int i = 0; i < versions.length; i++) {
			if (version.versions.length == i) {
				result = true;
				break;
			}
			if (versions[i] > version.versions[i]) {
				result = true;
				break;
			} else if (versions[i] < version.versions[i]) {
				result = false;
				break;
			} else if (versions[i] == version.versions[i]) {
				continue;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		String v = "";
		for (int i = 0; i < versions.length; i++)
			v += versions[i] + ".";
		return v.substring(0, v.length() - 1);
	}
}
