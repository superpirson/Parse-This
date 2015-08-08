package coreGame;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonController {
	public PythonInterpreter pyInterpreter = new PythonInterpreter();
	
	public PyObject eval(String pyCode){
		System.err.println("evaling python code : " + pyCode);
		return pyInterpreter.eval(pyCode);
		
	}
	public void exec(String pyCode){
		System.err.println("execing python code : " + pyCode);
		pyInterpreter.exec(pyCode);
		
	}
}
