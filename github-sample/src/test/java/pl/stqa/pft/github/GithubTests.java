package pl.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {


    Github github = new RtGithub("7d9ddba81ce8cb8123822157be545bcfb4394e5e");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("mariushu", "Repository_-homework_1")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
    System.out.println(new RepoCommit.Smart(commit).message());

  }
}
}
