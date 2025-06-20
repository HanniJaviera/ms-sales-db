package cl.duoc.ms_sales_db.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Long idSales;

    @Column(name = "sales_date")
    private LocalDate salesDate;

    @Column(name = "idusuario")
    private Long idUsuario; // 🔹 Solo guarda el ID, el resto lo traes desde ms-sales-bs

    @Column(name = "estadoventa")
    private String estadoVenta;

    @Column(name = "metododeretiro")
    private String metodoDeRetiro;

    @Column(name = "valortotal")
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private List<SalesDetail> salesDetails = new ArrayList<>();
}


