import java.util.Arrays;

public class Main {
public static boolean contains(char[] arr,char[] search, int start){
int i=0;
    while (i<search.length){
        if(arr[i+start]!=search[i]) {
            return false;
        }
        i++;
}
return true;
}
public static int countVxod(char[] arr, char[] search){
    int i=0,count=0;
    while (i<=arr.length-search.length){
        if (contains(arr,search,i)){
            count++;
            i+= search.length;
        }
        i++;
    }
    return count;
}
public static int indexoff(char[]arr,char[]search,int start){
    int i=start;
    while (i< arr.length){
        if(contains(arr,search,i)) {
            return i;
        }
        i++;
    }
    return -1;
}
public static char[] replaceAll(char[]original, char[] oldstar, char[] newStr){
    int countEnter=countVxod(original,oldstar);
    if (countEnter==0){
        return original;
    }
    int newSize=original.length-(oldstar.length*countEnter)+(newStr.length*countEnter);
            char[] result=new char[newSize];
            int startIndex=0;
            int findIndex=0;
            int resultIndex=0;
            while ((findIndex=indexoff(original,oldstar,startIndex))!=-1){
                result=arrayCopy(original,startIndex,result,resultIndex,findIndex-startIndex);
                resultIndex+=findIndex-startIndex;
                result=arrayCopy(newStr,0,result,resultIndex,newStr.length);
                resultIndex+=newStr.length;

                startIndex=findIndex+oldstar.length;
    }
    result=arrayCopy(original,startIndex,result,resultIndex, original.length-startIndex);


    return result;
}
public static char[] arrayCopy(char[]str,int strindex,char[]dest, int destIndex,int leng){
    int i=0;
    while (i<leng){
        dest[destIndex+i]=str[strindex+i];
        i++;
    }
    return dest;
}




    public static void main(String[] args) {
String str="Igor, kak dela Igor, poka Igor";
char[] arr=str.toCharArray();
char[] search="Igor".toCharArray();
char[] newstr="Oleg".toCharArray();
        System.out.println(contains(arr,search,0));
        System.out.println(countVxod(arr,search));
        System.out.println(indexoff(arr,search,0));
        System.out.println(replaceAll(arr,search,newstr));
    }
}