package com.chady.chadmac.jeansOrderApp;

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
    TextView lblTotal;

    JeansListDataAdapter jeansAdapter;
    JeansClass jeansDetail;

    float totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

         jeansDetail = new JeansClass();
        orderList = (ArrayList<OrderDetailClass>) getIntent().getSerializableExtra("orderList");

        lblTotal = (TextView) findViewById(R.id.txtTotalPrice);

        listView = (ListView) findViewById(R.id.listView);
        jeansAdapter = new JeansListDataAdapter(getBaseContext(), R.layout.custom_listview_layout, orderList);
        listView.setAdapter(jeansAdapter);

        //compute total
        for (OrderDetailClass orbobj: orderList) {
            int jeansOrderNo = orbobj.getJeansNo();
            int quant = orbobj.getOrderQuantity();


            totalPrice += ( jeansDetail.getJeansPrice(jeansOrderNo) * quant);
            lblTotal.setText("Total Amount: Php " + String.format("%,.2f", totalPrice));
        }
    }

    private class JeansListDataAdapter extends ArrayAdapter<OrderDetailClass> {

        private ArrayList<OrderDetailClass> jeansList;
        int layoutResID;

        public JeansListDataAdapter(Context context, int resourceLayoutID,
                               ArrayList<OrderDetailClass> listObj) {
            super(context, resourceLayoutID, listObj);
            // TODO Auto-generated constructor stub
            this.layoutResID = resourceLayoutID;
            this.jeansList = new ArrayList<OrderDetailClass>();
            this.jeansList.addAll(listObj);
        }


        //adding new set of arraylist (custom)
        public void addAll(ArrayList<OrderDetailClass> obj) {
            // TODO Auto-generated method stub
            jeansList.clear();
            jeansList.addAll(obj);
        }

        @Override
        public void remove(OrderDetailClass object) {
            // TODO Auto-generated method stub
            super.remove(object);
            jeansList.remove(object);

            totalPrice = 0;
            //compute total
            for (OrderDetailClass orbobj: jeansList) {
                int jeansOrderNo = orbobj.getJeansNo();
                int quant = orbobj.getOrderQuantity();


                totalPrice += ( jeansDetail.getJeansPrice(jeansOrderNo) * quant);
                lblTotal.setText("Total Amount: Php " + String.format("%,.2f", totalPrice));
            }
        }

        private class ViewHolder {
            TextView lblName, lblPrice, lblRepairType, lblQuantity, lblWaistLength;
            ImageView imgjeans;
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
                holder.lblName = (TextView) view.findViewById(R.id.txtOrderJeansName);
                holder.lblPrice = (TextView) view.findViewById(R.id.txtOrderJeansPrice);
                holder.lblRepairType = (TextView) view.findViewById(R.id.txtOrderRepairType);
                holder.lblWaistLength = (TextView) view.findViewById(R.id.txtWaistLength);
                holder.lblQuantity = (TextView) view.findViewById(R.id.txtOrderJeansQuantity);
                holder.imgjeans = (ImageView) view.findViewById(R.id.jeansOrderImg);
                holder.btndelete = (Button) view.findViewById(R.id.btnDelete);
                view.setTag(holder);

                holder.btndelete.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Button btnTag = (Button) v;
                        OrderDetailClass iconObj = (OrderDetailClass) btnTag.getTag();
                        jeansAdapter.remove(iconObj);
                        jeansAdapter.notifyDataSetChanged();

                    }
                });

            }else{
                holder = (ViewHolder) view.getTag();
            }

            try {
                OrderDetailClass jeansObj = jeansList.get(position);
                int jeansOrderNo = jeansObj.getJeansNo();
                String repairSTR = "";
                if (jeansObj.isHaveRepair()) {
                     repairSTR = "Back to Original";
                }else {
                     repairSTR = "Ordinary Hemming";

                }


                holder.lblName.setText( jeansDetail.getJeansName(jeansOrderNo));
                holder.lblPrice.setText("Price/Jeans: " +  jeansDetail.getJeansPrice(jeansOrderNo));
                holder.lblRepairType.setText("Alteration: " +  repairSTR);
                holder.lblWaistLength.setText("WaistLine " + (jeansObj.getWaistPercent()+21) + "inches | " +
                    "Length: " + (jeansObj.getLengthPercent()+21) + "INCHES");
                holder.lblQuantity.setText("No. of Order(s): " + jeansObj.getOrderQuantity());
                holder.imgjeans.setBackgroundResource( jeansDetail.getJeansImage(jeansOrderNo));
                holder.btndelete.setTag(jeansObj);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return view;
        }

    }
}
