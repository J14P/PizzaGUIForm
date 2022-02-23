import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class PizzaGUIFrame extends JFrame {
    JFrame frame;
    JPanel mainPnl;
    JPanel crustType;
    JPanel size;
    JPanel toppings;
    JPanel order;
    JPanel bottomPnl;

    JComboBox comboBox;

    JRadioButton thinBtn;
    JRadioButton regularBtn;
    JRadioButton deepDishBtn;

    JCheckBox pepperoniChkbox;
    JCheckBox sausageChkbox;
    JCheckBox hamChkbox;
    JCheckBox pineappleChkbox;
    JCheckBox olivesChkbox;
    JCheckBox baconChkbox;

    JTextArea orderTa;

    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;

    JOptionPane quitOpane;

    ButtonGroup group;

    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        createCrustType();
        mainPnl.add(crustType, gbc);

        createSize();
        mainPnl.add(size, gbc);

        createToppings();
        mainPnl.add(toppings, gbc);

        createOrder();
        mainPnl.add(order, gbc);

        createBottomPnl();
        mainPnl.add(bottomPnl, gbc);

        add(mainPnl);
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createCrustType()
    {
        crustType = new JPanel();
        crustType.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));

        thinBtn = new JRadioButton();
        regularBtn = new JRadioButton();
        deepDishBtn = new JRadioButton();

        thinBtn.setText("Thin Crust");
        thinBtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        regularBtn.setText("Regular Crust");
        regularBtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        deepDishBtn.setText("Deep Dish Crust");
        deepDishBtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        group = new ButtonGroup();
        group.add(thinBtn);
        group.add(regularBtn);
        group.add(deepDishBtn);

        thinBtn.setSelected(true);
        regularBtn.setSelected(false);
        deepDishBtn.setSelected(false);

        crustType.add(thinBtn);
        crustType.add(regularBtn);
        crustType.add(deepDishBtn);
    }

    private void createSize()
    {
        size = new JPanel();
        size.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        String[] sizes = { "Small", "Medium", "Large", "Super" };

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        comboBox = new JComboBox(sizes);
        comboBox.setSelectedIndex(0);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        comboBox.setPrototypeDisplayValue("AaAaAaAaAaAaAaAaAa");
        comboBox.setRenderer(listRenderer);
        size.add(comboBox, BorderLayout.CENTER);
    }

    private void createToppings()
    {
        toppings = new JPanel();
        toppings.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

        pepperoniChkbox = new JCheckBox();
        sausageChkbox = new JCheckBox();
        hamChkbox = new JCheckBox();
        pineappleChkbox = new JCheckBox();
        olivesChkbox = new JCheckBox();
        baconChkbox = new JCheckBox();

        pepperoniChkbox.setText("Pepperoni");
        sausageChkbox.setText("Sausage");
        hamChkbox.setText("Ham");
        pineappleChkbox.setText("Pineapple");
        olivesChkbox.setText("Olives");
        baconChkbox.setText("Bacon");
        pepperoniChkbox.setFont(new Font("Courier", Font.PLAIN, 30));
        sausageChkbox.setFont(new Font("Courier", Font.PLAIN, 30));
        hamChkbox.setFont(new Font("Courier", Font.PLAIN, 30));
        pineappleChkbox.setFont(new Font("Courier", Font.PLAIN, 30));
        olivesChkbox.setFont(new Font("Courier", Font.PLAIN, 30));
        baconChkbox.setFont(new Font("Courier", Font.PLAIN, 30));

        pepperoniChkbox.setSelected(false);
        sausageChkbox.setSelected(false);
        hamChkbox.setSelected(false);
        pineappleChkbox.setSelected(false);
        olivesChkbox.setSelected(false);
        baconChkbox.setSelected(false);

        toppings.add(pepperoniChkbox);
        toppings.add(sausageChkbox);
        toppings.add(hamChkbox);
        toppings.add(pineappleChkbox);
        toppings.add(olivesChkbox);
        toppings.add(baconChkbox);
    }

    private void createOrder()
    {
        order = new JPanel();
        order.setBorder(new TitledBorder(new EtchedBorder(), "Order"));

        orderTa = new JTextArea();
        orderTa.setFont(new Font("Arial", Font.ITALIC, 16));

        order.add(orderTa, BorderLayout.CENTER);
    }

    private void getOrder()
    {
        String selectedCrust = "";
        String selectedSize = "";
        String toppings = "Cheese";
        double totalPrice = 0.00;
        double toppingsPrice = 0.00;
        double sizePrice = 0.00;

        if (thinBtn.isSelected() == true)
        {
            selectedCrust = "Thin";
        }
        else if (regularBtn.isSelected() == true)
        {
            selectedCrust = "Regular";
        }
        else
        {
            selectedCrust = "Deep Dish";
        }

        selectedSize = (String)comboBox.getSelectedItem();
        switch(selectedSize)
        {
            case "Small":
                sizePrice = 8.00;
                break;
            case "Medium":
                sizePrice = 12.00;
                break;
            case "Large":
                sizePrice = 16.00;
                break;
            case "Super":
                sizePrice = 20.00;
                break;
            default:
                sizePrice = 0.00;
        }

        if (pepperoniChkbox.isSelected() == true)
        {
            toppings += ", Pepperoni";
        }

        if (sausageChkbox.isSelected() == true)
        {
            toppings += ", Sausage";
        }

        if (hamChkbox.isSelected() == true)
        {
            toppings += ", Ham";
        }

        if (pineappleChkbox.isSelected() == true)
        {
            toppings += ", Pineapple";
        }

        if (olivesChkbox.isSelected() == true)
        {
            toppings += ", Olives";
        }

        if (baconChkbox.isSelected() == true)
        {
            toppings += ", Bacon";
        }

        if (pepperoniChkbox.isSelected() == true)
        {
            toppingsPrice += 1.00;
        }

        if (sausageChkbox.isSelected() == true)
        {
            toppingsPrice += 1.00;
        }

        if (hamChkbox.isSelected() == true)
        {
            toppingsPrice += 1.00;
        }

        if (pineappleChkbox.isSelected() == true)
        {
            toppingsPrice += 1.00;
        }

        if (olivesChkbox.isSelected() == true)
        {
            toppingsPrice += 1.00;
        }

        if (baconChkbox.isSelected() == true)
        {
            toppingsPrice += 1.00;
        }

        orderTa.setText("=========================================================\n" + selectedCrust + ", " + selectedSize + "\t\t\t\t" + String.format("$%.2f", sizePrice) + "\n" + toppings + "\t\t" +
                String.format("$%.2f", toppingsPrice) + "\n\n" + "Sub-total:" + "\t\t\t\t" + String.format("$%.2f", totalPrice) + "\nTax:\t\t\t\t" +
                String.format("$%.2f", (totalPrice * .07)) + "\n-------------------------------------------------------------------------------------------------------\nTotal:\t\t\t\t" + String.format("$%.2f", totalPrice + (totalPrice * 0.07)) + "\n=========================================================");
        //orderTa.setText("Your order is 1 " + selectedSize + " with crust type: " + selectedCrust + " with topping(s): Cheese" + toppings + ".");
    }

    private void createBottomPnl()
    {
        bottomPnl = new JPanel();
        bottomPnl.setBorder(new TitledBorder(new EtchedBorder(), "Controls"));

        orderBtn = new JButton();
        orderBtn.addActionListener((ActionEvent ae) -> {getOrder();});

        clearBtn = new JButton();
        clearBtn.addActionListener((ActionEvent ae1) ->
        {
            thinBtn.setSelected(true);
            regularBtn.setSelected(false);
            deepDishBtn.setSelected(false);
            pepperoniChkbox.setSelected(false);
            sausageChkbox.setSelected(false);
            hamChkbox.setSelected(false);
            pineappleChkbox.setSelected(false);
            olivesChkbox.setSelected(false);
            baconChkbox.setSelected(false);
            orderTa.setText("");
        });

        quitBtn = new JButton();
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            quitOpane = new JOptionPane();
            int result = JOptionPane.showConfirmDialog(frame, "Do you want to quit?");
            switch (result)
            {
                case JOptionPane.YES_OPTION:
                    System.exit(0);
            }
        });

        orderBtn.setText("Order");
        orderBtn.setFont(new Font("Comic Sans", Font.BOLD, 36));
        clearBtn.setText("Clear");
        clearBtn.setFont(new Font("Comic Sans", Font.BOLD, 36));
        quitBtn.setText("Quit");
        quitBtn.setFont(new Font("Comic Sans", Font.BOLD, 36));

        bottomPnl.add(orderBtn, BorderLayout.CENTER);
        bottomPnl.add(clearBtn, BorderLayout.CENTER);
        bottomPnl.add(quitBtn, BorderLayout.CENTER);
    }
}
