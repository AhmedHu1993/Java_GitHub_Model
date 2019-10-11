import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitTest {

    private Commit commit1;

    @Before
    public void setup(){
        commit1 = new Commit(1,"initialize", CommitType.OTHER);
    }

    @Test
    public void testCommitProperties(){
        assertEquals(1, commit1.getUniqueId());
        assertEquals("initialize", commit1.getDescription());
        assertEquals(CommitType.OTHER, commit1.getType());
    }
}
