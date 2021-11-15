package com.chady.chadmac.jeansOrderApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView lblName, lblDesc, lblPrice, lblWaist, lblLength, lblQuantity;
    ImageView imgJeans;
    Button btnJeansA, btnJeansB, btnJeansC,btnJeansD, btnAddCart, btnViewOrder, btnPlus, btnMinus;
    ToggleButton togleRepair;
    SeekBar seekWaist, seekLength;


    ArrayList<OrderDetailClass> orderJeans;
    JeansClass jeansDetails;


    int jeansOrderCounter;
    int orderQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jeansDetails = new JeansClass();
        orderJeans = new ArrayList<OrderDetailClass>();

        lblName = (TextView) findViewById(R.id.txtName);
        lblDesc = (TextView) findViewById(R.id.txtDesc);
        lblPrice = (TextView) findViewById(R.id.txtPrice);
        lblWaist = (TextView) findViewById(R.id.txtWaist);
        lblLength = (TextView) findViewById(R.id.txtLength);
        lblQuantity = (TextView) findViewById(R.id.txtQuantity);

        imgJeans = (ImageView) findViewById(R.id.imgJeans);
        togleRepair = (ToggleButton) findViewById(R.id.toggleButtonRepair);
        seekWaist = (SeekBar) findViewById(R.id.seekBarWaist);
        seekLength = (SeekBar) findViewById(R.id.seekBarLength);


        btnJeansA = (Button) findViewById(R.id.btnJeans1);
        btnJeansB = (Button) findViewById(R.id.btnJeans2);
        btnJeansC = (Button) findViewById(R.id.btnJeans3);
        btnJeansD= (Button) findViewById(R.id.btnJeans4);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnAddCart = (Button) findViewById(R.id.btnAddCart);
        btnViewOrder = (Button) findViewById(R.id.btnViewOrder);

        lblWaist.setText("21 inches");
        lblLength.setText(("21 inches"));
        setDefaultJeans();




        seekWaist.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lblWaist.setText(progress + 21+" inches");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lblLength.setText(progress +21+" inches");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderQuantity++;
                lblQuantity.setText(orderQuantity + "");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (orderQuantity != 0) {
                    orderQuantity--;
                }
                lblQuantity.setText(orderQuantity + "");
            }
        });

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (orderQuantity == 0) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Order Error");
                    alert.setMessage("Please add at least one quantity per order...");
                    alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    }).create();
                    alert.show();

                } else {

                    OrderDetailClass newOrder = new OrderDetailClass();
                    newOrder.setJeansNo(jeansOrderCounter);
                    newOrder.setRepair(togleRepair.isChecked());
                    newOrder.setOrderQuantity(orderQuantity);
                    newOrder.setWaistPercent(seekWaist.getProgress());
                    newOrder.setLengthPercent(seekLength.getProgress());

                    orderJeans.add(newOrder);
                    setDefaultJeans();

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Add Order");
                    alert.setMessage("Please successfully added new order...");
                    alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    }).create();
                    alert.show();
                }
            }
        });

        btnViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(orderJeans.size() == 0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Order Error");
                    alert.setMessage("Please add at least one order in cart...");
                    alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    }).create();
                    alert.show();
                } else {

                    Intent openAct = new Intent(MainActivity.this, ListOrderActivity.class);
                    openAct.putExtra("orderList", orderJeans);
                    startActivity(openAct);

                    //finish();
                }

            }
        });
    }


    private void setDefaultJeans() {
        viewJeansDetails(0);
        togleRepair.setChecked(false);
        seekWaist.setProgress(0);
        seekLength.setProgress(0);
        orderQuantity = 0;
        lblQuantity.setText("0");

        btnJeansA.setBackgroundResource(R.color.btnJeansSelect);
        btnJeansB.setBackgroundResource(R.color.btnJeansUnSelect);
        btnJeansC.setBackgroundResource(R.color.btnJeansUnSelect);
    }

    public void onClickJeans(View view) {

        if (view == btnJeansA) {
            btnJeansA.setBackgroundResource(R.color.btnJeansSelect);
            btnJeansB.setBackgroundResource(R.color.btnJeansUnSelect);
            btnJeansC.setBackgroundResource(R.color.btnJeansUnSelect);
            btnJeansD.setBackgroundResource(R.color.btnJeansUnSelect);
            jeansOrderCounter = 0;
            viewJeansDetails(0);

        } else if (view == btnJeansB) {
            btnJeansA.setBackgroundResource(R.color.btnJeansUnSelect);
            btnJeansB.setBackgroundResource(R.color.btnJeansSelect);
            btnJeansC.setBackgroundResource(R.color.btnJeansUnSelect);
            btnJeansD.setBackgroundResource(R.color.btnJeansUnSelect);
            jeansOrderCounter = 1;
            viewJeansDetails(1);

        } else if (view == btnJeansC) {
            btnJeansA.setBackgroundResource(R.color.btnJeansUnSelect);
            btnJeansB.setBackgroundResource(R.color.btnJeansUnSelect);
            btnJeansC.setBackgroundResource(R.color.btnJeansSelect);
            btnJeansD.setBackgroundResource(R.color.btnJeansUnSelect);
            jeansOrderCounter = 2;
            viewJeansDetails(2);
        } else if (view == btnJeansD) {
                btnJeansA.setBackgroundResource(R.color.btnJeansUnSelect);
                btnJeansB.setBackgroundResource(R.color.btnJeansUnSelect);
                btnJeansC.setBackgroundResource(R.color.btnJeansUnSelect);
                btnJeansD.setBackgroundResource(R.color.btnJeansSelect);
                jeansOrderCounter = 3;
                viewJeansDetails(3);

        }

    }

    private void viewJeansDetails(int i) {


        lblName.setText(jeansDetails.getJeansName(i));
        lblDesc.setText(jeansDetails.getJeansDesc(i));
        lblPrice.setText("Php " + jeansDetails.getJeansPrice(i));
        //make sure that the image file is less than 500KB
        imgJeans.setBackgroundResource(jeansDetails.getJeansImage(i));
    }
}
