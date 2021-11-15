package com.Ram.Francis.RamsOrder;

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


    TextView RamsName, RamsDesc, RamsPrice, RamsGB, Speedwhun, RamsQuantity;
    ImageView imgRams;
    Button btnRam1, btnRam2, btnRam3 , btnRam4, btnRam5, btnAddCart, btnViewOrder, btnPlus, btnMinus;
    ToggleButton togleRepair;
    SeekBar seekGB, seekSpeed;


    ArrayList<OrderDetailClass> orderRam;
    RamsClass RamDetails;


    int RamOrderCounter;
    int speed , gb ,a;
    int orderQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RamDetails = new RamsClass();
        orderRam = new ArrayList<OrderDetailClass>();

        RamsName = (TextView) findViewById(R.id.txtName);
        RamsDesc = (TextView) findViewById(R.id.txtDesc);
        RamsPrice = (TextView) findViewById(R.id.txtPrice);
        RamsGB = (TextView) findViewById(R.id.txtGB);
        Speedwhun = (TextView) findViewById(R.id.txtSpeed);
        RamsQuantity = (TextView) findViewById(R.id.txtQuantity);

        imgRams = (ImageView) findViewById(R.id.imgJeans);
        togleRepair = (ToggleButton) findViewById(R.id.toggleButtonRepair);
        seekGB = (SeekBar) findViewById(R.id.seekBarGB);
        seekSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);


        btnRam1 = (Button) findViewById(R.id.btnRam1whun);
        btnRam2 = (Button) findViewById(R.id.btnRam2whun);
        btnRam3 = (Button) findViewById(R.id.btnRam3whun);
        btnRam4 = (Button) findViewById(R.id.btnRam4whun);
        btnRam5 = (Button) findViewById(R.id.btnRam5whun);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnAddCart = (Button) findViewById(R.id.btnAddCart);
        btnViewOrder = (Button) findViewById(R.id.btnViewOrder);
        a = 0;
        RamsGB.setText("2gb");
        Speedwhun.setText(("2400 MHz"));

        seekSpeed.setMax(3);
        setDefaultRams();

        seekGB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           public int progresswhun = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresswhun=progress;
                switch (progresswhun) {
                    case 0:
                        viewRamsDetails2(0);



                        break;

                    case 1:
                        viewRamsDetails2(1);

                        break;


                    case 2:

                        viewRamsDetails2(2);


                        break;
                    case 3:
                        viewRamsDetails2(3);


                        break;


                    case 4:

                        viewRamsDetails2(4,4);
                        RamOrderCounter =4;

                        break;
                    case 5:

                        viewRamsDetails2(5,5);
                        RamOrderCounter =5;

                        break;

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public int progresso =0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso=progress;
                switch (progresso) {
                    case 0:
                        viewSpeedDetails(0);

                        break;
                    case 1:
                        viewSpeedDetails(1);

                        break;
                    case 2:
                        viewSpeedDetails(2);

                        break;
                    case 3:
                        viewSpeedDetails(3);

                        break;
                }



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
                RamsQuantity.setText(orderQuantity + "");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (orderQuantity != 0) {
                    orderQuantity--;
                }
                RamsQuantity.setText(orderQuantity + "");
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
                    newOrder.setRamsNo(RamOrderCounter);
                    newOrder.setRepair(togleRepair.isChecked());
                    newOrder.setOrderQuantity(orderQuantity);
                    newOrder.setGBPercent(seekGB.getProgress());
                    newOrder.setSpeedPercent(seekSpeed.getProgress());

                    orderRam.add(newOrder);
                    setDefaultRams();

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

                if(orderRam.size() == 0) {
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
                    openAct.putExtra("orderList", orderRam);
                    startActivity(openAct);

                    //finish();
                }

            }
        });
    }


    private void setDefaultRams() {
        viewRamsDetails(0);
        togleRepair.setChecked(false);
        seekGB.setProgress(0);
        seekSpeed.setProgress(0);
        orderQuantity = 0;
        RamsQuantity.setText("0");

        btnRam1.setBackgroundResource(R.color.btnRamsSelect);
        btnRam2.setBackgroundResource(R.color.btnRamsUnSelect);
        btnRam3.setBackgroundResource(R.color.btnRamsUnSelect);
        btnRam4.setBackgroundResource(R.color.btnRamsUnSelect);
        btnRam5.setBackgroundResource(R.color.btnRamsUnSelect);
    }

    public void onClickRams(View view) {

        if (view == btnRam1) {
            btnRam1.setBackgroundResource(R.color.btnRamsSelect);
            btnRam2.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam3.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam4.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam5.setBackgroundResource(R.color.btnRamsUnSelect);
            RamOrderCounter = 0;
            viewRamsDetails(0);
            a = 0;

        } else if (view == btnRam2) {
            btnRam1.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam2.setBackgroundResource(R.color.btnRamsSelect);
            btnRam3.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam4.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam5.setBackgroundResource(R.color.btnRamsUnSelect);
            RamOrderCounter = 1;
            viewRamsDetails(1);
            a = 1;

        } else if (view == btnRam3) {
            btnRam1.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam2.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam3.setBackgroundResource(R.color.btnRamsSelect);
            btnRam4.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam5.setBackgroundResource(R.color.btnRamsUnSelect);
            RamOrderCounter = 2;
            viewRamsDetails(2);
            a = 2;

        } else if (view == btnRam4) {
            btnRam1.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam2.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam3.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam4.setBackgroundResource(R.color.btnRamsSelect);
            btnRam5.setBackgroundResource(R.color.btnRamsUnSelect);
            RamOrderCounter = 3;
            viewRamsDetails(3);
            a = 3;

        } else if (view == btnRam5) {
            btnRam1.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam2.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam3.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam4.setBackgroundResource(R.color.btnRamsUnSelect);
            btnRam5.setBackgroundResource(R.color.btnRamsSelect);
            RamOrderCounter = 4;
            viewRamsDetails(4);
            a = 4;
        }
    }

    private void viewRamsDetails(int i) {


        RamsName.setText(RamDetails.getRamName(i));
        RamsDesc.setText(RamDetails.getRamDesc(i));
        RamsPrice.setText("Php " + RamDetails.getRamPrice(i));

        imgRams.setBackgroundResource(RamDetails.getRamImage(i));
    }//gege
    private void viewRamsDetails2(int index)
    {
        RamsGB.setText(RamDetails.getGBwhun(index));
    }
    private void viewSpeedDetails(int index)
    {
        Speedwhun.setText(RamDetails.getSpeedwhun(index));
    }
}
