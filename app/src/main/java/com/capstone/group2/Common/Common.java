package com.capstone.group2.Common;

public class Common {

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";

    public static final int PICK_IMAGE_REQUEST = 71;

    public static String convertCodeToStatus(String code){
        if(code.equals("0"))
            return "Confirmed";
        else if (code.equals("1"))
            return "Processing";
        else
            return "Delivered";
    }


}
