package com.Ram.Francis.RamsOrder;


public class RamsClass {

    private String RamName[];
    private String RamDesc[];
    private float RamPrice[];
    private int RamImage[];
    private double teaprice[][];
    private String GBwhun[];
    private String Speedwhun[];



    public RamsClass() {

        RamName = new String[]{"Transcend", "HyperX", "Corsair","Gskill", "Samsung"};
        RamDesc = new String[]{"Fast Access", "Compatible", "Reliable","New version of Gskill","Brand New"};
        GBwhun = new String[]{"2gb","4gb","8gb","16gb","32gb"};
            //    ,{"2gb","4gb","8gb","16gb","32gb"},{"2gb","4gb","8gb","16gb","32gb"},{"2gb","4gb","8gb","16gb","32gb"},{"2gb","4gb","8gb","16gb","32gb"}};
        Speedwhun = new String []{"2400","3000","3200","3400"};
       // ,{"2400","3000","3200","3400"},{"2400","3000","3200","3400"},{"2400","3000","3200","3400"},{"2400","3000","3200","3400"}}
        RamPrice = new float[]{2567.35f, 2589.10f, 6578.20f,2800.43f,4876.49f};
        RamImage = new int[]{R.drawable.ram1, R.drawable.ram2, R.drawable.ram3,R.drawable.ram4,R.drawable.ram5};


    public String getRamDesc(int index) {
        return RamDesc[index];
    }


    public String getRamName(int index) {
        return RamName[index];
    }

    public int getRamImage(int index) {
        return RamImage[index];
    }

    public float getRamPrice(int index) {
        return RamPrice[index];
    }
    public String getGBwhun(int index ) {
        return GBwhun[index];
    }
    public String getSpeedwhun (int index ) {
        return Speedwhun[index];
    }




}
