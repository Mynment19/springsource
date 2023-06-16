package com.spring.memo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.ItemSellStatus;

@SpringBootTest
public class ItemRepositoryTest {
	
	//ItemRepository 잘 작성되었는지 테스트 : 단위 테스트
	@Autowired
	private ItemRepository repository;
	
	
//	@Test
//	public void itemCreateTest() {
//		
//		Item item = new Item();
//		item.setItemNm("순수 프리미엄");
//		item.setPrice(29500);
//		item.setStockNumber(55);
//		item.setItemDetail("깨끗한 나라");
//		item.setItemSellStatus(ItemSellStatus.SELL);
//		item.setRegTime(LocalDateTime.now());
//		item.setUpdateTime(LocalDateTime.now());
//		repository.save(item);	
//		
//		item = Item.builder()
//						.itemNm("프롬비")
//						.price(45800)
//						.stockNumber(70)
//						.itemDetail("휴대용 선풍기")
//						.itemSellStatus(ItemSellStatus.SELL)
//						.regTime(LocalDateTime.now())
//						.updateTime(LocalDateTime.now())
//						.build();	
//		
//		Item newItem = repository.save(item);
//		System.out.println(newItem);
//	}
	
	//조회
//	@Test
//	public void getItem() {
		
//		Optional<Item> item = repository.findById(1L);		
//		item.ifPresent(ele -> System.out.println(ele));
		
//		repository.findById(1L).ifPresent(ele -> System.out.println(ele));
//		
//		Item item = repository.findById(3L).orElseThrow(EntityNotFoundException::new);
//		System.out.println(item);
//	}
	
	//전체 조회
//	@Test
//	public void getItems() {		
//		
//		List<Item> list = repository.findAll();
//		
////		for (Item item : list) {
////			System.out.println(item);
////		}		
//		
//		list.forEach(item -> System.out.println(item));		
//	}
	
	
	// 상품명 조회
//	@Test
//	public void getItems() {		
		
//		List<Item> list = repository.findByItemNm("반팔티");		
//		list.forEach(item -> System.out.println(item));	
		
		
//		repository.findByItemNm("반팔티")
//				  .forEach(item -> System.out.println(item));
//	}
	
	
	// 상품명 or 상품상세 조회
	
//	@Test
//	public void getNameOrDetail() {
//		List<Item> list  = repository.findByItemNmOrItemDetail("블루투스 스피커", "카라티");
//		
//		list.forEach(item -> System.out.println(item));
//	}
	
	
//	@Test
//	public void getPriceLessThan() {
//		repository.findByPriceLessThan(50000).forEach(item -> System.out.println(item));
//	}
	
	
	@Test
	public void getPriceLessThanOrder() {
		repository.findByPriceLessThanOrderByPriceDesc(50000)
				  .forEach(item -> System.out.println(item));
	}
}















