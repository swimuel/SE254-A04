package se254.a4.q3;

import java.lang.reflect.*;

public class ExtractorTemplate
{
  protected static String nl;
  public static synchronized ExtractorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ExtractorTemplate result = new ExtractorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "public class ";
  protected final String TEXT_2 = " {";
  protected final String TEXT_3 = NL + "\tpublic ";
  protected final String TEXT_4 = " ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    try{
		Class<?> c = (Class<?>) argument.getClass();
		Class<?> cA = (Class<?>) c.getDeclaredField("a").get(argument); 
		Class<?> cB = (Class<?>) c.getDeclaredField("b").get(argument); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getDeclaredField("className").get(argument));
    stringBuffer.append(TEXT_2);
    	for (Field f1 : cA.getFields()) { 
    		for (Field f2 : cB.getFields()) { 
    			if(f1.getType().equals(f2.getType()) && f1.getName().equals(f2.getName())) {
    stringBuffer.append(TEXT_3);
    String str = f1.getType().toString();
    stringBuffer.append(str.substring(str.lastIndexOf(".")+1).trim());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(f1.getName());
    stringBuffer.append(TEXT_5);
    			}
    		}
    	}
    } catch (Exception e){ }
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
