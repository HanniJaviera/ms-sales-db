package cl.duoc.ms_sales_db.model.dto;

//import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SalesDTO {

    @JsonProperty( value = "idsales")
    private Long id;
    
    @JsonProperty( value = "usuario")
    private long customerId;

    @JsonProperty( value = "estadoventa")
    private String estadoVenta;

    @JsonProperty( value = "metodoretiro")
    private String metodoDeRetiro;

    @JsonProperty( value = "valortotal")
    private Long valorTotal;

    @JsonProperty( value = "detalles")
    private List<SalesDetailDTO> salesDetailDtoList;

}


   // @JsonProperty( value = "sales_date")
    //private LocalDate salesDate;
