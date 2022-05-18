package com.simplilearn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.simplilearn.entity.Recipie;
import com.simplilearn.repo.RecipieRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class RestfulWebservicesApplicationTests {
  @Autowired
	RecipieRepository Recipierepo;
  
	@Test
	@Order(1)
	public void testcreate() {
		Recipie r= new Recipie();
		r.setId(7);
		r.setName("Methi Rice");
		r.setImgurl("https://s3.amazonaws.com/images.chefinyou.com/main/methi-pulao-rice-recipe/main-img7.JPG");
		r.setCategory("Veg");
		r.setIngrediants("Oil_Methi_Rice_Vegies_Spices");
		r.setCookingSteps("Pour oil to a hot pan and add cumin, green cardamoms, green chilli and garlic.Saute garlic until a nice aroma comes out, then add green peas and methi leaves.Add garam masala powder, turmeric and mix well.Transfer cooled rice and sprinkle salt Serve methi rice with raita or a veggie salad.");
	    Recipierepo.save(r);
	    assertNotNull(Recipierepo.findById(7).get());
	    }
	@Test
	@Order(2)
	public void testReadAll() {
		List<Recipie> list =Recipierepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testSingleRecipie() {
		Recipie recipie = Recipierepo.findById(7).get();
		assertEquals("Veg",recipie.getCategory());
		
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Recipie r = Recipierepo.findById(7).get();
		r.setIngrediants("Oil_Methi_Rice_Vegies_Spices_pan");
		Recipierepo.save(r);
		assertNotEquals("Oil_Methi_Rice_Vegies_Spices",Recipierepo.findById(7).get().getIngrediants());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		
		Recipierepo.deleteById(7);
		assertThat(Recipierepo.existsById(7)).isFalse();
		
	}
	
	

}
