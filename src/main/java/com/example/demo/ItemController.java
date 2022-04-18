package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/item")
public class ItemController {

	
	@Autowired
	ItemRepository itemRepository;
	
	
	@PostMapping("")
	public ResponseEntity<Item> postData(@Valid @RequestBody Item item,BindingResult br) {
		item.setItemLastModifiedDate(LocalDate.now());
		item.setItemEnteredDate(LocalDate.now());

		if(item.getItemName() == null || item.getItemName().isEmpty() ) {
			System.out.println("error");
			br.rejectValue("itemName", "itemName", "The fullame is a mandatory field");
		  return null;
		}
//		try {
//			if(item.getItemId() ==1) {
//				throw new EmptyInputException("601", "Id is 1");
//			}
//		}catch(Exception  e) {
//			   System.out.println("Exception");
//		}
		
		if(itemRepository.findById(item.getItemId()).isPresent()) {
//			System.out.println(itemRepository.getById(item.getItemId()));
//			System.out.println(item.getItemId());
			return new ResponseEntity<Item>(item,HttpStatus.BAD_REQUEST);
		}
		else {
			Item items=itemRepository.save(item);
			return new ResponseEntity<Item>(items,HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/{itemId}")
	public ResponseEntity<Item> putData(@RequestBody Item item,@PathVariable int itemId) {
		item.setItemLastModifiedDate(LocalDate.now());
		if(!itemRepository.findById(itemId).isPresent()) { 
			System.out.println(itemId);
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		else {
			System.out.println(itemId);
			Item items=itemRepository.save(item);
			return new ResponseEntity<Item>(items,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{itemId}")
	public ResponseEntity<Item> deleteData(@PathVariable int itemId){
		if(itemRepository.findById(itemId).isPresent()) {
			itemRepository.deleteById(itemId);
			return new ResponseEntity<Item>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity deleteAll() {
		itemRepository.deleteAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<Item> getData(@PathVariable int itemId){
		if(itemRepository.findById(itemId).isPresent()) {
			Item item=itemRepository.findById(itemId).get();
			return new ResponseEntity<Item>(item,HttpStatus.OK);
		}else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}

	
	@RequestMapping(params={"itemStatus", "itemEnteredByUser"})
//	@RequestMapping
	public ResponseEntity<List<Item>> getDataByItemStatus(@RequestParam ItemStatus itemStatus,@RequestParam String itemEnteredByUser ){
		System.out.println(itemStatus);
		System.out.println(itemEnteredByUser);
		
			List<Item> item=itemRepository.findByItemStatusAndItemEnteredByUser(itemStatus,itemEnteredByUser);
			return new ResponseEntity<List<Item>>(item,HttpStatus.OK);
	}
	@GetMapping("")
	public ResponseEntity<List<Item>> getAllData(){
		
		System.out.println("all********");
			List<Item> item=(List<Item>) itemRepository.findAll();
			return new ResponseEntity<List<Item>>(item,HttpStatus.OK);
	}
	
	@GetMapping(params = {"pageSize", "page", "sortBy"})
	public ResponseEntity<List<Item>> getDataByPage(@RequestParam int pageSize,@RequestParam int page,@RequestParam String sortBy
			){
		Pageable paging=PageRequest.of(page, pageSize, Direction.DESC ,sortBy);
			Page<Item> item=itemRepository.findAll(paging);
//			if(item.hasContent())
				return new ResponseEntity<List<Item>>(item.getContent(),HttpStatus.OK);
//			else 
	}
	
	
	
}
