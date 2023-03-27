package com.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: LongyunBian
 * @date: 2023/3/26 13:03
 * @Description: 某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。
 */
public class PurchaseCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        String  products = sc.next();
        String [] productPrices =  products.substring(1,products.length()-1).split(",");
        int [] prices = new int[productPrices.length];
        for (int i =0;i<prices.length;i++){
            prices[i] = Integer.parseInt(productPrices[i]);
        }
        int [] [] dp = new int[prices.length+1][money+1];
        for (int i=1;i<prices.length+1;i++){
            dp[i][0] =1;
        }
        for (int i=1;i<prices.length+1;i++){
            for (int j=1;j<money+1;j++){
                dp[i][j] = dp[i-1][j];
                if (j>=prices[i-1])
                    dp[i][j] += dp[i][j-prices[i-1]];
            }
        }
        System.out.println(dp[prices.length][money]);

    }
}
