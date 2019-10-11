import java.util.ArrayList;
import java.util.Collections;

public class GitHub {

    private ArrayList<GitHubAccount> accounts;

    public GitHub(){
        accounts = new ArrayList<GitHubAccount>();
    }

    public ArrayList<GitHubAccount> getAccounts() {
        return this.accounts;
    }

    public void addAccount(GitHubAccount account){
        this.accounts.add(account);
    }

    private GitHubAccount getAccountByName(String name){
        GitHubAccount acc = new GitHubAccount("","");
        for(GitHubAccount account : accounts){
            if(account.getName() == name){
                return account;
            }
        }
        return acc;
    }

    public ArrayList<GitHubAccount> getSortedListOfAccounts(){
        ArrayList<String> sortedNames= new ArrayList<String>();

        for(GitHubAccount account : accounts){
           sortedNames.add(account.getName());
        }

        Collections.sort(sortedNames);
        ArrayList<GitHubAccount> sortedAccounts = new ArrayList<GitHubAccount>();

        for(String name: sortedNames){
            sortedAccounts.add(getAccountByName(name));
        }

        return sortedAccounts;
    }
}
