public class RepoDTO {
    private String name;
    private String description;
    private String language;
    private String homepage;
    private String url;
    private String size;

    public RepoDTO() {
    }

    /**
     * @param name Name of the repository
     * @param description Repo's description
     * @param language Programing Language - can be null or empty
     * @param homepage Projects homepage - can be null or empty
     * @param url Repo's URL
     * @param size Repo's size
     */
    public RepoDTO(String name, String description, String language, String homepage, String url, String size) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.homepage = homepage;
        this.url = url;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
