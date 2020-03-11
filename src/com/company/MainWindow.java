package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        super("Caesar cipher");
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
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


    private JTextField originalTextField = new JTextField();
    private JTextField morphedTextField  = new JTextField();
    private JComboBox<Integer> shift     = new JComboBox<>();
    private JLabel originalTextLabel     = new JLabel("Original text");
    private JLabel morphedTextLabel      = new JLabel();
    private JLabel shiftLabel            = new JLabel("Select shift");
    private JButton encryptButton        = new JButton("Encrypt");
    private JButton decryptButton        = new JButton("Decrypt");

    private final int WINDOW_WIDTH    = 550;
    private final int WINDOW_HEIGHT   = 300;
    private final int LABEL_WIDTH     = 90;
    private final int TEXTFIELD_WIDTH = 400;
    private final int BUTTON_WIDTH    = 165;


    private void setOriginalText() {
        originalTextLabel.setBounds(new Rectangle(10, 10, LABEL_WIDTH, 30));
        originalTextField.setBounds(new Rectangle(100, 10, TEXTFIELD_WIDTH, 30));
        add(originalTextLabel);
        add(originalTextField);
    }

    private void setMorphedText() {
        morphedTextLabel.setBounds(new Rectangle(10, 90, LABEL_WIDTH, 30));
        morphedTextField.setBounds(new Rectangle(100, 90, TEXTFIELD_WIDTH, 30));
        add(morphedTextLabel);
        add(morphedTextField);
    }

    private void setShift() {
        shift.setBounds(new Rectangle(100, 50, 50, 30));
        shiftLabel.setBounds(new Rectangle(10, 50, LABEL_WIDTH, 30));
        for (int i = 0; i < 26; i++) {
            shift.addItem(i);
        }
        shift.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_MINUS:
                        if (shift.getSelectedIndex() > 0) {
                            shift.setSelectedIndex(shift.getSelectedIndex() - 1);
                            break;
                        }
                    case KeyEvent.VK_EQUALS:
                        if (shift.getSelectedIndex() < 26) {
                            shift.setSelectedIndex(shift.getSelectedIndex() + 1);
                            break;
                        }
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        add(shiftLabel);
        add(shift);
    }

    private void setEncryptButton() {
        encryptButton.setBounds(new Rectangle(160, 50, BUTTON_WIDTH, 30));
        encryptButton.addActionListener(actionEvent -> {
            originalTextField.setText(originalTextField.getText().toUpperCase());
            if (MainLogic.isNumeric(String.valueOf(shift.getSelectedItem()))) {
                morphedTextField.setText(MainLogic.encryptText(originalTextField.getText(), Integer.parseInt(String.valueOf(shift.getSelectedItem()))));
                morphedTextLabel.setText("Encrypted text");
            }
            else {
                JOptionPane.showMessageDialog(null, "Enter integer in shift field");
            }
        });
        add(encryptButton);
    }

    private void setDecryptButton() {
        decryptButton.setBounds(new Rectangle(335, 50, BUTTON_WIDTH, 30));
        decryptButton.addActionListener(actionEvent -> {
            originalTextField.setText(originalTextField.getText().toUpperCase());
            if (MainLogic.isNumeric(String.valueOf(shift.getSelectedItem()))) {
                morphedTextField.setText(MainLogic.decryptText(originalTextField.getText(), Integer.parseInt(String.valueOf(shift.getSelectedItem()))));
                morphedTextLabel.setText("Decrypted text");
            }
            else {
                JOptionPane.showMessageDialog(null, "Enter integer in shift field");
            }
        });
        add(decryptButton);
    }

}

