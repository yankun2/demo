package com.example.demo.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.UTFDataFormatException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author zhurendong
 * @date 2018年5月10日
 */
public class StringUtils {
	/**
	 *  空字符串
	 */
	public static final String EMPTY = "";

	/**
	 *  字符串搜索时使用
	 */
	public static final int INDEX_NOT_FOUND = -1;

	private StringUtils() {
		super();
	}
	/**
	 * 空校验
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 非空校验
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !StringUtils.isEmpty(str);
	}
	/**
	 * 字符串比较
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}
	/**
	 * 空校验
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	/**
	 * 非空校验
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}

	/**
	 * 字符串空格处理
	 */
	public static final String trim(String value) {
		return value == null ? "" : value.trim();
	}

	/**
	 * 判断字符串是否为空
	 */
	public static boolean checkStringIsNull(String str) {
		return (str == null || str.length() == 0 || "".equals(str));
	}

	/**
	 * Format null for string
	 * 
	 * @param str
	 */
	public static String formatNULL(String str) {
		if (str == null || "null".equalsIgnoreCase(str) || "".equals(str)
				|| "undefined".equalsIgnoreCase(str)) {
			str = null;
		}
		return str;
	}

	/**
	 * Format null for string[]
	 * 
	 * @param str
	 */
	public static String[] formatNULL(String[] str) {
		if (str == null || str.length < 1 || str[0] == null
				|| "".equals(str[0])) {
			str = null;
		}
		return str;
	}

	/**
	 * String key is include str
	 * 
	 * @param key
	 *            ..,..
	 * @param str
	 * @return boolean
	 */
	public static boolean isInclude(String key, String str) {
		if (formatNULL(key) == null || formatNULL(str) == null) {
			return false;
		}
		return isInclude(key.split(","), str);
	}

	/**
	 * String keys is include str
	 * 
	 * @param keys
	 * @param str
	 * @return boolean
	 */
	public static boolean isInclude(String[] keys, String str) {
		if (formatNULL(keys) != null && formatNULL(str) != null) {
			for (int i = 0, len = keys.length; i < len; i++) {
				if (str.equals(keys[i])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 是否为移动号码
	 * @param mobile
	 * @return
	 */
	public static boolean isChinaMobile(String mobile){
		String cm = "^((13[4-9])|(147)|(15[0-2,7-9])|(18[2-3,7-8]))\\d{8}$"; 
		Pattern pattern = Pattern.compile(cm);
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}

	/**
	 * Trim datetime
	 * 
	 * @param str
	 *            2013年12月11日15:26:50
	 * @return 20130101101212
	 */
	public static String trimDTime(String str) {
		if (str == null || "".equals(str)) {
			return str;
		}
		String[] oldChars = { "-", " ", ":" };
		for (String old : oldChars) {
			str = str.replace(old, "");
		}
		return str;
	}

	/**
	 * 从xml获取节点的值
	 * @param qname
	 * @param xml
	 * @return
	 */
	public static String getText(String qname, String xml) {
		StringBuffer buff = new StringBuffer("<");
		buff.append(qname);
		buff.append(">");
		StringBuffer buff2 = new StringBuffer("</");
		buff2.append(qname);
		buff2.append(">");
		int start = xml.indexOf(buff.toString());
		int end = xml.indexOf(buff2.toString());

		return xml.substring(start + buff.length(), end);
	}
	/**
	 * 获取节点值
	 * @param qname
	 * @param xml
	 * @return
	 */
	public static String getXmlText(String qname, String xml) {
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = null;
			try{
				doc = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("gbk"))));
			}catch(UTFDataFormatException ue){
				doc = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
			}
			Element element = doc.getDocumentElement();
			if(element!=null){
				NodeList list = element.getElementsByTagName(qname);
				if(list.getLength()>0){
					return list.item(0).getTextContent();
				}
			}
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 取影藏处理的手机号
	 * @param phoneNo
	 * @return
	 */
	public static String getHidePhoneNo(String phoneNo) {
		String value="";
		if(phoneNo!=null && phoneNo.length()>10)
		{
			//取前三位
			String left = value.substring(0, 3);
			//取后四位
			String right = value.substring(phoneNo.length()-4);
			value = left + "****" + right;
		}
		return value;
	}

	/**
	 * 在str前后添加","
	 * @param
	 * @return
	 */
	public static String addMark(String str) {
		return addMark(str, ",");
		
	}
	/**
	 * 在str前后添加相同的标记或字段
	 * @param
	 * @return
	 */
	public static String addMark(String str, String aroundMark) {
		return addMark(str, aroundMark, aroundMark);
		
	}
	/**
	 * 在str前后添加不同的标记或字段
	 * @param
	 * @return
	 */
	public static String addMark(String str, String firstMark, String endMark) {
		StringBuilder stringBuffer = new StringBuilder("");
		if(StringUtils.isNotBlank(firstMark)) {
			stringBuffer.append(firstMark);
		}
		
		if(StringUtils.isNotBlank(str)) {
			stringBuffer.append(str);
		}
		
		if(StringUtils.isNotBlank(endMark)) {
			stringBuffer.append(endMark);
		}
		return stringBuffer.toString();
		
	}
	
	/**
	 * 基本数据类型和Date类型转换为String类型
	 * @param param
	 * @return
	 */
	public static String toStringValueByObject(Object param){
		String str = null;
		if(param != null){
			if (param instanceof Integer) {
				int value = ((Integer) param).intValue();
				str = String.valueOf(value);
			} else if (param instanceof String) {
				String value = (String) param;
				str = value;
			} else if (param instanceof Double) {
				double value = ((Double) param).doubleValue();
				str = String.valueOf(value);
			} else if (param instanceof Float) {
				float value = ((Float) param).floatValue();
				str = String.valueOf(value);
			} else if (param instanceof Long) {
				long value = ((Long) param).longValue();
				str = String.valueOf(value);
			} else if (param instanceof Boolean) {
				boolean value = ((Boolean) param).booleanValue();
				str = String.valueOf(value);
			} else if (param instanceof Date) {
				Date value = (Date) param;
				str = DateUtil.format(value, DateUtil.DEFAULT);
			}  
		}
		return str;
	}

}
