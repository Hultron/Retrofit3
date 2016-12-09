package com.hultron.retrofit3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ParamInterface {
  //不带 id 时：
  @GET("param")
  Call<ParamGet> get();
  //带有 id 时：
  @GET("param")
  Call<ParamGetWithId> get(@Query("id") String withId);
  //上面的写法等价于：
  //  @GET("param?id=withId")
  //  Call<ParamGetWithId> get(@Query("id") String withId);


  // 不带 id 时：
  @POST("param")
Call<ParamPost> post(@Header("type") String type);
  // 带有 id 时：
  @POST("param")
  Call<ParamPost> post(@Header("type") String type,@Query("id") String id);
}
