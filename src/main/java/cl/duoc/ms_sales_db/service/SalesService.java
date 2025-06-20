package cl.duoc.ms_sales_db.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_sales_db.model.dto.ProductDTO;
import cl.duoc.ms_sales_db.model.dto.SalesDTO;
import cl.duoc.ms_sales_db.model.dto.SalesDetailDTO;
import cl.duoc.ms_sales_db.model.entities.Sales;
import cl.duoc.ms_sales_db.model.entities.SalesDetail;
import cl.duoc.ms_sales_db.model.repository.SalesDetailRepository;
import cl.duoc.ms_sales_db.model.repository.SalesRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;


    @Autowired
    SalesDetailRepository salesDetailRepository;


    public SalesDTO findSalesById(Long id){
        Optional<Sales> sales = salesRepository.findById(id);      
        SalesDTO salesDto = null;


        if(sales.isPresent()){
            salesDto = translateEntityToDto(sales.get());


            List<SalesDetail> salesDetailList = salesDetailRepository.findBySalesId(sales.get().getId());
            salesDto.setSalesDetailDtoList(translateListEntityToDto(salesDetailList));
        }


        return salesDto;


    }


    public SalesDTO createSale(SalesDTO salesDTO){
        Sales sales = translateDtoToEntity(salesDTO);
        Sales newSales = salesRepository.save(sales);


        for(SalesDetailDTO salesDetailDTO: salesDTO.getSalesDetailDtoList()){
            SalesDetail salesDetail = new SalesDetail();
            salesDetail.setProductId(salesDetailDTO.getProductId().getId());
            salesDetail.setQuantity(salesDetailDTO.getQuantity());
            salesDetail.setSalesId(newSales.getId());
            salesDetailRepository.save(salesDetail);
        }


        SalesDTO newSalesDTO = null;


        if(newSales != null){
            newSalesDTO = translateEntityToDto(newSales);


            List<SalesDetail> salesDetailList = salesDetailRepository.findBySalesId(newSales.getId());
            newSalesDTO.setSalesDetailDtoList(translateListEntityToDto(salesDetailList));
        }


        return newSalesDTO;
    }


    public Sales translateDtoToEntity(SalesDTO salesDTO){
        Sales sales = new Sales();
        sales.setValorTotal(salesDTO.getValorTotal());
        sales.setCustomerId(salesDTO.getCustomerId());;
        sales.setEstadoVenta(salesDTO.getEstadoVenta());
        sales.setMetodoDeRetiro(salesDTO.getMetodoDeRetiro());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sales.setSalesDate(format.format(new Date(0)));
   
        return sales;
    }




        public SalesDTO translateEntityToDto(Sales sale){  
        SalesDTO salesDto = new SalesDTO();
        salesDto.setId(sale.getId());
        salesDto.setValorTotal(sale.getValorTotal());
        salesDto.setEstadoVenta(sale.getEstadoVenta());
        salesDto.setMetodoDeRetiro(sale.getMetodoDeRetiro());
        //salesDto.setSalesDate(sale.getSalesDate());
        salesDto.setCustomerId(sale.getCustomerId());;
        return salesDto;
    }


    public List<SalesDetailDTO> translateListEntityToDto(List<SalesDetail> saleDetail){
        List<SalesDetailDTO> lista = new ArrayList<>();
        SalesDetailDTO salesDetailDTO = null;
        for(SalesDetail detail: saleDetail){
            salesDetailDTO = new SalesDetailDTO();
            salesDetailDTO.setId(detail.getId());


            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(detail.getProductId());
            salesDetailDTO.setProductId(productDTO);


            salesDetailDTO.setQuantity(detail.getQuantity());
            salesDetailDTO.setSalesId(detail.getSalesId());
            lista.add(salesDetailDTO);
        }
       
        return lista;
    }

}
