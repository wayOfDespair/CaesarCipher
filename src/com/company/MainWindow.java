package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        super("Caesar cipher");
        setSize(new Dimension(600, 400));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setOriginalText();
        setMorphedText();
        setShift();
        setEncryptButton();
        setDecryptButton();
        setVisible(true);
    }

    private JTextField originalText = new JTextField();
    private JTextField morphedText = new JTextField();
    private JTextField shift = new JTextField();
    private JButton encryptButton = new JButton("Encrypt");
    private JButton decryptButton = new JButton("Decrypt");

    private void setOriginalText() {
        originalText.setBounds(new Rectangle(10, 10, 500, 30));
        add(originalText);
    }

    private void setMorphedText() {
        morphedText.setBounds(new Rectangle(10, 90, 500, 30));
        add(morphedText);
    }

    private void setShift() {
        shift.setBounds(new Rectangle(10, 50, 100, 30));
        shift.setText(String.valueOf(0));
        add(shift);
    }

    private void setEncryptButton() {
        encryptButton.setBounds(new Rectangle(210, 50, 100, 30));
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                originalText.setText(originalText.getText().toUpperCase());
                if (isNumeric(shift.getText())) {
                    morphedText.setText(encryptText(originalText.getText(), Integer.parseInt(shift.getText())));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Enter integer in shift field");
                }
            }
        });
        add(encryptButton);
    }

    private void setDecryptButton() {
        decryptButton.setBounds(new Rectangle(320, 50, 100, 30));
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                originalText.setText(originalText.getText().toUpperCase());
                if (isNumeric(shift.getText())) {
                    morphedText.setText(decryptText(originalText.getText(), Integer.parseInt(shift.getText())));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Enter integer in shift field");
                }
            }
        });
        add(decryptButton);
    }

    private String encryptText(String text, int shift) {
        char[] origText = text.toUpperCase().toCharArray();
        for (int i = 0; i < origText.length; i++) {
            if (origText[i] < 91 - shift) origText[i] += shift;
            else origText[i] = (char) (origText[i] - 25 + shift - 1);

        }
        return String.valueOf(origText);
    }

    private String decryptText(String text, int shift) {
        char[] origText = text.toUpperCase().toCharArray();
        for (int i = 0; i < origText.length; i++) {
            if (origText[i] > 64 + shift) {
                origText[i] -= shift;
            }
            else origText[i] = (char) (origText[i] + 25 - shift + 1);
        }
        return String.valueOf(origText);
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}

