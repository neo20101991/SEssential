package com.example.neo.sessential;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends Activity {

    private TextView txtCalc ;
    private Button btnZero ;
    private Button btnOne ;
    private Button btnTwo ;
    private Button btnThree;
    private Button btnFour ;
    private Button btnFive ;
    private Button btnSix ;
    private Button btnSeven;
    private Button btnEight ;
    private Button btnNine;
    private Button btnPlus ;
    private Button btnMinus ;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals ;
    private Button btnC ;
    private Button btnDecimal ;
    private Button btnMC ;
    private Button btnMR;
    private Button btnMM ;
    private Button btnMP;
    private Button btnBS;
    private Button btnPow ;
    private Button btnSqrRoot;
    private Button btnPM;

    private double num = 0;
    private double memNum = 0;
    private int operator = 1;
    // 0 = nothing, 1 = plus, 2 = minus, 3 =
    // multiply, 4 = divide
    private boolean readyToClear = false;
    private boolean hasChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Intent intent= getIntent();

        initControls();
        reset();
    }
    private void initControls() {
        txtCalc = (TextView) findViewById(R.id.txtCalc);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnC = (Button) findViewById(R.id.btnC);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnMC = (Button) findViewById(R.id.btnMC);
        btnMR = (Button) findViewById(R.id.btnMR);
        btnMM = (Button) findViewById(R.id.btnMM);
        btnMP = (Button) findViewById(R.id.btnMP);
        btnBS = (Button) findViewById(R.id.btnBS);
        btnPow = (Button) findViewById(R.id.btnPow);
        btnSqrRoot = (Button) findViewById(R.id.btnSqrRoot);
        btnPM = (Button) findViewById(R.id.btnPM);

        btnZero.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(0);
            }
        });
        btnOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(1);
            }
        });
        btnTwo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(2);
            }
        });
        btnThree.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(3);
            }
        });
        btnFour.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(4);
            }
        });
        btnFive.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(5);
            }
        });
        btnSix.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(6);
            }
        });
        btnSeven.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(7);
            }
        });
        btnEight.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(8);
            }
        });
        btnNine.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(9);
            }
        });
        btnPlus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(1);
            }
        });
        btnMinus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(2);
            }
        });
        btnMultiply.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(3);
            }
        });
        btnDivide.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(4);
            }
        });
        btnEquals.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(0);
            }
        });
        btnC.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });
        btnDecimal.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleDecimal();
            }
        });
        btnPM.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handlePlusMinus();
            }
        });
        btnMC.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                memNum = 0;
            }
        });
        btnMR.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(memNum));
            }
        });
        btnMM.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                memNum = memNum
                        - Double.parseDouble(txtCalc.getText().toString());
                operator = 0;
            }
        });
        btnMP.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                memNum = memNum
                        + Double.parseDouble(txtCalc.getText().toString());
                operator = 0;
            }
        });
        btnBS.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleBackspace();
            }
        });
        btnSqrRoot.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(Math.sqrt(Double.parseDouble(txtCalc
                        .getText().toString()))));
            }
        });
        btnPow.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(Math.pow( Double.parseDouble(txtCalc.getText()
                        .toString()),2)));
            }
        });

    }

    private void handleEquals(int newOperator) {
        if (hasChanged) {
            switch (operator) {
                case 1:
                    num = num + Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 2:
                    num = num - Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 3:
                    num = num * Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 4:
                    num = num / Double.parseDouble(txtCalc.getText().toString());
                    break;
            }

            String txt = Double.toString(num);
            txtCalc.setText(txt);
            //txtCalc.setSelection(txt.length());

            readyToClear = true;
            hasChanged = false;
        }

        operator = newOperator;
    }

    private void handleNumber(int num) {
        if (operator == 0)
            reset();

        String txt = txtCalc.getText().toString();
        if (readyToClear) {
            txt = "";
            readyToClear = false;
        } else if (txt.equals("0"))
            txt = "";

        txt = txt + Integer.toString(num);

        txtCalc.setText(txt);
        //txtCalc.setSelection(txt.length());

        hasChanged = true;
    }

    private void setValue(String value) {
        if (operator == 0)
            reset();

        if (readyToClear) {
            readyToClear = false;
        }

        txtCalc.setText(value);
        //txtCalc.setSelection(value.length());

        hasChanged = true;
    }

    private void handleDecimal() {
        if (operator == 0)
            reset();

        if (readyToClear) {
            txtCalc.setText("0.");
           // txtCalc.setSelection(2);
            readyToClear = false;
            hasChanged = true;
        } else {
            String txt = txtCalc.getText().toString();

            if (!txt.contains(".")) {
                txtCalc.append(".");
                hasChanged = true;
            }
        }
    }

    private void handleBackspace() {
        if (!readyToClear) {
            String txt = txtCalc.getText().toString();
            if (txt.length() > 0) {
                txt = txt.substring(0, txt.length() - 1);
                if (txt.equals(""))
                    txt = "0";

                txtCalc.setText(txt);
                //txtCalc.setSelection(txt.length());
            }
        }
    }

    private void handlePlusMinus() {
        if (!readyToClear) {
            String txt = txtCalc.getText().toString();
            if (!txt.equals("0")) {
                if (txt.charAt(0) == '-')
                    txt = txt.substring(1, txt.length());
                else
                    txt = "-" + txt;

                txtCalc.setText(txt);
               // txtCalc.setSelection(txt.length());
            }
        }
    }

    private void reset() {
        num = 0;
        txtCalc.setText("0");
       // txtCalc.setSelection(1);
        operator = 1;
    }

  }
