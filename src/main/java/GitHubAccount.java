import java.util.ArrayList;

public class GitHubAccount {

    private String username;
    private String name;
    private ArrayList<Repository> repositories;
    private AccountType accountType;

    public GitHubAccount(String username, String name, AccountType accountType){
        this.username = username;
        this.name = name;
        this.repositories = new ArrayList<Repository>();
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Repository> getRepositories() {
        return repositories;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void addRepo(Repository repository){
        this.repositories.add(repository);
    }
}
