import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class SimpleSwingExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mini Twitter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create a tree on the left half
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
            DefaultMutableTreeNode john = new DefaultMutableTreeNode("John");
            DefaultMutableTreeNode bob = new DefaultMutableTreeNode("Bob");
            DefaultMutableTreeNode steve = new DefaultMutableTreeNode("Steve");
            
            DefaultMutableTreeNode cs3560 = new DefaultMutableTreeNode("CS3560");
            DefaultMutableTreeNode stu1 = new DefaultMutableTreeNode("stu1");
            DefaultMutableTreeNode stu2 = new DefaultMutableTreeNode("stu2");
            DefaultMutableTreeNode stu3 = new DefaultMutableTreeNode("stu3");
            DefaultMutableTreeNode stu4 = new DefaultMutableTreeNode("stu4");

            DefaultMutableTreeNode cs3560Session = new DefaultMutableTreeNode("CS3560Session01");
            DefaultMutableTreeNode stu8 = new DefaultMutableTreeNode("stu8");
            DefaultMutableTreeNode stu9 = new DefaultMutableTreeNode("stu9");
            DefaultMutableTreeNode stu10 = new DefaultMutableTreeNode("stu10");
        
            DefaultMutableTreeNode oostu = new DefaultMutableTreeNode("oopstu");
            DefaultMutableTreeNode ppstu2 = new DefaultMutableTreeNode("ppstu2");


            cs3560.add(stu1);
            cs3560.add(stu2);
            cs3560.add(stu3);
            cs3560.add(cs3560Session);
            cs3560.add(stu4);

            cs3560Session.add(stu8);
            cs3560Session.add(stu9);
            cs3560Session.add(stu10);

            root.add(john);
            root.add(bob);
            root.add(steve);
            root.add(cs3560);
            root.add(oostu);
            root.add(ppstu2);
            
            JTree tree = new JTree(root);

            // Create other components on the right half
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new FlowLayout());

            JButton button = new JButton("Button");
            JLabel label = new JLabel("Label");
            JTextField textField = new JTextField(20);

            rightPanel.add(button);
            rightPanel.add(label);
            rightPanel.add(textField);

            // Create a split pane to divide the frame
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), rightPanel);
            splitPane.setDividerLocation(frame.getWidth() / 2);

            frame.add(splitPane);
            frame.setVisible(true);
        });
    }
}
