package com.adev.common.base.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

import java.lang.reflect.Field;


public class DataUtils {
	
	/**
	 * 非通常交易对的标志
	 */
	public static final String SIGN = "@";
	
	/**
	 * 合约和指数的交易对的结尾
	 */
	public static final String ETF = DataUtils.SIGN + "etf";
	
	/**
	 * 合约和指数的交易对的结尾
	 */
	public static final String QUOTE_ETF = DataUtils.SIGN + "quote" + DataUtils.SIGN + "etf";
	
	/**
	 * 标记价格订阅的交易对结尾
	 */
	public static final String QUOTE_MARK = DataUtils.SIGN + "quote" + DataUtils.SIGN + "mark";
	
	public static Long subSleepTime = 0L;
	
	/**
	 * 放慢深度，值越大，推送速度越慢
	 */
	public static Long depthSlowTime = -1L;
        

	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 字符串转
	 */
	public static JsonNode strToJsonNode(String str){
		try {
			if(str != null){
				JsonNode jsonNode = mapper.readTree(str);
				return jsonNode;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     * obj转long
     */
 	public static Long objToLong(Object obj){
 		
 		if(obj == null){
 			return null;
 		}
 		return Long.valueOf(obj.toString().replace("\"", "")).longValue();
 	}
 	
 	/**
     * obj转Integer
     */
 	public static Integer objToInteger(Object obj){
 		
 		if(obj == null){
 			return null;
 		}
 		return Integer.valueOf(obj.toString()).intValue();
 	}
 	
 	/**
 	 * obj转字符串
 	 */
 	public static String objToStr(Object obj){
 		
 		if(obj == null){
 			return "";
 		}
 		return obj.toString().replace("\"", "");
 	}
 	
 	/**
 	 * obj转BigDecimal
 	 */
 	public static BigDecimal objToBigDecimal(Object obj){
 		
 		if(obj == null){
 			return null;
 		}
 		
 		if(obj instanceof NullNode){
			return null;
 		}
 		
 		String objStr = obj.toString().replace("\"", "");
 		if(StringUtils.isEmpty(objStr)){
 			return null;
 		}
 		return new BigDecimal(objStr);
 	}
 	
 	// 判断集合不为空
  	public static Boolean listIsNotEmpty(List list){
  		
  		if(list != null && list.size() > 0){
  			return true;
  		}
  		return false;
  	}
  	
 	/**
 	 * 把降序的交易记录改成升序
 	 */
 	public static Iterator<JsonNode> reverseJsonNode(Iterator<JsonNode> it){
 		
 		List<JsonNode> jsonNodes = new ArrayList<>();
        while(it.hasNext()){
        	jsonNodes.add(it.next());
        }
        Collections.reverse(jsonNodes);
        
        Iterator<JsonNode> reverseIt = jsonNodes.iterator();
        return reverseIt;
 	}

	public static <T> List<T> sort(List<T> list,String sortField,String sortModel){
		Collections.sort(list, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				if(null==o1&&null==o2){
					return 0;
				}
				if(null==o1){
					return "asc".equalsIgnoreCase(sortModel)?-1:1;
				}
				if(null==o2){
					return "asc".equalsIgnoreCase(sortModel)?1:-1;
				}
				Class clazz1=o1.getClass();
				Class clazz2=o2.getClass();
				try {
					Field field1=getDeclaredField(clazz1,sortField);
					Field field2=getDeclaredField(clazz2,sortField);
					if(null==field1||null==field2){
						return 0;
					}
					field1.setAccessible(true);
					field2.setAccessible(true);
					Object value1=field1.get(o1);
					Object value2=field1.get(o2);
					if(null==value1&&null==value2){
						return 0;
					}
					if(null==value1){
						return "asc".equalsIgnoreCase(sortModel)?-1:1;
					}
					if(null==value2){
						return "asc".equalsIgnoreCase(sortModel)?1:-1;
					}
					if((value1 instanceof Comparable)&&(value2 instanceof Comparable)){
						Comparable comparable1=(Comparable)value1;
						Comparable comparable2=(Comparable)value2;
						return "asc".equalsIgnoreCase(sortModel)?comparable1.compareTo(comparable2):comparable2.compareTo(comparable1);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
				return 0;
			}
		});
		return list;
	}

	private static Field getDeclaredField(Class clazz,String fieldName){
		while (null!=clazz){
			try {
				Field field=clazz.getDeclaredField(fieldName);
				return field;
			} catch (NoSuchFieldException ne){
				clazz=clazz.getSuperclass();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Field> getDeclaredFields(Class clazz){
		List<Field> fieldList=new ArrayList<>();
		while (null!=clazz){
			Field[] declaredFields = clazz.getDeclaredFields();
			if(null!=declaredFields&&declaredFields.length>0){
				fieldList.addAll(Arrays.asList(declaredFields));
			}
			clazz=clazz.getSuperclass();
		}
		return fieldList;
	}

	public static void copyFatherAttribute(Object father,Object child){
		if(father.getClass().isAssignableFrom(child.getClass())){
			Field ff[]= father.getClass().getDeclaredFields();
			for(int i=0;i<ff.length;i++){
				Field f=ff[i];//取出每一个属性
				try {
					Method m = father.getClass().getDeclaredMethod("get"+upperHeadChar(f.getName()));
					Object obj=m.invoke(father);//取出属性值
					if(null!=obj){
						Method cm=child.getClass().getSuperclass().getDeclaredMethod("set"+upperHeadChar(f.getName()),obj.getClass());
						cm.invoke(child,obj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String upperHeadChar(String in){
		String head=in.substring(0,1);
		String out=head.toUpperCase()+in.substring(1,in.length());
		return out;
	}
}
