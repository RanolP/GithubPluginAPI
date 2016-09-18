package me.ranol.gpapi;

import me.ranol.gpapi.github.GithubProject;

public class APIChecker {
	public static void main(String[] args) {
		GithubProject project = new GithubProject("RanolP", "GithubPluginAPI",
				"GithubPluginAPI");
		project.connect(true);
		System.out.println(project.getVersion());
		System.out.println(project.getAuthors());
		System.out.println(project.getName());
		System.out.println(project.getRepositoryUrl());// */
	}
}
