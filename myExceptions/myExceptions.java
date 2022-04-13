
package myExceptions;


public class myExceptions extends Exception {
    public myExceptions(String errorMessage) {
        super(errorMessage);
    }

    public class InvalidArg extends myExceptions {
        public InvalidArg(String errorMessage) {
            super(errorMessage);
        }
    }
}

  class WrongFileNameException extends myExceptions {
    public WrongFileNameException(String errorMessage) {
        super(errorMessage);
    }
}

class Exception2 extends myExceptions {
    public Exception2(String errorMessage) {
        super(errorMessage);
    }
}

//  public class InvalidArg extends myExceptions {
//     public InvalidArg(String errorMessage) {
//         super(errorMessage);
//     }
// }

// throw new myExceptions("GeeksGeeks");