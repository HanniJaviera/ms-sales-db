package cl.duoc.ms_sales_db.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalesDetail;

    @Column(name = "idproduct")
    private Long idProduct;
    
    @Column(name = "cantidad")
    private Long cantidad;
}
