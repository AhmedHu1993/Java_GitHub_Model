import java.util.ArrayList;

public class GitHubAccount {

    private String username;
    private String name;
    private ArrayList<Repository> repositories;
    private AccountType accountType;

    public GitHubAccount(String username, String name, AccountType accountType){
        this.username = name;
        this.name = name;
        this.repositories = new ArrayList<Repository>();
        this.accountType = accountType;
    }
}
