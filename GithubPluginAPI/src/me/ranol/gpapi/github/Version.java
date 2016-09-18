package me.ranol.gpapi.github;

import java.util.Arrays;

public class Version {
	int[] versions = new int[0];

	public Version(String version) {
		if (version.contains(".")) {
			for (String s : version.split(".")) {
				int[] temp = Arrays.copyOf(versions, versions.length + 1);
				temp[temp.length - 1] = Integer.parseInt(s);
				versions = temp.clone();
			}
		} else {
			versions = new int[] { Integer.parseInt(version) };
		}
	}

	@Override
	public String toString() {
		String v = "";
		for (int i = 0; i < versions.length; i++)
			v += i + ".";
		return v.substring(0, v.length() - 1);
	}
}
