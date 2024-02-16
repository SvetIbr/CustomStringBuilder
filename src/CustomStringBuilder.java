import java.util.Stack;

public class CustomStringBuilder {
    private StringBuilder sb;
    private final Stack<String> snapshots;

    public CustomStringBuilder() {
        this.sb = new StringBuilder();
        this.snapshots = new Stack<>();
    }

    public void append(String str) {
        snapshots.push(sb.toString());
        sb.append(str);
    }

    public void undo() {
        if (!snapshots.isEmpty()) {
            sb = new StringBuilder(snapshots.pop());
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomStringBuilder usb = new CustomStringBuilder();
        usb.append("Hello, ");
        usb.append("Sveta!");
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
    }
}
