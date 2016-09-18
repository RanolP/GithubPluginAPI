package me.ranol.gpapi;

import me.ranol.gpapi.github.GithubProject;

public class APIChecker {
	public static void main(String[] args) {
		GithubProject project = new GithubProject("RanolP", "GithubPluginAPI");
		project.connect();
		System.out.println(project.getVersion());
	}
}
