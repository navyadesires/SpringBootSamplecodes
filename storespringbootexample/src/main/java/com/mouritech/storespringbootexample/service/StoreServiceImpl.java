package com.mouritech.storespringbootexample.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mouritech.storespringbootexample.entity.Store;

import com.mouritech.storespringbootexample.exception.StoreNotFoundException;

import com.mouritech.storespringbootexample.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Store insertStore(Store newStore) {
	
		newStore.setStoreId(generateStoreId());
		return storeRepository.save(newStore);
	}
	
	
	public String generateStoreId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long pId = (long) rand.nextInt(upperbound);
		return "P00" + pId; 
	
	}


	@Override
	public Store showStoreById(String storeId) throws StoreNotFoundException {
		// TODO Auto-generated method stub
		return storeRepository.findByStoreId(storeId).orElseThrow(() -> new StoreNotFoundException("Store not found with id " + storeId));
	}


	@Override
	public List<Store> showAllStores() {
		// TODO Auto-generated method stub
		return storeRepository.findAll();
	}


	@Override
	public Store updateStoreById(String storeId,Store store) throws StoreNotFoundException {
		Store existingStore = storeRepository.findByStoreId(storeId).orElseThrow(() -> new StoreNotFoundException("store not found with id " + storeId));
		existingStore.setStoreStartedDate(store.getStoreStartedDate());
		
		storeRepository.save(existingStore);
		return existingStore;
	}


	@Override
	public void deleteStoreById(String storeId) throws StoreNotFoundException {
		Store existingStore = storeRepository.findByStoreId(storeId).orElseThrow(() -> new StoreNotFoundException("store not found with id " + storeId));
		storeRepository.delete(existingStore);
	}

}