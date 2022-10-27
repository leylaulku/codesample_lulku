/**
*Class labscience that is a child of course.
*
*@author lulku3
*@version 11.0.13
*/
public class LabScience extends Course {
    private boolean labCoatRequired;
    /**
    *4 arg constructor for labscience.
    *@param courseName name of course
    *@param id of class
    *@param professorName name of professor
    *@param labCoatRequired boolean value representing whether lab coat needed
    */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }
    //Methods
    @Override
    public String toString() {
        String s = super.toString();
        String s1 = String.format("LabScience,%s,%b", s, labCoatRequired);
        return s1;
    }
    @Override
    public boolean equals(Object otherLS) {
        if (otherLS instanceof LabScience && otherLS != null) {
            return super.equals((LabScience) otherLS)
                && this.labCoatRequired == ((LabScience) otherLS).labCoatRequired;
        } else {
            return false;
        }
    }
}