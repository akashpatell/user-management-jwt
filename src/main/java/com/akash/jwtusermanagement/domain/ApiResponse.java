package com.akash.jwtusermanagement.domain;

/**
 * Common API response structure
 * 
 * @author Akash.Patel
 *
 * @param <T>
 */
public class ApiResponse<T> {

	private T data;

	private Integer status;

	private String message;

	public ApiResponse() {
		super();
	}

	public ApiResponse(Integer status, String message) {
		this(null, status, message);
	}

	public ApiResponse(T data, Integer status, String message) {
		super();
		this.data = data;
		this.status = status;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [data=" + data + ", status=" + status + ", message=" + message + "]";
	}

}
