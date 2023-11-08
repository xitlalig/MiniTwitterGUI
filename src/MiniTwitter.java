import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;

public class MiniTwitter {

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
            JPanel rightPanel = new JPanel(new BorderLayout());
            JPanel topPanel = new JPanel();
            JPanel bottomPanel = new JPanel();
            
            topPanel.setLayout(new GridBagLayout());
            bottomPanel.setLayout(new GridBagLayout());
            GridBagConstraints buttonConstraints = new GridBagConstraints();
            buttonConstraints.fill = GridBagConstraints.BOTH;
            buttonConstraints.weightx = 1;


            JButton userTotalButton = new JButton("Show User Total");
            userTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Total: 500");
                }
            });


            JButton groupTotalButton = new JButton("Show Group Total");
            groupTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Total: 7000");
                }
            });


            JButton messageTotalButton = new JButton("Show Message Total");
            messageTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Total: 500");
                }
            });


            JButton posPercentageButton = new JButton("Show Positive Percentage");
            posPercentageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Percentage: 75%");
                }
            });


            JButton addUserButton = new JButton("Add User");
            posPercentageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Adding new user...");
                }
            });


            JButton addGroupButton = new JButton("Add Group");
            posPercentageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Adding group...");
                }
            });


            topPanel.add(addUserButton, buttonConstraints);
            topPanel.add(addGroupButton, buttonConstraints);


            bottomPanel.add(userTotalButton, buttonConstraints);
            bottomPanel.add(groupTotalButton, buttonConstraints);
            bottomPanel.add(messageTotalButton, buttonConstraints);
            bottomPanel.add(posPercentageButton, buttonConstraints);

           
            rightPanel.add(topPanel, BorderLayout.NORTH);
            rightPanel.add(bottomPanel, BorderLayout.SOUTH);
            

            // Create a split pane to divide the frame
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), rightPanel);
            splitPane.setDividerLocation(frame.getWidth() / 2);


            frame.add(splitPane);
            frame.setVisible(true);
        });
    }
}
