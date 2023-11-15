import java.util.ArrayList;
import java.util.List;

public class Group implements Visitable, Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display() {
        // Implement how to display a group and its members
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
