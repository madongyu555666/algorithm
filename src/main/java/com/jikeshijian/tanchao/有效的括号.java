package com.jikeshijian.tanchao;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 20题
 * @date 2020/5/1211:39
 */
public class 有效的括号 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     */
    private HashMap<Character, Character> mappings;
    public 有效的括号(){
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
             char c =s.charAt(i);
             //如果当前字符是右括号。
            if(this.mappings.containsKey(c)){
                //获取堆栈的顶部元素。如果堆栈为空，则将伪值设置为“#”
                char top=stack.empty()?'#':stack.pop();
               //如果此括号的映射与堆栈的顶部元素不匹配，则返回false。
               if(top!=this.mappings.get(c)) {
                   return false;
               }
            }else {
                //如果是一个开口支架，推到堆栈上
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
