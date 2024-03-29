package com.capg.Product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capg.Product.Controller.productController;
import com.capg.Product.model.Product;
import com.capg.Product.service.productService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
    private productService pService;
    private Product p;
    private List<Product> pList;
    
    @InjectMocks
    private productController pController;
    
    @BeforeEach
    public void setUp(){
    	p=new Product("Samsung","1234","Coupon","1234","5");
        mockMvc= MockMvcBuilders.standaloneSetup(pController).build();
    }
    
    @Test
    public void saveProdControllerTest() throws Exception {
        when(pService.addProduct(any())).thenReturn(p);
        mockMvc.perform(post("/product/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(p)))
                .andExpect(status().isCreated());
        verify(pService, times(1)).addProduct(any());

    }
    
    @Test
    public void getAllProdControllerTest() throws Exception{
        when(pService.getProd()).thenReturn(pList);
        mockMvc.perform(MockMvcRequestBuilders.get("/product/GetProducts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(p)))
                .andDo(MockMvcResultHandlers.print());
        verify(pService, times(1)).getProd();

    }
    
    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
