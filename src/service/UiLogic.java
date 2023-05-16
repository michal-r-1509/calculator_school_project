package service;

import javax.swing.*;

public class UiLogic {

    private final JTextField displayArea;

    private final CalcService service = new CalcService();
    private StringBuilder number = new StringBuilder();
    private String command = null;
    private boolean hasResult = true;

    public UiLogic(final JTextField displayArea) {
        this.displayArea = displayArea;
    }

    public void uiLogic(final String command) {
        if (command.matches("[0-9]")) {
            service.clearB();
            if (hasResult) {
                clearNumber();
                setHasResult(false);
            }
            if (command.equals("0") && number.length() < 2 &&
                    ((number.toString().contains("-") && number.indexOf("0") == 1) ||
                            (number.toString().indexOf("0") == 0))) {
                return;
            }
            if (!command.equals("0") && !number.toString().contains(".") &&
                    (number.toString().indexOf("0") == 0 ||
                            (number.toString().contains("-") && number.indexOf("0") == 1))) {
                number.replace(0, 1, command);
                displayArea.setText(number.toString());
                return;
            }
            number.append(command);
            displayArea.setText(number.toString());
        } else if (command.equals("comma") && !number.toString().contains(".")) {
            if (number.length() < 1) {
                number.append("0");
            }
            number.append(".");
            displayArea.setText(number.toString());
        } else if (command.equals("toggle")) {
            if (number.length() == 0) {
                return;
            }
            double toToggle = Double.parseDouble(number.toString());
            toToggle = toToggle * (-1);
            clearNumber();
            number.append(stringValidation(String.valueOf(toToggle)));
            displayArea.setText(number.toString());
        } else if (command.equals("return") && number.length() > 0) {
            if (hasResult) {
                clearNumber();
                clearDisplay();
                setHasResult(false);
                return;
            }
            if (number.toString().contains("-") && number.length() == 2) {
                clearNumber();
            } else {
                number.deleteCharAt(number.length() - 1);
            }
            displayArea.setText(number.toString());
        } else if (command.equals("memory_clear")) {
            service.clearMemory();
        } else if (command.equals("memory_show")) {
            displayArea.setText(stringValidation(service.getMemory()));
            clearNumber();
        } else if (command.equals("memory_save")) {
            numberValidation();
            service.setMemory(number.toString());
            clearNumber();
        } else if (command.equals("memory_add")) {
            numberValidation();
            service.addToMemory(number.toString());
            clearNumber();
        } else if (command.equals("memory_subtract")) {
            numberValidation();
            service.subFromMemory(number.toString());
            clearNumber();
        } else if (command.equals("clear_entry")) {
            clearNumber();
            clearDisplay();
//            clearCommand();
        } else if (command.equals("clear_all")) {
            clearNumber();
            clearDisplay();
            clearCommand();
            service.clearAB();
        } else if (command.equals("root")) {
            numberValidation();
            String root = service.root(number.toString());
            clearNumber();
            number.append(stringValidation(root));
            displayArea.setText(number.toString());
            setHasResult(true);
            numberValidation();
            service.setA(number.toString());
//            clearNumber();
        } else if (command.equals("one_divide_by_x")) {
            numberValidation();
            String x = service.oneByX(number.toString());
            clearNumber();
            number.append(stringValidation(x));
            displayArea.setText(number.toString());
            setHasResult(true);
            numberValidation();
            service.setA(number.toString());
//            clearNumber();
        } else if (command.matches("divide|multiply|subtract|add")) {
            if (this.command == null) {
                numberValidation();
                service.setA(number.toString());
            } else {
                numberValidation();
                service.setA(number.toString());
            }
            this.command = command;
            clearNumber();
        } else if (command.equals("equals") && this.command != null && number.length() > 0) {
            String result;
            if (hasResult) {
                result = service.calculate(this.command);
            } else {
                numberValidation();
                service.setB(number.toString());
                result = service.calculate(this.command);
            }
            service.setA(result);
            clearNumber();
            number.append(stringValidation(result));
            displayArea.setText(number.toString());
//            clearCommand();
//            clearNumber();
//            service.clearAB();
            setHasResult(true);
        } else if (command.equals("percent")) {
            numberValidation();
            service.setB(number.toString());
            String result = service.calculatePercent();
            clearNumber();
            number.append(stringValidation(result));
            displayArea.setText(number.toString());
            clearCommand();
//            clearNumber();
//            service.clearAB();
            numberValidation();
            service.setA(number.toString());
            service.clearB();
            setHasResult(true);
        }
    }

    private void numberValidation() {
        String toValidate = number.toString();
        if (toValidate.isBlank() || toValidate.contains("a")) {
            clearNumber();
            this.number.append("0.0");
        }
        if (toValidate.endsWith(".")) {
            String temp = toValidate.substring(0, toValidate.length() - 1);
            clearNumber();
            this.number.append(temp);
        }
    }

    private String stringValidation(final String toValidate) {
        if (toValidate.matches("-?\\d+.0+$")) {
            int index = toValidate.indexOf('.');
            if (index < 0) {
                return toValidate;
            }
            return toValidate.substring(0, index);
        } else {
            return toValidate;
        }
    }

    private void clearNumber() {
        number.setLength(0);
    }

    private void clearDisplay() {
        displayArea.setText("0");
    }

    private void clearCommand() {
        this.command = null;
    }

    private void setHasResult(boolean hasResult) {
        this.hasResult = hasResult;
    }
}
