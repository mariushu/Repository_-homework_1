package pl.stqa.ptf.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

import java.util.Set;

public class TestBase {


    private boolean isIssueOpen(int issueId) {
      String json = RestAssured.get(String.format("http://bugify.stqa.ru/api/issues/%s.json", issueId)).asString();
      JsonElement parsed = new JsonParser().parse(json);


      Set<Issue> issues = new Gson().fromJson(parsed.getAsJsonObject().get("issues"), new TypeToken<Set<Issue>>() {
      }.getType());
      Issue issue = issues.iterator().next();

      return ! issue.getStatus().equals("Resolved");
    }

    public void skipIfNotFixed(int issueId) {
      if (isIssueOpen(issueId)) {
        throw new SkipException("Ignored because of issue " + issueId);
      }
    }

}
