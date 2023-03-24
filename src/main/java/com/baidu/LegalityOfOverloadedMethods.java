package com.baidu;

import java.util.*;

public class LegalityOfOverloadedMethods {

    public static void main(String [] args){

        class Params {

            private ArrayList<String> paramsArr;
            //        boolean isOrder;
            public Params(){
                paramsArr = new ArrayList<>();
            }


            public ArrayList<String> getParamsArr() {
                return paramsArr;
            }



            public void addPara(String paramString){
                String[] strings = paramString.split(",");
                for (String s:strings){
                    s = s.trim();
                    paramsArr.add(s.split(" ")[0]);
                }
                paramsArr.sort(String.CASE_INSENSITIVE_ORDER);


            }


            @Override
            public boolean equals(Object obj){
                //使用 == 检查参数是否为这个对象的引用。
                if(obj == this) {
                    return true;
                }
                //使用instanceof 检查参数是否为正确类型。
                if (!(obj instanceof Params)) {
                    return false;
                }
                Params params2 = (Params) obj;
                ArrayList<String> thatParams = params2.getParamsArr();
                if (paramsArr.size()!=thatParams.size()){
                    return false;
                }
                for (int i=0;i<paramsArr.size();i++){
                    if (!paramsArr.get(i).equals(thatParams.get(i))){
                        return false;
                    }
                }
                return true;

            }
            @Override
            public int hashCode(){
                int value = paramsArr.hashCode();
                return value;
            }

        }
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Set> method2param = new HashMap<>();
        for (int i=0;i<n;i++){
            String method = sc.nextLine();
            String methodName = method.split(" ")[1];
            String paramsString = method.split("\\(")[1];
            if (paramsString.length()==1) {
                paramsString = "";
            } else {
                paramsString = paramsString.split("\\)")[0];
            }
//            System.out.println(paramsString);
            Params params = new Params();
            params.addPara(paramsString);
            Set set = method2param.get(methodName);
            if (set==null){
                set = new HashSet();
                set.add(params);
                method2param.put(methodName,set);
                System.out.println("Yes");
                continue;
            }
            if (set.contains(params)){
                System.out.println("No");
            }else {
                set.add(params);
                System.out.println("Yes");
            }



        }
    }
    public void  test(){

    }
}
