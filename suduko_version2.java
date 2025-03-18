import java.util.Scanner;
class suduko{
  public int level ;
  public static final String company = "BHD_BROTHERS";
  private int size ;
  private int difficulty_per ;  
  int [] [] ans ;
  int [][]missing_value_array;
  String ans_string ;
  int [] [] final_ans;
  String final_ans_string ;
  boolean is_current_level_passed = false ;
  suduko(int level ){
  	this.level = level;
  	size = calculate_size(level);
  	difficulty_per = level*10;
  	ans = new int[size][size];
  	final_ans = new int[size][size];
  	}
  public static void operate(suduko obj){
  obj.display_greed();}
  
  public static void main(String[] args){
  suduko s1 = new suduko(1);
  s1.display_greed();
  Scanner scanner = new Scanner(System.in);
  while (true) {
       System.out.println("\n=== Sudoku Game Menu ===");
       System.out.println("1. Enter Sudoku Data");
       System.out.println("2. Show Answer");
       System.out.println("3. Exit");
       if(s1.is_current_level_passed)System.out.println("4. Move to the next level");
       System.out.print("Choose an option: ");
            
      int choice = scanner.nextInt();
            
       switch (choice) {
           case 1:
                s1.takeInputOneByOne(); // Call function to take input one by one
                break;
           case 2:
                System.out.println("correct ans is : \n");
                s1.showing_ans();
                break;
          
           case 3:
                System.out.println("Exiting... Thank you for playing!");
                scanner.close();
                return;
           case 4 :
                s1  = new suduko(s1.size+1);
                operate(s1);
                break;
           default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
  
  
  
  
  
  
  
  
  }
  public int calculate_size(int level){ 
      return level;}
  private int no_of_missing_value(){
       return (int)Math.ceil(size*difficulty_per/100F);  
  }
  
  

  public void display_greed() {
       String s = "" + size;
        int width = s.length();
        
       
        s = "\u250C" + "\u2500".repeat(width + 2) + "\u2510" + " ";
        s = s.repeat(size)+"  "+"\u2502"+"\n";
        s = "\u2502" +"  "+s;
        int length = s.length()-1;
        String str = "\u2502" + " "+"%s"+" " + "\u2502" + " ";
        str = str.repeat(size)+"  "+"\u2502"+"\n";
        str = "\u2502" +"  "+str;
       s += str ;
      
       str = "\u2514" + "\u2500".repeat(width + 2) + "\u2518" +" ";
       str= str.repeat(size)+"  "+"\u2502"+"\n";
        
        str = "\u2502" +"  "+str;
        s += str ;
        s = s.repeat(size);
        ans_string = s;
      
       
        int [][]arr = generate_pattern();
        final_ans = arr;
        missing_value_array = generate_pattern(no_of_missing_value(),size);
        preparing_ans(arr,missing_value_array);
        //display_array(missing_value_array,missing_value_array[0].length);
        //display_array(ans,size);
           for(int i = 0 ; i < size ;i ++){
                for(int j = 0 ; j < size ; j++){
                    String s2 = "";
                    if(check_availability(missing_value_array,i,j)){
                        s2 += " ".repeat(width);}
                   else{
                    s2 =""+ arr[i][j];
                   s2 = " ".repeat(width-s2.length())+s2;}
                    s = s.replaceFirst("%s",s2);
                  }}
        String st = "\u250C"+"\u2500".repeat(length-2)+"\u2510"+"\n";
        str = "\u2502"+" ".repeat(length-2)+"\u2502"+"\n";
     
        ans_string = st+str+ans_string+str+"\u2514"+"\u2500".repeat(length-2)+"\u2518"+"\n"; 
        final_ans_string = ans_string ;
        s = st+str+s+str+"\u2514"+"\u2500".repeat(length-2)+"\u2518"+"\n"; 
       System.out.println(s);}
void display_ans(){
     String s = "" + size;
     int width = s.length();
     s = final_ans_string ;
     String s1 = ans_string;
     for(int i = 0 ; i < size;i++){
         for(int j = 0 ; j < size; j++){
         	String s2 = "";
                    if(check_availability(missing_value_array,i,j)){
                        s2 += " ".repeat(width);}
                   else{
                    s2 =""+ final_ans[i][j];
                   s2 = " ".repeat(width-s2.length())+s2;}
                    s= s.replaceFirst("%s",s2);}}
     for(int i = 0 ; i < size;i++){
         for(int j = 0 ; j < size; j++){
         	String str = ""+ans[i][j];
		s1 =s1.replaceFirst("%s",str);}}
     
     System.out.println("your asked question was : " +" ".repeat(4)+ "your Submitted values are as follows :" +"\n"+"\n"+ display_ans_ans(s1,s));}
     
     
void showing_ans(){
   String string = final_ans_string;
   for(int i = 0 ; i < size;i++){
         for(int j = 0 ; j < size; j++){
         	String str = ""+final_ans[i][j];
		string =string.replaceFirst("%s",str);}}
    System.out.println(string);}
     

void preparing_ans (int[][]arr, int [][]m_array){
	for(int i = 0 ; i < size ;i++){
		for(int j = 0 ; j < size ;j++){
			if(check_availability(m_array,i,j))ans[i][j]=0;
			else ans[i][j]=arr[i][j];}}}
boolean check_availability(int [] [] arr , int i , int j){
	int length = arr[0].length;
	for(int k = 0 ; k < length ;k++){
		if(j == arr[i][k])return true;}
	return false;
}
 String display_ans_ans(String s1 ,String s){
     String []string_arrays = s1.split("\n");
     String []final_string_arrays = s.split("\n");
     String ans = "";
     for(int i = 0 ; i < string_arrays.length; i++){
     	ans  = ans + final_string_arrays[i]+ " ".repeat(4)+string_arrays[i];
     	ans += "\n";
      }
      return ans ;
}

int[] n_array(){
	int [] arr = new int [size];
	for(int i = 0 ; i < size ;i++){
	arr[i]=i+1;}
	return arr;}
int[] n_array(boolean is_0_index){
	int [] arr = new int [size];
	for(int i = 0 ; i < size ;i++){
	arr[i]=i;}
	return arr;}
void  possible_array(int[]arr,int integer){
        for(int i = 0 ; i < arr.length ;i++){
           if(arr[i] == integer)arr[i]=0;
           }
           }
void  possible_array(int[]arr,int integer,boolean is){
        for(int i = 0 ; i < arr.length ;i++){
           if(arr[i] == integer)arr[i]=size;
           }
           }
int[] possible_array(int[][] arr, int i , int j){
	int[] narray = n_array();
	for(int k = 0 ; k < i ;k++){
		possible_array(narray,arr[k][j]);}
	for(int k = 0 ; k < j ;k++){
		possible_array(narray,arr[i][k]);}
	int count = 0 ; 
	for(int k = 0 ; k < size ; k ++){
		if(narray[k]!= 0)count++;}
	int[] array = new int[count];
	count = 0 ;
	for(int k = 0 ; k < narray.length ;k++){
		if(narray[k]!=0 ){
		   array[count]=narray[k];
		   count++;}
		   }
	return array;
	}
int[] possible_array1(int[][] arr, int i , int j){
	int[] narray = n_array(true);
	for(int k = 0 ; k < j ;k++){
		possible_array(narray,arr[i][k],true);}
	int count = 0 ; 
	for(int k = 0 ; k < size ; k ++){
		if(narray[k]!= size)count++;}
	int[] array = new int[count];
	count = 0 ;
	for(int k = 0 ; k < narray.length ;k++){
		if(narray[k]!=size ){
		   array[count]=narray[k];
		   count++;}
		   }
	return array;
	}

void display_array(int [] [] arr, int length){
	for(int i = 0 ; i <arr.length ; i++){
		for(int j = 0 ; j < length ; j++){
		System.out.print(arr[i][j]+" ");
		}
		System.out.println();
		}
}
int  count(int [] arr){
    int cnt = 0 ;
    for(int i = 0 ; i < arr.length;i++){
        if(arr[i]!=0)cnt ++ ;
        }
     return cnt;}
boolean is_ans_correct(){
	int sum = 0 ;
	for(int i = 1 ; i <= size;i++){
		sum+= i;}
	int sum1 = 0 ;
	for ( int i = 0 ; i < size ; i++){
	     for(int j= 0 ; j < size ;j++){
	     sum1+= ans[i][j];}}
        if(sum1 != sum)return false;
        sum1 = 0 ;
        for ( int i = 0 ; i < size ; i++){
	     for(int j= 0 ; j < size ;j++){
	     sum1+= ans[j][i];
	        }    
        }
        if(sum1 != sum)return false;
        else return true;
	
	}
boolean is_array_valid(){
     for ( int i = 0 ; i < size ; i++){
	     int []array = n_array();
	     for(int j= 0 ; j < size ;j++){
	        possible_array(array,ans[i][j]);}
	      if(count(array)>0)return false ;
        }
        for ( int i = 0 ; i < size ; i++){
	     int []array = n_array();
	     for(int j= 0 ; j < size ;j++){
	        possible_array(array,ans[j][i]);}
	      if(count(array)>0)return false ;
        }
        return true;
}
boolean check_with_final_ans(){
         for ( int i = 0 ; i < size ; i++){
	     for(int j= 0 ; j < size ;j++){
	         if(ans[i][j] != final_ans[i][j])return false ;
	        }
	      
        } return true ;}
void checking(){
    if(check_with_final_ans()){
    is_current_level_passed=true;
    System.out.println("congradulation your ans is correct ");}
    else if( is_array_valid() && is_ans_correct()){
    is_current_level_passed=true;
    System.out.println("congradulation your ans is correct");}
    else System.out.println("your ans is wrong please try again");}
int [][]arr(){
       int [][]arr = new int[size][size];
        for(int i = 0 ; i < size;i ++){
            arr[0][i] = i+1;}
        for( int i = 0 ; i < size;i++){
            int sum = arr[0][i];    
           for(int j = 0 ; j <size;j++){
                sum += 1;
               if(sum > size)sum = 1 ;
              arr[j][i]=sum;}}
        return arr;}
 public void takeInputOneByOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Sudoku numbers one by one:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                while (true && check_availability(missing_value_array,i,j) ) {  
                   
                    System.out.print("Enter number at row " + (i + 1) + ", column " + (j + 1) + ": ");
                    if (scanner.hasNextInt()) {
                        int num = scanner.nextInt();
                        if (num >= 0 && num <=size ) {  
                            ans[i][j] = num;
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number between 1 and "+size+".");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        scanner.next(); // Clear invalid input
                    }
                }
            }
        }
        System.out.print("Till NOW YOUR  ANSWER LOOKS LIKE : \n");
        display_ans();
       while (true) {
       System.out.println("\n=== Sudoku Submition Menu ===");
       System.out.println("1. REEnter Sudoku Data");
       System.out.println("2. Submit Answer"); 
       System.out.print("Choose an option: ");     
      int choice = scanner.nextInt();     
       switch (choice) {
           case 1:
                this.takeInputOneByOne(); // Call function to take input one by one
                break;
          
           case 2:
                System.out.println("Submitting the Answer");
                display_ans();
                this.checking();
               
                return;
           default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
    
        
    }}
int[][] generate_pattern(){
	int [][]arr2 = arr() ;
	for(int i = 0 ; i < size ;i ++){
		for(int j = 0 ; j < size ;j++){
			int []array = possible_array(arr2,i,j);
			if(array.length>0)arr2[i][j]=array[(int)(System.nanoTime()%array.length)];
			else return  generate_pattern();}}
	return arr2;
	}
int[][] generate_pattern(int width , int length){
	int [][]arr2 = new int [length] [width];
	for(int i = 0 ; i < length ;i ++){
		for(int j = 0 ; j < width ;j++){
			int []array = possible_array1(arr2,i,j);
			if(array.length>0)arr2[i][j]=array[(int)(System.nanoTime()%array.length)];
			else return  generate_pattern(width,length);}}
	return arr2;
	}


}


