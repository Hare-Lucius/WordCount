package wordCount;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
  

public class wordCount 
{
	 static String[] slist=new String[30];
	 static int count=0,ccount,wcount,lcount,ocount=0,acount,ecount,scount,cf=0,wf=0,lf=0,of=0,af=0,ef=0,sf=0;
	 public static void main(String[] args)
	 {
		 //count��¼c�ļ���λ��
		 
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
		 if(args[ii].equals("-a"))
		 {
			 acount=ii;
			 if(count<acount)
				 count=acount;
			 af=1;
		 }
		 if(args[ii].equals("-s"))
		 {
			 scount=ii;
			 if(count<scount)
				 count=scount;
			 sf=1;
		 }
		 if(args[ii].equals("-e"))
		 {
			 ecount=ii;
			 
			 if(args.length<=ecount+1||!args[ecount+1].contains(".txt"))
				 System.out.println("������ͣ�ôʱ�");
			 else
			 {
				 ef=1;
				 readstop(args[ecount+1]);
			 }
		 }
		 }
		 count++;//ͳ�Ƹ����������λ��
		 if(of==1)
		 { 
			    try {  
			        File file = new File(args[ocount+1]);  
			        if (!file.exists()) {  
			            file.createNewFile();  
			        }  
			       FileWriter fileWriter =new FileWriter(file);
		            fileWriter.write("");
		            fileWriter.flush();
		            fileWriter.close();
			         
			    } catch (IOException e) {  
			        e.printStackTrace();  
			    }//�����д������ļ�  
			
			 
		 }
		 if(sf==1){
			 
			 if(!args[count].contains("\\"))
			 {
				 //File sfile=new File(this.getClass().getResource("").getPath()); 
				 
				  
				try {
					File sfile = new File("");//����Ϊ�� 
					String courseFile = sfile.getCanonicalPath();
					sfile = new File(courseFile);
					getFiles(sfile,args);
					//System.out.println("11");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 }
			 else 
			 {
				 try {
					 String[] sav=new String[40];
					 String sa=new String("");
					 //String sv=new String("");
					 sav=args[count].split("\\\\");
					 for(int co=0;co<sav.length-1;co++){
						 if(co<sav.length-1)
						  sa=sa+sav[co]+"\\";
					 }
					 //sv=sa+"\\"+sv+sav[sav.length-1];
					 //System.out.println("sv:"+sv);
						File sfile1 = new File(sa);//����Ϊ�� 
						String courseFile1 = sfile1.getCanonicalPath();
						sfile1 = new File(courseFile1);
						getAbsFiles(sfile1,args);
						//System.out.println(args[count]);
						//System.out.println(sfile1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			 }
		 }
		 
		 else
		 {
			 File fle=new File(args[count]);
			 countFile(fle,args,args[count]);
		 }
		
	 }
	
	/* public static void getAllJavaFilePaths(File srcFolder,String[] args) {  
	        // ��ȡ��Ŀ¼�µ��ļ������ļ��е�File����  
	        File[] fileArray = srcFolder.listFiles();  
	  
	        // ������File����,�õ�ÿһ��File����  
	        for (File file : fileArray) {  
	            if (file.isDirectory()) {  
	                getAllJavaFilePaths(file,args);  
	            } else {  
	                if (file.getName().endsWith(".c")) {  
	                    System.out.println(file.getAbsolutePath());  
	                }  
	            }  
	        }  
	    }*/  	 
	 
	 
	 
 public static void readstop(String stxt){
	 try{
	 Scanner in = new Scanner(new File(stxt));
	 while (in.hasNextLine()) 
	 {
		 String strtxt = in.nextLine();
         slist=strtxt.split("\\s");
	 }}
	 catch(IOException e) {  
	        e.printStackTrace();  
	    }
	 
 }
 public static void getFiles(File dir,String args[]){

	  if(dir.isDirectory())
	  {        //�ж��Ƿ�Ŀ¼��
	   File[] files=dir.listFiles(new FilenameFilter()   //����������������ļ�����Ϊ.java���ļ�
	   {
	    public boolean accept(File dir,String name)
	    {
	     return name.endsWith(".c");
	    }
	   });
	   for(int x=0;x<files.length;x++)        //��ӡ��.java��β���ļ���
	   {
		   String tm=""+files[x];
		   String[] cut=tm.split("\\\\");
		   tm=cut[cut.length-1];
			   
	    //System.out.println(files[x]); 
		   countFile(files[x],args,tm);
	   }
	   File[] files1=dir.listFiles();   //����û�й��������ļ��б�
	   for(int x=0;x<files1.length;x++)        
	   {
	    if(files1[x].isDirectory())   //�����Ŀ¼��ݹ���÷���,����Ŀ¼�����
	     getFiles(files1[x],args);  
	   }
	  }
 }
 
 
 public static void getAbsFiles(File dir,String args[]){

	  if(dir.isDirectory())
	  {        //�ж��Ƿ�Ŀ¼��
	   File[] files=dir.listFiles(new FilenameFilter()   //����������������ļ�����Ϊ.java���ļ�
	   {
	    public boolean accept(File dir,String name)
	    {
	     return name.endsWith(".c");
	    }
	   });
	   for(int x=0;x<files.length;x++)        //��ӡ��.java��β���ļ���
	   {
		   String tm=""+files[x];
		   String[] cut=tm.split("\\\\");
		   tm=cut[cut.length-1];
			   
	    //System.out.println(files[x].getAbsolutePath()); 
		   countFile(files[x],args,tm);
	   }
	   File[] files1=dir.listFiles();   //����û�й��������ļ��б�
	   for(int x=0;x<files1.length;x++)        
	   {
	    if(files1[x].isDirectory())   //�����Ŀ¼��ݹ���÷���,����Ŀ¼�����
	     getFiles(files1[x],args);  
	   }
	  }
}
 
 public static void countFile(File fl,String[] args,String ai){
	 try 
	 {
		 
		 int cha=0,word=0,line=0,m=0,cline=0,sline=0,aline=0,tmp=0,astart=0,snum=0;
		 int v=0;
		 String[] sto=new String [100];
		 Scanner in = new Scanner(fl);
		 while (in.hasNextLine()) 
		 {
			 String str = in.nextLine();
             for(int i=0;i<str.length();i++)
             {
            	 char b=str.charAt(i);
            	 if(b!=9&&b!=32&&b!=44)
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
             sto=str.split("\\s+|,+");
             for(int j=0;j<sto.length;j++)
             {
            	 for(int k=0;k<slist.length;k++)
            	 {
            		 if(sto[j].equals(slist[k]))
            			 snum++;
            	 }
     
             }
             cha+=m;
             word-=snum;
             snum=0;
             if(str.length()<2&&astart==0)
            	 sline++;
             if(str.contains("//")&&astart==0)
            	 aline++;
             if(str.contains("/*")&&astart==0)
            	 astart=1;
             if(str.contains("*/")&&astart==1)
             {
            	 astart=0;
            	 if(str.length()<3)
            	 {
            	 aline=aline+tmp+1;
            	 tmp=0;
            	 }
            	 else if(str.contains("/*"))
            	 {
            		 aline++;
            	 }
            	 else
            	 {
            		 aline=aline+tmp;
            		 tmp=0;
            	 }
             }
             line++;
             if(astart==1&&str.length()>0)
            	 tmp++;
         } //ͳ���ַ�����������������
		 
		 cline=line-sline-aline;
		 
	
		 if(cf==1)
		 {
			 
			 System.out.println(ai+", �ַ�����"+cha);	
		 }
		 if(wf==1)
		 {
			 System.out.println(ai+", ��������"+word);
		 }
		 if(lf==1)
		 {
			 System.out.println(ai+", ������"+line);
		 }
		 if(af==1)
		 {
			 System.out.println(ai+", ������/����/ע���У�"+cline+"/"+sline+"/"+aline);
		 }
		 if(of==1)
		 {
			 BufferedWriter bw = null;  
			    try {  
			        File file = new File(args[ocount+1]);  
			        
			        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);  
			        bw = new BufferedWriter(fw);
			        //bw.write(args[count]+", �ַ�����"+cha+"\r\n"+args[count]+", ��������"+word+"\r\n"+args[count]+", ������"+line+"\r\n");
			        if(cf==1)
			        	bw.write(ai+", �ַ�����"+cha+"\r\n");
			        if(wf==1)
			            bw.write(ai+", ��������"+word+"\r\n");
			        if(lf==1)
			            bw.write(ai+", ������"+line+"\r\n");
			        if(af==1)
			        	bw.write(ai+", ������/����/ע���У�"+cline+"/"+sline+"/"+aline+"\r\n");
			        bw.close();  
			    } catch (IOException e) {  
			        e.printStackTrace();  
			    }//�����д������ļ�  
			
			 
		 }//��������Ĳ���ѡ���Ӧ�Ĵ���ʽ
		 }
		   
      
	 catch (FileNotFoundException e) 
	 {
		 System.out.print("��������Ҫͳ�Ƶ��ı�����");
            
     }
 }
}



