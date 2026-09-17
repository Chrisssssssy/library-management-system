public class Member {
    final String name;
    final int memberNumber;

    public Member (String name, int memberNumber){
        this.name = name;
        this.memberNumber = memberNumber;
    }

    public String toString() {
        return name + " (Lånenr.: " + memberNumber + ")";
        }

}
