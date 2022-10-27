/**
*Abstract class course representing a course.
*
*@author lulku3
*@version 11.0.13
*/
public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;
    /**
    *3 arg constructor for course.
    *@param courseName name of course
    *@param id of class
    *@param professorName name of prof
    */
    public Course(String courseName, int id, String professorName) {
        if (courseName != null && courseName != "") {
            this.courseName = courseName;
        } else {
            throw new IllegalArgumentException();
        }
        if (id >= 10000 && id <= 99999) {
            this.id = id;
        } else {
            throw new IllegalArgumentException();
        }
        if (professorName != null && professorName != "") {
            this.professorName = professorName;
        } else {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public String toString() {
        String s = String.format("%s,%d,%s", courseName, id, professorName);
        return s;
    }
    @Override
    public boolean equals(Object otherCourse) {
        if (otherCourse instanceof Course && otherCourse != null) {
            return this.courseName.equals(((Course) otherCourse).courseName)
                && this.id == ((Course) otherCourse).id
                && this.professorName.equals(((Course) otherCourse).professorName);
        } else {
            return false;
        }
    }
}