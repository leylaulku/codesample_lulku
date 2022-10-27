import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
*Class representing classes which holds other methods.
*
*@author lulku3
*@version 11.0.13
*/
public class Classes {
    /**
    *method which puts courses into an arraylist.
    *@param name of file
    *@return ArrayList<Course>> representing courses
    */
    public static ArrayList<Course> outputCourses(String name) throws FileNotFoundException, InvalidCourseException {
        ArrayList<Course> ocourses = new ArrayList<Course>();
        String f = name;
        File myFile = new File(f);
        try {
            if (myFile.exists() && myFile.isFile()) {
                Scanner scan = new Scanner(myFile);
                //int count = 0;
                while (scan.hasNextLine()) {
                    String s = scan.nextLine();
                    String[] stringList = s.split(",");
                    ArrayList<String> list = new ArrayList<String>();
                    for (String piece : stringList) {
                        //System.out.println(piece + " " + count);
                        String p = piece.trim();
                        list.add(p);
                    }
                    if (list.get(0).equals("ComputerScience")) {
                        Integer i = Integer.valueOf(list.get(2));
                        Course cs = new ComputerScience(list.get(1), i, list.get(3), list.get(4));
                        ocourses.add(cs);
                    } else if (list.get(0).equals("LabScience")) {
                        Integer i = Integer.valueOf(list.get(2));
                        Boolean b = Boolean.valueOf(list.get(4));
                        Course ls = new LabScience(list.get(1), i, list.get(3), b);
                        ocourses.add(ls);
                    } else {
                        throw new InvalidCourseException();
                    }
                    //count += 1;
                }
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("FNFE caught!");
        }
        return ocourses;
    }
    /**
    *Method which writes courses to file.
    *@param name of file
    *@param courses in arraylist
    *@return boolean true or false
    */
    public static boolean writeCourses(String name, ArrayList<Course> courses) {
        File finalFile = new File(name);
        try {
            //I don't know why this isn't working like it should!!!! I am
            //getting so frustrated but it is what it is right now.
            PrintWriter outWriter = new PrintWriter(finalFile);
            ArrayList<Course> cList = outputCourses(name);
            for (Course item : cList) {
                outWriter.println(item);
            }
            for (Course course : courses) {
                outWriter.println(course);
            }
            outWriter.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("FNFE caught!");
            System.out.println("Error: " + fnf.getMessage());
        } finally {
            return finalFile.length() != 0;
        }
    }
    /**
    *Method which reads courses.
    *@param name of file
    *@param course to be found
    *@return ArrayList<Integer>> line numbers
    */
    public static ArrayList<Integer> readCourses(String name, Course course) throws FileNotFoundException {
        File myFile = new File(name);
        Scanner scan = new Scanner(myFile);
        ArrayList<Integer> lineNum = new ArrayList<Integer>();
        if (myFile.exists() && myFile.isFile()) {
            ArrayList<Course> courses = outputCourses(name);
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).equals(course)) {
                    lineNum.add(i + 1);
                }
            }
        } else {
            throw new FileNotFoundException();
        }
        return lineNum;
    }
    /**
    *Main method for testing.
    *@param args is string
    */
    public static void main(String[] args) throws FileNotFoundException {
        Classes nc = new Classes();
        File newFile = new File("TestCourses.csv");
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Course> crs = new ArrayList<Course>();
        ComputerScience c1 = new ComputerScience("CS", 66666, "leyla ulku", "string");
        ComputerScience c2 = new ComputerScience("yfvfgk", 69696, "blorbly", "meow");
        ComputerScience c3 = new ComputerScience("Glup", 42042, "njfdsnk", "tired");
        LabScience l1 = new LabScience("vf", 89289, "jsnjsdk", true);
        LabScience l2 = new LabScience("jfbfh", 22134, "kjdssn", false);
        LabScience l3 = new LabScience("kjnsk", 19876, "oiioj", true);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        crs.add(l1);
        crs.add(l2);
        crs.add(l3);
        System.out.println(nc.writeCourses("TestCourses.csv", crs));
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }
        //System.out.println(nc.outputCourses("Courses"));
        nc.writeCourses("TestCourses.csv", courses);
        nc.writeCourses("TestCourses.csv", crs);
    }
}