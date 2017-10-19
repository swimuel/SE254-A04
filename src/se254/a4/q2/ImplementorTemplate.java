package se254.a4.q2;

import java.lang.reflect.*;

public class ImplementorTemplate
{
  protected static String nl;
  public static synchronized ImplementorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ImplementorTemplate result = new ImplementorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "public class ";
  protected final String TEXT_2 = "Implementation implements ";
  protected final String TEXT_3 = "{";
  protected final String TEXT_4 = NL + "\t" + NL + "\t@Override" + NL + "\tpublic ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = "(";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = " p";
  protected final String TEXT_9 = ") { ";
  protected final String TEXT_10 = "return 0; }";
  protected final String TEXT_11 = "return null; }";
  protected final String TEXT_12 = "return false; }";
  protected final String TEXT_13 = " }";
  protected final String TEXT_14 = "\t";
  protected final String TEXT_15 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Class c = (Class) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_3);
     for(Method m : c.getMethods()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(m.getReturnType().getSimpleName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(m.getName());
    stringBuffer.append(TEXT_6);
    
	for(int i=0; i<m.getParameterCount();i++) { 
    
		if(i!=0){
    stringBuffer.append(TEXT_7);
    
		}
    stringBuffer.append(m.getParameterTypes()[i].getSimpleName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(i+1);
    }
    stringBuffer.append(TEXT_9);
    
		if (m.getReturnType().equals(int.class) || m.getReturnType().equals(double.class)){
    stringBuffer.append(TEXT_10);
    
		}else if(m.getReturnType().equals(Object.class)){
    stringBuffer.append(TEXT_11);
    
		}else if(m.getReturnType().equals(boolean.class)){
    stringBuffer.append(TEXT_12);
    
		}else{
    stringBuffer.append(TEXT_13);
    
		}
    stringBuffer.append(TEXT_14);
    	}
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
