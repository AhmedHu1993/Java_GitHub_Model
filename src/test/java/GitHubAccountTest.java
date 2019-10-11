import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    private Repository repository1;
    private GitHubAccount account1;


    @Before
    public void setup(){
        repository1 = new Repository("Habit Tracker", "JS project", RepoType.PUBLIC);
        account1 = new GitHubAccount("ahm93", "Ahmed");
    }

    @Test
    public void testGitHubAccountProperties(){
        assertEquals("ahm93", account1.getUsername());
        assertEquals("Ahmed", account1.getName());
        assertEquals(AccountType.FREE, account1.getAccountType());
        assertEquals(0, account1.getRepositories().size());
    }




}
