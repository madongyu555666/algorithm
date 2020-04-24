package com.company.快手;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/4/2216:29
 */
public class 验证IP地址 {
    /*编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
    IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
    同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
    IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
    然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
    同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
    说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
    */

    /**
     * 分治法
     */
    
    
    
    public static String validateIPv4(String IP) {
        String[] nums=IP.split("\\.",-1);
        for (String num : nums) {
            //块的长度在1到3之间
            if(num.length()==0||num.length()>3){
                return "Neither";
            }
            //没有多余的前导零
            if(num.charAt(0)=='0'&&num.length()!=1){
                return "Neither";
            }
            //只允许数字
            for (char ch:num.toCharArray()){
                if(!Character.isDigit(ch)){
                    return "Neither";
                }
            }
            if(Integer.parseInt(num)>255){
                return "Neither";
            }

        }
        return "IPv4";
    }





    public static String validateIPv6(String IP) {
        String[] nums=IP.split(":",-1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String num : nums) {
            ////验证范围（0，2**16）中的十六进制：
            ////一。一个块中至少有一个且不超过4个十六进制数字
            if(num.length() ==0|| num.length()>4){
                return "Neither";
            }
            for (char ch:num.toCharArray()){
                if(hexdigits.indexOf(ch)==-1){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public static  String validIPAddress(String IP) {
        if(IP.chars().filter(ch->ch=='.').count()==3){
            return validateIPv4(IP);
        }else if(IP.chars().filter(ch->ch==':').count() ==7) {
            return validateIPv6(IP);
        }else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        //String address = validIPAddress("172.16.254.1");
        String address = validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        System.out.println(address);
    }


}
