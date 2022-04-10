import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GitHubService {
    private static final String GITHUB_API_URL = "https://api.github.com/users/euaaron/repos";
    private static GitHubService instance;
    private List<RepoDTO> repos;

    private GitHubService() {
        this.repos = this.getAll();
    }

    public static GitHubService getInstance() {
        if (instance == null) {
            instance = new GitHubService();
        }
        return instance;
    }

    private List<RepoDTO> getReposFromGitHub() {
        try {
            URL url = new URL(GITHUB_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            Gson gson = new GsonBuilder().create();
            RepoDTO[] repoDTOs = gson.fromJson(result.toString(), RepoDTO[].class);
            return Arrays.asList(repoDTOs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<RepoDTO> getAll() {
        if (this.repos == null) {
            this.repos = this.getReposFromGitHub();
        }
        return this.repos;
    }

    public RepoDTO getByIndex(int index) {
        List<RepoDTO> repos = this.getAll();
        return repos.get(index);
    }

    public List<RepoDTO> update() {
        this.repos = this.getReposFromGitHub();
        return repos;
    }
}
