import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubTest {

    private GitHub gitHub;

    private GitHubAccount account1;
    private GitHubAccount account2;
    private GitHubAccount account3;
    private GitHubAccount account4;
    private GitHubAccount account5;

    @Before
    public void setup(){
        gitHub = new GitHub();

        account1 = new GitHubAccount("ros5", "Ross");
        account2 = new GitHubAccount("joeyPizza", "Joey");
        account3 = new GitHubAccount("mon4", "Monica");
        account4 = new GitHubAccount("chand6", "Chandler");
        account5 = new GitHubAccount("rach90", "Rachel");

        gitHub.addAccount(account1);
        gitHub.addAccount(account2);
        gitHub.addAccount(account3);
        gitHub.addAccount(account4);
        gitHub.addAccount(account5);
    }

    @Test
    public void testGitHubContainsAccounts(){
        assertEquals(5, gitHub.getAccounts().size());
    }

    @Test
    public void testSortedMapForAccounts(){
        assertEquals(0, gitHub.getSortedListOfAccounts().indexOf(account4));
    }
}
