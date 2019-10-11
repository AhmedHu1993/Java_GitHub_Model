import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

    private Commit commit1;
    private Repository repository1;

    @Before
    public void setup(){
        commit1 = new Commit();
        repository1 = new Repository("Habit Tracker", "JS project", RepoType.PRIVATE);
    }

    @Test
    public void testRepoProperties(){
        assertEquals("Habit Tracker", repository1.getName());
        assertEquals("JS project", repository1.getDescricription());
        assertEquals(RepoType.PRIVATE, repository1.getRepoType());
        assertEquals(0, repository1.getCommits().size());
    }
}
