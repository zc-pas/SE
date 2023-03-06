package ae2.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ae2.src.Course;

public class FileSystem implements IOsystem {
    // read from a txt file
    public static void readfromFile(String strFile){
        FileReader FR = null;
        try{
            FR=new FileReader(strFile);
            try (Scanner s = new Scanner(FR)) {
                //read all course
                if(s.hasNextLine()){
                    String line=s.nextLine();
                    if(line.equals("<Course>")){
                        line=s.nextLine();
                        while(!line.equals("<Course>")){
                            try (Scanner lineScanner = new Scanner(line)) {
                                int id=lineScanner.nextInt();
                                String name=lineScanner.next();
                                String type=lineScanner.next();
                                Course c=null;
                                if(lineScanner.hasNext()){
                                    c=new Course(type,name,id,lineScanner.next());
                                }else{
                                    c=new Course(type, name,id);
                                }
                                Database.courseList.add(c);
                            }
                            line=s.nextLine();
                        }
                    }
                }

                //read all teacher
                if(s.hasNextLine()){
                    String line=s.nextLine();
                    if(line.equals("<Teacher>")){
                        line=s.nextLine();
                        while(!line.equals("<Teacher>")){
                            try (Scanner lineScanner = new Scanner(line)) {
                				int id=lineScanner.nextInt();
                				String name=lineScanner.next();
                				ArrayList<String> cap=new ArrayList<String>();
                				while(lineScanner.hasNext()){
                				    cap.add(lineScanner.next());
                				}
                				Teacher t=new Teacher(id,name,cap);
                				Database.teacherList.add(t);
                			}
                            line=s.nextLine();
                        }
                    }
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(FR!=null){
                    FR.close();
                    
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    };
    public static void saveasFile(String strFile) throws IOException{
        FileWriter FW=null;
        try{
            FW=new FileWriter(strFile);
            String allCourse="<Course>";
            allCourse+="\n";
            if(!Database.courseList.isEmpty()){
                for(Course c:Database.courseList){
                    allCourse+=c;
                    allCourse+="\n";
                }
            }
            allCourse+="<Course>";
            allCourse+="\n";
            String allTeacher="<Teacher>";
            allTeacher+="\n";
            if(!Database.teacherList.isEmpty()){
                for(Teacher t:Database.teacherList){
                    allTeacher+=t;
                    allTeacher+="\n";
                }
            }
            allTeacher+="<Teacher>";
            FW.write(allCourse+allTeacher);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            try{
                if(FW!=null){
                    FW.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
