package ui;

import service.UiLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserInterface extends JPanel implements ActionListener {

    private final int GAP = 5;
    private final int BTN_H = 40;    private final int BTN_W = 40;
    private final int DISPLAY_H = 50;

    private final int DISPLAY_W;

    private final Font font = new Font("Serif", Font.BOLD, 12);
    private final Font displayFont = new Font("Serif", Font.BOLD, 16);

    private final int top = 1;
    private final int left = 1;
    private final int bottom = 1;
    private final int right = 1;
    private final Insets buttonInsets = new Insets(top, left, bottom, right);

    private JTextField displayArea;
    private JButton mcBtn, mrBtn, msBtn, mPlusBtn, mMinusBtn;
    private JButton backspaceBtn, ceBtn, cBtn, toggleBtn, commaBtn, equalsBtn;
    private JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    private JButton rootBtn, divBtn, percBtn, mulBtn, divOneByXBtn, subBtn, addBtn;

    private final UiLogic logic;

    public UserInterface(final int width, final int height, final JFrame window) {
        this.DISPLAY_W = width - 2 * GAP;
        setLayout(null);
        window.addKeyListener(new KeyInput());
        initWindow();
        logic = new UiLogic(displayArea);
    }

    private void initWindow() {
        displayArea = new JTextField("");
        displayArea.setEnabled(false);
        displayArea.setBounds(GAP, GAP, DISPLAY_W, DISPLAY_H);
        displayArea.setFont(displayFont);
        displayArea.setForeground(Color.BLACK);
        add(displayArea);

        mcBtn = new JButton("MC");
        mcBtn.setActionCommand("memory_clear");
        mcBtn.setFont(font);
        mcBtn.setBounds(GAP, GAP * 2 + DISPLAY_H, BTN_W, BTN_H);
        mcBtn.setFocusable(false);
        mcBtn.setMargin(buttonInsets);
        mcBtn.addActionListener(this);
        add(mcBtn);

        mrBtn = new JButton("MR");
        mrBtn.setActionCommand("memory_show");
        mrBtn.setFont(font);
        mrBtn.setBounds(GAP * 2 + BTN_W, GAP * 2 + DISPLAY_H, BTN_W, BTN_H);
        mrBtn.setFocusable(false);
        mrBtn.setMargin(buttonInsets);
        mrBtn.addActionListener(this);
        add(mrBtn);

        msBtn = new JButton("MS");
        msBtn.setActionCommand("memory_save");
        msBtn.setFont(font);
        msBtn.setBounds(GAP * 3 + BTN_W * 2, GAP * 2 + DISPLAY_H, BTN_W, BTN_H);
        msBtn.setFocusable(false);
        msBtn.setMargin(buttonInsets);
        msBtn.addActionListener(this);
        add(msBtn);

        mPlusBtn = new JButton("M+");
        mPlusBtn.setActionCommand("memory_add");
        mPlusBtn.setFont(font);
        mPlusBtn.setBounds(GAP * 4 + BTN_W * 3, GAP * 2 + DISPLAY_H, BTN_W, BTN_H);
        mPlusBtn.setFocusable(false);
        mPlusBtn.setMargin(buttonInsets);
        mPlusBtn.addActionListener(this);
        add(mPlusBtn);

        mMinusBtn = new JButton("M-");
        mMinusBtn.setActionCommand("memory_subtract");
        mMinusBtn.setFont(font);
        mMinusBtn.setBounds(GAP * 5 + BTN_W * 4, GAP * 2 + DISPLAY_H, BTN_W, BTN_H);
        mMinusBtn.setFocusable(false);
        mMinusBtn.setMargin(buttonInsets);
        mMinusBtn.addActionListener(this);
        add(mMinusBtn);

        // SECOND ROW
        backspaceBtn = new JButton("←");
        backspaceBtn.setActionCommand("return");
        backspaceBtn.setFont(font);
        backspaceBtn.setBounds(GAP, GAP * 3 + DISPLAY_H + BTN_H, BTN_W, BTN_H);
        backspaceBtn.setFocusable(false);
        backspaceBtn.setMargin(buttonInsets);
        backspaceBtn.addActionListener(this);
        add(backspaceBtn);

        ceBtn = new JButton("CE");
        ceBtn.setActionCommand("clear_entry");
        ceBtn.setFont(font);
        ceBtn.setBounds(GAP * 2 + BTN_W, GAP * 3 + DISPLAY_H + BTN_H, BTN_W, BTN_H);
        ceBtn.setFocusable(false);
        ceBtn.setMargin(buttonInsets);
        ceBtn.addActionListener(this);
        add(ceBtn);

        cBtn = new JButton("C");
        cBtn.setActionCommand("clear_all");
        cBtn.setFont(font);
        cBtn.setBounds(GAP * 3 + BTN_W * 2, GAP * 3 + DISPLAY_H + BTN_H, BTN_W, BTN_H);
        cBtn.setFocusable(false);
        cBtn.setMargin(buttonInsets);
        cBtn.addActionListener(this);
        add(cBtn);

        toggleBtn = new JButton("+/-");
        toggleBtn.setActionCommand("toggle");
        toggleBtn.setFont(font);
        toggleBtn.setBounds(GAP * 4 + BTN_W * 3, GAP * 3 + DISPLAY_H + BTN_H, BTN_W, BTN_H);
        toggleBtn.setFocusable(false);
        toggleBtn.setMargin(buttonInsets);
        toggleBtn.addActionListener(this);
        add(toggleBtn);

        rootBtn = new JButton("√");
        rootBtn.setActionCommand("root");
        rootBtn.setFont(font);
        rootBtn.setBounds(GAP * 5 + BTN_W * 4, GAP * 3 + DISPLAY_H + BTN_H, BTN_W, BTN_H);
        rootBtn.setFocusable(false);
        rootBtn.setMargin(buttonInsets);
        rootBtn.addActionListener(this);
        add(rootBtn);

        // THIRD ROW
        num7 = new JButton("7");
        num7.setFont(font);
        num7.setBounds(GAP, GAP * 4 + DISPLAY_H + BTN_H * 2, BTN_W, BTN_H);
        num7.setFocusable(false);
        num7.setMargin(buttonInsets);
        num7.addActionListener(this);
        add(num7);

        num8 = new JButton("8");
        num8.setFont(font);
        num8.setBounds(GAP * 2 + BTN_W, GAP * 4 + DISPLAY_H + BTN_H * 2, BTN_W, BTN_H);
        num8.setFocusable(false);
        num8.setMargin(buttonInsets);
        num8.addActionListener(this);
        add(num8);

        num9 = new JButton("9");
        num9.setFont(font);
        num9.setBounds(GAP * 3 + BTN_W * 2, GAP * 4 + DISPLAY_H + BTN_H * 2, BTN_W, BTN_H);
        num9.setFocusable(false);
        num9.setMargin(buttonInsets);
        num9.addActionListener(this);
        add(num9);

        divBtn = new JButton("/");
        divBtn.setActionCommand("divide");
        divBtn.setFont(font);
        divBtn.setBounds(GAP * 4 + BTN_W * 3, GAP * 4 + DISPLAY_H + BTN_H * 2, BTN_W, BTN_H);
        divBtn.setFocusable(false);
        divBtn.setMargin(buttonInsets);
        divBtn.addActionListener(this);
        add(divBtn);

        percBtn = new JButton("%");
        percBtn.setActionCommand("percent");
        percBtn.setFont(font);
        percBtn.setBounds(GAP * 5 + BTN_W * 4, GAP * 4 + DISPLAY_H + BTN_H * 2, BTN_W, BTN_H);
        percBtn.setFocusable(false);
        percBtn.setMargin(buttonInsets);
        percBtn.addActionListener(this);
        add(percBtn);

        // FOURTH ROW
        num4 = new JButton("4");
        num4.setFont(font);
        num4.setBounds(GAP, GAP * 5 + DISPLAY_H + BTN_H * 3, BTN_W, BTN_H);
        num4.setFocusable(false);
        num4.setMargin(buttonInsets);
        num4.addActionListener(this);
        add(num4);

        num5 = new JButton("5");
        num5.setFont(font);
        num5.setBounds(GAP * 2 + BTN_W, GAP * 5 + DISPLAY_H + BTN_H * 3, BTN_W, BTN_H);
        num5.setFocusable(false);
        num5.setMargin(buttonInsets);
        num5.addActionListener(this);
        add(num5);

        num6 = new JButton("6");
        num6.setFont(font);
        num6.setBounds(GAP * 3 + BTN_W * 2, GAP * 5 + DISPLAY_H + BTN_H * 3, BTN_W, BTN_H);
        num6.setFocusable(false);
        num6.setMargin(buttonInsets);
        num6.addActionListener(this);
        add(num6);

        mulBtn = new JButton("*");
        mulBtn.setActionCommand("multiply");
        mulBtn.setFont(font);
        mulBtn.setBounds(GAP * 4 + BTN_W * 3, GAP * 5 + DISPLAY_H + BTN_H * 3, BTN_W, BTN_H);
        mulBtn.setFocusable(false);
        mulBtn.setMargin(buttonInsets);
        mulBtn.addActionListener(this);
        add(mulBtn);

        divOneByXBtn = new JButton("1/x");
        divOneByXBtn.setActionCommand("one_divide_by_x");
        divOneByXBtn.setFont(font);
        divOneByXBtn.setBounds(GAP * 5 + BTN_W * 4, GAP * 5 + DISPLAY_H + BTN_H * 3, BTN_W, BTN_H);
        divOneByXBtn.setFocusable(false);
        divOneByXBtn.setMargin(buttonInsets);
        divOneByXBtn.addActionListener(this);
        add(divOneByXBtn);

        // FIFTH ROW
        num1 = new JButton("1");
        num1.setFont(font);
        num1.setBounds(GAP, GAP * 6 + DISPLAY_H + BTN_H * 4, BTN_W, BTN_H);
        num1.setFocusable(false);
        num1.setMargin(buttonInsets);
        num1.addActionListener(this);
        add(num1);

        num2 = new JButton("2");
        num2.setFont(font);
        num2.setBounds(GAP * 2 + BTN_W, GAP * 6 + DISPLAY_H + BTN_H * 4, BTN_W, BTN_H);
        num2.setFocusable(false);
        num2.setMargin(buttonInsets);
        num2.addActionListener(this);
        add(num2);

        num3 = new JButton("3");
        num3.setFont(font);
        num3.setBounds(GAP * 3 + BTN_W * 2, GAP * 6 + DISPLAY_H + BTN_H * 4, BTN_W, BTN_H);
        num3.setFocusable(false);
        num3.setMargin(buttonInsets);
        num3.addActionListener(this);
        add(num3);

        subBtn = new JButton("-");
        subBtn.setActionCommand("subtract");
        subBtn.setFont(font);
        subBtn.setBounds(GAP * 4 + BTN_W * 3, GAP * 6 + DISPLAY_H + BTN_H * 4, BTN_W, BTN_H);
        subBtn.setFocusable(false);
        subBtn.setMargin(buttonInsets);
        subBtn.addActionListener(this);
        add(subBtn);

        equalsBtn = new JButton("=");
        equalsBtn.setActionCommand("equals");
        equalsBtn.setFont(font);
        equalsBtn.setBounds(GAP * 5 + BTN_W * 4, GAP * 6 + DISPLAY_H + BTN_H * 4, BTN_W, BTN_H * 2 + GAP);
        equalsBtn.setFocusable(false);
        equalsBtn.setMargin(buttonInsets);
        equalsBtn.addActionListener(this);
        add(equalsBtn);

        // SIXTH ROW
        num0 = new JButton("0");
        num0.setFont(font);
        num0.setBounds(GAP, GAP * 7 + DISPLAY_H + BTN_H * 5, BTN_W * 2 + GAP, BTN_H);
        num0.setFocusable(false);
        num0.setMargin(buttonInsets);
        num0.addActionListener(this);
        add(num0);

        commaBtn = new JButton(",");
        commaBtn.setActionCommand("comma");
        commaBtn.setFont(font);
        commaBtn.setBounds(GAP * 3 + BTN_W * 2, GAP * 7 + DISPLAY_H + BTN_H * 5, BTN_W, BTN_H);
        commaBtn.setFocusable(false);
        commaBtn.setMargin(buttonInsets);
        commaBtn.addActionListener(this);
        add(commaBtn);

        addBtn = new JButton("+");
        addBtn.setActionCommand("add");
        addBtn.setFont(font);
        addBtn.setBounds(GAP * 4 + BTN_W * 3, GAP * 7 + DISPLAY_H + BTN_H * 5, BTN_W, BTN_H);
        addBtn.setFocusable(false);
        addBtn.setMargin(buttonInsets);
        addBtn.addActionListener(this);
        add(addBtn);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        String command = e.getActionCommand();
        logic.uiLogic(command);
    }

    class KeyInput extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent e) {
            super.keyPressed(e);
            char k = e.getKeyChar();
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_BACK_SPACE) {
                logic.uiLogic("return");
            } else if (code == KeyEvent.VK_COMMA || code == KeyEvent.VK_PERIOD || code == 110) {
                logic.uiLogic("comma");
            } else if (code == KeyEvent.VK_ADD) {
                logic.uiLogic("add");
            } else if (code == KeyEvent.VK_SUBTRACT) {
                logic.uiLogic("subtract");
            } else if (code == KeyEvent.VK_MULTIPLY) {
                logic.uiLogic("multiply");
            } else if (code == KeyEvent.VK_DIVIDE || code == 47) {
                logic.uiLogic("divide");
            } else if (code == KeyEvent.VK_ENTER || code == 61) {
                logic.uiLogic("equals");
            } else if (code == KeyEvent.VK_DELETE) {
                logic.uiLogic("clear_all");
            }else if (code == KeyEvent.VK_HOME) {
                logic.uiLogic("clear_entry");
            } else if (code == 92) {
                logic.uiLogic("root");
            } else if (code == 45) {
                logic.uiLogic("toggle");
            }else if (code == KeyEvent.VK_P) {
                logic.uiLogic("percent");
            }else if (code == KeyEvent.VK_X) {
                logic.uiLogic("one_divide_by_x");
            }else if (code == KeyEvent.VK_Q) {
                logic.uiLogic("memory_clear");
            }else if (code == KeyEvent.VK_W) {
                logic.uiLogic("memory_show");
            }else if (code == KeyEvent.VK_E) {
                logic.uiLogic("memory_save");
            }else if (code == KeyEvent.VK_R) {
                logic.uiLogic("memory_add");
            }else if (code == KeyEvent.VK_T) {
                logic.uiLogic("memory_subtract");
            } else {
                logic.uiLogic(String.valueOf(k));
            }
        }
    }
}
