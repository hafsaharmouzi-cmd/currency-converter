import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter extends JFrame implements ActionListener {


    JLabel titleLabel, amountLabel, Input, Output;
    JTextField amountTextField;
    JButton convertButton, quitButton;
    JPanel p1, p2, p3;


    public Converter() {


        setTitle("Converter");
        setSize(350, 250);
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

        // Création des panels
        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(3, 2, 30, 20));
        p3 = new JPanel();


        p1.add(titleLabel);

        p2.add(amountLabel);
        p2.add(amountTextField);
        p2.add(Input);
        p2.add(Output);

        p2.add(convertButton);
        p2.add(quitButton);


        setLayout(new BorderLayout(10, 10));

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);



        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == convertButton) {
            try {
                double amount = Double.parseDouble(amountTextField.getText());


                double result = amount / 11.0;

                Input.setText("Amount : " + amount + " DH");
                Output.setText(
                        String.format("Result : %.2f euros", result)
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
