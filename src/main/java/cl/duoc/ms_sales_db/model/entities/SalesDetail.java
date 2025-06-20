package cl.duoc.ms_sales_db.model.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salesdetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsalesdetail")
    private Long id;

    @Column(name = "idproduct")
    private Long productId;

    @Column(name = "cantidad")
    private Long quantity;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsales",          
                referencedColumnName = "idsales",
                nullable = false,
                insertable = false, 
                updatable = false)  
    private Sales sales;

    @Column(name = "idsales") 
    private Long salesId; 


   
}
