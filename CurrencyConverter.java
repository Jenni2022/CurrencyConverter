import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class CurrencyConverter {
    public static void main(String[] args) {

        JFrame janela = new JFrame();
        
        janela.setTitle("Currency converter");
        janela.setSize(400, 250);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLayout(new GridLayout(4, 1));


        JLabel title = new JLabel("Conversor of value");
        title.setHorizontalAlignment(JLabel.CENTER);

        JTextField amount = new JTextField();

        JLabel currencyLabel = new JLabel("EUR -> BRL");
        currencyLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton reverseButton = new JButton("Reverse");
        JButton convertButton = new JButton("Convert");

        JPanel currencyPanel = new JPanel(new FlowLayout());
        currencyPanel.add(currencyLabel);
        currencyPanel.add(reverseButton);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(convertButton);

        final boolean[] eurToBrl = {true};

        reverseButton.addActionListener(e-> {
            eurToBrl[0] = !eurToBrl[0];

            if(eurToBrl[0]) {
                currencyLabel.setText("EUR -> BRL");            
            } else {
                currencyLabel.setText("BRL -> EUR");
            }
        });

        convertButton.addActionListener(e-> {
            try{
                double value = Double.parseDouble(
                    amount.getText().replace(",","."));
                    double result;

                    if(eurToBrl[0]){
                        result = value*6.0;                    
                    } else {
                        result = value/6.0;
                    }
                    
                    title.setText(String.format(java.util.Locale.US, "Result: %.2f %s", result, eurToBrl[0] ? "BRL" : "EUR"));
                    
            } catch (NumberFormatException ex) {
                title.setText("Please enter a valid amount!");
            }
        });

        convertButton.addActionListener(e-> {
            double value = Double.parseDouble(amount.getText());
            double result = value * 6.0;
            title.setText("Result: " + result + "BRL");
        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        panel.add(title);
        panel.add(amount);
        panel.add(convertButton);
        panel.add(currencyPanel);
        panel.add(buttonPanel);

        janela.add(panel);

        janela.setVisible(true);


    }

}
