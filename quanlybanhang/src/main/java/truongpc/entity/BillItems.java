package truongpc.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class BillItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@ManyToOne
	@CollectionTable(name="bill_id")
	Bill bill;
	@ManyToOne
	@CollectionTable(name="product_id")
	Product product;
	private int quantity;
	
	private double buyPrice;
}
