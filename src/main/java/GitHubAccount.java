import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GitHubAccount {

    private String username;
    private String name;
    private HashMap<String , Repository> repositories;
    private AccountType accountType;

    public GitHubAccount(String username, String name){
        this.username = username;
        this.name = name;
        this.repositories = new HashMap<String, Repository>();
        this.accountType = AccountType.FREE;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public HashMap getRepositories() {
        return this.repositories;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public void upgradeAccount(){
        this.accountType = AccountType.PRO;
    }

    public void downgradeAccount(){
        this.accountType = AccountType.FREE;
    }

    public void addRepo(Repository repo){
        this.repositories.put(repo.getName(), repo);
    }

    public Repository getRepoByName(String name) {
        return this.repositories.get(name);
    }

    public Repository getRepoByMostCommits(){
        int maxNumber = 0;
        Repository repoWithMaxCommits = null;

        for (Map.Entry mapElement : repositories.entrySet()){
            Repository repository =  (Repository) mapElement.getValue();
            if (repository.getCommits().size() > maxNumber){
                maxNumber = repository.getCommits().size();
                repoWithMaxCommits = repository;
            }
        }
        return  repoWithMaxCommits;
    }
}
