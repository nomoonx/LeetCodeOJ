/**
 * Created by noMoon on 2015-01-26.
 */
public class CompareVersionNumbers {
    public static void main(String[] args){
        System.out.println(compareVersion("1.0","1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1array;
        if(version1.contains(".")){
            v1array=version1.split("\\.");
        }else{
            v1array=new String[]{version1};
        }
        String[] v2array;
        if(version2.contains(".")){
            v2array=version2.split("\\.");
        }else{
            v2array=new String[]{version2};
        }
        int length=v1array.length>v2array.length?v2array.length:v1array.length;
        for(int i=0;i<length;i++){
            int temp1=Integer.valueOf(v1array[i]);
            int temp2=Integer.valueOf(v2array[i]);
            if(temp1>temp2) return 1;
            if(temp1<temp2) return -1;
        }
        if(v1array.length>v2array.length){
            for(int j=length;j<v1array.length;j++){
                int temp1=Integer.valueOf(v1array[j]);
                if(temp1>0) return 1;
            }
        }
        if(v1array.length<v2array.length){
            for(int j=length;j<v2array.length;j++){
                int temp2=Integer.valueOf(v2array[j]);
                if(temp2>0) return -1;
            }
        }
        return 0;
    }
}
