package com.Ram.Francis.RamsOrder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListOrderActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<OrderDetailClass> orderList;
    TextView RamsTotal;

    RamsListDataAdapter RamsAdapter;
    RamsClass RamsDetail;
    public int RamgbNo,Ramsped;

    float totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

        RamsDetail = new RamsClass();
        orderList = (ArrayList<OrderDetailClass>) getIntent().getSerializableExtra("orderList");

        RamsTotal = (TextView) findViewById(R.id.txtTotalPrice);

        listView = (ListView) findViewById(R.id.listView);
        RamsAdapter = new RamsListDataAdapter(getBaseContext(), R.layout.custom_listview_layout, orderList);
        listView.setAdapter(RamsAdapter);

        //compute total
        for (OrderDetailClass orbobj: orderList) {
            int RamsOrderNo = orbobj.getRamsNo();
            int quant = orbobj.getOrderQuantity();


            totalPrice += ( RamsDetail.getRamPrice(RamsOrderNo) * quant);
            RamsTotal.setText("Total Amount: Php " + String.format("%,.2f", totalPrice));
        }
    }

    private class RamsListDataAdapter extends ArrayAdapter<OrderDetailClass> {

        private ArrayList<OrderDetailClass> RamsList;
        int layoutResID;

        public RamsListDataAdapter(Context context, int resourceLayoutID,
                                   ArrayList<OrderDetailClass> listObj) {
            super(context, resourceLayoutID, listObj);
            // TODO Auto-generated constructor stub
            this.layoutResID = resourceLayoutID;
            this.RamsList = new ArrayList<OrderDetailClass>();
            this.RamsList.addAll(listObj);
        }


        //adding new set of arraylist (custom)
        public void addAll(ArrayList<OrderDetailClass> obj) {
            // TODO Auto-generated method stub
            RamsList.clear();
            RamsList.addAll(obj);
        }

        @Override
        public void remove(OrderDetailClass object) {
            // TODO Auto-generated method stub
            super.remove(object);
            RamsList.remove(object);

            totalPrice = 0;
            //compute total
            for (OrderDetailClass orbobj: RamsList) {
                int jeansOrderNo = orbobj.getRamsNo();
                int quant = orbobj.getOrderQuantity();


                totalPrice += ( RamsDetail.getRamPrice(jeansOrderNo) * quant);
                RamsTotal.setText("Total Amount: Php " + String.format("%,.2f", totalPrice));
            }
        }

        private class ViewHolder {
            TextView RamsName, RamsPrice, lblRepairType, lblQuantity, RamsGBSpeed;
            ImageView imgRams;
            Button btndelete;



        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            ViewHolder holder = null;
            View view = convertView;

            if (convertView == null) {

                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(layoutResID, null);

                holder = new ViewHolder();
                holder.RamsName = (TextView) view.findViewById(R.id.txtOrderRamsName);
                holder.RamsPrice = (TextView) view.findViewById(R.id.txtOrderRamsPrice);
                holder.lblRepairType = (TextView) view.findViewById(R.id.txtOrderRepairType);
                holder.RamsGBSpeed = (TextView) view.findViewById(R.id.txtGBSpeed);
                holder.lblQuantity = (TextView) view.findViewById(R.id.txtOrderRamsQuantity);
                holder.imgRams = (ImageView) view.findViewById(R.id.RamsOrderImg);
                holder.btndelete = (Button) view.findViewById(R.id.btnDelete);
                view.setTag(holder);

                holder.btndelete.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Button btnTag = (Button) v;
                        OrderDetailClass iconObj = (OrderDetailClass) btnTag.getTag();
                        RamsAdapter.remove(iconObj);
                        RamsAdapter.notifyDataSetChanged();

                    }
                });

            }else{
                holder = (ViewHolder) view.getTag();
            }

            try {
                OrderDetailClass RamsObj = RamsList.get(position);
                int RamsOrderNo = RamsObj.getRamsNo();
                int RamgbNo=RamsObj.getGBPercent();
                int RamspedNo=RamsObj.getSpeedPercent();
                String repairSTR = "";
                if (RamsObj.isHaveRepair()) {
                    repairSTR = "Back to Original";
                }else {
                    repairSTR = "Pickup Delivery";

                }


                holder.RamsName.setText( RamsDetail.getRamName(RamsOrderNo));
                holder.RamsPrice.setText("Price/Jeans: " +  RamsDetail.getRamPrice(RamsOrderNo));
                holder.lblRepairType.setText("Alteration: " +  repairSTR);
                holder.RamsGBSpeed.setText("Gigabytes " + (RamsDetail.getGBwhun(RamgbNo)) + "GB | " +
                        "Speed: " + (RamsDetail.getSpeedwhun(RamspedNo)) + "MHz");
                holder.lblQuantity.setText("No. of Order(s): " + RamsObj.getOrderQuantity());
                holder.imgRams.setBackgroundResource( RamsDetail.getRamImage(RamsOrderNo));
                holder.btndelete.setTag(RamsObj);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return view;
        }

    }
}
