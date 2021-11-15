package com.chady.chadmac.jeansOrderApp;


public class JeansClass {

    private String jeansName[];
    private String jeansDesc[];
    private float jeansPrice[];
    private int jeansImage[];
    private double teaprice[][];



    public JeansClass() {

        jeansName = new String[]{"Levis 501", "Levis 511", "Levis 510","Levis 505"};
        jeansDesc = new String[]{"Original Fly Jeans", "Slim Fit Tapered", "Skinny Jeans","classic straight"};
      jeansPrice = new float[]{3999.95f, 2799.50f, 2200.50f,1800f};
       jeansImage = new int[]{R.drawable.levis501, R.drawable.levis511, R.drawable.levis510,R.drawable.levis505};
        teaprice=new double  [][]{{70.00,80.00,90.00},{75.00,85.00,95.00},{70.00,80.00,90.00},{72.00,82.00,92.00},{80.00,90.00,100.00}};
    }

    public String getJeansDesc(int index) {
        return jeansDesc[index];
    }


    public String getJeansName(int index) {
        return jeansName[index];
    }

    public int getJeansImage(int index) {
        return jeansImage[index];
    }

    public float getJeansPrice(int index) {
        return jeansPrice[index];
    }

    public double getTeaprice(int row, int col) {
        return teaprice[row][col];
    }


}
