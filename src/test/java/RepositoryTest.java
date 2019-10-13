import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

    private Commit commit1;
    private Commit commit2;
    private Commit commit3;
    private Commit commit4;
    private Repository repository1;

    @Before
    public void setup(){
        commit1 = new Commit(1,"initialize", CommitType.OTHER);
        commit2 = new Commit(2,"adding new feature", CommitType.FEATURE);
        commit3 = new Commit(3,"fixing errors", CommitType.BUGFIX);
        commit4 = new Commit(4,"creating two classes", CommitType.OTHER);
        repository1 = new Repository("Habit Tracker", "JS project", RepoType.PRIVATE);
    }

    @Test
    public void testRepoProperties(){
        assertEquals("Habit Tracker", repository1.getName());
        assertEquals("JS project", repository1.getDescription());
        assertEquals(RepoType.PRIVATE, repository1.getRepoType());
        assertEquals(0, repository1.getCommits().size());
    }

    @Test
    public void testCanAddCommitToRepoWithoutDuplication(){
        repository1.addCommit(commit1);
        repository1.addCommit(commit1);
        repository1.addCommit(commit2);
        assertEquals(2, repository1.getCommits().size());
    }

    @Test
    public void testCanFindCommitById(){
        repository1.addCommit(commit1);
        repository1.addCommit(commit2);
        repository1.addCommit(commit3);
        assertEquals(commit1 , repository1.getCommitById(1));
    }

    @Test
    public void testCanFindAllCommitOfAType(){
        repository1.addCommit(commit1);
        repository1.addCommit(commit2);
        repository1.addCommit(commit4);
        assertEquals(2, repository1.getAllCommitsWithSpecificType(CommitType.OTHER).size());
    }

    @Test
    public void testCanRevertCommitToCertainPoint(){
        repository1.addCommit(commit1);
        repository1.addCommit(commit4);
        repository1.addCommit(commit2);
        repository1.addCommit(commit3);
        repository1.revertAtCommit(2);
        assertEquals(2, repository1.getCommits().size());
        assertEquals(commit2 , repository1.getCommits().get(1));
    }


}
