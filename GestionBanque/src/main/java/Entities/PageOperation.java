package Entities;

import java.io.Serializable;
import java.util.List;

public class PageOperation implements Serializable {
	private List <Operation> Operations;
	private int page;
	private int nombreOperations;
	private int totalOperations;
	private int totalpages;
	public PageOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageOperation(List<Operation> operations, int page, int nombreOperations, int totalOperations,
			int totalpages) {
		super();
		Operations = operations;
		this.page = page;
		this.nombreOperations = nombreOperations;
		this.totalOperations = totalOperations;
		this.totalpages = totalpages;
	}
	public List<Operation> getOperations() {
		return Operations;
	}
	public void setOperations(List<Operation> operations) {
		Operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public int getTotalOperations() {
		return totalOperations;
	}
	public void setTotalOperations(int totalOperations) {
		this.totalOperations = totalOperations;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	

}
