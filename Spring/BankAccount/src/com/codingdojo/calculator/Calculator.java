package com.codingdojo.calculator;

public class Calculator implements java.io.Serializable {
	

	private Double operandOne;
	private Double operandTwo;
	private String operation;
	private Double result;
	
	public Calculator() {
		
	}
	
	public void performOperation() {
		
		// Value Check
		if(this.getOperandOne() == null || this.getOperandTwo() == null) return;
		
		//Operator Check
		if(operation.equals("+")) {
			this.setResult(this.getOperandOne() + this.getOperandTwo());
		}else if(operation.equals("-")) {
			this.setResult(this.getOperandOne() - this.getOperandTwo());
		}else {
			System.out.println("Only addition & subtraction are authorized.");
		}
		return;
	}
	
	public void getResults() {
		System.out.println("Result: " + this.getResult());
	}
	
	public Double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(Double operandOne) {
		this.operandOne = operandOne;
	}

	public Double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(Double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
}