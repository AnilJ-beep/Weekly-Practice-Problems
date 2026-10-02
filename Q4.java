
class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode,
                              String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }

        return false;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        if (l.changeCode("1234", "5678")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Change rejected");
        }

        if (l.changeCode("0000", "9999")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Change rejected");
        }
    }
}