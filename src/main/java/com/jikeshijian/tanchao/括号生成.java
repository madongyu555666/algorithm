package com.jikeshijian.tanchao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madongyu
 * @title: 括号生成
 * @projectName algorithm
 * @description: 22
 * @date 2020/5/1821:45
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        // 执行深度优先遍历，搜索可能的结果
        dfs("", result,n, n);
        return result;

    }

    private void dfs(String sublist,List<String> result, int left, int right) {
        if(left==0 && right==0){
            result.add(sublist);
             return;
        }

        //判断左括号
        if(left>0){
            dfs(sublist+"(",result,left-1,right);
        }
        //右
        if(left<right){
            dfs(sublist+")",result,left,right-1);
        }
    }
}
