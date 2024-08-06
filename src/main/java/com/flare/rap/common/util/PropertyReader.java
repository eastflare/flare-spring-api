package com.flare.rap.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

  public PropertyReader() {
    properties = new Properties();
  }

  public Properties getProperties(){
    return properties;
  }

  /**
   * 이 메소드는 프로퍼티 파일을 스트림으로 읽어 들여 멤버 변수의 프로퍼티에 적재합니다.
   *
   * @param path
   * @throws IOException
   */
  public void loadProp(String path) throws Exception{

    InputStream inputStream = getClass().getResourceAsStream(path);
    properties.load(inputStream);
    inputStream.close();
  }

  /**
   * 이 메소드는 static으로 선언해서 프로퍼티 파일을 읽는 것을 보여줍니다.
   * @param path
   * @return
   * @throws IOException
   */
  public static Properties loadPropForStatic(String path) throws IOException{
    Properties properties = new Properties();
    InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(path);
    properties.load(inputStream);
    inputStream.close();
    return properties;
  }
}