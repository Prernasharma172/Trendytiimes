package com.product.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.product.entity.Cart;
import com.product.entity.Watch;
import com.product.utility.DBConnection;

public class CartServiceImpl implements CartService {
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs= null;


	public boolean addToCart(Cart c) {
		con=DBConnection.makeConnection();
		sql="insert  into cart values (?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,c.getCartId());
			ps.setString(2,c.getwatchId());
			ps.setString(3,c.getcustomerid());
			ps.setInt(4,c.getQuantity());
			ps.setDouble(6,c.getPrice());
			ps.setDouble(5,c.getSubtotal());
			
			
		int i =ps.executeUpdate();
		if(i>0)
			 return true;
	}
	catch(Exception e ) {
		e.printStackTrace();
			
	}
	finally {
		try {
			ps.close();
			con.close();
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	return false;
}


		
		

	
	public boolean updateQuantity(String cartId, Integer quantity) {
try {
	con=DBConnection.makeConnection();
	sql="update cart set quantity=? where cartId=?";
	
	ps=con.prepareStatement(sql);
	ps.setInt(1, quantity);
	ps.setString(2, cartId);
	
	int i=ps.executeUpdate();
	if(i>0) {
		sql="update cart set subtotal =price*quantity where cartId=?";
		
		ps=con.prepareStatement(sql);
		ps.setString(1, cartId);
		
		i=ps.executeUpdate();
		if(i>0)
			return true;
	}
}
catch(Exception e) {
	e.printStackTrace();
}
finally {
	try {
		ps.close();
		con.close();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
		return false;
	}


	public boolean deletewatchItemFromcart(String cartId) {
try {
	con=DBConnection.makeConnection();
	sql=" delete from cart where cartId=?";
	
	ps=con.prepareStatement(sql);
	ps.setString(1, cartId);

	int i=ps.executeUpdate();
	if(i>0)
		return true;
	}


catch(Exception e) {
	e.printStackTrace();
}
finally {
	try {
		ps.close();
		con.close();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	
}
	

return false;
	}


	
	public List<Cart> showAllCart() {
try {
	con=DBConnection.makeConnection();
	sql="select * from cart";
	ps=con.prepareStatement(sql);
	rs=ps.executeQuery();
	
	List<Cart> clist=new ArrayList<Cart>();
	
	while(rs.next()) {
		Cart c=new Cart();
		c.setCartId(rs.getString("cartId"));
		c.setcustomerid(rs.getString("customerid"));
		c.setwatchId(rs.getString("watchId"));
		c.setPrice(rs.getDouble("price"));
		c.setQuantity(rs.getInt("quantity"));
		c.setSubtotal(rs.getDouble("subtotal"));

		Watch w=new WatchServiceImpl().getWatchById(rs.getString("watchId"));	
	c.setW(w);
		clist.add(c);
		}
     return clist;
}
catch(Exception e) {
	e.printStackTrace();
}
finally {
	try {
		ps.close();
		con.close();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	
}

		return null;
	}






	@Override
	public boolean clearMyCart(String customerid) {
		try {
			con=DBConnection.makeConnection();
			sql=" delete from cart where customerid=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerid);

			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
				catch (Exception e) {
					e.printStackTrace();
				}
				}
		
		return false;


	}



	@Override
	public List<Cart> showMyCart(String customerid) {
		try {
			con=DBConnection.makeConnection();
		sql="select * from cart where customerid=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, customerid);
		
		rs=ps.executeQuery();
		List<Cart> clist=new ArrayList<Cart>();
		
		while(rs.next()) {
			Cart c=new Cart();
			c.setCartId(rs.getString("cartId"));
			c.setcustomerid(rs.getString("customerid"));
			c.setwatchId(rs.getNString("watchid"));
			c.setPrice(rs.getDouble("price"));
			c.setQuantity(rs.getInt("quantity"));
			c.setSubtotal(rs.getDouble("subtotal"));
	
			Watch w=new WatchServiceImpl().getWatchById(rs.getString("watchId"));	
		c.setW(w);
			clist.add(c);
			}
	     return clist;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				finally {
					try {
						ps.close();
						con.close();
					}
						catch (Exception e) {
							e.printStackTrace();
						}
					
				}
		
				
		return null;
	}
public  Cart getCartById(String CartId) {
	try {
		con=DBConnection.makeConnection();
	sql="select * from cart where cartId=?";
	ps=con.prepareStatement(sql);
	ps.setString(1, CartId);
	
	rs=ps.executeQuery();
	
	if(rs.next()) {
		Cart c=new Cart();
		c.setCartId(rs.getString("cartId"));
		c.setcustomerid(rs.getString("customerid"));
		c.setwatchId(rs.getNString("watchid"));
		c.setPrice(rs.getDouble("price"));
		c.setQuantity(rs.getInt("quantity"));
		c.setSubtotal(rs.getDouble("subtotal"));

		Watch w=new WatchServiceImpl().getWatchById(rs.getString("watchId"));
		
	c.setW(w);
    return c;
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
			finally {
				try {
					ps.close();
					con.close();
				}
					catch (Exception e) {
						e.printStackTrace();
					}
				
			}
	
			
	return null;
	
}






@Override
public boolean checkwatchItem(String customerid, String watchId) {
try {
	con=DBConnection.makeConnection();
	
	sql=" select * from cart where customerid=? && watchId=?";
	ps=con.prepareStatement(sql);
	ps.setString(1, customerid);
	ps.setString(2, watchId);
	rs=ps.executeQuery();
	if(rs.next()) {
		int quantity=rs.getInt("quantity");
		quantity++;
		
		String cartId=rs.getString("cartId");
		
		boolean flag=updateQuantity(cartId,quantity);
		return flag;
		}
}
catch(Exception e) {
	e.printStackTrace();
}
finally {
	try {
		ps.close();
		con.close();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
	return false;
}
}