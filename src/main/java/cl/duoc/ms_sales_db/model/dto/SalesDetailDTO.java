package cl.duoc.ms_sales_db.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalesDetailDTO {

    private Long id;

    private ProductDTO productId;   

    private Long quantity;
    
    private Long salesId; 
}
