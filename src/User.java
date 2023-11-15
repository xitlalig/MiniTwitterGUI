public class User implements Visitable, Component {
    @Override
    public void add(Component component) {
        // Users are leaves, so this method doesn't apply
    }

    @Override
    public void remove(Component component) {
        // Users are leaves, so this method doesn't apply
    }

    @Override
    public void display() {
        // Implement how to display a user
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
