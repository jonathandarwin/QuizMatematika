package com.example.user.quizmatematika;

import java.util.ArrayList;

/**
 * Created by User on 12/5/2018.
 */

public class ListUserModel {
    public static ArrayList<UserModel> listUserModel = new ArrayList<>();

    public static ArrayList<UserModel> getListUserModel() {
        return listUserModel;
    }

    public static void setListUserModel(ArrayList<UserModel> listUserModel) {
        ListUserModel.listUserModel = listUserModel;
    }
}
