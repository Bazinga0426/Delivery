package com.example.delivery.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.delivery.R;
import com.example.delivery.helpers.UserHelper;
import com.example.delivery.utils.UserInforSPUtils;
import com.example.delivery.utils.UserUtil;

public class AccountActivity extends BaseActivity {

    private TextView username;
    private TextView phone;
    private ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initView();
    }

    private void initView() {
        initNavBar(true, "User Account", false);
        username = fd(R.id.username);
        phone = fd(R.id.phone);
        profilePicture = fd(R.id.profile_picture);
        username.setText(UserHelper.getInstance().getUserName());
        phone.setText(UserHelper.getInstance().getPhone());
        if (UserHelper.getInstance().getProfilePicture() != null && !UserHelper.getInstance().getProfilePicture().equals("")) {
            Uri uri = Uri.parse(UserHelper.getInstance().getProfilePicture());
            profilePicture.setImageURI(uri);
        }
    }

    public void onAddPhoneNumClick(View view) {
        startActivity(new Intent(this, AddPhoneNumActivity.class));
    }

    public void onUpdateProfilePictureClick(View view) {
        startActivity((new Intent(this, UpdateProfilePictureActivity.class)));
    }

    public void onChangePasswordClick(View view) {
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }

    public void onLogoutClick(View view) {
        // remove account info
        UserInforSPUtils.saveEmail("");
        UserInforSPUtils.saveName("");
        UserInforSPUtils.savePhone("");
        UserInforSPUtils.savePic("");

        UserUtil.logout(this);
    }
}