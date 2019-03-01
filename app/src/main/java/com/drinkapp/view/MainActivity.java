package com.drinkapp.view;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.drinkapp.R;
import com.drinkapp.Retrofit.IDrinkShopAPI;
import com.drinkapp.Utils.Common;
import com.drinkapp.model.CheckUserResponse;
import com.drinkapp.model.User;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.szagurskii.patternedtextwatcher.PatternedTextWatcher;

import java.io.IOException;

import dmax.dialog.SpotsDialog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;
    Button btn_continue;
    IDrinkShopAPI mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getApi();


        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startLoginPage(LoginType.PHONE);
            }
        });


        if (AccountKit.getCurrentAccessToken() != null) {

            AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                @Override
                public void onSuccess(final Account account) {

                    final AlertDialog alertDialog = new SpotsDialog(MainActivity.this);
                    alertDialog.show();
                    alertDialog.setMessage("Please Waiting...");


                    mService.checkUserExists(account.getPhoneNumber().toString())
                            .enqueue(new Callback<CheckUserResponse>() {
                                @Override
                                public void onResponse(Call<CheckUserResponse> call, Response<CheckUserResponse> response) {
                                    CheckUserResponse userResponse = response.body();

                                    if (userResponse.isExists()) {

                                        mService.getUserInformation(account.getPhoneNumber().toString())
                                                .enqueue(new Callback<User>() {
                                                    @Override
                                                    public void onResponse(Call<User> call, Response<User> response) {

                                                        alertDialog.dismiss();

                                                        Common.currentUser = response.body();

                                                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                                        finish();

                                                    }

                                                    @Override
                                                    public void onFailure(Call<User> call, Throwable t) {
                                                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                });

                                    } else {
                                        alertDialog.dismiss();

                                        showRegisterDialog(account.getPhoneNumber().toString());
                                    }
                                }

                                @Override
                                public void onFailure(Call<CheckUserResponse> call, Throwable t) {

                                }
                            });
                }

                @Override
                public void onError(AccountKitError accountKitError) {
                    Log.d("ERROR", accountKitError.getErrorType().getMessage());
                }
            });


        }

    }

    private void startLoginPage(LoginType loginType) {
        Intent intent = new Intent(this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder builder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(loginType,
                        AccountKitActivity.ResponseType.TOKEN);
        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, builder.build());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            AccountKitLoginResult result = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);

            if (result.getError() != null) {
                Toast.makeText(this, ""+result.getError().getErrorType().getMessage(), Toast.LENGTH_SHORT).show();

            } else if (result.wasCancelled()) {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();

            } else {

                if (result.getAccessToken() != null) {
                    final AlertDialog alertDialog = new SpotsDialog(MainActivity.this);
                    alertDialog.show();
                    alertDialog.setMessage("Please Waiting...");

                    AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                        @Override
                        public void onSuccess(final Account account) {


                            mService.checkUserExists(account.getPhoneNumber().toString())
                                    .enqueue(new Callback<CheckUserResponse>() {
                                        @Override
                                        public void onResponse(Call<CheckUserResponse> call, Response<CheckUserResponse> response) {
                                            CheckUserResponse userResponse = response.body();

                                            if (userResponse.isExists()) {

                                                mService.getUserInformation(account.getPhoneNumber().toString())
                                                        .enqueue(new Callback<User>() {
                                                            @Override
                                                            public void onResponse(Call<User> call, Response<User> response) {

                                                                alertDialog.dismiss();

                                                                User user = response.body();

                                                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                                                finish();

                                                            }

                                                            @Override
                                                            public void onFailure(Call<User> call, Throwable t) {
                                                                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                                                            }
                                                        });

                                            } else {
                                                alertDialog.dismiss();

                                                showRegisterDialog(account.getPhoneNumber().toString());
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<CheckUserResponse> call, Throwable t) {

                                        }
                                    });
                        }

                        @Override
                        public void onError(AccountKitError accountKitError) {
                            Log.d("ERROR", accountKitError.getErrorType().getMessage());
                        }
                    });
                }
            }
        }
    }

    private void showRegisterDialog(final String phone) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("REGISTER");

        LayoutInflater inflater = this.getLayoutInflater();
        View register_layout = inflater.inflate(R.layout.register_layout, null);

        final MaterialEditText et_name = register_layout.findViewById(R.id.et_name);
        final MaterialEditText et_address = register_layout.findViewById(R.id.et_address);
        final MaterialEditText et_birthdate = register_layout.findViewById(R.id.et_birthdate);

        Button btn_register = register_layout.findViewById(R.id.btn_register);

        et_birthdate.addTextChangedListener(new PatternedTextWatcher("####-##-##"));

        builder.setView(register_layout);
        final AlertDialog dialog = builder.create();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                if (TextUtils.isEmpty(et_name.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(et_birthdate.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your birthdate", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(et_address.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your address", Toast.LENGTH_SHORT).show();
                    return;
                }

                final AlertDialog watingDialog = new SpotsDialog(MainActivity.this);
                watingDialog.show();
                watingDialog.setMessage("Please Waiting...");


                mService.registerNewUser(phone,
                        et_name.getText().toString(),
                        et_birthdate.getText().toString(),
                        et_address.getText().toString())
                        .enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                watingDialog.dismiss();

                                User user = response.body();

                                if (TextUtils.isEmpty(user.getError_msg())) {
                                    Toast.makeText(MainActivity.this, "User Registered successfully!", Toast.LENGTH_SHORT).show();
                                    Common.currentUser = response.body();

                                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                    finish();
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                watingDialog.dismiss();
                            }
                        });




            }
        });

        dialog.show();

    }
}
























