package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item,Integer>{
//		List<Item> findAllByItemEnteredByUser(String itemEnteredByUser);
//		List<Item> findByItemStatusAndItemEnteredByUser(ItemStatus itemStatus,String itemEnteredByUser);
	
	@Query(value= "SELECT i from Item as i  WHERE i.itemStatus=:itemStatus and i.itemEnteredByUser=:itemEnteredByUser")
	List<Item> findByItemStatusAndItemEnteredByUser(ItemStatus itemStatus,String itemEnteredByUser);
}
