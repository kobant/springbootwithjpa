/**
 * <p>Title: common StringsUtil.java</p>
 * <p>Copyright: Copyright (kuyu) 2018</p>
 * @date 2018年5月31日
 * @version 1.0
 */
package com.example.springbootwithjpa.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsUtil<main> {
	// 大陆手机正则
    private static Pattern MP = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
    // 香港手机正则
    private static Pattern HKMP = Pattern.compile("^(5|6|8|9)\\d{7}$");

    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    public static final char UNDERLINE = '_';

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel2(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            // String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }

    public static boolean isEmailAddress(String str) {
        if (str != null) {
            /*邮箱域名限制不少于两个字符*/
            return str.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w]{2,}");
        } else {
            return false;
        }
    }

    public static boolean isMobile(String str) {
        if (str != null) {
            return MP.matcher(str).matches() || HKMP.matcher(str).matches();
        } else {
            return false;
        }
    }

    public static String joinLongList(String join, ArrayList<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (Long id : ids) {
            builder.append(String.valueOf(id)).append(join);
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static String joinIntegerList(String join, List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (Integer id : ids) {
            builder.append(String.valueOf(id)).append(join);
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
    
    public static String formartKeys(String baseKey,Object... args) {
    	return String.format(baseKey, args);
    }
    
    public static String splitValueByCondition(String value,String regex,int index) {
    	if(value == null || value=="") {
    		return value;
    	}
    	try {
    		String values []=value.split(regex);
    		return values[index];
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
    }
    
    public static String generateCode() {
    	String no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    	return no;
    }
    
    /**
     * 生成随机数：当前年月日时分秒+4位随机数
     * @return
     */
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取8位随机数
        return str + rannum;// 当前时间
    }
    
    public static String generateAutocompleteCode(int code,int digit) {
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(digit);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(digit);
        return nf.format(code);
	}
    
    public static String generateAutocompleteCode(long code,int digit) {
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(digit);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(digit);
        return nf.format(code);
	}
    
    public static String generatePrizedrawCode(int code) {
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(5);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(5);
        return nf.format(code);
	}
    
	public static List<String> getHostAddress() {
		List<String> ipList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            Enumeration<InetAddress> inetAddresses;
            InetAddress inetAddress;
            String ip;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                        ip = inetAddress.getHostAddress();
                        if("127.0.0.1".equals(ip)) {
                        	continue;
                        }
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
	}
	
	public static boolean isMatch(String match,String[] params) {
		boolean m = false;
		for (String val : params) {
			if (match.contains(val)) {
				return true;
			}
		}
		return m;
	}
	
	/*public static String getRequstURL(HttpServletRequest request) {
		String requestURL = "";
		try {
			StringBuffer url = request.getRequestURL();
			String params = request.getQueryString();
			if (!com.tcl.uf.common.base.util.StringsUtil.isEmpty(params)) {
				url.append(params);
			}
			requestURL = url.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestURL;
	}*/
	
	public static String generateProblemId(int oid, int pid) {
		String date = new SimpleDateFormat("yyyy").format(new Date());
		StringBuffer problemId = new StringBuffer();
		problemId.append(date);
		problemId.append(oid);

		// 得到一个NumberFormat的实例
		NumberFormat nf = NumberFormat.getInstance();
		// 设置是否使用分组
		nf.setGroupingUsed(false);
		// 设置最大整数位数
		nf.setMaximumIntegerDigits(3);
		// 设置最小整数位数
		nf.setMinimumIntegerDigits(3);
		problemId.append(nf.format(pid));
		return String.valueOf(problemId);
	}
	
	public static StringBuffer generateProblemType(StringBuffer problemType, JSONArray params) {
		if(params==null || params.size()<=0) {
			return problemType;
		}
		//当前元素加入其中
		JSONObject object =params.getJSONObject(0);
		problemType.append(object.getString("name"));
		//判断资源是否存在
		JSONArray subNodes=object.getJSONArray("subNodes");
		if(subNodes !=null && !subNodes.isEmpty()) {
			problemType.append("，");
		}
		//递归处理数据信息
		return generateProblemType(problemType, subNodes);
	}

	public static String generateNumber(int activityId,int index) {
    	String no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).concat(""+activityId);
    	// 得到一个NumberFormat的实例
		NumberFormat nf = NumberFormat.getInstance();
		// 设置是否使用分组
		nf.setGroupingUsed(false);
		// 设置最大整数位数
		nf.setMaximumIntegerDigits(2);
		// 设置最小整数位数
		nf.setMinimumIntegerDigits(2);
		no.concat(nf.format(index));
    	return no.concat(String.valueOf(index));
    }

    public static String generateIdentification(){
        return UUID.randomUUID().toString().substring(24);
    }


    public static String getUUID32(){
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase() ;
    }

    /**
     * 方法一：使用indexOf和subString方法，循环判断并截取
     */
    public static int way1(String st,String M) {
        int count = 0;
        while(st.indexOf(M)>=0) {
            st=st.substring(st.indexOf(M)+M.length());
            count++;
        }
        return count;
    }
    /**
     * 方法二：使用replace方法将字符串替换为空，然后求长度
     */
    public static int way2(String st,String M) {
        int count = (st.length() - st.replace(M, "").length()) / M.length();
        return count;
    }

    public static String getRandom(int len) {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < len; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }

    /**
     * 方法：6X0X和36,把X 按位替换成指定的数值
     */
    public static String replacePrice(String price, String value) {
        char[] replaceValue = value.toCharArray();
        char[] originalValue = price.toCharArray();
        int bout = 0;
        for (int i = 0; i < originalValue.length; i++) {
            char ov = originalValue[i];
            if (ov == 'X') {
                char rv = replaceValue[bout];
                originalValue[i] = rv;
                bout++;
            }
        }
        return String.valueOf(originalValue);
    }

    /**
     * TODO 获取文字在数组中的位置
     * @param arr
     * @param value
     * @return int
     * @date 2019/12/19 14:24
     */
    public static int getValueIndex(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static String toSafeString(String str) {
    	return str == null ? "" : str;
    }

   /* public static int sum(String value) {
        if(com.tcl.uf.common.base.util.StringsUtil.isEmpty(value)){
            return 0;
        }
        char[]  valueChars= value.toCharArray();
        int sum = 0;
        for (char c : valueChars) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }*/

    public static String getStringByEnter(int length, String string) {
        try{
            for (int i = 1; i <= string.length(); i++) {
                if (string.substring(0, i).getBytes("GBK").length > length) {
                    return string.substring(0, i - 1) + "\n" + getStringByEnter(length, string.substring(i - 1));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return string;
        }
        return string;
    }

    public static List<Integer> stringSplitList(String s) {

        List<Integer> data = new ArrayList<>();

        if (StringUtils.isEmpty(s)) {
            return data;
        }

        String[] split = s.split(",");
        for (String item : split) {
            if (!StringUtils.isEmpty(item)) {
                data.add(Integer.valueOf(item));
            }
        }

        return data;
    }

    public static int parseInt(String str) {
        int intValue = 0;
        if (StringUtils.isEmpty(str)) {
            return intValue;
        }
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intValue;
    }

    public static int parseInt(Object str) {
        int intValue = 0;
        if (StringUtils.isEmpty(str)) {
            return intValue;
        }
        try {
            Integer.parseInt((String) str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intValue;
    }

    public static String fileName(String originalFilename){
        String newName = null;
        if(StringUtils.isEmpty(originalFilename)){
            return newName;
        }
        String fileName = getUUID32();
        String [] fileNames =originalFilename.split("\\.");
        return fileName.concat(".").concat(fileNames[1]);
    }

    private static String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    public static String getShortUuid() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            stringBuilder.append(chars[x % 0x3E]);
        }
        return stringBuilder.toString();

    }

    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}
