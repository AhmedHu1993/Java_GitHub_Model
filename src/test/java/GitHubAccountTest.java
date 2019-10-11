import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    private Commit commit1;
    private Commit commit2;
    private Commit commit3;
    private Commit commit4;
    private Commit commit5;
    private Commit commit6;
    private Commit commit7;
    private Commit commit8;
    private Commit commit9;
    private Commit commit10;

    private Repository repo1;
    private Repository repo2;
    private Repository repo3;

    private GitHubAccount account1;


    @Before
    public void setup(){
        commit1 = new Commit(1, "Initializing", CommitType.OTHER);
        commit2 = new Commit(2, "Add Graph feature", CommitType.FEATURE);
        commit3 = new Commit(3, "Fixing Error", CommitType.BUGFIX);
        commit4 = new Commit(4, "Add Advance Tracking", CommitType.FEATURE);
        commit5 = new Commit(1, "Initializing", CommitType.OTHER);
        commit6 = new Commit(2, "Add Interactive Map", CommitType.FEATURE);
        commit7 = new Commit(3, "Fix Sizing Issue", CommitType.BUGFIX);
        commit8 = new Commit(4, "Refactoring", CommitType.REFACTOR);
        commit9 = new Commit(1, "PDA Collecting Evidence", CommitType.OTHER);
        commit10 = new Commit(2, "Task A", CommitType.OTHER);

        repo1 = new Repository("Habit Tracker", "JS project", RepoType.PUBLIC);
        repo2 = new Repository("Travel List", "Ruby Project", RepoType.PUBLIC);
        repo3 = new Repository("PDA", "PDA Revision Material", RepoType.PRIVATE);

        account1 = new GitHubAccount("ahm93", "Ahmed");

        repo1.addCommit(commit1);
        repo1.addCommit(commit2);
        repo1.addCommit(commit3);
        repo1.addCommit(commit4);

        repo2.addCommit(commit5);
        repo2.addCommit(commit6);
        repo2.addCommit(commit7);
        repo2.addCommit(commit8);

        repo3.addCommit(commit9);
        repo3.addCommit(commit10);

        account1.addRepo(repo1);
        account1.addRepo(repo2);
        account1.addRepo(repo3);

    }

    @Test
    public void testGitHubAccountProperties(){
        assertEquals("ahm93", account1.getUsername());
        assertEquals("Ahmed", account1.getName());
        assertEquals(AccountType.FREE, account1.getAccountType());
        assertEquals(3, account1.getRepositories().size());
    }

    @Test
    public void testCanUpgradeAccount(){
        account1.upgradeAccount();
        assertEquals(AccountType.PRO, account1.getAccountType());
    }

    @Test
    public void testCanDowngradeAccount(){
        account1.upgradeAccount();
        account1.downgradeAccount();
        assertEquals(AccountType.FREE, account1.getAccountType());
    }

    @Test
    public void testGetRepoByName(){
        assertEquals(repo3, account1.getRepoByName("PDA"));
    }

}
