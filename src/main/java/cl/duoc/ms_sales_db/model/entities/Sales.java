package cl.duoc.ms_sales_db.model.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sales")
@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsales")
    private Long id;

    @Column(name = "valortotal")
    private Long valorTotal;

    @Column(name = "sales_date")
    private String salesDate;

    @Column(name = "idusuario")
    private Long customerId;  

    @Column(name = "estadoventa")
    private String estadoVenta;

    @Column(name = "metodoretiro")
    private String metodoDeRetiro;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SalesDetail> detalles;

}


