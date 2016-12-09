package com.hultron.retrofit3;

public class ParamGetWithId {
  private int code;

  private String desc;

  private Data data;

  public void setCode(int code){
    this.code = code;
  }
  public int getCode(){
    return this.code;
  }
  public void setDesc(String desc){
    this.desc = desc;
  }
  public String getDesc(){
    return this.desc;
  }
  public void setData(Data data){
    this.data = data;
  }
  public Data getData(){
    return this.data;
  }
  public static class Data {
    private String id;

    public void setId(String id){
      this.id = id;
    }
    public String getId(){
      return this.id;
    }

  }
}