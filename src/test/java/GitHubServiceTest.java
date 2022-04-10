import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GitHubServiceTest {
    List<RepoDTO> repositories = new ArrayList<>();

    @Before
    public void getInstance() {
        GitHubService.getInstance();
    }

    @Test
    public void getAll() {
        this.repositories = GitHubService.getInstance().getAll();
        assertNotEquals(repositories.size(), 0);
    }

    @Test
    public void updateRepos() {
        this.repositories = GitHubService.getInstance().update();
        assertNotEquals(repositories.size(), 0);
    }

    @Test
    public void checkRepoName() {
        RepoDTO repo = GitHubService.getInstance().getByIndex(1);
        assertNotNull(repo.getName());
    }

    @Test
    public void checkRepoDescription() {
        RepoDTO repo = GitHubService.getInstance().getByIndex(1);
        assertNotNull(repo.getDescription());
    }

    @Test
    public void checkRepoLanguage() {
        RepoDTO repo = GitHubService.getInstance().getByIndex(5);
        assertNotNull(repo.getLanguage());
    }

    @Test
    public void checkRepoHomepage() {
        RepoDTO repo = GitHubService.getInstance().getByIndex(1);
        assertNotNull(repo.getHomepage());
    }

    @Test
    public void checkRepoUrl() {
        RepoDTO repo = GitHubService.getInstance().getByIndex(1);
        assertNotNull(repo.getUrl());
    }

    @Test
    public void checkRepoSize() {
        RepoDTO repo = GitHubService.getInstance().getByIndex(1);
        assertNotNull(repo.getSize());
    }
}