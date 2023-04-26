package choreotype;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class GUI {
    private JFrame frame;
    private JTable userTable;
    private JTable choreTable;

    public GUI() {
        createGUI();
    }

    public void createGUI() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Choreotype");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(900, 600));

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        frame.add(mainPanel);

        JPanel userPanel = new JPanel(new BorderLayout());
        mainPanel.add(userPanel);

        userTable = new JTable(new DefaultTableModel(new Object[]{"ID", "Username", "Role"}, 0));
        JScrollPane userScrollPane = new JScrollPane(userTable);
        userPanel.add(userScrollPane, BorderLayout.CENTER);

        JPanel chorePanel = new JPanel(new BorderLayout());
        mainPanel.add(chorePanel);

        choreTable = new JTable(new DefaultTableModel(new Object[]{"ID", "Name", "Description", "Assigned To", "Completed"}, 0));
        JScrollPane choreScrollPane = new JScrollPane(choreTable);
        chorePanel.add(choreScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        chorePanel.add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add");
        buttonPanel.add(addButton);

        JButton editButton = new JButton("Edit");
        buttonPanel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(deleteButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}