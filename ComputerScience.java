/**
*Class computerscience is a child of Course.
*
*@author lulku3
*@version 11.0.13
*/
public class ComputerScience extends Course {
    private String language;
    /**
    *4 arg computerscience constructor.
    *@param courseName name of course
    *@param id of class
    *@param professorName name of prof
    *@param language of coding
    */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);
        if (language == null || language.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.language = language;
        }
    }
    //Methods
    @Override
    public String toString() {
        String s = super.toString();
        String s1 = String.format("ComputerScience,%s,%s", s, language);
        return s1;
    }
    @Override
    public boolean equals(Object otherCS) {
        if (otherCS instanceof ComputerScience && otherCS != null) {
            return super.equals(otherCS) && this.language.equals(((ComputerScience) otherCS).language);
        } else {
            return false;
        }
    }
}