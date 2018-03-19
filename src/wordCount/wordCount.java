package wordCount;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class wordCount 
{
	 public static void main(String[] args)
	 {
		 int count=0,ccount,wcount,lcount,ocount=0,cf=0,wf=0,lf=0,of=0;
		 for(int ii=0;ii<args.length;ii++)
		 {
		 if(args[ii].equals("-c"))
		 {
			 ccount=ii;
			 count=ccount;
			 cf=1;
		 }
		 if(args[ii].equals("-w"))
		 {
			 wcount=ii;
			 if(count<wcount)
				 count=wcount;
			 wf=1;
		 }
		 if(args[ii].equals("-l"))
		 {
			 lcount=ii;
			 if(count<lcount)
				 count=lcount;
			 lf=1;
		 }
		 if(args[ii].equals("-o"))
		 {
			 ocount=ii;
			 of=1;
		 }
		 }
		 count++;//统计各输入参数的位置
		 
		 try 
		 {
			 
			 int cha=0,word=0,line=0,m=0;
			 int v=0;
			 Scanner in = new Scanner(new File(args[count]));
			 while (in.hasNextLine()) 
			 {
				 String str = in.nextLine();
	             for(int i=0;i<str.length();i++)
	             {
	            	 char b=str.charAt(i);
	            	 if((b>=97&&b<=122)||(b>=65&&b<=90))
	            	 {
	            		 v++;
	            		 if((i==str.length()-1))
	            		 {
	            			 word++;
	            			 v=0;
	            		 }
	            	 }
	            	 else
	            	 {
	            		 if(v>0)
	            		 {
	            			 word++;
	            			 v=0;
	            		 }
	                 }
	            	 m=i+1;
	             }
	             cha+=m;
	             line++;
	         }//统计字符数、单词数、行数
			 
			 
			 if(cf==1)
			 {
				 
				 System.out.println(args[count]+", 字符数："+cha);	
			 }
			 if(wf==1)
			 {
				 System.out.println(args[count]+", 单词数："+word);
			 }
			 if(lf==1)
			 {
				 System.out.println(args[count]+", 行数："+line);
			 }
			 if(of==1)
			 {
				 BufferedWriter bw = null;  
				    try {  
				        File file = new File(args[ocount+1]);  
				        if (!file.exists()) {  
				            file.createNewFile();  
				        }  
				        FileWriter fileWriter =new FileWriter(file);
			            fileWriter.write("");
			            fileWriter.flush();
			            fileWriter.close();
				        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);  
				        bw = new BufferedWriter(fw);
				        //bw.write(args[count]+", 字符数："+cha+"\r\n"+args[count]+", 单词数："+word+"\r\n"+args[count]+", 行数："+line+"\r\n");
				        if(cf==1)
				        	bw.write(args[count]+", 字符数："+cha+"\r\n");
				        if(wf==1)
				            bw.write(args[count]+", 单词数："+word+"\r\n");
				        if(lf==1)
				            bw.write(args[count]+", 行数："+line+"\r\n");
				        bw.close();  
				    } catch (IOException e) {  
				        e.printStackTrace();  
				    }//将结果写进输出文件  
				
				 
			 }//根据输入的参数选择对应的处理方式
			 }
			   
	      
		 catch (FileNotFoundException e) 
		 {
			 System.out.print("请输入需要统计的文本名！");
	            
	     }
	 }
	 
}



