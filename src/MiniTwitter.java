import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MiniTwitter 
{
    //Singleton instance of MiniTwitter
    private static MiniTwitter instance;

    //Composite
    private Component c_root;

    //Counters for users, groups, positive word instances and tweets
    private static int userCounter = 9;
    private static int groupCounter = 1;
    private static int tweetCounter = 0;
    private static int positiveTweetCounter = 0;

    //Root node
    private static DefaultMutableTreeNode root;
    
    //Set of Positive Words
    private static final Set<String> positiveWords = new HashSet<>(Arrays.asList("good", "great", "excellent", "awesome", "fantastic", "happy"));


    private MiniTwitter() {}


    public void accept(Visitor visitor){}


    public void addComponent(Component component) {
        c_root.add(component);
    }

    public void removeComponent(Component component) {
        c_root.remove(component);
    }

    public void displayTree() {
        c_root.display();
    }


    //Get instance of MiniTwitter (Singleton Pattern)
    public static MiniTwitter getInstance()
    {
        if(instance == null)
        {
            instance = new MiniTwitter();
        }
        return instance;
    }


    //Create Add User Button
    private static JButton createAddUserButton(JTree tree, JLabel userIDLabel, JLabel groupIDLabel, DefaultListModel<String> userListModel) 
    {
        ImageIcon star = new ImageIcon("C:\\Users\\grell\\OneDrive\\Documents\\FirstGUI\\bin\\star.png");
        Image resizedStar = star.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finStar = new ImageIcon(resizedStar);

        JButton addUserButton = new JButton("add user", finStar);
        addUserButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = JOptionPane.showInputDialog(null, "Enter username:");

                if (username != null && !username.isEmpty()) 
                {
                    DefaultMutableTreeNode newUserNode = new DefaultMutableTreeNode(username);
                    root.add(newUserNode);
                    userCounter++;

                    ((DefaultTreeModel) tree.getModel()).reload();
                    userIDLabel.setText("User ID: " + username);
                }
            }
        });

        addUserButton.setContentAreaFilled(false);
        addUserButton.setOpaque(true);
        addUserButton.setForeground(Color.WHITE);
        addUserButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        addUserButton.setBackground(new Color(204, 153, 255));

        return addUserButton;
    }


    //Create Add Group Button
    private static JButton createAddGroupButton(JTree tree, JLabel userIDLabel, JLabel groupIDLabel) 
    {
        ImageIcon star = new ImageIcon("C:\\Users\\grell\\OneDrive\\Documents\\FirstGUI\\bin\\star.png");
        Image resizedStar = star.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finStar = new ImageIcon(resizedStar);
    
        JButton addGroupButton = new JButton("add group", finStar);
        addGroupButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String groupName = JOptionPane.showInputDialog("Select a user first. ", "Enter group name:");

                if (groupName != null && !groupName.isEmpty()) 
                {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                    if (selectedNode != null) 
                    {
                        DefaultMutableTreeNode newGroupNode = new DefaultMutableTreeNode(groupName);
                        
                        selectedNode.removeFromParent();
                        newGroupNode.add(selectedNode);
                        root.add(newGroupNode);
                        groupCounter++;

                        ((DefaultTreeModel) tree.getModel()).reload();
                        groupIDLabel.setText("Group ID: " + groupName);
                    }
                }
            }
        });

        addGroupButton.setContentAreaFilled(false);
        addGroupButton.setOpaque(true);
        addGroupButton.setForeground(Color.WHITE);
        addGroupButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        addGroupButton.setBackground(new Color(204, 153, 255));

        return addGroupButton;
    }


    //Find user node in tree
    private static DefaultMutableTreeNode findUserNode(String userID)
    {
        Enumeration<TreeNode> enumeration = root.depthFirstEnumeration();
        while(enumeration.hasMoreElements())
        {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();

            if(node.getUserObject().toString().equals(userID))
            {
                return node;
            }
        }
        return null;
    }


    //Create open user view button
    private static JButton createOpenUserViewButton(JButton addUserButton, JButton addGroupButton, JLabel userID, JLabel groupID, DefaultListModel<String> userListModel)
    {
        ImageIcon star = new ImageIcon("C:\\Users\\grell\\OneDrive\\Documents\\FirstGUI\\bin\\star.png");
        Image resizedStar = star.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finStar = new ImageIcon(resizedStar);

        JButton openUserView = new JButton("open user view", finStar);
        openUserView.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame userViewFrame = new JFrame("User View");
                userViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userViewFrame.setSize(800, 600);
                
                GridBagConstraints gconstraint = new GridBagConstraints();
                JPanel userPage = new JPanel();
                userPage.setLayout(new GridBagLayout());
                userPage.setBackground(new Color(155, 206, 186));
                userPage.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                
                gconstraint.insets = new Insets(5, 5, 5, 5);
                gconstraint.gridx = 0;
                gconstraint.gridy = 0;
                userID.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
                userPage.add(userID, gconstraint);

                JButton followUserButton = new JButton("follow user", finStar);
                followUserButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String followUserID = JOptionPane.showInputDialog(null, "Enter userID to follow: ");


                        if(followUserID != null && !followUserID.isEmpty())
                        {
                            DefaultMutableTreeNode userNodeToFollow = findUserNode(followUserID);

                            if(userNodeToFollow != null)
                            {
                                userListModel.addElement(followUserID);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "User not found.");
                            }
                        }
                    }
                });

                followUserButton.setContentAreaFilled(false);
                followUserButton.setOpaque(true);
                followUserButton.setForeground(Color.WHITE);
                followUserButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
                followUserButton.setBackground(new Color(204, 153, 255));

                gconstraint.gridx = 1;
                gconstraint.gridy = 0;
                gconstraint.gridwidth = 1;
                gconstraint.fill = GridBagConstraints.HORIZONTAL;
                userPage.add(followUserButton, gconstraint);
                
                JLabel followersList = new JLabel("followers list");
                gconstraint.gridx = 0;
                gconstraint.gridy = 1;
                gconstraint.gridwidth = 3;
                gconstraint.fill = GridBagConstraints.HORIZONTAL;
                userPage.add(followersList, gconstraint);


                JList<String> listView = new JList<>(userListModel);
                JScrollPane scroller = new JScrollPane(listView);

                gconstraint.gridx = 0;
                gconstraint.gridy = 2;
                gconstraint.gridwidth = 3;
                gconstraint.fill = GridBagConstraints.HORIZONTAL;
                userPage.add(scroller, gconstraint);

                JTextArea tweetTextArea = new JTextArea();
                tweetTextArea.setLineWrap(true);
                tweetTextArea.setWrapStyleWord(true);

                DefaultListModel<String> tweetListModel = new DefaultListModel<>();
                JList<String> tweetListView = new JList<>(tweetListModel);
                JScrollPane tweetScrollPane = new JScrollPane(tweetListView);

                gconstraint.gridx = 0;
                gconstraint.gridy = 5;
                gconstraint.gridwidth = 3;
                gconstraint.fill = GridBagConstraints.HORIZONTAL;
                userPage.add(tweetScrollPane, gconstraint);

                JButton postTweetButton = new JButton("Post Tweet");
                postTweetButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String tweetMessage = tweetTextArea.getText();
                        tweetListModel.addElement(tweetMessage);

                        if(containsPositiveWords(tweetMessage))
                        {
                            positiveTweetCounter++;
                        }

                        tweetCounter++;
                        tweetTextArea.setText("");
                    }
                });

                postTweetButton.setContentAreaFilled(false);
                postTweetButton.setOpaque(true);
                postTweetButton.setForeground(Color.WHITE);
                postTweetButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
                postTweetButton.setBackground(new Color(204, 153, 255));

                gconstraint.gridx = 0;
                gconstraint.gridy = 3;
                gconstraint.gridwidth = 4;
                gconstraint.fill = GridBagConstraints.HORIZONTAL;
                userPage.add(tweetTextArea, gconstraint);

                gconstraint.gridx = 0;
                gconstraint.gridy = 4;
                gconstraint.gridwidth = 4;
                gconstraint.fill = GridBagConstraints.HORIZONTAL;
                userPage.add(postTweetButton, gconstraint);

                userViewFrame.add(userPage);
                userViewFrame.setVisible(true);
            }
        });

        openUserView.setContentAreaFilled(false);
        openUserView.setOpaque(true);
        openUserView.setForeground(Color.WHITE);
        openUserView.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        openUserView.setBackground(new Color(204, 153, 255));

        return openUserView;
    }


    //Check if tweet contains positive words
    private static boolean containsPositiveWords(String tweet) 
    {
        for (String word : positiveWords) 
        {
            if (tweet.toLowerCase().contains(word)) 
            {
                return true;
            }
        }
        return false;
    }


    //create main panel of GUI
    private static JPanel createMainPanel(JTree tree, JButton addUserButton, JButton addGroupButton, JLabel userID, JLabel groupID, JButton openUserView) 
    {
        ImageIcon star = new ImageIcon("C:\\Users\\grell\\OneDrive\\Documents\\FirstGUI\\bin\\star.png");
        Image resizedStar = star.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finStar = new ImageIcon(resizedStar);
        
        JPanel page = new JPanel();
        page.setLayout(new GridBagLayout());
        page.setBackground(new Color(229, 204, 255));
        page.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        userID.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        page.add(userID, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        groupID.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        page.add(groupID, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(addUserButton, gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(addGroupButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(openUserView, gbc);

        JButton userTotalButton = new JButton("show user total", finStar);
        userTotalButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Total users: " + userCounter);
            }
        });

        userTotalButton.setContentAreaFilled(false);
        userTotalButton.setOpaque(true);
        userTotalButton.setForeground(Color.WHITE);
        userTotalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        userTotalButton.setBackground(new Color(204, 153, 255));
            
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(userTotalButton, gbc);

        JButton groupTotalButton = new JButton("show group total", finStar);
        groupTotalButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    JOptionPane.showMessageDialog(null, "Total Groups: " + groupCounter);
            }
        });

        groupTotalButton.setContentAreaFilled(false);
        groupTotalButton.setOpaque(true);
        groupTotalButton.setForeground(Color.WHITE);
        groupTotalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        groupTotalButton.setBackground(new Color(204, 153, 255));

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(groupTotalButton, gbc);

        JButton messageTotalButton = new JButton("show message total", finStar);
        messageTotalButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Total Tweet Messages: " + tweetCounter);
            }
        });

        messageTotalButton.setContentAreaFilled(false);
        messageTotalButton.setOpaque(true);
        messageTotalButton.setForeground(Color.WHITE);
        messageTotalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        messageTotalButton.setBackground(new Color(204, 153, 255));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(messageTotalButton, gbc);

        JButton posPercentageButton = new JButton("show positive percentage", finStar);
        posPercentageButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(tweetCounter > 0)
                {
                    double positivePercentage = ((double) positiveTweetCounter / tweetCounter) * 100;
                    JOptionPane.showMessageDialog(null, String.format("Positive Percentage: %.2f%%", positivePercentage));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No tweet messages yet.");
                }   
            }
        });

        posPercentageButton.setContentAreaFilled(false);
        posPercentageButton.setOpaque(true);
        posPercentageButton.setForeground(Color.WHITE);
        posPercentageButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        posPercentageButton.setBackground(new Color(204, 153, 255));

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(posPercentageButton, gbc);
    
        return page;
    }


    //Entry point of the application
    void run() 
    {
        JFrame frame = new JFrame("Mini Twitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode defaultOne = new DefaultMutableTreeNode("bob465");
        DefaultMutableTreeNode defaultTwo = new DefaultMutableTreeNode("steve728");
        DefaultMutableTreeNode defaultThree = new DefaultMutableTreeNode("stacy555");
        DefaultMutableTreeNode defaultFour = new DefaultMutableTreeNode("joey11");
        DefaultMutableTreeNode defaultFive = new DefaultMutableTreeNode("lucy63");
        DefaultMutableTreeNode defaultSix = new DefaultMutableTreeNode("angel10");
        DefaultMutableTreeNode defaultSeven = new DefaultMutableTreeNode("mary189");
        DefaultMutableTreeNode defaultEight = new DefaultMutableTreeNode("john829");
        DefaultMutableTreeNode defaultNine = new DefaultMutableTreeNode("karen290");
            
        root.add(defaultOne);
        root.add(defaultTwo);
        root.add(defaultThree);
        root.add(defaultFour);
        root.add(defaultFive);
        root.add(defaultSix);
        root.add(defaultSeven);
        root.add(defaultEight);
        root.add(defaultNine);

        JTree tree = new JTree(root);

        DefaultListModel<String> userListModel = new DefaultListModel<>();

        JLabel userIDLabel = new JLabel("UserID: No user added.");
        JLabel groupIDLabel = new JLabel("Group ID: No group added.");

        JButton addUserButton = createAddUserButton(tree, userIDLabel, groupIDLabel, userListModel);
        JButton addGroupButton = createAddGroupButton(tree, userIDLabel, groupIDLabel);
        JButton openUserView = createOpenUserViewButton(addUserButton, addGroupButton, userIDLabel, groupIDLabel, userListModel);

        JScrollPane treePane = new JScrollPane(tree);
        tree.setBackground(new Color(246, 195, 224));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane, createMainPanel(tree, addUserButton, addGroupButton, userIDLabel, groupIDLabel, openUserView));
        splitPane.setDividerLocation(frame.getWidth() / 4);

        frame.add(splitPane);
        frame.setVisible(true);
    }
}
    

