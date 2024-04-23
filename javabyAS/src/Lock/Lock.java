package Lock;

import java.util.Arrays;

//Define the Lock class
public class Lock {
 // Declare the attributes
 private String lockModel;
 private int codeLength;
 private int[] code;
 private String lockState;

 // Initialize the attributes with a four-argument constructor
 public Lock(String lockModel, int codeLength, int[] code, String lockState) {
     this.lockModel = lockModel;
     this.codeLength = codeLength;
     this.code = code;
     this.lockState = lockState;
 }

 // Define the getters and setters for the attributes
 public String getLockModel() {
     return lockModel;
 }

 public void setLockModel(String lockModel) {
     this.lockModel = lockModel;
 }

 public int getCodeLength() {
     return codeLength;
 }

 public void setCodeLength(int codeLength) {
     this.codeLength = codeLength;
 }

 public int[] getCode() {
     return code;
 }

 public void setCode(int[] code) {
     this.code = code;
 }

 public String getLockState() {
     return lockState;
 }

 public void setLockState(String lockState) {
     this.lockState = lockState;
 }

 // Define the method to extract the details of the Lock from a string
 
 // Define the method to enter the code to unlock the lock
 public String enterCodeToUnlock(int[] codeAttempts) {
	 if(lockState.equalsIgnoreCase("Unlocked")) {
		 return "Lock is already unlocked.";
	 }
	 if(Arrays.equals(code, codeAttempts)) {
		 lockState="Unlocked";
		 return "Code correct. Lock is now unlocked.";
	 }
	 return "Incorrect code. Please try again.";
	 
//	 if(lockState.equalsIgnoreCase("locked")) {
//		 for(int i=0;i<codeAttempts.length;i++) {
//			 if(!(codeAttempts[i]==code[i])) {
//				 return "Incorrect code. Please try again.";
//			}
//		 }
//		 	 
//	 }
//	 lockState="Unlocked";
//	 return "Code correct. Lock is now unlocked.";
     
 }
}

