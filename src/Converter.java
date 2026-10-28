import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter extends JFrame implements ActionListener {


    JLabel titleLabel, amountLabel, Input, Output;
    JTextField amountTextField;
    JButton convertButton, quitButton;
    JPanel p1, p2, p3;
    String[] currencies = {"MAD", "Euros", "Dollars", "Pounds"};
    JList<String> inputList,outputList;
    double[] rates = {
            1.0,    // 1 MAD = 1 MAD
            11.0,   // 1 Euro = 11 MAD
            13.0,   // 1 Pound = 13 MAD
            10.0    // 1 Dollar = 10 MAD
    };
    public Converter() {


        setTitle("Converter");
        setSize(350, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        titleLabel = new JLabel("currency converter");
        amountLabel = new JLabel("Amount in DH:");

        amountTextField = new JTextField(10);

        Input = new JLabel("Amount : ");
        Output = new JLabel("Result : ");

        convertButton = new JButton("Convert");
        quitButton = new JButton("Quit");


        convertButton.addActionListener(this);
        quitButton.addActionListener(this);

        inputList = new JList<>(currencies);
        outputList = new JList<>(currencies);

        inputList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
        outputList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane inputScrollPane = new JScrollPane(inputList);
        JScrollPane outputScrollPane = new JScrollPane(outputList);

        inputList.setSelectedIndex(0);
        outputList.setSelectedIndex(1);



        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(3, 2, 30, 20));
        p3 = new JPanel(new GridLayout(1, 2, 20, 0));



        p1.add(titleLabel);

        p2.add(amountLabel);
        p2.add(amountTextField);
        p2.add(Input);
        p2.add(Output);

        p2.add(convertButton);
        p2.add(quitButton);

        p3.add(inputScrollPane);
        p3.add(outputScrollPane);

        setLayout(new BorderLayout(10, 10));

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
        add(p3, BorderLayout.CENTER);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == convertButton) {
            try {
                double amount = Double.parseDouble(amountTextField.getText());


                int EntryIndex = inputList.getSelectedIndex();
                int SortieIndex = outputList.getSelectedIndex();

                if (EntryIndex == -1 || SortieIndex == -1) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Please select the two currencies."
                    );
                    return;
                }


                double amountInMAD = amount * rates[EntryIndex];
                double result = amountInMAD / rates[SortieIndex];

                Input.setText(
                        "amount : " + amount + " "
                                + currencies[EntryIndex]
                );

                Output.setText(
                        String.format(
                                "Result : %.2f %s",
                                result,
                                currencies[SortieIndex]
                        )
                );

            } catch (NumberFormatException ex) {
                Input.setText("Amount  : invalid");
                Output.setText("Enter a valid number .");
            }

        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }



    public static void main(String[] args) {
        Converter C =  new Converter();
    }
}
