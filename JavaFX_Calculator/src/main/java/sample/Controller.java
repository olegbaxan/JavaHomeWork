package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.TouchEvent;

public class Controller {
    @FXML
    String operType = "";
    private Double doubleFirstNumber = 0.0;
    private Boolean counter = false, pressEqual = false, isNegativ = false;

    //
    @FXML
    private TextField enteredAndResultTxtField;

    @FXML
    private TextField allEnteredButtonsTxtField;

    @FXML
    private Button equalBtn;

    @FXML
    void pressPlus(ActionEvent event) {
        if (!pressEqual) {
            allEnteredButtonsTxtField.setText(allEnteredButtonsTxtField.getText() + enteredAndResultTxtField.getText() + "+");
            doubleFirstNumber = doubleFirstNumber + Double.parseDouble(enteredAndResultTxtField.getText());
            enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
        } else {
            allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText() + "+");
            doubleFirstNumber = Double.parseDouble(enteredAndResultTxtField.getText());
            pressEqual = false;
        }
        counter = false;

        operType = "+";
    }

    @FXML
    void pressEight(ActionEvent event) {
        equalBtn.setDisable(false);

        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("8");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "8");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "8");
            counter = true;
        }
    }

    @FXML
    void pressFive(ActionEvent event) {
        equalBtn.setDisable(false);

        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("5");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "5");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "5");
            counter = true;
        }
    }

    @FXML
    void pressEqual(ActionEvent event) {
        allEnteredButtonsTxtField.setText(allEnteredButtonsTxtField.getText() + enteredAndResultTxtField.getText() + "=");
        equalBtn.setDisable(true);
        switch (operType) {
            case "+": {
                doubleFirstNumber = doubleFirstNumber + (Double.parseDouble(enteredAndResultTxtField.getText()));
                enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));

                counter = false;
                pressEqual = true;
                break;
            }

            case "-": {
                doubleFirstNumber = doubleFirstNumber - (Double.parseDouble(enteredAndResultTxtField.getText()));
                enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
                counter = false;
                pressEqual = true;
                break;
            }

            case "*": {
                doubleFirstNumber = doubleFirstNumber * (Double.parseDouble(enteredAndResultTxtField.getText()));
                enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
                counter = false;
                pressEqual = true;
                break;
            }

            case "/": {
                doubleFirstNumber = doubleFirstNumber / (Double.parseDouble(enteredAndResultTxtField.getText()));
                enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));

                counter = false;
                pressEqual = true;
                break;
            }
            case "^": {
                doubleFirstNumber = Math.pow(doubleFirstNumber, (Double.parseDouble(enteredAndResultTxtField.getText())));
                enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
                counter = false;
                pressEqual = true;
                break;
            }
        }
    }

    @FXML
    void pressMinus(ActionEvent event) {
        if (!pressEqual) {
            allEnteredButtonsTxtField.setText(allEnteredButtonsTxtField.getText() + enteredAndResultTxtField.getText() + "-");
            doubleFirstNumber = doubleFirstNumber + Double.parseDouble(enteredAndResultTxtField.getText());
            enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
        } else {
            allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText() + "-");
            doubleFirstNumber = Double.parseDouble(enteredAndResultTxtField.getText());
            pressEqual = false;
        }
        counter = false;
        operType = "-";

    }

    @FXML
    void pressMultiply(ActionEvent event) {
        if (!pressEqual) {
            allEnteredButtonsTxtField.setText(allEnteredButtonsTxtField.getText() + enteredAndResultTxtField.getText() + "*");
            doubleFirstNumber = doubleFirstNumber + Double.parseDouble(enteredAndResultTxtField.getText());
            enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
        } else {
            allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText() + "*");
            doubleFirstNumber = Double.parseDouble(enteredAndResultTxtField.getText());
            pressEqual = false;
        }
        counter = false;
        operType = "*";
    }

    @FXML
    void pressDivide(ActionEvent event) {
        if (!pressEqual) {
            allEnteredButtonsTxtField.setText(allEnteredButtonsTxtField.getText() + enteredAndResultTxtField.getText() + "/");
            doubleFirstNumber = doubleFirstNumber + Double.parseDouble(enteredAndResultTxtField.getText());
            enteredAndResultTxtField.setText(!doubleFirstNumber.toString().matches("(.*).0") ? doubleFirstNumber.toString() : doubleFirstNumber.toString().replaceAll("(.0)", ""));
        } else {
            allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText() + "/");
            doubleFirstNumber = Double.parseDouble(enteredAndResultTxtField.getText());
            pressEqual = false;
        }
        counter = false;
        operType = "/";
    }

    @FXML
    void pressFour(ActionEvent event) {
        equalBtn.setDisable(false);

        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("4");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "4");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "4");
            counter = true;
        }
        pressEqual = false;
    }

    @FXML
    void pressNine(ActionEvent event) {
        equalBtn.setDisable(false);
        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("9");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "9");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "9");
            counter = true;
        }
    }

    @FXML
    void pressOne(ActionEvent event) {
        equalBtn.setDisable(false);

        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("1");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "1");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "1");
            counter = true;
        }
    }

    @FXML
    void pressSeven(ActionEvent event) {
        equalBtn.setDisable(false);

        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("7");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "7");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "7");
            counter = true;
        }
    }

    @FXML
    void pressSix(ActionEvent event) {
        equalBtn.setDisable(false);
        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("6");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "6");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "6");
            counter = true;
        }
    }

    @FXML
    void pressThree(ActionEvent event) {
        equalBtn.setDisable(false);
        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("3");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "3");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "3");
            counter = true;
        }
    }

    @FXML
    void pressTwo(ActionEvent event) {
        equalBtn.setDisable(false);
        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("2");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "2");
            }
        } else {
            enteredAndResultTxtField.setText("");
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "2");
            counter = true;
        }
    }

    @FXML
    void pressZero(ActionEvent event) {
        equalBtn.setDisable(false);
        System.out.println("Counter =" + counter);
        if (counter) {
            if (pressEqual) {
                allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText());
                enteredAndResultTxtField.setText("0");
                counter = false;
            } else {
                enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "0");
            }
        }
    }

    @FXML
    void cleanEnteredTxt(ActionEvent event) {
        enteredAndResultTxtField.setText("");
        counter = false;

    }

    @FXML
    void useDoubleNumbersTxtField(ActionEvent event) {
        System.out.println("=" + pressEqual + ", text=" + enteredAndResultTxtField.getText());
        if (enteredAndResultTxtField.getText().isEmpty() || pressEqual) {
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + "0.");
            pressEqual = false;
            counter = true;
        } else if (!enteredAndResultTxtField.getText().isEmpty()) {
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText() + ".");
        }

    }

    @FXML
    void calculateSqrtXofY(ActionEvent event) {
        allEnteredButtonsTxtField.setText("sqrt(" + enteredAndResultTxtField.getText() + ")");
        doubleFirstNumber = Math.sqrt(Double.parseDouble(enteredAndResultTxtField.getText()));
        enteredAndResultTxtField.setText(String.valueOf(doubleFirstNumber));
        pressEqual = true;
    }

    @FXML
    void calculateXpowY(ActionEvent event) {
        doubleFirstNumber = Double.valueOf(enteredAndResultTxtField.getText());
        allEnteredButtonsTxtField.setText(enteredAndResultTxtField.getText() + "^");
        operType = "^";
        counter = false;
    }

    @FXML
    void negateNumber(ActionEvent event) {
        if (!isNegativ) {
            enteredAndResultTxtField.setText("-" + enteredAndResultTxtField.getText());
            isNegativ = true;
        } else {
            enteredAndResultTxtField.setText(enteredAndResultTxtField.getText().replaceAll("(-)", ""));
            isNegativ = false;
        }
    }


//    public static Integer calculateOperations(String operType, Integer number1, Integer number2) {
//        Integer intResult;
//        switch (operType) {
//            case "+": {
//                intResult = number1 + number2;
//                break;
//            }
//
//            case "-": {
//                intResult = number1 - number2;
//                break;
//            }
//
//            case "*": {
//                intResult = number1 * number2;
//                break;
//            }
//
//            case "/": {
//                intResult = number1 / number2;
//                break;
//            }
//            default:
//                intResult = 0;
//        }
//        return intResult;
//    }
//
//    public static Double calculateOperations(String operType, Double number1, Double number2) {
//        Double doubleResult;
//        switch (operType) {
//            case "+": {
//                doubleResult = number1 + number2;
//                break;
//            }
//
//            case "-": {
//                doubleResult = number1 - number2;
//                break;
//            }
//
//            case "*": {
//                doubleResult = number1 * number2;
//                break;
//            }
//
//            case "/": {
//                doubleResult = number1 / number2;
//                break;
//            }
//            default:
//                doubleResult = 0.0;
//        }
//        return doubleResult;
//    }

}
