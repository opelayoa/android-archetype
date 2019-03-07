package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tienda")
public class Tienda {
	@PrimaryKey
	@ColumnInfo(name = "tclave")
	@SerializedName("tclave")
	private Integer tclave;
	@ColumnInfo(name = "tnombre")
	@SerializedName("tnombre")
	private String tnombre;
	@ColumnInfo(name = "dclave")
	@SerializedName("dclave")
	private Integer dclave;
	@ColumnInfo(name = "talmacen")
	@SerializedName("talmacen")
	private Integer talmacen;

	public Integer getTclave() {
		return tclave;
	}

	public void setTclave(Integer tclave) {
		this.tclave = tclave;
	}

	public String getTnombre() {
		return tnombre;
	}

	public void setTnombre(String tnombre) {
		this.tnombre = tnombre;
	}

	public Integer getDclave() {
		return dclave;
	}

	public void setDclave(Integer dclave) {
		this.dclave = dclave;
	}

	public Integer getTalmacen() {
		return talmacen;
	}

	public void setTalmacen(Integer talmacen) {
		this.talmacen = talmacen;
	}

}
