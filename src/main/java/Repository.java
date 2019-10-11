import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;

public class Repository {

    private String name;
    private String descricription;
    private ArrayList<Commit> commits;
    private RepoType repoType;

    public Repository(String name, String descricription, RepoType repoType){
        this.name = name;
        this.descricription = descricription;
        this.commits = new ArrayList<Commit>();
        this.repoType = repoType;
    }

    public String getName() {
        return this.name;
    }

    public String getDescricription() {
        return this.descricription;
    }

    public ArrayList<Commit> getCommits() {
        return this.commits;
    }

    public RepoType getRepoType() {
        return this.repoType;
    }
}
