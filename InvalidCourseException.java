/**
*Exception that is specialized for Course.
*
*@author lulku3
*@version 11.0.13
*/
public class InvalidCourseException extends IllegalArgumentException {
    private String message;
    /**
    *single arg constructor.
    *@param message error message
    */
    public InvalidCourseException(String message) {
        this.message = message;
    }
    /**
    *Default constructor.
    */
    public InvalidCourseException() {
        this("Invalid course type!");
    }
}