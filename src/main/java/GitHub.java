import java.util.HashMap;

public class GitHub {

    private HashMap<String, GitHubAccount> accounts;

    public GitHub(){
        accounts = new HashMap<String, GitHubAccount>();
    }

    public HashMap<String, GitHubAccount> getAccounts() {
        return this.accounts;
    }

    public void addAccount(GitHubAccount account){
        this.accounts.put(account.getName(), account);
    }
}
