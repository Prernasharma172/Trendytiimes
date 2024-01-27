package com.product.Service;

import java.util.List;

import com.product.entity.Cart;

public interface CartService {
public  boolean addToCart (Cart c );
public boolean updateQuantity(String cartId,Integer quantity);
public boolean clearMyCart(String customerid);
public boolean deletewatchItemFromcart(String cartId) ;
public  Cart getCartById(String CartId) ;

public List <Cart> showMyCart(String customerid);
public List<Cart> showAllCart();
public boolean  checkwatchItem(String customerid,String watchId);
}
