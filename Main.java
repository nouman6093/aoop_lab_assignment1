import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static Product[] products = new Product[5];

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Home Inventory System");
        frame1.setSize(600, 400);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(Color.darkGray);
        frame1.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);

        JButton button1 = new JButton("New");
        JButton button2 = new JButton("Remove");
        JButton button3 = new JButton("Browse");

        customizeButton(button1);
        customizeButton(button2);
        customizeButton(button3);

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        frame1.add(panel1, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBackground(Color.LIGHT_GRAY);

        JLabel productNameLabel = new JLabel("Product Name:");
        JTextField productNameField = new JTextField(20);

        JLabel locationLabel = new JLabel("Location:");
        String[] locations = {"Drying Room", "Bed Room", "Garage", "Living Room"};
        JComboBox<String> locationComboBox = new JComboBox<>(locations);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(20);

        JLabel datePurchasedLabel = new JLabel("Date Purchased:");
        JTextField datePurchasedField = new JTextField(20);

        JLabel noteLabel = new JLabel("Note:");
        JTextArea noteArea = new JTextArea(3, 20);
        JScrollPane noteScrollPane = new JScrollPane(noteArea);

        JButton saveButton = new JButton("Save");

        formPanel.add(productNameLabel);
        formPanel.add(productNameField);
        formPanel.add(locationLabel);
        formPanel.add(locationComboBox);
        formPanel.add(priceLabel);
        formPanel.add(priceField);
        formPanel.add(datePurchasedLabel);
        formPanel.add(datePurchasedField);
        formPanel.add(noteLabel);
        formPanel.add(noteScrollPane);
        formPanel.add(saveButton);

        frame1.add(formPanel, BorderLayout.CENTER);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < products.length; i++) {
                    if (products[i] == null) {
                        products[i] = new Product(
                                productNameField.getText(),
                                (String) locationComboBox.getSelectedItem(),
                                priceField.getText(),
                                datePurchasedField.getText(),
                                noteArea.getText()
                        );
                        break;
                    }
                }
                JOptionPane.showMessageDialog(frame1, "Product information saved successfully!");
            }
        });

        frame1.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                openFrame2(products);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                openFrame3(products);
            }
        });
    }

    public static void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
    }

    public static void openFrame2(Product[] products) {
        JFrame frame2 = new JFrame("Remove Product");
        frame2.setSize(600, 400);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().setBackground(Color.darkGray);
        frame2.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);

        JButton button1 = new JButton("New");
        JButton button2 = new JButton("Remove");
        JButton button3 = new JButton("Browse");

        customizeButton(button1);
        customizeButton(button2);
        customizeButton(button3);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        frame2.add(panel2, BorderLayout.NORTH);

        JComboBox<Product> productComboBox = new JComboBox<>(products);
        productComboBox.setPreferredSize(new Dimension(200, 30));

        JButton removeProductButton = new JButton("Remove Product");
        removeProductButton.setPreferredSize(new Dimension(150, 30));

        JPanel removePanel = new JPanel();
        removePanel.setBackground(Color.LIGHT_GRAY);
        removePanel.add(productComboBox);
        removePanel.add(removeProductButton);

        frame2.add(removePanel, BorderLayout.CENTER);

        removeProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product selectedProduct = (Product) productComboBox.getSelectedItem();
                for (int i = 0; i < products.length; i++) {
                    if (products[i] != null && products[i].equals(selectedProduct)) {
                        products[i] = null;
                        break;
                    }
                }
                JOptionPane.showMessageDialog(frame2, "Product removed successfully!");
                frame2.dispose();
                openFrame1();
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                openFrame1();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                openFrame3(products);
            }
        });

        frame2.setVisible(true);
    }

    public static void openFrame3(Product[] products) {
        JFrame frame3 = new JFrame("Browse");
        frame3.setSize(600, 400);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.getContentPane().setBackground(Color.darkGray);
        frame3.setLayout(new BorderLayout());

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.LIGHT_GRAY);

        JButton button1 = new JButton("New");
        JButton button2 = new JButton("Remove");
        JButton button3 = new JButton("Browse");

        customizeButton(button1);
        customizeButton(button2);
        customizeButton(button3);

        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);

        frame3.add(panel3, BorderLayout.NORTH);

        JComboBox<Product> productComboBox = new JComboBox<>(products);
        productComboBox.setPreferredSize(new Dimension(200, 30));

        JTextArea productDetailsArea = new JTextArea(10, 40);
        productDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productDetailsArea);

        JPanel browsePanel = new JPanel();
        browsePanel.setBackground(Color.LIGHT_GRAY);
        browsePanel.add(productComboBox);
        browsePanel.add(scrollPane);

        frame3.add(browsePanel, BorderLayout.CENTER);

        productComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product selectedProduct = (Product) productComboBox.getSelectedItem();
                String details = "Details for " + selectedProduct.name + ":\n";
                details += "Location: " + selectedProduct.location + "\n";
                details += "Price: " + selectedProduct.price + "\n";
                details += "Date Purchased: " + selectedProduct.datePurchased + "\n";
                details += "Note: " + selectedProduct.note + "\n";
                productDetailsArea.setText(details);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.dispose();
                openFrame1();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.dispose();
                openFrame2(products);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(true);
            }
        });

        frame3.setVisible(true);
    }

    public static void openFrame1() {
        JFrame frame1 = new JFrame("Home Inventory System");
        frame1.setSize(600, 400);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(Color.darkGray);
        frame1.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);

        JButton button1 = new JButton("New");
        JButton button2 = new JButton("Remove");
        JButton button3 = new JButton("Browse");

        customizeButton(button1);
        customizeButton(button2);
        customizeButton(button3);

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        frame1.add(panel1, BorderLayout.NORTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                openFrame2(new Product[0]);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                openFrame3(products);
            }
        });

        frame1.setVisible(true);
    }
}
