import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class config {
    @Value("${repositoryName}")
    private String repositoryName;

    @Value("${Url}")
    private String credentials;

    // Getters and setters for the properties

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
