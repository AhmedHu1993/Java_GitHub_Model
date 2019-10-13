import java.util.ArrayList;
import java.util.Collections;

public class Repository {

    private String name;
    private String description;
    private ArrayList<Commit> commits;
    private RepoType repoType;

    public Repository(String name, String description, RepoType repoType){
        this.name = name;
        this.description = description;
        this.commits = new ArrayList<Commit>();
        this.repoType = repoType;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Commit> getCommits() {
        return this.commits;
    }

    public RepoType getRepoType() {
        return this.repoType;
    }

    public void addCommit(Commit commit){
        if (!this.commits.contains(commit)){
            this.commits.add(commit);
        }
    }

    public Commit getCommitById(int id){
        Commit foundCommit = null ;

        for (Commit commit : this.commits){
            if(commit.getUniqueId() == id){
                foundCommit = commit;
            }
        }
        return foundCommit;
    }

    public ArrayList<Commit> getAllCommitsWithSpecificType(CommitType type){
        ArrayList<Commit> foundCommits = new ArrayList<Commit>();

        for (Commit commit : commits){
            if (commit.getType() == type){
                foundCommits.add(commit);
            }
        }
        return foundCommits;
    }

    private void arrangeCommitsById(){
        ArrayList<Integer> commitsUniqueId = new ArrayList<Integer>();
        for (Commit commit : this.commits){
            commitsUniqueId.add(commit.getUniqueId());
        }
        Collections.sort(commitsUniqueId);
        ArrayList<Commit> sortedArray = new ArrayList<Commit>();
        for (int id : commitsUniqueId){
            sortedArray.add(getCommitById(id));
        }
        this.commits = sortedArray;
    }

    public void revertAtCommit(int uniqueId) {
        this.arrangeCommitsById();
        Commit lastCommit = getCommitById(uniqueId);
        int indexNumberOfLastCommit = this.commits.indexOf(lastCommit);
        int numberOfCommits = this.commits.size();
        for (int i = numberOfCommits - 1; i > indexNumberOfLastCommit; i--){
            this.commits.remove(i);
        }

    }

}
