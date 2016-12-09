package com.hultron.retrofit3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  private static final String BASE_URL = "http://retrofit.devwiki.net/";
  private static final String TAG1 = "Param GET ";
  private static final String TAG2 = "Param GETWithId ";
  private static final String TAG3 = "Param POST ";
  private static final String TAG4 = "Param POSTWithId ";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // 创建了一个 Retrofit 对象
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    ParamInterface paramInterface = retrofit.create(ParamInterface.class);
    // 1.通过 "param" 接口发送 GET 请求（不带 id）
    final Call<ParamGet> paramGet = paramInterface.get();
    final Call<ParamGetWithId> paramGetWithId = paramInterface.get("123");//这里的 id 可以是任意字符串
    final Call<ParamPost> paramPost = paramInterface.post("POST");
    final Call<ParamPost> paramPostWithId = paramInterface.post("POST", "123");//这里的 id 可以是任意值
    paramGet.enqueue(new Callback<ParamGet>() {
      @Override public void onResponse(Call<ParamGet> call, Response<ParamGet> response) {
        try {
          ParamGet paramGet1 = response.body();
          System.out.println(TAG1 + paramGet1.getCode());
          System.out.println(TAG1 + paramGet1.getDesc());
        } catch (Exception e) {
          e.printStackTrace();
        }
        Log.e("MainActivity", "");
      }

      @Override public void onFailure(Call<ParamGet> call, Throwable t) {

      }
    });
    paramGetWithId.enqueue(new Callback<ParamGetWithId>() {
      @Override
      public void onResponse(Call<ParamGetWithId> call, Response<ParamGetWithId> response) {
        try {
          ParamGetWithId paramGetId1 = response.body();
          System.out.println(TAG2 + paramGetId1.getCode());
          System.out.println(TAG2 + paramGetId1.getDesc());
          System.out.println(TAG2 + paramGetId1.getData().getId());
        } catch (Exception e) {
          e.printStackTrace();
        }

        Log.e("MainActivity", "");
      }

      @Override public void onFailure(Call<ParamGetWithId> call, Throwable t) {

      }
    });
    paramPost.enqueue(new Callback<ParamPost>() {
      @Override public void onResponse(Call<ParamPost> call, Response<ParamPost> response) {
        try {
          ParamPost paramPost = response.body();
          System.out.println(TAG3 + paramPost.getCode());
          System.out.println(TAG3 + paramPost.getDesc());
          //查看返回结果，就可以发现，这行语句没有得到执行，因为 没有 id ,
          // 只能得到返回失败的结果
          //System.out.println(TAG3 + paramPost.getData().getType());
        } catch (Exception e) {
          e.printStackTrace();
        }
        Log.e("MainActivity", "");
      }

      @Override public void onFailure(Call<ParamPost> call, Throwable t) {
      }
    });
    paramPostWithId.enqueue(new Callback<ParamPost>() {
      @Override public void onResponse(Call<ParamPost> call, Response<ParamPost> response) {
        try {
          ParamPost paramPostWithId1 = response.body();
          System.out.println(TAG4 + paramPostWithId1.getCode());
          System.out.println(TAG4 + paramPostWithId1.getDesc());
          System.out.println(TAG4 + paramPostWithId1.getData().getId());
          System.out.println(TAG4 + paramPostWithId1.getData().getType());
        } catch (Exception e) {
          e.printStackTrace();
        }
        Log.e("MainActivity","");
      }

      @Override public void onFailure(Call<ParamPost> call, Throwable t) {

      }
    });
  }
}
