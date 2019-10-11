public class Commit {

    private String description;
    private CommitType type;
    private int uniqueId;

    public Commit(int uniqueId, String description, CommitType type){
        this.description = description;
        this.uniqueId = uniqueId;
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public CommitType getType() {
        return this.type;
    }

    public int getUniqueId() {
        return this.uniqueId;
    }
}
