package com.product.Service;

import java.util.List;

import com.product.entity.Watch;

public interface WatchService {

	public boolean addWatch(Watch w);
	public boolean updateWatch(Watch w);
	public boolean deleteWatch(Watch w);
	
	public Watch getWatchById(String watchId);
	public List<Watch> showAllwatch();
	public List<Watch> getWatchByCategory(String category);
	public List<Watch> getWatchByType(String type);
	
}
