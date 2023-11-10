import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.tree.*;
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

            //******** Just Added for Testing ************/
            GridBagConstraints gbc = new GridBagConstraints();
            JPanel page = new JPanel();
            page.setLayout(new GridBagLayout());
            page.setBackground(new Color(229, 204, 255));
            page.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            gbc.insets = new Insets(5, 5, 5, 5);

            // ***** ICONS *****
            //ImageIcon plusSign = new ImageIcon("add_FILL0_wght400_GRAD0_opsz24.png");
            ImageIcon star = new ImageIcon("C:\\Users\\grell\\OneDrive\\Documents\\FirstGUI\\bin\\star.png");
            Image resizedStar = star.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            ImageIcon finStar = new ImageIcon(resizedStar);


            JLabel userID = new JLabel("User ID: Lemon123");
            gbc.gridx = 0;
            gbc.gridy = 0;
            userID.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
            page.add(userID, gbc);


            JLabel groupID = new JLabel("Group ID: Buddies543");
            gbc.gridx = 0;
            gbc.gridy = 1;
            groupID.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
            page.add(groupID, gbc);


            JButton addUserButton = new JButton("add user", finStar);
            addUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Adding new user...");
                }
            });
            addUserButton.setContentAreaFilled(false);
            addUserButton.setOpaque(true);
            addUserButton.setForeground(Color.WHITE);
            addUserButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            addUserButton.setBackground(new Color(204, 153, 255));

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            page.add(addUserButton, gbc);


            JButton addGroupButton = new JButton("add group", finStar);
            addGroupButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Adding group...");
                }
            });

            addGroupButton.setContentAreaFilled(false);
            addGroupButton.setOpaque(true);
            addGroupButton.setForeground(Color.WHITE);
            addGroupButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            addGroupButton.setBackground(new Color(204, 153, 255));

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            page.add(addGroupButton, gbc);


            JButton userTotalButton = new JButton("show user total", finStar);
            userTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Total: 500");
                }
            });

            userTotalButton.setContentAreaFilled(false);
            userTotalButton.setOpaque(true);
            userTotalButton.setForeground(Color.WHITE);
            userTotalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            userTotalButton.setBackground(new Color(204, 153, 255));
            
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            page.add(userTotalButton, gbc);



            JButton groupTotalButton = new JButton("show group total", finStar);
            groupTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Total: 7000");
                }
            });

            groupTotalButton.setContentAreaFilled(false);
            groupTotalButton.setOpaque(true);
            groupTotalButton.setForeground(Color.WHITE);
            groupTotalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            groupTotalButton.setBackground(new Color(204, 153, 255));

            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            page.add(groupTotalButton, gbc);


            JButton messageTotalButton = new JButton("show message total", finStar);
            messageTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Total: 500");
                }
            });

            messageTotalButton.setContentAreaFilled(false);
            messageTotalButton.setOpaque(true);
            messageTotalButton.setForeground(Color.WHITE);
            messageTotalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            messageTotalButton.setBackground(new Color(204, 153, 255));

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            page.add(messageTotalButton, gbc);


            JButton posPercentageButton = new JButton("show positive percentage", finStar);
            posPercentageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Percentage: 75%");
                }
            });

            posPercentageButton.setContentAreaFilled(false);
            posPercentageButton.setOpaque(true);
            posPercentageButton.setForeground(Color.WHITE);
            posPercentageButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            posPercentageButton.setBackground(new Color(204, 153, 255));

            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            page.add(posPercentageButton, gbc);


            // Create a split pane to divide the frame
            JScrollPane treePane = new JScrollPane(tree);
            tree.setBackground(new Color(246, 195, 224));
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane, page);
            splitPane.setDividerLocation(frame.getWidth() / 4);


            frame.add(splitPane);
            frame.setVisible(true);
        });
    }
}
