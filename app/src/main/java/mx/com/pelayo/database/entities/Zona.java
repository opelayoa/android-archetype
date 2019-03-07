package mx.com.pelayo.database.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "zona")
public class Zona {

	@PrimaryKey
	@ColumnInfo(name = "zonaid")
	@SerializedName("zonaid")
	private Integer zonaid;
	@ColumnInfo(name = "zonadesc")
	@SerializedName("zonadesc")
	private String zonadesc;
	@ColumnInfo(name = "supervisor")
	@SerializedName("supervisor")
	private String supervisor;
	@ColumnInfo(name = "useq")
	@SerializedName("useq")
	private Integer useq;
	@ColumnInfo(name = "rclave")
	@SerializedName("rclave")
	private Integer rclave;

	public Integer getZonaid() {
		return zonaid;
	}

	public void setZonaid(Integer zonaid) {
		this.zonaid = zonaid;
	}

	public String getZonadesc() {
		return zonadesc;
	}

	public void setZonadesc(String zonadesc) {
		this.zonadesc = zonadesc;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public Integer getUseq() {
		return useq;
	}

	public void setUseq(Integer useq) {
		this.useq = useq;
	}

	public Integer getRclave() {
		return rclave;
	}

	public void setRclave(Integer rclave) {
		this.rclave = rclave;
	}

}
